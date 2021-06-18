package com.example.please.Home.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.please.DB.ConnectionDB;
import com.example.please.Data.Myinfo;
import com.example.please.R;

import java.util.concurrent.ExecutionException;

public class NoteBookFragment extends Fragment {
    ConnectionDB task;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.notebook, container, false);

        Bundle extra = this.getArguments();
        extra = getArguments();
        Myinfo myinfo = (Myinfo) extra.getSerializable("myinfo");
        final String id = myinfo.getId();
        final TextView 노트북잔여수 = (TextView) root.findViewById(R.id.노트북잔여수);
        final TextView 예약자수 = (TextView) root.findViewById(R.id.예약자수);
        final TextView 나의순번 = (TextView) root.findViewById(R.id.나의순번);
        final TextView 반납날짜 = (TextView)root.findViewById(R.id.반납날짜);
        Button 신청 = (Button) root.findViewById(R.id.신청);
        Button 연장 = (Button) root.findViewById(R.id.연장);
        Button 예약취소 = (Button) root.findViewById(R.id.예약취소);

        try {
            String type = "ViewNB";
            task = new ConnectionDB();
            String str = task.execute(type, id).get();
            String[] arr;
            arr = str.split("\t");
            노트북잔여수.setText(arr[1]);
            예약자수.setText(arr[2]);
            나의순번.setText(arr[3]);
            반납날짜.setText(arr[4]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        신청.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String type = "registerNB";
                    task = new ConnectionDB();
                    String str = task.execute(type, id).get();

                    String[] arr;
                    arr = str.split("\t");

                    switch (arr[0]) {
                        case "Already_Borrow":
                            Toast.makeText(getActivity(), "이미 대여하셨습니다.", Toast.LENGTH_SHORT).show();
                            break;
                        case "Your_Waiting":
                            Toast.makeText(getActivity(), "당신의 순번은" + arr[1] + "입니다.", Toast.LENGTH_SHORT).show();
                            break;
                        case "WatingNB_O":
                            Toast.makeText(getActivity(), "예약자로 등록되었습니다.", Toast.LENGTH_SHORT).show();
                            노트북잔여수.setText(arr[1]);
                            예약자수.setText(arr[2]);
                            나의순번.setText(arr[3]);
                            break;
                        case "RegisterNB_O":
                            노트북잔여수.setText(arr[1]);
                            예약자수.setText(arr[2]);
                            나의순번.setText(arr[3]);
                            반납날짜.setText(arr[4]);
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                            builder.setTitle("반납 날짜").setMessage("반납 날짜는 " + arr[4]+"입니다. 기간내에 반납해주세요.");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                            break;
                        case "Erroor":
                            str = "뭔가가 잘못됐어요...";
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        연장.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (나의순번.getText().equals("이미 빌렸습니다.")) {
                    try {
                        String type = "ExtendNB";
                        task = new ConnectionDB();
                        String str = task.execute(type, id).get();

                        String[] arr;
                        arr = str.split("\t");
                        if(예약자수.getText().equals("0")) {
                            switch (arr[0]) {
                                case "ExtendNB_O":
                                    반납날짜.setText(arr[1]);
                                    Toast.makeText(getActivity(), "연장됐습니다 ㅎ", Toast.LENGTH_SHORT).show();
                                    break;
                                case "ExtendNB_X":
                                    Toast.makeText(getActivity(), "대이열로부터 2주후 연장신청이 가능합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }else
                            Toast.makeText(getActivity().getApplicationContext(),"예약자가 있을 경우 연장할 수 없습니다.",Toast.LENGTH_SHORT).show();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getActivity().getApplicationContext(),"노트북을 먼저 대여해 주십시오.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        예약취소.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(나의순번.getText().equals("이미 빌렸습니다.")||나의순번.getText().equals(" ")){
                    Toast.makeText(getActivity(),"예약자가 아닙니다.",Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        String type = "CancelNB";
                        task = new ConnectionDB();
                        String str = task.execute(type, id).get();

                        String[] arr;
                        arr = str.split("\t");

                        예약자수.setText(arr[1]);
                        나의순번.setText(" ");


                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        return root;
    }
}