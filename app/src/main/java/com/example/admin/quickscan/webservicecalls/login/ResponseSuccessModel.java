package com.example.admin.quickscan.webservicecalls.login;

import com.example.admin.quickscan.models.User;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chint on 3/20/2016.
 */
public class ResponseSuccessModel {
    @SerializedName("responseStatus")
    public int responseStatus;

    @SerializedName("responseBody")
    public User responseBody;

    public ResponseSuccessModel(int responseStatus, User responseBody) {
        this.responseStatus = responseStatus;
        this.responseBody = responseBody;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public User getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(User responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "ResponseSuccessModel{" +
                "responseStatus=" + responseStatus +
                ", responseBody=" + responseBody +
                '}';
    }
}
