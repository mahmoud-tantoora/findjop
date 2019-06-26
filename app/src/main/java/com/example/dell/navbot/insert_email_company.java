package com.example.dell.navbot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class insert_email_company {


    @Expose
    @SerializedName("email") private static String email;
    @Expose
    @SerializedName("id_company") private static int id_company;
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
        insert_email_company.email = email;
    }

    public static int getId_worker() {
        return id_company;
    }

    public static void setId_worker(int id_company) {
        insert_email_company.id_company = id_company;
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
