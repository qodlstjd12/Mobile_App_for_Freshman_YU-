package com.example.please.Data;

public class Notice {
    String num;
    String notice;
    String date;

    public Notice(String num, String notice, String date) {
        this.num = num;
        this.notice = notice;
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
