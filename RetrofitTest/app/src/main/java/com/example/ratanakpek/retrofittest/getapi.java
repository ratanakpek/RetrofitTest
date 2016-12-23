package com.example.ratanakpek.retrofittest;

import com.example.ratanakpek.retrofittest.dao.User;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by RatanakPek on 11/21/2016.
 */

public interface getapi {
    @GET("v1/api/users")
    Call<User> getStudentDetails();

    @POST("api/users/banner")
    Call<Student> upload(@Body Student body);

}
