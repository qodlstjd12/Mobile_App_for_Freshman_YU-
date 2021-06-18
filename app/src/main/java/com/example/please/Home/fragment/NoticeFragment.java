package com.example.please.Home.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.please.DB.ConnectionDB;
import com.example.please.Data.Myinfo;
import com.example.please.Data.Notice;
import com.example.please.DB.NoticeDB;
import com.example.please.NoticeListAdapter;
import com.example.please.R;
import com.example.please.Dialog.ViewDialog;
import com.example.please.Dialog.WriteDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class NoticeFragment extends Fragment {


    private ConnectionDB task;
    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.notice, container, false);
        TextView 글쓰기 = (TextView)root.findViewById(R.id.write);
        글쓰기.setPaintFlags(글쓰기.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        Bundle extra = getArguments();
        final Bundle bundle = new Bundle();
        final Myinfo myinfo = (Myinfo)extra.getSerializable("myinfo");
        final ViewDialog vd = new ViewDialog();
        try {
            noticeListView = (ListView) root.findViewById(R.id.noticeListView);
            noticeList = new ArrayList<Notice>();
            String result;
            String type = "getDataNT";
            NoticeDB task = new NoticeDB();
            result = task.execute(type).get();
            if(result.equals("")){

            }
            else {
                String[] arr1;
                String[] arr2;
                arr1 = result.split("\t\t");

                for (int i = 0; i < arr1.length; i++) {
                    arr2 = arr1[i].split("\t");
                    noticeList.add(new Notice(arr2[0], arr2[1], arr2[2]));
                }
                adapter = new NoticeListAdapter(getActivity(), noticeList);
                noticeListView.setAdapter(adapter);
                noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        bundle.putString("num",noticeList.get(position).getNum());
                        bundle.putString("title",noticeList.get(position).getNotice());
                        bundle.putSerializable("myinfo",myinfo);
                        vd.setArguments(bundle);
                        vd.show(getActivity().getSupportFragmentManager(),"tag");
                        vd.setDialogResult(new ViewDialog.OnMyDialogResult() {
                            @Override
                            public void finish(String result) {
                                if(result.equals("O")) {
                                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                    Fragment f;
                                    f = new NoticeFragment();
                                    f.setArguments(bundle);
                                    ft.replace(R.id.nav_host_fragment, f);
                                    ft.commit();
                                }
                            }
                        });
                    }
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } //View 됨

        글쓰기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myinfo.getAdmin().equals("1")){
                    WriteDialog wd = new WriteDialog();
                    wd.show(getActivity().getSupportFragmentManager(),"tag");
                    bundle.putSerializable("myinfo",myinfo);
                    wd.setDialogResult(new WriteDialog.OnMyDialogResult() {
                        @Override
                        public void finish(String result) {
                            if(result.equals("O")) {
                                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                Fragment f;
                                f = new NoticeFragment();
                                f.setArguments(bundle);
                                ft.replace(R.id.nav_host_fragment, f);
                                ft.commit();
                            }

                        }
                    });
                }else
                    Toast.makeText(getActivity().getApplicationContext(),"권한이 없습니다.",Toast.LENGTH_SHORT).show();
            }
        });


        return root;
    }
}