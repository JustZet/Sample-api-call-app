package com.example.displayuser.services;

import com.example.displayuser.interfaces.ApiInterface;
import com.example.displayuser.models.UserData;
import com.example.displayuser.models.Users;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://reqres.in";

    public static synchronized Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }

    public static Call<UserData> getUser(String userId) {
        ApiInterface jsonUserApiCall = getRetrofit().create(ApiInterface.class);
        return jsonUserApiCall.getUser(userId);
    }

    public static Call<Users> getUsers() {
        ApiInterface jsonUserApiCall = getRetrofit().create(ApiInterface.class);
        return jsonUserApiCall.getUsers();
    }
}



