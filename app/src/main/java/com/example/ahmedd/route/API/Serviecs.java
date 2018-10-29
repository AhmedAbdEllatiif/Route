package com.example.ahmedd.route.API;

import com.example.ahmedd.route.API.Login.Login;
import com.example.ahmedd.route.API.Survey.Survey;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Serviecs {


    @POST("login")
    @FormUrlEncoded
    Call<Login> login(@Field("user_name") String userName,
                      @Field("password") String password);
        ///login?user_name=nobel&password=123456


}
