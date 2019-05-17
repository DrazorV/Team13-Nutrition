package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class SuggestedSportsActivity extends AppCompatActivity {
    private SuggestedSportsPresenter presenter = new SuggestedSportsPresenter();
    ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_sports);
        lv = findViewById(R.id.sports);

        ArrayList<Exercise> sports = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            sports = presenter.createList();
        }
        ArrayAdapter<Exercise> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sports) ;
        lv.setAdapter(arrayAdapter);
    }
}
