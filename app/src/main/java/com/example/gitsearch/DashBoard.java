package com.example.gitsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {
    ListView listView;
    String[] mRepoNames = {"Teddy", "Martin", "Brian", "George", "Kelvin", "Ibrahim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ImageView mNotification = (ImageView) findViewById(R.id.notification_icon);
        ImageView mUser = (ImageView) findViewById(R.id.user_icon);

        listView = (ListView) findViewById(R.id.base_ListView);
        listView.setAdapter(new RepoAdapter(this, mRepoNames));


        mNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoard.this, NotificationsActivity.class);
                startActivity(intent);

            }
        });


        mUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashBoard.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}