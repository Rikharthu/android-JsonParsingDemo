package com.example.uberv.jsonparsingdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.uberv.jsonparsingdemo.models2.FeedDeserializerKt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .setLenient()
//                .registerTypeAdapter(com.example.uberv.jsonparsingdemo.models2.Feed.class, new FeedDeserializer())
                .registerTypeAdapter(com.example.uberv.jsonparsingdemo.models2.Feed.class, new FeedDeserializerKt())
//                .registerTypeAdapter(String.class, new StringDeserializer())
//                .registerTypeAdapterFactory(new MyTypeAdapterFactory())
                .setDateFormat(DateFormat.FULL, DateFormat.FULL)
                .create();
        String jsonText = Utils.readFromAssets("topcharts.json", this);
//        FeedResponse feedResponse = gson.fromJson(jsonText, FeedResponse.class);
//        String previewUrl = feedResponse.feed.entry.get(0).link.get(1).attributes.href;
//        long duration = feedResponse.feed.entry.get(0).link.get(1).duration.label;
        com.example.uberv.jsonparsingdemo.models2.Feed feed = gson.fromJson(jsonText, com.example.uberv.jsonparsingdemo.models2.Feed.class);
        int a = 4;
    }
}
