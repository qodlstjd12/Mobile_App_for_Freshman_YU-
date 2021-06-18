package com.example.please.Data;

import java.io.Serializable;

public class Professor_info implements Serializable {

    String name;
    String school;
    String major;
    String room;
    String email;
    String call;
    String home;
    byte[] face;

    public byte[] getFace() {
        return face;
    }

    public void setFace(byte[] face) {
        this.face = face;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getMajor() {
        return major;
    }

    public String getRoom() {
        return room;
    }

    public String getEmail() {
        return email;
    }

    public String getCall() {
        return call;
    }

    public String getHome() {
        return home;
    }



}
