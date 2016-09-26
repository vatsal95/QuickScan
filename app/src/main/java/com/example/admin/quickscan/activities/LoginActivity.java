package com.example.admin.quickscan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.quickscan.R;
import com.example.admin.quickscan.models.User;
import com.example.admin.quickscan.util.SharedPreferencesUtils;
import com.example.admin.quickscan.webservicecalls.login.LoginWebService;
import com.example.admin.quickscan.webservicecalls.login.RequestModel;
import com.example.admin.quickscan.webservicecalls.login.ResponseFailureModel;
import com.example.admin.quickscan.webservicecalls.login.ResponseSuccessModel;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    EditText edUserName, etLoginPsswd;
    String Edname, Edpwd;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserName = (EditText) findViewById(R.id.edUserName);
        etLoginPsswd = (EditText) findViewById(R.id.etLoginPsswd);
        Edname = edUserName.getText().toString();
        Edpwd = etLoginPsswd.getText().toString();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.e-grocery.insuurelife.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void loginUser(View view) {
        LoginWebService service = retrofit.create(LoginWebService.class);
        Call<ResponseSuccessModel> mainResponseCall = service.login(new RequestModel(edUserName.getText().toString(), etLoginPsswd.getText().toString()));
        mainResponseCall.enqueue(new Callback<ResponseSuccessModel>() {
            @Override
            public void onResponse(Call<ResponseSuccessModel> call, Response<ResponseSuccessModel> response) {

                if (response.isSuccess()) {
                    User user = response.body().getResponseBody();
                    Toast.makeText(LoginActivity.this, response.body().getResponseBody().toString(), Toast.LENGTH_SHORT).show();
                    Log.i("Success", response.body().getResponseBody().toString());
                    SharedPreferencesUtils.getInstance(LoginActivity.this).setInt("UserId", user.getUId());
                } else {
                    ResponseBody responseBody = response.errorBody();
                    Gson gson = new Gson();
//                    try {
//                        ResponseFailureModel responseFailureModel = gson.fromJson(new String(responseBody.bytes(), "UTF-8"), ResponseFailureModel.class);
//                        Toast.makeText(LoginActivity.this, responseFailureModel.getResponseBody(), Toast.LENGTH_SHORT).show();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
//                MainResponse mainResponse = response.body();
//                Toast.makeText(LoginActivity.this, mainResponse.getResponseBody(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseSuccessModel> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

//        if( edUserName.getText().toString().equals("Thakkar") && (etLoginPsswd.getText().toString().equals("12345"))) {
//            new LoginAsyncTask().execute();
//        } else {
//            Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();
//        }
    }


    public void registerUser(View view) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}
