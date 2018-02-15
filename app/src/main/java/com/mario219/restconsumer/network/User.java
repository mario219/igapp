package com.mario219.restconsumer.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mario on 30/01/18.
 */

public class User {

    @SerializedName("name")
    private String name;
    @SerializedName("token")
    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
