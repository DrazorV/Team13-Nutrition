package com.example.team13_nutrition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class SuggestedSportsPresenter {


    ArrayList<Exercise> createList() {
        Map<String, Customer> c = CustomerMap.customerMap;
        Map.Entry<String, Customer> entry = c.entrySet().iterator().next();
        String key = entry.getKey();
        Customer customer = entry.getValue();
        try {
            HashMap fs = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                fs = customer.calculateFoodsAndExcercises();
            }
            return (ArrayList<Exercise>) fs.get(1);
        } catch (Exception e) {
            return null;
        }

    }
}
