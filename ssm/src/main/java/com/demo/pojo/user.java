package com.demo.pojo;

import java.io.Serializable;

public class user implements Serializable {
    private int ID;
    private String UserName;
    private String Yel;

    @Override
    public String toString() {
        return "user{" +
                "ID=" + ID +
                ", UserName='" + UserName + '\'' +
                ", Yel='" + Yel + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getYel() {
        return Yel;
    }

    public void setYel(String yel) {
        Yel = yel;
    }
}
