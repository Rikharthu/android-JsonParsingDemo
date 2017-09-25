package com.example.uberv.jsonparsingdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
                .create();
        String jsonText = Utils.readFromAssets("topcharts.json", this);
        Feed feed = gson.fromJson(jsonText, Feed.class);
        int a = 4;
    }
}
