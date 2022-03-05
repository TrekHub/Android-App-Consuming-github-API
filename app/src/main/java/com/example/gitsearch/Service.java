package com.example.gitsearch;

import com.example.gitsearch.model.Item;
import com.example.gitsearch.model.Repositories;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/users/trekhub/repos")
    Call<List<Item>> getItems();
}
