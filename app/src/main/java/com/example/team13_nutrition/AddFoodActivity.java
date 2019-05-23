package com.example.team13_nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.team13_nutrition.ui.main.Tab1;

import java.util.ArrayList;

public class AddFoodActivity extends AppCompatActivity {

    SearchView searchView;
    ListView foodListView;
    Button confirmFoodButton;
    ListViewFoodAdapter foodAdapter;
    ArrayList<ListViewFoodClass> foodList;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_consumption_layout);
        user = getIntent().getStringExtra("params");

        searchView = findViewById(R.id.foodSearchView);
        foodListView = findViewById(R.id.foodListView);
        confirmFoodButton = findViewById(R.id.foodConfirmButton);

        loadFoods();
        foodAdapter = new ListViewFoodAdapter(this, foodList);
        foodListView.setAdapter(foodAdapter);

        confirmFoodButton.setOnClickListener(v -> applyExercises());
    }

    private void loadFoods() {
        foodList = new ArrayList<>();

        for (String key : MakeMap.foodMap.keySet()) {
            ListViewFoodClass added = new ListViewFoodClass(key, false, 1, "BREAKFAST");
            foodList.add(added);
        }
    }

    private void applyExercises(){

        foodAdapter.notifyDataSetChanged();
        boolean hasChosen = false;

        for(ListViewFoodClass item : foodList){
            if(item.isChecked()){
                hasChosen = true;
                FoodConsumption consumption = new FoodConsumption(item.getQuantity(), item.getMealType(), MakeMap.foodMap.get(item.getName()));
                Tab1.foodConsumptions.add(consumption);
                Intent it = new Intent(AddFoodActivity.this, MainActivity.class);
                it.putExtra("params", user);
                startActivity(it);
            }
        }
        if (!hasChosen)
            Toast.makeText(this, "No foods have been selected!", Toast.LENGTH_LONG).show();
    }

}
