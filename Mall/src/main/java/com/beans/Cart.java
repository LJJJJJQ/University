package com.beans;

public class Cart {
    private String cid;
    private String commodityName;
    private double price;
    private int commodityID;
    private int num;

    public Cart() {
    }

    public Cart(int commodityID, int num) {
        this.commodityID = commodityID;
        this.num = num;
    }

    public Cart(String cid, String commodityName,double price, int num) {
        this.cid = cid;
        this.commodityName = commodityName;
        this.num = num;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(int commodityID) {
        this.commodityID = commodityID;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
