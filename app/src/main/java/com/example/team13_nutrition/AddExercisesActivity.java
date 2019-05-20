package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddExercisesActivity extends AppCompatActivity {

    SearchView searchView;
    ListView exerciseListView;
    Spinner sportsType;
    Button confirmExercisesButton;
    ListViewItemAdapter exerciseAdapter;
    ArrayList<ListViewItemClass> sportsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_performance_layout);

        searchView = findViewById(R.id.exerciseSearchView);
        exerciseListView = findViewById(R.id.exerciseListView);
        sportsType = findViewById(R.id.exerciseIntensity);
        confirmExercisesButton = findViewById(R.id.exerciseConfirmButton);

        loadExercises();
        exerciseAdapter = new ListViewItemAdapter(this, sportsList);
        exerciseListView.setAdapter(exerciseAdapter);


        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.exercise_intensity, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sportsType.setAdapter(spinnerAdapter);

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

}
