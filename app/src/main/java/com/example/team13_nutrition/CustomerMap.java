package com.example.team13_nutrition;

import java.util.HashMap;
import java.util.Map;

public class CustomerMap {
    public static Map<String,Customer> customerMap = new HashMap<>();
    public static Map<String,Food> foodMap = new HashMap<>();
    public static Map<String, Exercise> exerciseMap = new HashMap<>();


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

    public static void MakeFoodMap() { //source -> https://www.nutritionvalue.org/

        try {
            Food f1 = new Food("apple", 52, 14, 85.56, 0.2, 0.3);
            Food f2 = new Food("chicken", 158, 4.1, 57.41, 18,18); //100gr
            Food f3 = new Food("rice", 130, 28, 68.44, 0.3, 2.7);
            Food f4 = new Food("beef", 240, 0.6, 58.69, 15, 25);
            Food f5 = new Food("beans", 139, 25, 63.08, 0.4, 9.7);
            Food f6 = new Food("pork", 297, 0, 52.75, 21, 26);
            Food f7 = new Food("banana", 89, 23, 74.91, 0.3, 1.1);
            Food f8 = new Food("spaghetti", 121, 16, 73.16, 3.6, 5.8);
            Food f9 = new Food("fish", 162, 0, 69.63, 7.2, 23);
            Food f10 = new Food("tomato", 18, 3.9, 94.52, 0.2, 0.9);
            Food f11 = new Food("cucumber", 12, 2.2, 96.73, 0.2, 0.6);
            Food f12 = new Food("olive oil", 884, 0, 0, 100, 0);
            Food f13 = new Food("feta cheese", 264, 4.1, 55.22, 21, 14);
            Food f14 = new Food("bread", 267, 49, 35.2, 3.2, 11);
            Food f15 = new Food("lettuce", 15, 2.9, 94.98, 0.2, 1.4);
            Food f16 = new Food("sausage", 230, 2.6, 60.97, 17, 15);

            foodMap.put(f1.getName(), f1);
            foodMap.put(f2.getName(), f2);
            foodMap.put(f3.getName(), f3);
            foodMap.put(f4.getName(), f4);
            foodMap.put(f5.getName(), f5);
            foodMap.put(f6.getName(), f6);
            foodMap.put(f7.getName(), f7);
            foodMap.put(f8.getName(), f8);
            foodMap.put(f9.getName(), f9);
            foodMap.put(f10.getName(), f10);
            foodMap.put(f11.getName(), f11);
            foodMap.put(f12.getName(), f12);
            foodMap.put(f13.getName(), f13);
            foodMap.put(f14.getName(), f14);
            foodMap.put(f15.getName(), f15);
            foodMap.put(f16.getName(), f16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void MakeExerciseMap() {

        try {


            Exercise e1 = new Exercise("Basketball", 340, "Intense");
            Exercise e2 = new Exercise("Boxing", 544, "Intense");
            Exercise e3 = new Exercise("Football", 544, "Intense");
            Exercise e4 = new Exercise("Handball", 476, "Intense");
            Exercise e5 = new Exercise("Horseback riding", 204, "Intense");
            Exercise e6 = new Exercise("Martial arts", 612, "Intense");
            Exercise e7 = new Exercise("Rock climbing", 680, "Intense");
            Exercise e8 = new Exercise("Skateboarding", 272, "Intense");
            Exercise e9 = new Exercise("Tennis", 408, "Intense");
            Exercise e10 = new Exercise("Volleyball, competitive", 476, "Intense");
            Exercise e11 = new Exercise("Wrestling", 340, "Intense");
            Exercise e12 = new Exercise("Jogging", 420, "Intense");
            Exercise e13 = new Exercise("Running", 490, "Intense"); //5 mph
            Exercise e14 = new Exercise("Bicycling", 490, "Intense");
            Exercise e15 = new Exercise("Occupation", 500, "Intense");
            Exercise e16 = new Exercise("Occupation", 250, "Normal");
            Exercise e17 = new Exercise("Occupation", 100, "Light");

            exerciseMap.put(e1.getName(), e1);
            exerciseMap.put(e2.getName(), e2);
            exerciseMap.put(e3.getName(), e3);
            exerciseMap.put(e4.getName(), e4);
            exerciseMap.put(e5.getName(), e5);
            exerciseMap.put(e6.getName(), e6);
            exerciseMap.put(e7.getName(), e7);
            exerciseMap.put(e8.getName(), e8);
            exerciseMap.put(e9.getName(), e9);
            exerciseMap.put(e10.getName(), e10);
            exerciseMap.put(e11.getName(), e11);
            exerciseMap.put(e12.getName(), e12);
            exerciseMap.put(e13.getName(), e13);
            exerciseMap.put(e14.getName(), e14);
            exerciseMap.put(e15.getName(), e15);
            exerciseMap.put(e16.getName(), e16);
            exerciseMap.put(e17.getName(), e17);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
