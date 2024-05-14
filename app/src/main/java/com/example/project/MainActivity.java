package com.example.project;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=a21jonfa";
    private final String JSON_FILE = "kb.json";

    RecyclerView view;
    private RecyclerViewAdapter adapter;

    private ArrayList<RecyclerViewItem> recyclerViewItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewItems = new ArrayList<>();

        view = findViewById(R.id.recyclerView);
        adapter = new RecyclerViewAdapter(this, recyclerViewItems);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));






        new JsonTask(this).execute(JSON_URL);

    }

    @Override
    public void onPostExecute(String json) {
        json = JsonReformater.reformat(json);
        Log.d("MainActivity", json);
        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                recyclerViewItems.add(new OpenNightItem(jsonArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        adapter.notifyDataSetChanged();
    }
}
