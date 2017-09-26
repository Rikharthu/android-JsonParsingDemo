package com.example.uberv.jsonparsingdemo.models2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entry {
    @SerializedName("im:name")
    public String name;
    @SerializedName("im:image")
    public List<Image> image;
    public List<Link> link;
    public Collection collection;
    @SerializedName("im:price")
    public String price;
    public ContentType contentType;
    public String rights;
    public String title;
    public String idLabel; // TODO maybe url?
    public long id;
    public String artist;
    public String artistUrl;
    public String releaseDate;
    public String releaseDateLabel;

}
