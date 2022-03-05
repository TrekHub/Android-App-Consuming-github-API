package com.example.gitsearch.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    @Expose
    private  String login;

    @SerializedName("html_url")
    @Expose
    private  String html_url;

    public User(String login, String html_url) {
        this.login = login;
        this.html_url = html_url;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
