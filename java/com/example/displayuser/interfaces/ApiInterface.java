
package com.example.displayuser.interfaces;


import com.example.displayuser.models.UserData;
import com.example.displayuser.models.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("api/users/{user}")
    Call<UserData> getUser(@Path("user") String user);

    @GET("api/users")
    Call<Users> getUsers();

}