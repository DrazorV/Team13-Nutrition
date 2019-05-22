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

public class AddExercisesActivity extends AppCompatActivity {

    SearchView searchView;
    ListView exerciseListView;
    Button confirmExercisesButton;
    ListViewExerciseAdapter exerciseAdapter;
    ArrayList<ListViewExerciseClass> sportsList;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_performance_layout);
        user = getIntent().getStringExtra("params");

        searchView = findViewById(R.id.searchEditText);
        exerciseListView = findViewById(R.id.exerciseListView);
        confirmExercisesButton = findViewById(R.id.exerciseConfirmButton);

        loadExercises();
        exerciseAdapter = new ListViewExerciseAdapter(this, sportsList);
        exerciseListView.setAdapter(exerciseAdapter);

        confirmExercisesButton.setOnClickListener(v -> applyExercises());


    }

    private void loadExercises() {

        sportsList = new ArrayList<>();

        for (String key : MakeMap.exerciseMap.keySet()) {
            ListViewExerciseClass added = new ListViewExerciseClass(key, false, 1, "Intense");
            sportsList.add(added);
        }

    }

    private void applyExercises(){

        exerciseAdapter.notifyDataSetChanged();
        boolean hasChosen = false;

        for(ListViewExerciseClass item : sportsList){
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

        }
        else{
            Toast.makeText(this, "No exercises have been selected!", Toast.LENGTH_LONG).show();
        }

    }

}
