package com.example.ahmedd.route.API;

import com.example.ahmedd.route.API.Login.Login;
import com.example.ahmedd.route.API.Survey.Survey;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Serviecs {


    @POST("login")
    Call<Login> login(@Query("user_name") String userName,
                      @Query("password") String password);
        ///login?user_name=nobel&password=123456


}
