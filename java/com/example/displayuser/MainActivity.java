package com.example.displayuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.displayuser.models.Data;
import com.example.displayuser.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.displayUser("5");

    }
    public void displayUser(String id) {

        TextView firstName = findViewById(R.id.firstName);
        TextView lastName = findViewById(R.id.lastName);
        TextView email = findViewById(R.id.email);
        ImageView avatar = findViewById(R.id.avatar);


        Call<Data> call = RequestApi.call(id);

        call.enqueue(new Callback<Data>() {

            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                User user = response.body().getData();

                email.setText(user.getEmail());
                firstName.setText(user.getFirstName());
                lastName.setText(user.getLastName());

                Glide.with(getApplicationContext()).load(user.getAvatar()).into(avatar);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }


}