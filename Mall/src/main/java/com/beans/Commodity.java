package com.beans;

public class Commodity {
    private int cid;
    private String cname;
    private double price;
    private int num;

    public Commodity() {
    }

    public Commodity(String cname, double price, int num) {
        this.cname = cname;
        this.price = price;
        this.num = num;
    }

    public Commodity(int cid, String cname, double price, int num) {
        this.cid = cid;
        this.cname = cname;
        this.price = price;
        this.num = num;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
