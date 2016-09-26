package com.example.admin.quickscan.webservicecalls.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vatsal on 3/20/2016.
 */
public class RequestModel {
    @SerializedName("userEmail")
    String userEmail;

    @SerializedName("userPassword")
    String userPassword;

    public RequestModel(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
}
