package com.example.gitsearch;

import com.example.gitsearch.model.Repositories;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/users/trekhub/repos")
    Call<Repositories> getItems();
}
