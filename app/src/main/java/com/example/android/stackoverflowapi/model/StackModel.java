package com.example.android.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class StackModel {
    @SerializedName("display_name")
    private String display_name;
    @SerializedName("reputation")
    private String reputation;
    @SerializedName("location")
    private String location;
    @SerializedName("badge_counts")
    private HashMap<String, Integer> badges = new HashMap<>();


    public StackModel(String display_name, String reputation, String location, HashMap<String, Integer> badges) {
        this.display_name = display_name;
        this.reputation = reputation;
        this.location = location;
        this.badges = badges;

    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getReputation() {
        return reputation;
    }

    public String getLocation() {
        return location;
    }

    public HashMap<String, Integer> getBadges() {
        return badges;
    }
}
