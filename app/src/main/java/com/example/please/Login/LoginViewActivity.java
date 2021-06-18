package com.example.please.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.please.BackPressCloseHandler;
import com.example.please.DB.ConnectionDB;
import com.example.please.Data.Myinfo;
import com.example.please.Home.HomeViewActivity;
import com.example.please.R;

import androidx.appcompat.app.AppCompatActivity;

public class LoginViewActivity extends AppCompatActivity {
    EditText ided, pwed;
    Button login, register, searchID;
    Intent intent;
    private BackPressCloseHandler backPressCloseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("로그인");

        ided = (EditText) findViewById(R.id.login_id);
        pwed = (EditText) findViewById(R.id.login_pw);
        login = (Button) findViewById(R.id.로그인);
        searchID = (Button) findViewById(R.id.아이디찾기);
        register = (Button) findViewById(R.id.회원가입);

        backPressCloseHandler = new BackPressCloseHandler(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String id = ided.getText().toString();
                    String pw = pwed.getText().toString();
                    String type = "login";
                    Toast myToast;
                    ConnectionDB task = new ConnectionDB();
                    String str = task.execute(type, id, pw).get();
                    String[] arr;
                    arr = str.split("\t");
                    switch (arr[0]) {
                        case "X":
                            str =  "아이디를 다시 확인해주세요.";
                            break;
                        case "O":
                            str = "로그인이 되었습니다.";
                            myToast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
                            myToast.show();
                            Intent intent = new Intent(getApplicationContext(), HomeViewActivity.class);
                            Myinfo myinfo = new Myinfo(arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8]);
                            intent.putExtra("myinfo",myinfo);
                            startActivity(intent);
                            finish();
                            break;
                        case "R":
                            str = "비밀번호를 다시 확인해주세요";
                            break;
                        case "Error":
                            str = "서버가 불안정합니다.";
                    }
                    myToast = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
                    myToast.show();
                } catch (Exception e) {
                    Log.i("DBtest", ".....ERROR.....!");
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), RegisterViewActivity.class);
                startActivity(intent);
            }
        });
        searchID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), SearchIDViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){
        backPressCloseHandler.onBackPressed();
    }
}