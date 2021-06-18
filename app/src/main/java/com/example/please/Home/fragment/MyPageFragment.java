package com.example.please.Home.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.please.ChangePW.MyPwChangeActivity;
import com.example.please.DB.ConnectionDB;
import com.example.please.Data.Myinfo;
import com.example.please.Login.LoginViewActivity;
import com.example.please.R;

import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

public class MyPageFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.mypage, container, false);
        Bundle extra = getArguments();


        TextView 내이름,내폰,내이메일;
        Button 비밀번호변경,회원탈퇴;

        내이름 = (TextView)root.findViewById(R.id.myname);
        내폰 = (TextView)root.findViewById(R.id.myphone);
        내이메일 = (TextView)root.findViewById(R.id.myemail);

        비밀번호변경 = (Button)root.findViewById(R.id.myPwChnge);
        회원탈퇴 = (Button)root.findViewById(R.id.회원탈퇴);

        final Myinfo myinfo = (Myinfo) extra.getSerializable("myinfo");

        내이름.setText(myinfo.getName());
        내폰.setText(myinfo.getPhone());
        내이메일.setText(myinfo.getEmail());

        비밀번호변경.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyPwChangeActivity.class);
                intent.putExtra("myinfo",myinfo);
                startActivity(intent);
            }
        });
        회원탈퇴.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("회원 탈퇴").setMessage("정말로 회원 탈퇴 하시겠습니까??");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            String[] arr;
                            String type = "ViewNB";
                            ConnectionDB task = new ConnectionDB();
                            String result = task.execute(type,myinfo.getId()).get();
                            arr = result.split("\t");
                            if(!arr[4].equals(" ")){
                                Toast.makeText(getActivity(),"노트북을 먼저 반납해 주세요.",Toast.LENGTH_SHORT).show();
                            }else if(!arr[3].equals(" ")){
                                type = "CancelNB";
                                task = new ConnectionDB();
                                task.execute(type,myinfo.getId());
                                type = "dropCheckDB";
                                task = new ConnectionDB();
                                task.execute(type,myinfo.getId()).get();
                                ActivityCompat.finishAffinity(getActivity());
                                Intent intent = new Intent(getActivity().getApplicationContext(), LoginViewActivity.class);
                                startActivity(intent);
                            }else{
                                type = "dropCheckDB";
                                task = new ConnectionDB();
                                task.execute(type,myinfo.getId()).get();
                                ActivityCompat.finishAffinity(getActivity());
                                Intent intent = new Intent(getActivity().getApplicationContext(), LoginViewActivity.class);
                                startActivity(intent);}
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return root;
    }

}