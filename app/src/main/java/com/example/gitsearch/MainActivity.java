package com.example.gitsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.gitsearch.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.gitBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, DashBoard.class);
        if (view == binding.gitBtn) {
            startActivity(intent);

        }

    }
}