package com.example.gitsearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gitsearch.databinding.ActivityDashBoardBinding;
import com.example.gitsearch.model.Item;
import com.example.gitsearch.model.Repositories;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    TextView Disconnected;
    ProgressDialog pd;

    ActivityDashBoardBinding binding;
    String[] mRepoNames = {"Git Search", "Pizza Palace", "Restfull api", "Java spark website", "Mern stack project"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

//        binding.baseListView.setAdapter(new RepoAdapter(this, mRepoNames));
        binding.notificationIcon.setOnClickListener(this);
        binding.userIcon.setOnClickListener(this);
        loadJSON();


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

    }


    private void loadJSON() {
        try {
            ApiClient apiClient = new ApiClient();
            Service apiService =
                    apiClient.getClient().create(Service.class);
            Call<List<Item>> call = apiService.getItems();
            call.enqueue(new Callback<List<Item>>() {
                @Override
                public void onResponse( Call<List<Item>> call, Response<List<Item>> response) {

                    assert response.body() != null;
                    List<Item> items = response.body();
                    System.out.println("hello");
                    System.out.println(items.toString());
                    binding.baseListView.setAdapter(new RepoAdapter(DashBoard.this, items));
                    System.out.println("success");
                    Toast.makeText(DashBoard.this, "Successfully Fetched Data", Toast.LENGTH_SHORT).show();

                }




                @Override
                public void onFailure(Call<List<Item>> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(DashBoard.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();

                }
            });
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}