package com.example.team13_nutrition;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;//

public class SuggestedSportsPresenter {//
    @RequiresApi(api = Build.VERSION_CODES.N)
    private SuggestedSportsActivity view;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public SuggestedSportsPresenter(SuggestedSportsActivity view){
        this.view=view;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Excercise> createList(){
        Map<String,Customer> c=CustomerMap.customerMap;
        Map.Entry<String,Customer> entry=c.entrySet().iterator().next();
        String key=entry.getKey();
        Customer customer=entry.getValue();
        try {
            HashMap<String,Object> fs=customer.calculateFoodsAndExcercises();
            ArrayList<Excercise> excercises= (ArrayList<Excercise>) fs.get(1);
            return  excercises;
        }catch (Exception e){
            return null;
        }

    }
}
