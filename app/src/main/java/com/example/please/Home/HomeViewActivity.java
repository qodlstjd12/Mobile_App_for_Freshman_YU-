package com.example.please.Home;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.please.BackPressCloseHandler;
import com.example.please.Data.Myinfo;
import com.example.please.Login.LoginViewActivity;
import com.example.please.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class HomeViewActivity extends AppCompatActivity{
    BackPressCloseHandler backPressCloseHandler;
    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        TextView 마이페이지 = (TextView)findViewById(R.id.mypage);
        TextView 로그아웃 = (TextView)findViewById(R.id.logout);

        마이페이지.setPaintFlags(마이페이지.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        로그아웃.setPaintFlags(로그아웃.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        ArrayList<String> arr = new ArrayList<String>();


        backPressCloseHandler = new BackPressCloseHandler(this);

        Intent intent = getIntent();
        final Myinfo myinfo = (Myinfo) intent.getSerializableExtra("myinfo");


        ImageButton 교수진소개,공지사항,노트북대여,맛집;
        교수진소개 = (ImageButton)findViewById(R.id.button1);
        공지사항 = (ImageButton)findViewById(R.id.button2);
        노트북대여 = (ImageButton)findViewById(R.id.button3);
        맛집 = (ImageButton)findViewById(R.id.button4);


        교수진소개.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FragmentActivity.class);
                intent.putExtra("myinfo",myinfo);
                intent.putExtra("fragment","professor");
                startActivity(intent);
            }
        });

        노트북대여.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FragmentActivity.class);
                intent.putExtra("myinfo",myinfo);
                intent.putExtra("fragment","notebook");
                startActivity(intent);
            }
        });
        공지사항.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FragmentActivity.class);
                intent.putExtra("myinfo",myinfo);
                intent.putExtra("fragment","notice");
                startActivity(intent);
            }
        });

        맛집.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FragmentActivity.class);
                intent.putExtra("myinfo",myinfo);
                intent.putExtra("fragment","food");
                startActivity(intent);
            }
        });

        마이페이지.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FragmentActivity.class);
                intent.putExtra("myinfo",myinfo);
                intent.putExtra("fragment","mypage");
                startActivity(intent);
            }
        });
        로그아웃.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginViewActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() { backPressCloseHandler.onBackPressed();}
}




