package com.example.team13_nutrition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class SuggestedFoodsPresenter {


    ArrayList<Food> createList() {
        Map<String, Customer> c = CustomerMap.customerMap;
        Map.Entry<String, Customer> entry = c.entrySet().iterator().next();
        String key = entry.getKey();
        Customer customer = entry.getValue();
        try {
            HashMap fs = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                fs = customer.calculateFoodsAndExcercises();
            }
            return (ArrayList<Food>) fs.get(0);
        } catch (Exception e) {
            return null;
        }

    }

}
