package com.example.admin.quickscan.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chint on 3/20/2016.
 */
public class User {
    @SerializedName("UId")
    public int UId;

    @SerializedName("UName")
    public int UName;

    @Override
    public String toString() {
        return "User{" +
                "UId=" + UId +
                ", UName=" + UName +
                '}';
    }

    public User(int UId, int UName) {
        this.UId = UId;
        this.UName = UName;
    }

    public int getUId() {

        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }

    public int getUName() {
        return UName;
    }

    public void setUName(int UName) {
        this.UName = UName;
    }
}
