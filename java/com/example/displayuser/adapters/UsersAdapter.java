package com.example.displayuser.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.displayuser.R;
import com.example.displayuser.models.User;

import java.util.List;


public class UsersAdapter extends ArrayAdapter<User> {
    private Context context;
    private List<User> users;

    TextView userFirstName;
    TextView userLastName;
    TextView userEmail;
    ImageView userAvatar;

    public UsersAdapter(Context context, List<User> users) {
        super(context, R.layout.user_card, users);
        this.context = context;
        this.users = users;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.user_card, parent, false);

        User user = users.get(position);

        this.getUserView(convertView);
        this.setUserView(user);

        return convertView;
    }

    public void getUserView(View v) {
         userFirstName = v.findViewById(R.id.card_userLastName);
         userLastName =  v.findViewById(R.id.card_userFirstName);
         userEmail = v.findViewById(R.id.card_userEmail);
         userAvatar = v.findViewById(R.id.card_userAvatar);
    }

    public void setUserView(User user) {
        userFirstName.setText(String.valueOf(user.getFirstName()));
        userLastName.setText(String.valueOf(user.getLastName()));
        userEmail.setText(String.valueOf(user.getEmail()));
        Glide.with(context)
            .load(user.getAvatar())
            .into(userAvatar);
    }


}
