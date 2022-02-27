package com.example.gitsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ImageView mNotification = (ImageView) findViewById(R.id.notification_icon);
        ImageView mUser = (ImageView) findViewById(R.id.user_icon);


        mNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashBoard.this, "No Notifications!!", Toast.LENGTH_LONG).show();
            }
        });


        mUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashBoard.this, "Create a new Profile", Toast.LENGTH_LONG).show();

            }
        });


    }
}