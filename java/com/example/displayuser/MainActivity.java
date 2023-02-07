package com.example.displayuser;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.displayuser.adapters.UsersAdapter;
import com.example.displayuser.models.User;
import com.example.displayuser.models.Users;
import com.example.displayuser.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private ListView listViewUsers;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        onUserClick();
    }

    public void initUI() {
        listViewUsers = findViewById(R.id.users_listView);
        fetchUsersData();
    }

    // fetch users from api and set users in listView
    private void fetchUsersData() {
        Call<Users> call = ApiService.getUsers();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                users = response.body().getData();
                listViewUsers.setAdapter(new UsersAdapter(getApplicationContext(), users));
            }
            @Override
            public void onFailure(Call<Users> call, Throwable t) {}
        });
    }

    // open user page when clicked
    private void onUserClick() {
        listViewUsers.setOnItemClickListener(
            (parent, view, position, id) -> {
                Intent intent = new Intent(this, UserActivity.class);

                int userId = position += 1;
                intent.putExtra("userId", String.valueOf(userId));
                startActivity(intent);
            }
        );
    }








}