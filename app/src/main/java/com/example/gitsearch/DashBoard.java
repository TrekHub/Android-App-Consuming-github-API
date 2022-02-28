package com.example.gitsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gitsearch.databinding.ActivityDashBoardBinding;
import com.example.gitsearch.databinding.ActivityMainBinding;

public class DashBoard extends AppCompatActivity {

    ActivityDashBoardBinding binding;
    ListView listView;
    String[] mRepoNames = {"Git Search", "Pizza Palace", "Restfull api", "Java spark website", "Mern stack project"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      setContentView(R.layout.activity_dash_board);

        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.baseListView.setAdapter(new RepoAdapter(this, mRepoNames));
        binding.notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoard.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });


        binding.userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoard.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}