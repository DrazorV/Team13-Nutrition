package com.example.team13_nutrition.ui.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        
        TextView name = Objects.requireNonNull(getView()).findViewById(R.id.name);
        String nm = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getName();

        TextView age = Objects.requireNonNull(getView()).findViewById(R.id.age);
        int ag = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getAge();

        TextView weight = Objects.requireNonNull(getView().findViewById(R.id.weight));
        double wght = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight();

        TextView height = Objects.requireNonNull(getView().findViewById(R.id.height));
        double hght = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getHeight();

        TextView gender = Objects.requireNonNull(getView().findViewById(R.id.gender));
        String gndr = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getGender();


        TextView bmi = Objects.requireNonNull(getView().findViewById(R.id.bmi));
        String bm = df.format(Objects.requireNonNull(CustomerMap.customerMap.get(user)).BMI(wght));

        TextView target = Objects.requireNonNull(getView().findViewById(R.id.target));
        Set<Nutrition_Goal> set = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getNutriton_goals();
        for (Nutrition_Goal value: set) if(value.isActive()) temp = value;
        String trgt;
        if (Objects.requireNonNull(temp).getGoal_Type().equals(Nutrition_Goal.Nutrition_Goal_Type.Gain_Weight))
            trgt = ("Gain " + (Objects.requireNonNull(temp).getTargetWeight() - wght) + " kg");
        else if (Objects.requireNonNull(temp).getGoal_Type().equals(Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss))
            trgt = ("Lose " + (wght - Objects.requireNonNull(temp).getTargetWeight()) + " kg");
        else trgt = "Maintain Weight";

        ImageView edit = getView().findViewById(R.id.edit);

        name.setText(nm +" "+ Objects.requireNonNull(CustomerMap.customerMap.get(user)).getSurname());
        age.setText(ag + " years old");
        weight.setText(wght + " kg");
        height.setText(hght + " m");
        gender.setText(gndr + "");
        bmi.setText(bm);
        target.setText(trgt);


        edit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Title");

            // Set up the input
            final TextView input = name;
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            builder.setView(input);

            // Set up the buttons
            builder.setPositiveButton("OK", (dialog, which) -> m_Text = input.getText().toString());
            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();
        });
    }
    private String m_Text = "";
}