package com.example.dell.navbot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class insertwork_getCount {

    @Expose
    @SerializedName("name") private static String name;
    @Expose
    @SerializedName("type") private static String type;
    @Expose
    @SerializedName("mobile") private static int mobile;
    @Expose
    @SerializedName("message") private String message;


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        insertwork_getCount.name = name;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        insertwork_getCount.type = type;
    }


    public static int getPassword() {
        return mobile;
    }

    public static void setPassword(int password) {
        insertwork_getCount.mobile = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
