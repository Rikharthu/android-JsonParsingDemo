package com.example.uberv.jsonparsingdemo;

import android.text.TextUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class StringDeserializer implements JsonDeserializer<String> {
    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String result = null;
        boolean isParsed = false;
        if (json.isJsonObject()) {
            JsonElement jsonElement = json.getAsJsonObject();
            if (jsonElement != null) {
                JsonElement labelElement = jsonElement.getAsJsonObject().get("label");
                if (labelElement != null && !TextUtils.isEmpty(labelElement.getAsString())) {
                    result = labelElement.getAsString();
                    isParsed = true;
                }
            }
        }
        if (!isParsed) {
            result = json.getAsString();
        }

        return result;
    }
}
