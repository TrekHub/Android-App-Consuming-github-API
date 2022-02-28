package com.example.gitsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.gitsearch.databinding.ActivityDashBoardBinding;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {
    ActivityDashBoardBinding binding;
    String[] mRepoNames = {"Git Search", "Pizza Palace", "Restfull api", "Java spark website", "Mern stack project"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.baseListView.setAdapter(new RepoAdapter(this, mRepoNames));
        binding.notificationIcon.setOnClickListener(this);
        binding.userIcon.setOnClickListener(this);


    }

    //Onclick method

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(DashBoard.this, ProfileActivity.class);

        if (view == binding.userIcon) {
            startActivity(intent);

        }
        if (view == binding.notificationIcon) {
            startActivity(intent);

        }

    }
}