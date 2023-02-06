
package com.example.displayuser;


import com.example.displayuser.models.Data;
import com.example.displayuser.models.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApiService {

    @GET("api/users/{user}")
    Call<Data> getUser(@Path("user") String user);

    @GET("api/users")
    Call<Users> getUsers();


}