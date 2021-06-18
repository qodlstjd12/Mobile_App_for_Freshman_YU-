package com.example.please.Data;

import java.io.Serializable;

public class Myinfo implements Serializable {
     String id;
     String pwd;
     String name;
     String email;
     String phone;
     String gen;
     String school;
     String admin;


        public Myinfo(String id, String pwd, String name, String email, String phone, String gen, String school, String admin) {
            this.id = id;
            this.pwd = pwd;
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.gen = gen;
            this.school = school;
            this.admin = admin;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
