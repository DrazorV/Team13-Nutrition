package com.example.team13_nutrition.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.team13_nutrition.CustomerMap;
import com.example.team13_nutrition.Nutrition_Goal;
import com.example.team13_nutrition.R;

import java.util.Objects;
import java.util.Set;

/**
 * A placeholder fragment containing a simple view.
 */
public class Tab2 extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String user = Objects.requireNonNull(getArguments()).getString("params");
        
        TextView name = Objects.requireNonNull(getView()).findViewById(R.id.name);
        TextView age = Objects.requireNonNull(getView()).findViewById(R.id.age);
        TextView weight = Objects.requireNonNull(getView().findViewById(R.id.weight));
        TextView height = Objects.requireNonNull(getView().findViewById(R.id.height));
        TextView gender = Objects.requireNonNull(getView().findViewById(R.id.gender));
        TextView target = Objects.requireNonNull(getView().findViewById(R.id.target));


        name.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getName() +" "+ Objects.requireNonNull(CustomerMap.customerMap.get(user)).getSurname());
        age.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getAge() + " years old");
        weight.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight() + " kg");
        height.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getHeight() + " cm");
        gender.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getGender() + "");
        Set<Nutrition_Goal> set = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getNutriton_goals();
        Nutrition_Goal temp = null;
        for (Nutrition_Goal value: set){
            if(value.isActive()) temp = value;
        }
        if (Objects.requireNonNull(temp).getGoal_Type().equals(Nutrition_Goal.Nutrition_Goal_Type.Gain_Weight)){
            target.setText("Gain " + Objects.requireNonNull(temp).getTargetWeight() + " kg");
        }else if (Objects.requireNonNull(temp).getGoal_Type().equals(Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss)){
            target.setText("Lose " + Objects.requireNonNull(temp).getTargetWeight() + " kg");
        }else{
            target.setText("Maintain Weight");
        }

    }

}