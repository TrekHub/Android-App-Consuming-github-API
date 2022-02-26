package com.example.gitsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mGitBtn = (Button) findViewById(R.id.gitBtn);
        mGitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DashBoard.class);
                startActivity(intent);

            }
        });
    }
}