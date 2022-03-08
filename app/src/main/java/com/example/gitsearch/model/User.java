package com.example.gitsearch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    @Expose
    private  String login;

    @SerializedName("public_repos")
    @Expose
    private int public_repos;


    @SerializedName("followers")
    @Expose
    private int followers;


    @SerializedName("following")
    @Expose
    private int following;


    @SerializedName("public_gists")
    @Expose
    private int public_gists;

    public User(String login, int public_repos, int followers, int following, int public_gists) {
        this.login = login;
        this.public_repos = public_repos;
        this.followers = followers;
        this.following = following;
        this.public_gists = public_gists;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getPublic_gists() {
        return public_gists;
    }

    public void setPublic_gists(int public_gists) {
        this.public_gists = public_gists;
    }
}
