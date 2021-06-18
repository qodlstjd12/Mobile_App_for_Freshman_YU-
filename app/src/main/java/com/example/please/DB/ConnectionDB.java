package com.example.please.DB;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionDB extends AsyncTask<String, Void, String> {
    String sendMsg, receiveMsg;

    @Override
    protected String doInBackground(String... strings) {
        try {
            String str;

            // 접속할 서버 주소 (이클립스에서 android.jsp 실행시 웹브라우저 주소)
            URL url = new URL("http://165.229.229.53:8080/WebApp/register.jsp");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

            // 전송할 데이터. GET 방식으로 작성
            switch (strings[0]){
                case "idChk":
                    sendMsg = "type=" + strings[0] + "&id="+strings[1];
                    break;
                case "register":
                    sendMsg = "type="+strings[0]+"&id=" + strings[1] + "&pw=" + strings[2] + "&name=" + strings[3] + "&email=" + strings[4] + "&phone=" + strings[5] + "&gen=" + strings[6] + "&school=" + strings[7];
                    break;
                case "searchID":
                    sendMsg = "type="+ strings[0]+"&name=" + strings[1] + "&email=" + strings[2];
                    break;
                case "searchPW":
                    sendMsg = "type="+ strings[0]+"&name=" + strings[1] + "&id="+strings[2] +"&school=" + strings[3];
                    break;
                case "login":
                    sendMsg = "type=" + strings[0] + "&id="+strings[1]+ "&pw=" + strings[2];
                    break;
                case "changePW":
                    sendMsg = "type="+ strings[0]+"&id=" + strings[1]+"&pw=" + strings[2];
                    break;
                case "registerNB":
                    sendMsg = "type=" + strings[0] +"&id="+strings[1];
                    break;
                case "ViewNB":
                    sendMsg = "type=" + strings[0] + "&id=" + strings[1];
                    break;
                case "ExtendNB":
                    sendMsg = "type=" + strings[0] + "&id=" + strings[1];
                    break;
                case "CancelNB":
                    sendMsg = "type=" + strings[0] + "&id=" + strings[1];
                    break;
                case "dropCheckDB":
                    sendMsg = "type="+strings[0]+"&id="+strings[1];
            }
            osw.write(sendMsg);
            osw.flush();

            //jsp와 통신 성공 시 수행
            if (conn.getResponseCode() == conn.HTTP_OK) {

                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();
                // jsp에서 보낸 값을 받는 부분
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                receiveMsg = buffer.toString();
            } else {
                // 통신 실패
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //jsp로부터 받은 리턴 값
        return receiveMsg;
    }

}