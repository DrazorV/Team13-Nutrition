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
        final AlertDialog dialogBuilder = new AlertDialog.Builder(getContext()).create();
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        Nutrition_Goal temp = null;
        Button button1 = dialogView.findViewById(R.id.buttonSubmit);
        Button button2 = dialogView.findViewById(R.id.buttonCancel);
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
        double trgt = (Objects.requireNonNull(temp).getTargetWeight());

        name.setText(nm +" "+ Objects.requireNonNull(CustomerMap.customerMap.get(user)).getSurname());
        age.setText(String.valueOf(ag));
        weight.setText(String.valueOf(wght));
        height.setText(String.valueOf(hght));
        gender.setText(gndr);
        bmi.setText(bm);
        target.setText(trgt + "");

        name.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setText(name.getText());
            TextView textView = dialogView.findViewById(R.id.textView);
            textView.setText("Name Change");
            button2.setOnClickListener(view1 -> dialogBuilder.dismiss());
            button1.setOnClickListener(view12 -> {
                // DO SOMETHINGS
                dialogBuilder.dismiss();
            });

            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            return true;
        });

        age.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setText(age.getText());
            TextView textView = dialogView.findViewById(R.id.textView);
            textView.setText("Age Change");
            button2.setOnClickListener(view1 -> dialogBuilder.dismiss());
            button1.setOnClickListener(view12 -> {
                // DO SOMETHINGS
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
                // DO SOMETHINGS
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
                // DO SOMETHINGS
                dialogBuilder.dismiss();
            });

            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            return true;
        });

        gender.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setText(gender.getText());
            TextView textView = dialogView.findViewById(R.id.textView);
            textView.setText("Gender Change");
            button2.setOnClickListener(view1 -> dialogBuilder.dismiss());
            button1.setOnClickListener(view12 -> {
                // DO SOMETHINGS
                dialogBuilder.dismiss();
            });

            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            return true;
        });

        target.setOnLongClickListener(u ->{
            EditText editText = dialogView.findViewById(R.id.edt_comment);
            editText.setText(target.getText());
            TextView textView = dialogView.findViewById(R.id.textView);
            textView.setText("Goal Change");
            button2.setOnClickListener(view1 -> dialogBuilder.dismiss());
            button1.setOnClickListener(view12 -> {
                // DO SOMETHINGS
                dialogBuilder.dismiss();
            });

            dialogBuilder.setView(dialogView);
            dialogBuilder.show();
            return true;
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Toast.makeText(getContext(),"Long press on any value to change it",Toast.LENGTH_LONG).show();
        }
    }
}