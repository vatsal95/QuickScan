package com.example.admin.quickscan.models;

/**
 * Created by ADMIN on 09-02-2016.
 */
public class BillDetails {
    private int product_pic,qty,PId;
    private String product_name,product_price,product_date;


    public BillDetails(int product_pic, int qty, int PId, String product_name, String product_price, String product_date) {
        this.product_pic = product_pic;
        this.qty = qty;
        this.PId = PId;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_date = product_date;
    }

    public int getProduct_pic() {
        return product_pic;
    }

    public void setProduct_pic(int product_pic) {
        this.product_pic = product_pic;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPId() {
        return PId;
    }

    public void setPId(int PId) {
        this.PId = PId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }
}
