package com.example.uberv.jsonparsingdemo.models;

import com.google.gson.annotations.SerializedName;

public class Entry {
    @SerializedName("name")
    private Attribute<String> name;
}
