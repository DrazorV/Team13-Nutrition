package com.example.team13_nutrition;

import java.util.HashMap;
import java.util.Map;

public class CustomerMap {
    public static Map<String,Customer> customerMap = new HashMap<>();


    public static void MakeCustomerMap() {

        try {
            Customer c1 = new Customer("vagelis","123456","Vagelis","Panos","Male",21,1.88,86,"Weight_Loss","Normal",84);
            Customer c2 = new Customer("test","123456","Nikolas","Kotas","Male",22,1.9,80,"Gain_Weight","Normal",90);
            Customer c3 = new Customer("test2","123456","Alexandra","Kramitrou","Female",23,1.78,56,"Maintain_Weight","Normal",57);
            CustomerMap.customerMap.put(c1.getUsername(),c1);
            CustomerMap.customerMap.put(c2.getUsername(),c2);
            CustomerMap.customerMap.put(c3.getUsername(),c3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
