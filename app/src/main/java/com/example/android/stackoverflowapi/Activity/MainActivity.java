package com.example.android.stackoverflowapi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.telecom.Call;

import com.example.android.stackoverflowapi.Adapter.StackAdapter;
import com.example.android.stackoverflowapi.R;
import com.example.android.stackoverflowapi.Rest.APIservice;
import com.example.android.stackoverflowapi.Rest.StackEndPoints;
import com.example.android.stackoverflowapi.model.StackModel;
import com.example.android.stackoverflowapi.model.UserRecieved;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<StackModel> myData = new ArrayList<>();
    RecyclerView.Adapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.stack_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new StackAdapter(myData, getApplicationContext());
        recyclerView.setAdapter(myAdapter);
        loadUsers();
    }

    private void loadUsers() {
        StackEndPoints apiservice =
                APIservice.getClient().create(StackEndPoints.class);
        retrofit2.Call<UserRecieved> call = apiservice.getUsers("reputation");
        call.enqueue(new Callback<UserRecieved>() {
            @Override
            public void onResponse(retrofit2.Call<UserRecieved> call, Response<UserRecieved> response) {
                List<StackModel> users = response.body().getUsers();
                myData.clear();
                myData.addAll(response.body().getUsers());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(retrofit2.Call<UserRecieved> call, Throwable t) {

            }
        });
    }

}
