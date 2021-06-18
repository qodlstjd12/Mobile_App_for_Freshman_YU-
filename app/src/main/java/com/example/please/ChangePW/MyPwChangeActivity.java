package com.example.please.ChangePW;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.please.DB.ConnectionDB;
import com.example.please.Data.Myinfo;
import com.example.please.Login.LoginViewActivity;
import com.example.please.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MyPwChangeActivity extends AppCompatActivity {

    Button 확인,취소;
    EditText 현재비밀번호,비밀번호1,비밀번호2;
    ConnectionDB task;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_change_pw);
        setTitle("비밀번호 변경");

        확인 = (Button)findViewById(R.id.myPw확인);
        취소 = (Button)findViewById(R.id.myPw취소);


        확인.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    현재비밀번호 = (EditText)findViewById(R.id.nowMyPw);
                    비밀번호1 = (EditText) findViewById(R.id.newMyPw);
                    비밀번호2 = (EditText) findViewById(R.id.newMyPwRe);
                    task = new ConnectionDB();
                    intent = getIntent();
                    Myinfo myinfo = (Myinfo) intent.getSerializableExtra("myinfo");
                    String result;
                    String type = "changePW";
                    String nowPw = 현재비밀번호.getText().toString();
                    String pw1 = 비밀번호1.getText().toString();
                    String pw2 = 비밀번호2.getText().toString();
                    Toast myToast;
                    String id = myinfo.getId();
                    if(!nowPw.equals(myinfo.getPwd())){
                        myToast = Toast.makeText(getApplication(), "현재비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                    } else if (!pw1.equals(pw2)) {
                        myToast = Toast.makeText(getApplication(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                    } else {
                        myToast = Toast.makeText(getApplication(), "비밀번호가 변경 되었습니다. 다시 로그인해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        result = task.execute(type,id,pw1).get();
                        ArrayList<Activity> actList = new ArrayList<Activity>();
                        for(int i = 0; i < actList.size(); i++)
                            actList.get(i).finish();
                        intent = new Intent(getApplicationContext(),LoginViewActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (Exception e) {
                    Log.i("DBtest", ".....ERROR.....!");
                }
            }
        });

        취소.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

