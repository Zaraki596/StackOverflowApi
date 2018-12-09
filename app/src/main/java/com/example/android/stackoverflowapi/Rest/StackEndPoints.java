package com.example.android.stackoverflowapi.Rest;


import com.example.android.stackoverflowapi.model.UserRecieved;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StackEndPoints {

    @GET("2.2/users?page=1&pagesize=5&order=desc&site=stackoverflow")
    Call<UserRecieved> getUsers(@Query("sort") String sort);

}
