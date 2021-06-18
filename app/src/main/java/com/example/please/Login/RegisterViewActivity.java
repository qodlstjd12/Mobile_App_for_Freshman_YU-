package com.example.please.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.please.DB.ConnectionDB;
import com.example.please.R;

public class RegisterViewActivity extends AppCompatActivity {

    Button registerBtn, idchkbtn,ccbtn;
    EditText idet, pwet, pwchk, naed, emed, phed, sced;
    RadioGroup geed;
    RadioButton genchk;
    Toast myToast;
    int idCheck = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        setTitle("회원가입");
        registerBtn = (Button) findViewById(R.id.가입완료);
        idchkbtn = (Button) findViewById(R.id.중복확인);
        ccbtn = (Button)findViewById(R.id.회원가입_취소);

        naed = (EditText) findViewById(R.id.이름);
        idet = (EditText) findViewById(R.id.학번);
        pwet = (EditText) findViewById(R.id.비밀번호);
        pwchk = (EditText) findViewById(R.id.비밀번호재확인);
        phed = (EditText) findViewById(R.id.핸드폰);
        emed = (EditText) findViewById(R.id.이메일);
        geed = (RadioGroup) findViewById(R.id.성별);
        sced = (EditText) findViewById(R.id.출신학교);


        idchkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String type = "idChk";
                    String id = idet.getText().toString();
                    ConnectionDB task = new ConnectionDB();
                    String result = task.execute(type,id).get();
                    if(id.isEmpty()){
                        myToast = Toast.makeText(getApplicationContext(),"아이디를 입력하세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }
                    myToast = Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT);
                    myToast.show();
                    if(result.equals("사용 하실 수 있는 아이디 입니다."))
                        idCheck = 1;
                    else
                        idCheck = 0;
                }catch(Exception e) {
                    Log.i("DBtest", ".....ERROR.....!");
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    String result;
                    String type = "register";
                    String id = idet.getText().toString();
                    String pw = pwet.getText().toString();
                    String pwc = pwchk.getText().toString();
                    String name = naed.getText().toString();
                    String email = emed.getText().toString();
                    String phone = phed.getText().toString();
                    String school = sced.getText().toString();
                    if(name.isEmpty()) {
                        myToast = Toast.makeText(getApplicationContext(), "이름을 입력해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }else if(id.isEmpty()||(id.length()<8)){
                        myToast = Toast.makeText(getApplicationContext(), "아이디를 확인해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }else if(pw.isEmpty()||(pw.length()<10)) {
                        myToast = Toast.makeText(getApplicationContext(), "비밀번호를 확인해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }
                    else if(pwc.isEmpty()) {
                        myToast = Toast.makeText(getApplicationContext(), "비밀번호 확인을 입력해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }else if(geed.getCheckedRadioButtonId() == -1) {
                        myToast = Toast.makeText(getApplicationContext(), "성별를 체크해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }else if(email.isEmpty()) {
                        myToast = Toast.makeText(getApplicationContext(), "이메일을 입력해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }else if(phone.isEmpty()||(phone.length()<11)) {
                        myToast = Toast.makeText(getApplicationContext(), "핸드폰 번호를 확인해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }else if(school.isEmpty()) {
                        myToast = Toast.makeText(getApplicationContext(), "출신초등학교를 입력해 주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }else if (!pw.equals(pwc)){
                        myToast = Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    }else if (idCheck==0){
                        myToast = Toast.makeText(getApplicationContext(), "아이디 중복확인을 해주세요.", Toast.LENGTH_SHORT);
                        myToast.show();
                        return;
                    } else {
                        genchk = (RadioButton)findViewById(geed.getCheckedRadioButtonId());
                        String gen = genchk.getText().toString();
                        ConnectionDB task = new ConnectionDB();
                        result = task.execute(type,id, pw, name, email, phone, gen, school).get();
                        myToast = Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT);
                        myToast.show();
                        finish();
                    }
                } catch (Exception e) {
                    Log.i("DBtest", ".....ERROR.....!");
                }
            }
        });

        ccbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}