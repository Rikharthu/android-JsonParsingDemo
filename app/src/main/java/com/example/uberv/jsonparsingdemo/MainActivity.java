package com.example.uberv.jsonparsingdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.uberv.jsonparsingdemo.models.FeedResponse;
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
//                .registerTypeAdapter(Feed.class, new FeedDeserializer())
                .registerTypeAdapter(String.class, new StringDeserializer())
//                .registerTypeAdapterFactory(new MyTypeAdapterFactory())
                .setDateFormat(DateFormat.FULL, DateFormat.FULL)
                .create();
        String jsonText = Utils.readFromAssets("topcharts.json", this);
        FeedResponse feed = gson.fromJson(jsonText, FeedResponse.class);
        int a = 4;
    }
}
