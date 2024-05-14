package com.example.project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenNightItem extends RecyclerViewItem{
    String theme;
    String occasion;
    String times;

    OpenNightItem(String ID, String theme, String occasion, String times) {
        super(ID);
        this.theme = theme;
        this.occasion = occasion;
        this.times = times;
    }
    OpenNightItem(JSONObject json) throws JSONException {
        super(json.getString("ID"));
        this.theme = json.getString("theme");
        this.occasion = json.getString("occasion");
        this.times = json.getString("times");
    }
    String getTheme() {
        return theme;
    }
    String getOccasion() {
        return occasion;
    }
    String getTimes() {
        return times;
    }

}
