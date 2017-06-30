package com.mario219.restconsumer.models;

/**
 * Created by marioalejndro on 29/06/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class SessionErrorResponse  {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("error")
    @Expose
    private String error;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}