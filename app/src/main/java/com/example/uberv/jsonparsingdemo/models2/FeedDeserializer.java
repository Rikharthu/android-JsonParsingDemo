package com.example.uberv.jsonparsingdemo.models2;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class FeedDeserializer implements JsonDeserializer<Feed> {

    private Gson gson;

    @Override
    public Feed deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        long t1 = System.currentTimeMillis();

        Feed feed = new Feed();
        JsonObject feedJsonObj = json.getAsJsonObject().getAsJsonObject("feed");

        JsonObject authorJsonObj = feedJsonObj.getAsJsonObject("author");
        feed.author = getLabel(authorJsonObj.getAsJsonObject("name"));
        feed.authorUrl = getLabel(authorJsonObj.getAsJsonObject("uri"));
        feed.updated = getLabel(feedJsonObj.getAsJsonObject("updated"));
        feed.rights = getLabel(feedJsonObj.getAsJsonObject("rights"));
        feed.title = getLabel(feedJsonObj.getAsJsonObject("title"));
        feed.icon = getLabel(feedJsonObj.getAsJsonObject("icon"));
        feed.id = getLabel(feedJsonObj.getAsJsonObject("id"));
        // links
        Link link;
        for (JsonElement element : feedJsonObj.getAsJsonArray("link")) {
            if (feed.link == null) {
                feed.link = new ArrayList<>();
            }
            link = getLink(element);
            if (link != null) {
                feed.link.add(link);
            }
        }
        // entries
        Entry entry;
        for (JsonElement element : feedJsonObj.getAsJsonArray("entry")) {
            if (feed.entry == null) {
                feed.entry = new ArrayList<>();
            }
            entry = getEntry(element);
            if (entry != null) {
                feed.entry.add(entry);
            }
        }
        long t2 = System.currentTimeMillis();

        long timeTakenMillis = t2 - t1;
        double timeTakenSeconds = (double) timeTakenMillis / 1000;

        return feed;
    }

    private Entry getEntry(JsonElement element) {
        if (isValidJsonObject(element)) {
            Entry entry = new Entry();
            JsonObject entryObject = element.getAsJsonObject();
            entry.name = getLabel(entryObject.get("im:name"));
            entry.rights = getLabel(entryObject.get("rights"));
            entry.title = getLabel(entryObject.get("title"));
            entry.releaseDate = getLabel(entryObject.get("im:releaseDate"));
            // TODO add checks
            entry.releaseDateLabel = getLabel(entryObject.getAsJsonObject("im:releaseDate").getAsJsonObject("attributes"));
            entry.price = getLabel(entryObject.get("im:price"));
            Link link;
            for (JsonElement linkElement : entryObject.getAsJsonArray("link")) {
                link = getLink(linkElement);
                if (link != null) {
                    if (entry.link == null) {
                        entry.link = new ArrayList<>();
                    }
                    entry.link.add(link);
                }
            }
            return entry;
        }
        return null;
    }

    private boolean isValidJsonObject(JsonElement object) {
        return object != null && object.isJsonObject();
    }

    private Link getLink(JsonElement element) {
        if (element != null && element.isJsonObject()) {
            Link link = new Link();
            JsonObject linkObject = element.getAsJsonObject();
            // TODO add checks
            JsonObject attributes = linkObject.getAsJsonObject("attributes");
            if (isValidJsonObject(attributes)) {
                link.rel = getAsString(attributes.get("rel"));
                link.href = getAsString(attributes.get("href"));
                link.rel = getAsString(attributes.get("rel"));
                link.type = getAsString(attributes.get("type"));
                link.assetType = getAsString(attributes.get("im:assetType"));
            }
            String durationLabel = getLabel(linkObject.getAsJsonObject("im:duration"));
            if (!TextUtils.isEmpty(durationLabel)) {
                link.duration = Long.parseLong(durationLabel);
            }
            return link;
        }
        return null;
    }

    public String getAsString(JsonElement element) {
        if (element != null && element.isJsonPrimitive()) {
            String elementString = element.getAsString();
            if (!TextUtils.isEmpty(elementString)) {
                return elementString;
            }
        }
        return null;
    }

    @Nullable
    public String getLabel(JsonElement jsonElement) {
        if (isValidJsonObject(jsonElement)) {
            return getAsString(jsonElement.getAsJsonObject().get("label"));
        }
        return null;
    }
}
