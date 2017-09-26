package com.example.uberv.jsonparsingdemo.models;

import java.util.Date;
import java.util.List;

public class Feed {
    public Author author;
    public List<Entry> entry;
    public Attribute<Date> updated;
    public Attribute rights;
    public Attribute title;
    public Attribute icon;
    public List<VerboseAttribute> link;
    public Attribute id;
}
