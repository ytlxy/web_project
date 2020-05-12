package com.demo.pojo;

import java.io.Serializable;

public class transaction implements Serializable {
    private int ID;
    private String Userid;
    private String Productid;

    @Override
    public String toString() {
        return "transaction{" +
                "ID=" + ID +
                ", Userid='" + Userid + '\'' +
                ", Productid='" + Productid + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getProductid() {
        return Productid;
    }

    public void setProductid(String productid) {
        Productid = productid;
    }
}
