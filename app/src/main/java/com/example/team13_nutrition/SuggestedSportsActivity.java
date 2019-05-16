package com.example.team13_nutrition;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.N)
public class SuggestedSportsActivity extends AppCompatActivity {
    private SuggestedSportsPresenter presenter = new SuggestedSportsPresenter(this);
    ListView lv;
    @RequiresApi(api = Build.VERSION_CODES.N)//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_sports);
        lv = findViewById(R.id.sports);
        try {
            ArrayList<Excercise> sports = presenter.createList();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sports) ;
            lv.setAdapter(arrayAdapter);
        } catch(Exception e){
        }

    }
}
