package com.example.uberv.jsonparsingdemo;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class FeedDeserializer implements JsonDeserializer<Feed> {
    @Override
    public Feed deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Feed result = new Feed();
        JsonObject feedObject = json.getAsJsonObject().getAsJsonObject("feed");
        return result;
    }
}
