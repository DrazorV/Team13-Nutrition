package com.example.team13_nutrition;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewExerciseAdapter extends ArrayAdapter<ListViewExerciseClass> {

    private Context mContext;
    private ArrayList<ListViewExerciseClass> itemList;

    public ListViewExerciseAdapter(@NonNull Context context, ArrayList<ListViewExerciseClass> list){
        super(context, 0 , list);
        mContext = context;
        itemList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.listview_item_layout,parent,false);

        ListViewExerciseClass currentItem = itemList.get(position);

        TextView name = listItem.findViewById(R.id.listItemNameTextView);
        name.setText(currentItem.getName());

        CheckBox checkBox = listItem.findViewById(R.id.checkBox);

        TextView duration = listItem.findViewById(R.id.quantityEditText);

        TextView dr = listItem.findViewById(R.id.quantityTextView);

        dr.setText("Min:");

        Spinner spinner = listItem.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.exercise_intensity, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        checkBox.setOnClickListener(view -> {
            if (((CompoundButton) view).isChecked()) {
                //System.out.println("Checked");
                currentItem.setChecked(true);
                checkBox.setChecked(true);
            } else {
                //System.out.println("Un-Checked");
                currentItem.setChecked(false);
                checkBox.setChecked(false);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentItem.setIntensity(parent.getItemAtPosition(position).toString());
                System.out.println(currentItem.getIntensity());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return listItem;
    }

}
