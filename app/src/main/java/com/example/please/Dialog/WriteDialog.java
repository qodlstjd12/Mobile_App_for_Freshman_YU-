package com.example.please.Dialog;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.please.DB.NoticeDB;
import com.example.please.R;

import java.util.concurrent.ExecutionException;

import androidx.fragment.app.DialogFragment;

public class WriteDialog extends DialogFragment {
    WriteDialog.OnMyDialogResult mDialogResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.post_write, container, false);

        final NoticeDB task = new NoticeDB();

        final EditText 제목, 내용;
        Button 확인, 취소;
        제목 = (EditText) root.findViewById(R.id.글쓰기_제목);
        내용 = (EditText) root.findViewById(R.id.글쓰기_내용);

        확인 = (Button) root.findViewById(R.id.글쓰기_확인);
        취소 = (Button) root.findViewById(R.id.글쓰기_취소);



        확인.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String title,contents;

                    title = 제목.getText().toString();
                    contents = 내용.getText().toString();
                    contents = contents.replace(System.getProperty("line.separator"),"\\n");

                    String type = "writeNT";
                    String result;
                    result = task.execute(type,contents,title).get();
                    if( mDialogResult != null ){
                        mDialogResult.finish("O");
                    }
                    dismiss();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        취소.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return root;
    }
    public void onResume()
    {
        super.onResume();
        int width,height;

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x*8/9;
        height = size.y*8/9;

        Window window = getDialog().getWindow();
        window.setLayout(width,height);
    }
    public void setDialogResult(WriteDialog.OnMyDialogResult dialogResult){

        mDialogResult = dialogResult;
    }
    public interface OnMyDialogResult{

        void finish(String result);

    }
}

