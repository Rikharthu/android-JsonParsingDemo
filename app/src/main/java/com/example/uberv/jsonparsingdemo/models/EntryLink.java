package com.example.uberv.jsonparsingdemo.models;

import com.google.gson.annotations.SerializedName;

public class EntryLink {
    @SerializedName("im:duration")
    public Attribute<Long> duration;
    public Attribute attributes;
}
