package com.example.team13_nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.team13_nutrition.ui.main.Tab1;

import java.util.ArrayList;

public class AddExercisesActivity extends AppCompatActivity {

    SearchView searchView;
    ListView exerciseListView;
    Spinner sportsType;
    Button confirmExercisesButton;
    ListViewItemAdapter exerciseAdapter;
    ArrayList<ListViewItemClass> sportsList;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_performance_layout);
        user = getIntent().getStringExtra("params");

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

        confirmExercisesButton.setOnClickListener(v -> applyExercises());


    }

    private void loadExercises() {

        sportsList = new ArrayList<>();

        for (String key : MakeMap.exerciseMap.keySet()) {
            ListViewItemClass added = new ListViewItemClass(key, false, 1);
            sportsList.add(added);
        }

    }

    private void applyExercises(){

        exerciseAdapter.notifyDataSetChanged();
        boolean hasChosen = false;

        for(ListViewItemClass item : sportsList){
            //System.out.println(item.getName() + " + " + item.getQuantity() + " + " + item.isChecked());
            if(item.isChecked()){
                hasChosen = true;
                Exercise exercise = MakeMap.exerciseMap.get(item.getName());
                ExercisePerformance performance = new ExercisePerformance(item.getQuantity(), exercise);
                Tab1.exercisePerformances.add(performance);
                Intent it = new Intent(AddExercisesActivity.this, MainActivity.class);
                it.putExtra("params", user);
                startActivity(it);
                //System.out.println("Added: " + performance.getExercise().getName());
            }
        }

        if(hasChosen){
            String intensity = sportsType.getSelectedItem().toString();
        }
        else{
            Toast.makeText(this, "No exercises have been selected!", Toast.LENGTH_LONG).show();
        }

    }

}
