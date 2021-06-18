package com.example.please;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.please.Data.Notice;

import java.util.List;

public class NoticeListAdapter extends BaseAdapter {
    private Context context;
    private List<Notice> noticeList;

    public NoticeListAdapter(Context context, List<Notice> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int i) {
        return noticeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View.inflate(context,R.layout.notice_item,null);
        TextView 공지사항제목 = (TextView) v.findViewById(R.id.공지사항제목);
        TextView 공지사항날짜 = (TextView) v.findViewById(R.id.공지사항날짜);
        TextView 공지사항번호 = (TextView) v.findViewById(R.id.공지사항번호);

        공지사항제목.setText(noticeList.get(i).getNotice());
        공지사항날짜.setText(noticeList.get(i).getDate());
        공지사항번호.setText(noticeList.get(i).getNum());
        v.setTag(noticeList.get(i).getNotice());
        return v;
    }


}
