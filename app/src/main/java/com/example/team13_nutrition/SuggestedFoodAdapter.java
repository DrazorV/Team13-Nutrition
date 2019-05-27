package com.example.team13_nutrition;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SuggestedFoodAdapter extends ArrayAdapter<SuggestedFoodClass> {

    private Context mContext;
    private ArrayList<SuggestedFoodClass> itemList;

    public SuggestedFoodAdapter(@NonNull Context context, ArrayList<SuggestedFoodClass> list) {

        super(context, 0, list);
        mContext = context;
        itemList = list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        {

            View listItem = convertView;
            if (listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.suggested_food_listview_layout, parent, false);

            SuggestedFoodClass currentItem = itemList.get(position);

            TextView foodName = listItem.findViewById(R.id.foodNameTextView);
            foodName.setText(currentItem.getFoodName());

            String temp;

            TextView quantity = listItem.findViewById(R.id.foodQuantity);
            temp = "" + currentItem.getQuantity();
            quantity.setText(temp);

            TextView proteins = listItem.findViewById(R.id.foodProteins);
            temp = "" + currentItem.getProteins();
            proteins.setText(temp);

            TextView carbs = listItem.findViewById(R.id.foodCarbohydrates);
            temp = "" + currentItem.getCarbs();
            carbs.setText(temp);

            TextView fats = listItem.findViewById(R.id.foodFat);
            temp = "" + currentItem.getFats();
            fats.setText(temp);

            return listItem;
        }
    }
}
