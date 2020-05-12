package com.demo.pojo;

import java.io.Serializable;

public class product implements Serializable {
    private int ID;
    private String ProductName;
    private String Catalog;

    @Override
    public String toString() {
        return "product{" +
                "ID=" + ID +
                ", ProductName='" + ProductName + '\'' +
                ", Catalog='" + Catalog + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getCatalog() {
        return Catalog;
    }

    public void setCatalog(String catalog) {
        Catalog = catalog;
    }
}
