package com.example.dell.navbot;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<Response_user> login(@Field("email") String user_name, @Field("password") String password);

    @FormUrlEncoded
    @POST("insertworker.php")
    Call<insertwork_getCount> insert_worker(

            @Field("name") String name,
            @Field("type") String type,
            @Field("mobile") int mobile
    );

    @FormUrlEncoded
    @POST("insertcompany.php")
    Call<insert_company> insert_company(

            @Field("name") String name,
            @Field("specializing") String specializing,
            @Field("mobile") int mobile
    );


    @FormUrlEncoded
    @POST("insertemail.php")
    Call<insert_email_worker> insert_email_worker(
            @Field("email") String email,
            @Field("id_worker") int id_worker,
            @Field("password") String password,
            @Field("phone") int phone,
            @Field("type") int type
    );

    @FormUrlEncoded
    @POST("insertemailcompany.php")
    Call<insert_email_company> insert_email_company(
            @Field("email") String email,
            @Field("id_company") int id_company,
            @Field("password") String password,
            @Field("phone") int phone,
            @Field("type") int type
    );

    @FormUrlEncoded
    @POST("getcount.php")
    Call<Response_user> getcounts(@Field("mobile") int  mobile);

    @FormUrlEncoded
    @POST("getidcompany.php")
    Call<Response_user> get_id_company(@Field("mobile") int  mobile);
}
