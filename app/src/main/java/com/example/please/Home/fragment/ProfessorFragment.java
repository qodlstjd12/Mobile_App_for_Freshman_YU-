package com.example.please.Home.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.please.Data.Professor_info;
import com.example.please.Home.Professor_View;
import com.example.please.R;

import java.io.ByteArrayOutputStream;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ProfessorFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.professor, container, false);
        Bundle extra = getArguments();
        final Professor_info p = new Professor_info();
        TextView btn_1 = (TextView)root.findViewById(R.id.button_1);
        btn_1.setPaintFlags(btn_1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);
                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kjw);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("곽종욱");
                p.setSchool("서울대학교(컴퓨터공학과)");
                p.setMajor("컴퓨터구조, 운영체제, 임베디드 시스템");
                p.setRoom("IT관 217호");
                p.setEmail("kwak@yu.ac.kr");
                p.setCall("053-810-3533");
                p.setHome("http://yu.ac.kr/~kwak");
                p.setFace(byteArray);
                intent.putExtra("class", p);
                startActivity(intent);
            }
        });


        TextView btn_2 = (TextView) root.findViewById(R.id.button_2);
        btn_2.setPaintFlags(btn_2.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.syh);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("손영호");
                p.setSchool("Texas A,M Univ. Ph.D.(Electrical,Computer Eng.전공)");
                p.setMajor("Sensor Informatics, Computational Modeling");
                p.setRoom("IT관 205호");
                p.setEmail("ysohn@ynu.ac.kr ");
                p.setCall("053-810-2482");
                p.setHome("");

                p.setFace(byteArray);
                intent.putExtra("class", p);


                startActivity(intent);
            }
        });
        TextView btn_3 = (TextView) root.findViewById(R.id.button_3);
        btn_3.setPaintFlags(btn_3.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kwh);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("김욱현");
                p.setSchool("일)쯔꾸바대 Ph.D.(공학연구전공)");
                p.setMajor("시각정보처리");
                p.setRoom("IT관 218호");
                p.setEmail("whkim@yu.ac.kr ");
                p.setCall("053-810-2558");
                p.setHome("http://vipsun.yeungnam.ac.kr");

                p.setFace(byteArray);
                intent.putExtra("class", p);

                startActivity(intent);
            }
        });
        TextView btn_4 = (TextView) root.findViewById(R.id.button_4);
        btn_4.setPaintFlags(btn_4.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kjk);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("김종근");
                p.setSchool("일)전기통신대 공학박사(정보공학전공)");
                p.setMajor("컴퓨터망");
                p.setRoom("IT관 207호");
                p.setEmail("cgkim@yu.ac.kr ");
                p.setCall("053-810-2555");
                p.setHome("http://ynucc.yeungnam.ac.kr/~cgkim");

                p.setFace(byteArray);
                intent.putExtra("class", p);

                startActivity(intent);
            }
        });
        TextView btn_5 = (TextView) root.findViewById(R.id.button_5);
        btn_5.setPaintFlags(btn_5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);
                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pch);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("박창현");
                p.setSchool("서울대 이학박사(계산통계학전공)");
                p.setMajor("지식기반시스템");
                p.setRoom("IT관 211호");
                p.setEmail("park@yu.ac.kr");
                p.setCall("053-810-2557");
                p.setHome("http://cse.yu.ac.kr/~park");

                p.setFace(byteArray);
                intent.putExtra("class", p);


                startActivity(intent);
            }
        });
        TextView btn_6 = (TextView) root.findViewById(R.id.button_6);
        btn_6.setPaintFlags(btn_6.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sys);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("서영석");
                p.setSchool("KAIST 공학박사 (전산학 소프트웨어공학 전공)");
                p.setMajor("소프트웨어 공학");
                p.setRoom("IT관 225호");
                p.setEmail("ysseo@yu.ac.kr");
                p.setCall("053-810-3534");
                p.setHome("");

                p.setFace(byteArray);
                intent.putExtra("class", p);

                startActivity(intent);
            }
        });
        TextView btn_7 = (TextView) root.findViewById(R.id.button_7);
        btn_7.setPaintFlags(btn_1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sku);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("사공운");
                p.setSchool("");
                p.setMajor("BioInformatics");
                p.setRoom("IT관 209호");
                p.setEmail("wsagong@yu.ac.kr");
                p.setCall("053-810-2554");
                p.setHome("");

                p.setFace(byteArray);
                intent.putExtra("class", p);

                startActivity(intent);
            }
        });
        TextView btn_8 = (TextView) root.findViewById(R.id.button_8);
        btn_8.setPaintFlags(btn_1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("안병철");
                p.setSchool("미)오레곤주립대 Ph.D.(전기및전산공학전공)");
                p.setMajor("다중컴퓨터");
                p.setRoom("IT관 216호");
                p.setEmail("b.ahn@yu.ac.kr ");
                p.setCall("053-810-2556");
                p.setHome("http://msl.yu.ac.kr");

                p.setFace(byteArray);
                intent.putExtra("class", p);
                startActivity(intent);
            }
        });
        TextView btn_9 = (TextView) root.findViewById(R.id.button_9);
        btn_9.setPaintFlags(btn_1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yjh);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("윤종희");
                p.setSchool("서울대학교 공학박사(전기컴퓨터공학전공)");
                p.setMajor("컴파일러, 소프트웨어 최적화 및 보안");
                p.setRoom("IT관 231호");
                p.setEmail("youn@yu.ac.kr ");
                p.setCall("053-810-2552");
                p.setHome("http://sos.yu.ac.kr");

                p.setFace(byteArray);
                intent.putExtra("class", p);

                startActivity(intent);
            }
        });
        TextView btn_10 = (TextView) root.findViewById(R.id.button_10);
        btn_10.setPaintFlags(btn_10.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lkd);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();


                p.setName("이기동");
                p.setSchool("서울대 공학박사(제어계측공학전공)");
                p.setMajor("로보틱스");
                p.setRoom("IT관 233호");
                p.setEmail("kdrhee@yu.ac.kr");
                p.setCall("053-810-2584");
                p.setHome("http://sos.yu.ac.kr");

                p.setFace(byteArray);
                intent.putExtra("class", p);

                startActivity(intent);
            }
        });
        TextView btn_11 = (TextView) root.findViewById(R.id.button_11);
        btn_11.setPaintFlags(btn_11.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_11.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chr);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("조행래");
                p.setSchool("서울대학교(컴퓨터공학과)");
                p.setMajor("데이터베이스,알고리즘,자료구조");
                p.setRoom("IT관 215호");
                p.setEmail("hrcho@yu.ac.kr");
                p.setCall("053-810-2559");
                p.setHome("http://ynucc.yu.ac.kr/");

                p.setFace(byteArray);
                intent.putExtra("class", p);

                startActivity(intent);
            }
        });
        TextView btn_12 = (TextView) root.findViewById(R.id.button_12);
        btn_12.setPaintFlags(btn_12.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hds);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                p.setName("황도삼");
                p.setSchool("Natural Language Processing Kyoto University");
                p.setMajor("언어미디어통신");
                p.setRoom("IT관 204호");
                p.setEmail("dshwang@yu.ac.kr");
                p.setCall("053-810-3515");
                p.setHome("http://lp.yu.ac.kr/~dshwang/");

                p.setFace(byteArray);
                intent.putExtra("class", p);
                startActivity(intent);
            }
        });
        TextView btn_13 = (TextView) root.findViewById(R.id.button_13);
        btn_13.setPaintFlags(btn_13.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btn_13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity().getApplicationContext(),
                        Professor_View.class);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hjk);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();


                p.setName("홍정규");
                p.setSchool("고려대학교 공학사(컴퓨터통신공학)");
                p.setMajor("컴퓨팅 및 메모리 시스템");
                p.setRoom("IT관 236호");
                p.setEmail("jhong@yu.ac.kr");
                p.setCall("053-810-2553");
                p.setHome("https://sites.google.com/view/jhong");

                p.setFace(byteArray);
                intent.putExtra("class", p);

                startActivity(intent);


            }
        });



        return root;
    }

}