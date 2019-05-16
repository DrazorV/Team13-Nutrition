package com.example.team13_nutrition;

import android.widget.Toast;

import java.util.Map;

public class ReportWeightPresenter {
    private ReportWeightActivity view;

    public ReportWeightPresenter(ReportWeightActivity view){
        this.view=view;
    }
    public void setWeight(){
        double weight;
        try{
            weight=Double.parseDouble(view.getEditText().getText().toString());
        }catch(Exception e){
            Toast.makeText(view ,"Weight in numbers", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, Customer> c = CustomerMap.customerMap;
        Map.Entry<String, Customer> entry = c.entrySet().iterator().next();
        String key = entry.getKey();
        Customer customer = entry.getValue();
        try {
            customer.setWeight(weight);
        }catch (Exception e){
            Toast.makeText(view ,"Weight out off range", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
