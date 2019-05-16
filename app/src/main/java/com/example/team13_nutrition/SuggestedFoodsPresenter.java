package com.example.team13_nutrition;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuggestedFoodsPresenter {
    private SuggestedFoodsActivity view;

    public SuggestedFoodsPresenter(SuggestedFoodsActivity view) {
        this.view = view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Food> createList() {
        Map<String, Customer> c = CustomerMap.customerMap;
        Map.Entry<String, Customer> entry = c.entrySet().iterator().next();
        String key = entry.getKey();
        Customer customer = entry.getValue();
        try {
            HashMap fs = customer.calculateFoodsAndExcercises();
            return (ArrayList<Food>) fs.get(0);
        } catch (Exception e) {
            return null;
        }

    }

}
