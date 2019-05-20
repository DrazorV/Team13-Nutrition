package com.example.team13_nutrition;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewItemAdapter extends ArrayAdapter<ListViewItemClass> {

    private Context mContext;
    private ArrayList<ListViewItemClass> itemList;

    public ListViewItemAdapter(@NonNull Context context, ArrayList<ListViewItemClass> list){
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

        ListViewItemClass currentItem = itemList.get(position);

        TextView name = listItem.findViewById(R.id.listItemNameTextView);
        name.setText(currentItem.getName());

        CheckBox checkBox = listItem.findViewById(R.id.checkBox);

        TextView quantity = listItem.findViewById(R.id.quantityEditText);

        Button minus = listItem.findViewById(R.id.minusButton);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(quantity.getText().toString());
                String newValue = changeQuantity(value, false);
                quantity.setText(newValue);
            }
        });

        Button plus = listItem.findViewById(R.id.plusButton);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(quantity.getText().toString());
                String newValue = changeQuantity(value, true);
                quantity.setText(newValue);
            }
        });

        return listItem;
    }

    public String changeQuantity(int value, boolean add){

        if(add)
            value++;
        else{
            if(value>1)
                value--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(value);
        String newValue = sb.toString();

        return newValue;
    }

}
