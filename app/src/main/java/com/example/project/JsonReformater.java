package com.example.project;

import java.util.ArrayList;

public class JsonReformater {
    public static String reformat(String json) {
        json = json.replaceAll("name", "theme");
        json = json.replaceAll("location", "occasion");
        json = json.replaceAll("auxdata", "times");
        return json;
    }

}
