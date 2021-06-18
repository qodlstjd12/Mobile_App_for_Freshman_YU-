package com.example.please.Login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.please.ChangePW.ChangePwViewActivity;
import com.example.please.DB.ConnectionDB;
import com.example.please.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SearchIDViewActivity extends AppCompatActivity {

    Button 아이디찾기,비밀번호찾기;
    EditText 이름_아이디,이메일_아이디,이름_비밀번호,아이디_비밀번호,출신학교_비밀번호;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchid);
        setTitle("아이디, 비밀번호 찾기");


        final Context context = this;

        아이디찾기 = (Button)findViewById(R.id.find_id);
        비밀번호찾기 = (Button)findViewById(R.id.find_pw);

        이름_아이디 = (EditText)findViewById(R.id.name_id);
        이메일_아이디 = (EditText)findViewById(R.id.email_id);
        이름_비밀번호 = (EditText)findViewById(R.id.name_pw);
        아이디_비밀번호 = (EditText)findViewById(R.id.id_pw);
        출신학교_비밀번호 = (EditText)findViewById(R.id.school_pw);

        아이디찾기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Toast myToast;
                    ConnectionDB task = new ConnectionDB();
                    String name_id = 이름_아이디.getText().toString();
                    String email_id = 이메일_아이디.getText().toString();
                    String type = "searchID";
                    String result;
                    result = task.execute(type, name_id, email_id).get();

                    if(result.equals("Search_X")) {
                        myToast = Toast.makeText(getApplicationContext(), "아이디를 찾을 수 없습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("찾는 아이디").setMessage(result);
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }catch (Exception e) {
                    Log.i("DBtest", ".....ERROR.....!");
                }
            }
        });

        비밀번호찾기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast myToast;
                    ConnectionDB task = new ConnectionDB();
                    String name_pw = 이름_비밀번호.getText().toString();
                    String id_pw = 아이디_비밀번호.getText().toString();
                    String school_pw = 출신학교_비밀번호.getText().toString();
                    String type = "searchPW";
                    String result;
                    result = task.execute(type, name_pw, id_pw, school_pw).get();

                    if(result.equals("SearchPW_X")) {
                        myToast = Toast.makeText(getApplication(), "비밀번호를 찾을 수 없습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), ChangePwViewActivity.class);
                        intent.putExtra("아이디",id_pw);
                        startActivity(intent);
                        finish();
                    }
                }
                catch (Exception e) {
                    Log.i("DBtest", ".....ERROR.....!");
                }
            }
        });
    }
}
