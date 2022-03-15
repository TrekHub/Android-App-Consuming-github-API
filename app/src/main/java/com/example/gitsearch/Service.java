package com.example.gitsearch;

import com.example.gitsearch.model.Repo;
import com.example.gitsearch.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("/users/{userName}/repos")
    Call<List<Repo>> getItems(@Path("userName") String userName);

    @GET("/user")
    Call<User> getAuthUser();

    @GET("/users/{userName}")
    Call<User> getUserProfile(@Path("userName")String userName);
}
