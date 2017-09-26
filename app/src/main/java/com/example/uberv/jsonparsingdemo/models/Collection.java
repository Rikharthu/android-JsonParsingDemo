package com.example.uberv.jsonparsingdemo.models;

import com.google.gson.annotations.SerializedName;

public class Collection {
    @SerializedName("im:name")
    public Attribute name;
    public VerboseAttribute link;
    @SerializedName("im:contentType")
    public ContentType contentType;
}
