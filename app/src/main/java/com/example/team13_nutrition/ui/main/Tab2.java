package com.example.team13_nutrition.ui.main;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.team13_nutrition.Customer;
import com.example.team13_nutrition.CustomerMap;
import com.example.team13_nutrition.Nutrition_Goal;
import com.example.team13_nutrition.R;
import com.example.team13_nutrition.exceptions.AgeException;
import com.example.team13_nutrition.exceptions.HeightException;
import com.example.team13_nutrition.exceptions.WeightException;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Set;

public class Tab2 extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        DecimalFormat df = new DecimalFormat("#.##");
        final AlertDialog dialogBuilder = new AlertDialog.Builder(getContext()).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        Nutrition_Goal temp = null;
        Button button1 = dialogView.findViewById(R.id.buttonSubmit);
        Button button2 = dialogView.findViewById(R.id.buttonCancel);
        String user = Objects.requireNonNull(getArguments()).getString("params");

        TextView name = view.findViewById(R.id.name);
        name.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getName() + " " + Objects.requireNonNull(CustomerMap.customerMap.get(user)).getSurname());

        TextView age = view.findViewById(R.id.age);
        age.setText(String.valueOf(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getAge()));

        TextView weight = view.findViewById(R.id.weight);
        weight.setText(String.valueOf(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight()));

        TextView height = view.findViewById(R.id.height);
        height.setText(String.valueOf(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getHeight()));

        TextView gender = view.findViewById(R.id.gender);
        gender.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getGender());

        TextView bmi = view.findViewById(R.id.bmi);
        bmi.setText(df.format(Objects.requireNonNull(CustomerMap.customerMap.get(user)).BMI(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight())));

        TextView target = view.findViewById(R.id.target);
        Set<Nutrition_Goal> set = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getNutriton_goals();
        for (Nutrition_Goal value: set) if(value.isActive()) temp = value;
        target.setText(Objects.requireNonNull(temp).getTargetWeight()+"");

        age.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setText(age.getText());
            TextView textView = dialogView.findViewById(R.id.textView);
            textView.setText("Age Change");
            button2.setOnClickListener(view1 -> dialogBuilder.dismiss());
            button1.setOnClickListener(view12 -> {
                try {
                    int t = Integer.parseInt(editText.getText().toString());
                    Customer.checkAge(t);
                    Objects.requireNonNull(CustomerMap.customerMap.get(user)).setAge(t);
                    age.setText(String.valueOf(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getAge()));
                } catch (AgeException e) {
                    Toast.makeText(getContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }
                dialogBuilder.dismiss();
            });

            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            return true;
        });

        weight.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setText(weight.getText());
            TextView textView = dialogView.findViewById(R.id.textView);
            textView.setText("Weight Change");
            button2.setOnClickListener(view1 -> dialogBuilder.dismiss());
            button1.setOnClickListener(view12 -> {
                try {
                    double t = Double.parseDouble(editText.getText().toString());
                    Customer.checkWeight(t);
                    Objects.requireNonNull(CustomerMap.customerMap.get(user)).setWeight(t);
                    weight.setText(String.valueOf(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight()));
                    bmi.setText(df.format(Objects.requireNonNull(CustomerMap.customerMap.get(user)).BMI(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight())));
                } catch (WeightException e) {
                    Toast.makeText(getContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }
                dialogBuilder.dismiss();
            });

            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            return true;
        });

        height.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setText(height.getText());
            TextView textView = dialogView.findViewById(R.id.textView);
            textView.setText("Height Change");
            button2.setOnClickListener(view1 -> dialogBuilder.dismiss());
            button1.setOnClickListener(view12 -> {
                try {
                    double t = Double.parseDouble(editText.getText().toString());
                    Customer.checkHeight(t);
                    Objects.requireNonNull(CustomerMap.customerMap.get(user)).setHeight(t);
                    height.setText(String.valueOf(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getHeight()));
                    bmi.setText(df.format(Objects.requireNonNull(CustomerMap.customerMap.get(user)).BMI(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight())));
                } catch (HeightException e) {
                    Toast.makeText(getContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }
                dialogBuilder.dismiss();
            });
            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            return true;
        });


        gender.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setEnabled(false);
            editText.setText("Press Submit to change gender");
            TextView textView2 = dialogView.findViewById(R.id.textView);
            textView2.setText("Gender Change");
            button1.setOnClickListener(view1 -> {
                Objects.requireNonNull(CustomerMap.customerMap.get(user)).changeGender();
                gender.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getGender());
                dialogBuilder.dismiss();
            });
            button2.setOnClickListener(view12 -> dialogBuilder.dismiss());
            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            Objects.requireNonNull(CustomerMap.customerMap.get(user));
            return true;
        });


        target.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setText(target.getText());
            TextView textView = dialogView.findViewById(R.id.textView);
            textView.setText("Goal Change");
            button1.setOnClickListener(view1 -> {
                Nutrition_Goal temp2 = null;
                double t = Double.parseDouble(editText.getText().toString());
                double currentWeight = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight();
                try {
                    if (t > currentWeight) {
                        Objects.requireNonNull(CustomerMap.customerMap.get(user)).setGoals("Gain_Weight", t);
                    }

                    if (t == currentWeight) {
                        Objects.requireNonNull(CustomerMap.customerMap.get(user)).setGoals("Maintain_Weight", Objects.requireNonNull(CustomerMap.customerMap.get(user)).getWeight());
                    }

                    if (t < currentWeight){
                        Objects.requireNonNull(CustomerMap.customerMap.get(user)).setGoals("Weight_Loss", t);
                    }

                    Set<Nutrition_Goal> set2 = Objects.requireNonNull(CustomerMap.customerMap.get(user)).getNutriton_goals();
                    for (Nutrition_Goal value : set2) if (value.isActive()) temp2 = value;
                    target.setText(String.valueOf(Objects.requireNonNull(temp2).getTargetWeight()));
                } catch (WeightException e) {
                    e.printStackTrace();
                }
                dialogBuilder.dismiss();
            });
            button2.setOnClickListener(view12 -> dialogBuilder.dismiss());
            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            return true;
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) Toast.makeText(getContext(),"Long press on any value to change it",Toast.LENGTH_LONG).show();
    }
}