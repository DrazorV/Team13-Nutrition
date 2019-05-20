package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddFoodActivity extends AppCompatActivity {

    SearchView searchView;
    ListView foodListView;
    Spinner mealType;
    Button confirmFoodButton;
    ListViewItemAdapter foodAdapter;
    ArrayList<ListViewItemClass> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_consumption_layout);

        searchView = findViewById(R.id.foodSearchView);
        foodListView = findViewById(R.id.foodListView);
        mealType = findViewById(R.id.mealType);
        confirmFoodButton = findViewById(R.id.foodConfirmButton);

        loadFoods();
        foodAdapter = new ListViewItemAdapter(this, foodList);
        foodListView.setAdapter(foodAdapter);


        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.diary_item_list_header_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mealType.setAdapter(spinnerAdapter);

    }

    private void loadFoods() {

        foodList = new ArrayList<>();

        for (String key: CustomerMap.foodMap.keySet()) {
            System.out.println("key : " + key);
            System.out.println("value : " + CustomerMap.foodMap.get(key));

            ListViewItemClass added = new ListViewItemClass(key, false, 1);

            foodList.add(added);
        }

    }

}
