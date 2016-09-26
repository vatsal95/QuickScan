package com.example.admin.quickscan.models;

/**
 * Created by ADMIN on 19-02-2016.
 */
public class ProductDetails {
    int ProductId;
    String Product_Name,Product_Price,qty,Date_Order;
    int Product_Image;

    public ProductDetails(int productId, String product_Name, String product_Price, String qty, String date_Order, int product_Image) {
        this.ProductId = productId;
        this.Product_Name = product_Name;
        this.Product_Price = product_Price;
        this.qty = qty;
        this.Date_Order = date_Order;
        this.Product_Image = product_Image;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public String getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(String product_Price) {
        Product_Price = product_Price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDate_Order() {
        return Date_Order;
    }

    public void setDate_Order(String date_Order) {
        Date_Order = date_Order;
    }

    public int getProduct_Image() {
        return Product_Image;
    }

    public void setProduct_Image(int product_Image) {
        Product_Image = product_Image;
    }
}
