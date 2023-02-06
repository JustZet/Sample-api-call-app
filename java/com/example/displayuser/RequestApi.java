package com.example.displayuser;

import com.example.displayuser.models.Data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestApi {
    public static Call<Data> call(String userId) {
        final String BASE_URL = "https://reqres.in";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

                .build();

        UserApiService jsonUserApiCall = retrofit.create(UserApiService.class);

        Call<Data> call = jsonUserApiCall.getUser(userId);
        return call;
    }
}
