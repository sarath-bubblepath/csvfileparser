package com.csvfileparser.db;

import org.json.JSONObject;

import java.sql.Timestamp;

public class EventContent {

    private Timestamp timestamp;
    private JSONObject jsonObject;

    public EventContent setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public EventContent setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}
