package com.example.team13_nutrition;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;//

class SuggestedSportsPresenter {


    @RequiresApi(api = Build.VERSION_CODES.N)
    ArrayList<Excercise> createList() {
        Map<String, Customer> c = CustomerMap.customerMap;
        Map.Entry<String, Customer> entry = c.entrySet().iterator().next();
        String key = entry.getKey();
        Customer customer = entry.getValue();
        try {
            HashMap fs = customer.calculateFoodsAndExcercises();
            return (ArrayList<Excercise>) fs.get(1);
        } catch (Exception e) {
            return null;
        }

    }
}
