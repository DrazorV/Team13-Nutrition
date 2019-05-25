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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewFoodAdapter extends ArrayAdapter<ListViewFoodClass> {

    private Context mContext;
    private ArrayList<ListViewFoodClass> itemList;

    ListViewFoodAdapter(@NonNull Context context, ArrayList<ListViewFoodClass> list) {
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

        ListViewFoodClass currentItem = itemList.get(position);

        TextView name = listItem.findViewById(R.id.listItemNameTextView);
        name.setText(currentItem.getName());

        EditText editText = listItem.findViewById(R.id.quantityEditText);

        CheckBox checkBox = listItem.findViewById(R.id.checkBox);

        Spinner spinner = listItem.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.diary_item_list_header_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        checkBox.setOnClickListener(view -> {
            if (((CompoundButton) view).isChecked()) {
                //System.out.println("Checked");
                currentItem.setChecked(true);
                checkBox.setChecked(true);
                currentItem.setQuantity(Integer.parseInt(editText.getText().toString()));
            } else {
                //System.out.println("Un-Checked");
                currentItem.setChecked(false);
                checkBox.setChecked(false);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentItem.setMealType(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return listItem;
    }

}
