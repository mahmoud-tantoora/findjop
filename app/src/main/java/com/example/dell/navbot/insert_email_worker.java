package com.example.dell.navbot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class insert_email_worker {
    @Expose
    @SerializedName("email") private static String email;
    @Expose
    @SerializedName("id_worker") private static int id_worker;
    @Expose
    @SerializedName("password") private String password;
    @Expose
    @SerializedName("phone") private int phone;
    @Expose
    @SerializedName("type") private int type;
    @Expose
    @SerializedName("message") private String message;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        insert_email_worker.email = email;
    }

    public static int getId_worker() {
        return id_worker;
    }

    public static void setId_worker(int id_worker) {
        insert_email_worker.id_worker = id_worker;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
