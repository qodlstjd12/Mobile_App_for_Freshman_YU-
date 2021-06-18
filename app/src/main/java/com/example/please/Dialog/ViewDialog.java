package com.example.please.Dialog;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.please.DB.NoticeDB;
import com.example.please.Data.Myinfo;
import com.example.please.R;


import java.util.concurrent.ExecutionException;

import androidx.fragment.app.DialogFragment;

public class ViewDialog extends DialogFragment {
    private String type;
    OnMyDialogResult mDialogResult;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.post_delete, container, false);

        try {
            NoticeDB task = new NoticeDB();
            final Bundle extra = getArguments();
            final Myinfo myinfo = (Myinfo) extra.getSerializable("myinfo");
            Button 확인, 삭제;
            final TextView 제목, 내용, 날짜;
            제목 = (TextView) root.findViewById(R.id.글조회_제목);
            내용 = (TextView) root.findViewById(R.id.글조회_내용);
            날짜 = (TextView) root.findViewById(R.id.글조회_날짜);

            확인 = (Button) root.findViewById(R.id.글조회_확인);
            삭제 = (Button) root.findViewById(R.id.글조회_삭제);
            type = "reDataNT";
            String str = task.execute(type,extra.getString("num"),extra.getString("title")).get();
            String[] arr;
            arr = str.split("\t");
            if (arr[0].equals(" ")) {
                내용.setGravity(Gravity.CENTER);
                삭제.setEnabled(false);
                내용.setTextSize(30);
                내용.setText("글이 삭제되었습니다.");
            } else {
                arr[0] = arr[0].replace("\\n",System.getProperty("line.separator"));
                내용.setText(arr[0]);
                제목.setText(arr[1]);
                날짜.setText(arr[2]);
            }
            삭제.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (myinfo.getAdmin().equals("1")) {
                        NoticeDB task = new NoticeDB();
                        type = "deleteNT";
                        String result;
                        task.execute(type, extra.getString("num"));
                        if( mDialogResult != null ){
                            mDialogResult.finish("O");
                        }
                        dismiss();
                    } else
                        Toast.makeText(getActivity(), "권한이 없습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            확인.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return root;
    }

    public void onResume() {

        super.onResume();
        int width, height;

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x * 8 / 9;
        height = size.y * 8 / 9;

        Window window = getDialog().getWindow();
        window.setLayout(width, height);
        //TODO:
    }

    public void setDialogResult(OnMyDialogResult dialogResult){
        mDialogResult = dialogResult;
    }

    public interface OnMyDialogResult{
        void finish(String result);
    }

}
