package com.example.uberv.jsonparsingdemo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feed {

    @SerializedName("feed")
    Feed feed;

    Author author;
    Attribute updated;
    Attribute rights;
    Attribute title;
    //    String title;
    Attribute icon;
    List<Entry> entry;
    List<Attribute> link;
    Attribute id;
}
