package com.example.uberv.jsonparsingdemo.models;

import com.google.gson.annotations.SerializedName;

public class ContentType extends VerboseAttribute {
    @SerializedName("im:contentType")
    public VerboseAttribute contentType;
}
