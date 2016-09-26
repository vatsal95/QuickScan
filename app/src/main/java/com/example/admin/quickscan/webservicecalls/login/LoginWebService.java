package com.example.admin.quickscan.webservicecalls.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by chint on 3/13/2016.
 */
public interface LoginWebService {
    @POST("/api/login")
    Call<ResponseSuccessModel> login(@Body RequestModel loginModel);
}
