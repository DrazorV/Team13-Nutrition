package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddExercisesActivity extends AppCompatActivity {

    EditText searchView;
    ListView exerciseListView;
    Spinner sportsType;
    Button confirmExercisesButton, minus, plus;
    ListViewItemAdapter exerciseAdapter;
    ArrayList<ListViewItemClass> sportsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_performance_layout);

        searchView = findViewById(R.id.searchEditText);
        exerciseListView = findViewById(R.id.exerciseListView);
        sportsType = findViewById(R.id.exerciseIntensity);
        confirmExercisesButton = findViewById(R.id.exerciseConfirmButton);

        loadExercises();
        exerciseAdapter = new ListViewItemAdapter(this, sportsList);
        exerciseListView.setAdapter(exerciseAdapter);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.exercise_intensity, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sportsType.setAdapter(spinnerAdapter);

        confirmExercisesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyExercises();
            }
        });

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (AddExercisesActivity.this).exerciseAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void loadExercises() {

        sportsList = new ArrayList<>();

        for (String key : MakeMap.exerciseMap.keySet()) {
            System.out.println("key : " + key);
            System.out.println("value : " + MakeMap.exerciseMap.get(key));

            ListViewItemClass added = new ListViewItemClass(key, false, 1);

            sportsList.add(added);
        }

    }

    public void applyExercises(){

        exerciseAdapter.notifyDataSetChanged();

        for(ListViewItemClass item : sportsList){

            System.out.println(item.getName() + " + " + item.getQuantity() + " + " + item.isChecked());
        }

    }

}
