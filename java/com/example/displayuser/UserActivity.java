package com.example.displayuser;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.displayuser.models.UserData;
import com.example.displayuser.models.User;
import com.example.displayuser.services.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    TextView firstName;
    TextView lastName;
    TextView email;
    ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        this.initUI();
        this.parseUser();
    }

    // Init global variables
    public void initUI() {
         firstName = findViewById(R.id.user_firstName);
         lastName = findViewById(R.id.user_lastName);
         email = findViewById(R.id.user_email);
         avatar = findViewById(R.id.user_avatar);
    }

    public void parseUser() {
        Bundle extras = getIntent().getExtras();

        // get user id
        if (extras != null) {
            String value = extras.getString("userId");
            this.fetchUserData(value);

        // get default user id
        } else {
            this.fetchUserData("1");
        }

    }

    // fetch user with defined id
    public void fetchUserData(String id) {

        Call<UserData> call = ApiService.getUser(id);

        call.enqueue(new Callback<UserData>() {

            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                User user = response.body().getData();

                email.setText(user.getEmail());
                firstName.setText(user.getFirstName());
                lastName.setText(user.getLastName());

                Glide.with(getApplicationContext()).load(user.getAvatar()).into(avatar);
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {}
        });
    }

}