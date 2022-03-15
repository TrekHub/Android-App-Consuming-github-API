package com.example.gitsearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gitsearch.databinding.ActivityDashBoardBinding;
import com.example.gitsearch.model.Repo;
import com.example.gitsearch.model.User;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {

    ActivityDashBoardBinding binding;
    Bundle bundle;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.notificationIcon.setOnClickListener(this);
        binding.userIcon.setOnClickListener(this);
        binding.searchBtn.setOnClickListener(this);


        bundle = getIntent().getExtras();
        name = bundle.getString("name");
        String dashIntro = "Hello " + name;
        binding.dashIntro.setText(dashIntro);
    }

    //Onclick method
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);

        if (view == binding.userIcon) {
            startActivity(intent);

        }
        if (view == binding.notificationIcon) {
            startActivity(intent);

        }
        //getting user input
        if (view == binding.searchBtn) {
            String userName = binding.userSearch.getText().toString();
            loadJSON(userName);
        }
    }

//Function to fetch response from the api
    private void loadJSON(String userName) {
        try {
            Service apiService =
                    ApiClient.getClient().create(Service.class);
            Call<List<Repo>> call = apiService.getItems(userName);
            Call<User> userCall = apiService.getUserProfile(userName);

            //Get user repositories
            call.enqueue(new Callback<List<Repo>>() {
                @Override
                public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                    assert response.body() != null;
                    List<Repo> repos = response.body();
                    binding.baseListView.setAdapter(new RepoAdapter(DashBoard.this, repos));
                    System.out.println("success");
                    Toast.makeText(DashBoard.this, "Successfully Fetched Data", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(@NonNull Call<List<Repo>> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(DashBoard.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();

                }
            });

            //Get USer Profile
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                    assert response.body() != null;
                    User userProfile = response.body();
                    binding.repos.setText(String.valueOf(userProfile.getPublic_repos()));
                    binding.followers.setText(String.valueOf(userProfile.getFollowers()));
                    binding.following.setText(String.valueOf(userProfile.getFollowing()));
                    binding.gists.setText(String.valueOf(userProfile.getPublic_gists()));
                }
                @Override
                public void onFailure(@NonNull Call<User> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                }
            });

        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}