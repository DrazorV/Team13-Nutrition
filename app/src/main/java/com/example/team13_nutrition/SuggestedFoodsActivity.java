package com.example.team13_nutrition;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SuggestedFoodsActivity extends AppCompatActivity {
    private SuggestedFoodsPresenter presenter = new SuggestedFoodsPresenter(this);
    ListView lv;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggested_foods);
        lv = findViewById(R.id.foods);
        try {
            ArrayList<Food> foods = presenter.createList();
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foods) ;
            lv.setAdapter(arrayAdapter);
            } catch(Exception e){
            }


    }
}
