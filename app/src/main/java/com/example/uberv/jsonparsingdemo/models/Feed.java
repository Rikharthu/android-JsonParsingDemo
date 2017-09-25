package com.example.uberv.jsonparsingdemo.models;

import java.util.Date;
import java.util.List;

public class Feed {
    private Author author;
    private List<Entry> entry;
    private Attribute<Date> updated;
    private Attribute<String> rights;
    private Attribute<String> title;
    private Attribute<String> icon;
    private List<Attributes> link;
    private Attribute id;
}
