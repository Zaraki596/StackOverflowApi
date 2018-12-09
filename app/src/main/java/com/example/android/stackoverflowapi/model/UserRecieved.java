package com.example.android.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserRecieved {
    @SerializedName("items")
    private List<StackModel> users;

    public UserRecieved(List<StackModel> users) {

        this.users = users;
    }

    public List<StackModel> getUsers() {
        return users;
    }
}
