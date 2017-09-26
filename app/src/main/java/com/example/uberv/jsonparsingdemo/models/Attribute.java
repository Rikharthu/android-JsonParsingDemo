package com.example.uberv.jsonparsingdemo.models;

import com.google.gson.annotations.SerializedName;

public class Attribute<T> {
    public T label;
    public int height;
    public String rel;
    public String href;
    public String type;
    public String title;
    @SerializedName("im:assetType")
    public String assetType;
    public String term;
    public String amount;
    public String currency;
    @SerializedName("im:id")
    public long id;
}
