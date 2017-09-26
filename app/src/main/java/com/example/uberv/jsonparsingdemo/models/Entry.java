package com.example.uberv.jsonparsingdemo.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entry {

    @SerializedName("im:name")
    public Attribute name;
    @SerializedName("im:image")
    public List<VerboseAttribute> image;
    @SerializedName("im:collection")
    public Collection collection;
    @SerializedName("im:price")
    public VerboseAttribute price;
    @SerializedName("im:contentType")
    public ContentType contentType;
    public Attribute rights;
    public Attribute title;
    public List<EntryLink> link;
    public VerboseAttribute id;
    @SerializedName("im:artist")
    public VerboseAttribute artist;
    public VerboseAttribute category;
    public VerboseAttribute releaseDate;
}
