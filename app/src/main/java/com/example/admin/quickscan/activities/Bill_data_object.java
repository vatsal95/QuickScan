package com.example.admin.quickscan.activities;

/**
 * Created by Vatsal on 18-02-2016.
 */
public class Bill_data_object {

    private String mText1;
    private String mText2;

    Bill_data_object(String text1, String text2) {
        mText1 = text1;
        mText2 = text2;
    }

    public String getProductName() {
        return mText1;
    }

    public void setProductName(String mText1) {
        this.mText1 = mText1;
    }

    public String getProductDesc() {
        return mText2;
    }

    public void setProductDesc(String mText2) {
        this.mText2 = mText2;
    }
}


