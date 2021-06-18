package com.example.please.Home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.please.Data.Professor_info;
import com.example.please.R;

import androidx.appcompat.app.AppCompatActivity;

public class Professor_View extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professor_info);


        Intent intent = getIntent();
        TextView professor = (TextView) findViewById(R.id.professor);
        TextView name = (TextView) findViewById(R.id.name);
        TextView school = (TextView) findViewById(R.id.school);
        TextView major = (TextView) findViewById(R.id.major);
        TextView room = (TextView) findViewById(R.id.room);
        TextView email = (TextView) findViewById(R.id.email);
        TextView call = (TextView) findViewById(R.id.call);
        TextView home = (TextView) findViewById(R.id.home);
        ImageView picture = (ImageView) findViewById(R.id.picture);


        Button 확인 = (Button)findViewById(R.id.교수확인);


        Professor_info p = (Professor_info) intent.getSerializableExtra("class");


        byte[] arr = p.getFace();
        Bitmap image = BitmapFactory.decodeByteArray(arr, 0, arr.length);


        picture.setImageBitmap(image);
        professor.setText(p.getName());
        name.setText(p.getName());
        school.setText(p.getSchool());
        major.setText(p.getMajor());
        room.setText(p.getRoom());
        email.setText(p.getEmail());
        call.setText(p.getCall());
        home.setText(p.getHome());

        확인.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

