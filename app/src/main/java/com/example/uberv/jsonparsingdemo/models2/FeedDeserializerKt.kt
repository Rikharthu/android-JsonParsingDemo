package com.example.uberv.jsonparsingdemo.models2

import android.text.TextUtils
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class FeedDeserializerKt : JsonDeserializer<Feed> {

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Feed {
        val feed = Feed()
        val feedJsonObj: JsonObject? = json?.getAsJsonObject()?.getAsJsonObject("feed")

        val authorJsonObj = feedJsonObj?.getAsJsonObject("author")
        feed.author = getLabel(authorJsonObj?.getAsJsonObject("name"))
        feed.authorUrl = getLabel(authorJsonObj?.getAsJsonObject("uri"))
        feed.updated = getLabel(feedJsonObj?.getAsJsonObject("updated"))
        feed.rights = getLabel(feedJsonObj?.getAsJsonObject("rights"))
        feed.title = getLabel(feedJsonObj?.getAsJsonObject("title"))
        feed.icon = getLabel(feedJsonObj?.getAsJsonObject("icon"))
        feed.id = getLabel(feedJsonObj?.getAsJsonObject("id"))
//        for (element in feedJsonObj.getAsJsonArray("link")) {
//            if (feed.link == null) {
//                feed.link = ArrayList<Link>()
//            }
//            feed.link.add(getLink(element))
//        }
        val links = feedJsonObj?.getAsJsonArray("link")
        if (links != null) {
            for (element in links) {
                val link = getLink(element)
                if (link != null) {
                    if (feed.link == null) {
                        feed.link = mutableListOf()
                    }
                    feed.link.add(link)
                }
            }
        }

        return feed
    }

    private fun isValidJsonObject(json: JsonObject?): Boolean {
        return json != null && json is JsonObject
    }

    private fun getLink(element: JsonElement): Link? {
        if (element != null && element.isJsonObject) {
            val link = Link()
            val linkObject = element.asJsonObject
            // TODO add checks
            val attributes = linkObject.getAsJsonObject("attributes")
            if (isValidJsonObject(attributes)) {
                link.rel = getAsString(attributes.get("rel"))
                link.href = getAsString(attributes.get("href"))
                link.rel = getAsString(attributes.get("rel"))
                link.type = getAsString(attributes.get("type"))
                link.assetType = getAsString(attributes.get("im:assetType"))
            }
            val durationLabel = getLabel(linkObject.getAsJsonObject("im:duration"))
            if (!TextUtils.isEmpty(durationLabel)) {
                link.duration = java.lang.Long.parseLong(durationLabel)
            }
            return link
        }
        return null
    }

    fun getAsString(element: JsonElement?): String? {
        if (element != null && element.isJsonPrimitive) {
            val elementString = element.asString
            if (!TextUtils.isEmpty(elementString)) {
                return elementString
            }
        }
        return null
    }

    fun getLabel(jsonElement: JsonElement?): String? {
        if (jsonElement != null && jsonElement is JsonObject) {
            val labelJson = jsonElement.get("label")
            if (labelJson != null && labelJson.isJsonPrimitive) {
                return labelJson.asString
            }
        }
        return null
    }
}