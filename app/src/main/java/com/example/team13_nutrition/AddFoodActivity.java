package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

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

        confirmFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyExercises();
            }
        });

    }

    private void loadFoods() {

        foodList = new ArrayList<>();

        for (String key : MakeMap.foodMap.keySet()) {
            ListViewItemClass added = new ListViewItemClass(key, false, 1);
            foodList.add(added);
        }

    }

    private void applyExercises(){

        foodAdapter.notifyDataSetChanged();
        boolean hasChosen = false;

        for(ListViewItemClass item : foodList){
            //System.out.println(item.getName() + " + " + item.getQuantity() + " + " + item.isChecked());
            if(item.isChecked()){
                hasChosen = true;
                Food food = MakeMap.foodMap.get(item.getName());
                String type = mealType.getSelectedItem().toString();
                FoodConsumption consumption = new FoodConsumption(item.getQuantity(), type, food);
                //System.out.println("Added: " + performance.getExercise().getName());
            }
        }

        if(hasChosen){

        }
        else{
            Toast.makeText(this, "No foods have been selected!", Toast.LENGTH_LONG).show();
        }

    }

}
