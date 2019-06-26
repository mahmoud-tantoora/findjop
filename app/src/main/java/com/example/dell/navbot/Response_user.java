package com.example.dell.navbot;

import com.google.gson.annotations.SerializedName;

public class Response_user {

    @SerializedName("response")
    private  String response;

    public Response_user(String R)
    {
        response=R;
    }
    public String getResponse()
    {
        return response;
    }

}
