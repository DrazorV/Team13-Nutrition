package com.example.team13_nutrition.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.team13_nutrition.CustomerMap;
import com.example.team13_nutrition.Nutrition_Goal;
import com.example.team13_nutrition.R;

import java.text.DecimalFormat;
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
        DecimalFormat df = new DecimalFormat("#.##");
        Nutrition_Goal temp = null;
        String user = Objects.requireNonNull(getArguments()).getString("params");

        EditText name = Objects.requireNonNull(getView()).findViewById(R.id.name);
        String nm = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getName();

        EditText age = Objects.requireNonNull(getView()).findViewById(R.id.age);
        int ag = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getAge();

        EditText weight = Objects.requireNonNull(getView().findViewById(R.id.weight));
        double wght = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight();

        EditText height = Objects.requireNonNull(getView().findViewById(R.id.height));
        double hght = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getHeight();

        EditText gender = Objects.requireNonNull(getView().findViewById(R.id.gender));
        String gndr = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getGender();


        TextView bmi = Objects.requireNonNull(getView().findViewById(R.id.bmi));
        String bm = df.format(Objects.requireNonNull(CustomerMap.customerMap.get(user)).BMI(wght));

        EditText target = Objects.requireNonNull(getView().findViewById(R.id.target));
        Set<Nutrition_Goal> set = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getNutriton_goals();
        for (Nutrition_Goal value: set) if(value.isActive()) temp = value;
        String trgt;
        if (Objects.requireNonNull(temp).getGoal_Type().equals(Nutrition_Goal.Nutrition_Goal_Type.Gain_Weight))
            trgt = ("Gain " + (Objects.requireNonNull(temp).getTargetWeight() - wght) + " kg");
        else if (Objects.requireNonNull(temp).getGoal_Type().equals(Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss))
            trgt = ("Lose " + (wght - Objects.requireNonNull(temp).getTargetWeight()) + " kg");
        else trgt = "Maintain Weight";

        name.setText(nm +" "+ Objects.requireNonNull(CustomerMap.customerMap.get(user)).getSurname());
        age.setText(ag + " years old");
        weight.setText(wght + " kg");
        height.setText(hght + " m");
        gender.setText(gndr + "");
        bmi.setText(bm);
        target.setText(trgt);

        name.setOnClickListener(v -> {

        });
    }
}