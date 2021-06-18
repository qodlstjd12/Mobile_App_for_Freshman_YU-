package com.example.please.ChangePW;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.please.DB.ConnectionDB;
import com.example.please.R;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePwViewActivity extends AppCompatActivity {
    Button 확인,취소;
    EditText 비밀번호1,비밀번호2;
    ConnectionDB task;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepw);
        setTitle("비밀번호 변경");
        확인 = (Button)findViewById(R.id.변경확인);
        취소 = (Button)findViewById(R.id.변경취소);


        확인.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    비밀번호1 = (EditText) findViewById(R.id.비밀번호1);
                    비밀번호2 = (EditText) findViewById(R.id.비밀번호2);
                    task = new ConnectionDB();
                    intent = getIntent();
                    String result;
                    String type = "changePW";
                    String pw1 = 비밀번호1.getText().toString();
                    String pw2 = 비밀번호2.getText().toString();
                    Toast myToast;
                    String id = intent.getExtras().getString("아이디");
                    if (pw1.equals(pw2)) {
                        myToast = Toast.makeText(getApplication(), "비밀번호가 변경 되었습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                        result = task.execute(type,id,pw1).get();
                        finish();
                    } else {
                        myToast = Toast.makeText(getApplication(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
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

