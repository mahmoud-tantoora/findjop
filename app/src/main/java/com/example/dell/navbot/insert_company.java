package com.example.dell.navbot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class insert_company {

    @Expose
    @SerializedName("name") private static String name;
    @Expose
    @SerializedName("specializing") private static String specializing;
    @Expose
    @SerializedName("mobile") private static int mobile;
    @Expose
    @SerializedName("message") private String message;


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        insert_company.name = name;
    }

    public static String getspecializing() {
        return specializing;
    }

    public static void setspecializing(String specializing) {
        insert_company.specializing = specializing;
    }


    public static int getPassword() {
        return mobile;
    }

    public static void setPassword(int password) {
        insert_company.mobile = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
