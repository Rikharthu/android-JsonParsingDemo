package com.example.uberv.jsonparsingdemo;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Utils {

    public static String readFromAssets(String filename, Context context) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(filename), "UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();

            // do reading, usually loop until end of file reading
            String line;
            while ((line = reader.readLine()) != null) {
                //process line
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            //log the exception
            Log.e("Utils", "error reading file:", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                    Log.e("Utils", "error reading file:", e);
                }
            }
        }
        return null;
    }
}
