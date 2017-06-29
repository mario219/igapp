package com.mario219.restconsumer.models;

/**
 * Created by marioalejndro on 28/06/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SessionModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("authToken")
    @Expose
    private String authToken;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("zone")
    @Expose
    private Object zone;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getZone() {
        return zone;
    }

    public void setZone(Object zone) {
        this.zone = zone;
    }

}
