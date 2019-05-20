package com.example.team13_nutrition;

import java.util.HashMap;
import java.util.Map;

public class MakeMap {
    public static Map<String,Customer> customerMap = new HashMap<>();
    public static Map<String,Food> foodMap = new HashMap<>();
    public static Map<String, Exercise> exerciseMap = new HashMap<>();


    public static void MakeCustomerMap() {

        try {
            Customer c1 = new Customer("vagelis","123456","Vagelis","Panos","Male",21,1.88,86,"Weight_Loss","Normal",84);
            Customer c2 = new Customer("τ","τ","Nikolas","Kotas","Male",22,1.9,80,"Gain_Weight","Normal",90);
            Customer c3 = new Customer("test","123","Alexandra","Kramitrou","Female",23,1.78,56,"Maintain_Weight","Normal",57);
            MakeMap.customerMap.put(c1.getUsername(), c1);
            MakeMap.customerMap.put(c2.getUsername(), c2);
            MakeMap.customerMap.put(c3.getUsername(), c3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void MakeFoodMap() { //source -> https://www.nutritionvalue.org/

        try {
            Food []ff=new Food[16];
            ff[0] = new Food("apple", 52, 14, 85.56, 0.2, 0.3);
            ff[1] = new Food("chicken", 158, 4.1, 57.41, 18,18); //100gr
            ff[2] = new Food("rice", 130, 28, 68.44, 0.3, 2.7);
            ff[3] = new Food("beef", 240, 0.6, 58.69, 15, 25);
            ff[4] = new Food("beans", 139, 25, 63.08, 0.4, 9.7);
            ff[5] = new Food("pork", 297, 0, 52.75, 21, 26);
            ff[6] = new Food("banana", 89, 23, 74.91, 0.3, 1.1);
            ff[7] = new Food("spaghetti", 121, 16, 73.16, 3.6, 5.8);
            ff[8] = new Food("fish", 162, 0, 69.63, 7.2, 23);
            ff[9] = new Food("tomato", 18, 3.9, 94.52, 0.2, 0.9);
            ff[10] = new Food("cucumber", 12, 2.2, 96.73, 0.2, 0.6);
            ff[11] = new Food("olive oil", 884, 0, 0, 100, 0);
            ff[12] = new Food("feta cheese", 264, 4.1, 55.22, 21, 14);
            ff[13] = new Food("bread", 267, 49, 35.2, 3.2, 11);
            ff[14] = new Food("lettuce", 15, 2.9, 94.98, 0.2, 1.4);
            ff[15] = new Food("sausage", 230, 2.6, 60.97, 17, 15);

            for(int i=0; i<16; i++) {
                foodMap.put(ff[i].getName(), ff[i]);
                FoodsAndExcercises.addFood(ff[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void MakeExerciseMap() { //source -> http://calorielab.com/burned/
        try {
            Exercise []exc=new Exercise[16];
            exc[0] = new Exercise("Basketball", 340, "Intense");
            exc[1] = new Exercise("Boxing", 544, "Intense");
            exc[2] = new Exercise("Football", 544, "Intense");
            exc[3] = new Exercise("Handball", 476, "Intense");
            exc[4]  = new Exercise("Horseback riding", 204, "Intense");
            exc[5] = new Exercise("Martial arts", 612, "Intense");
            exc[6] = new Exercise("Rock climbing", 680, "Intense");
            exc[7] = new Exercise("Skateboarding", 272, "Intense");
            exc[8] = new Exercise("Tennis", 408, "Intense");
            exc[9] = new Exercise("Volleyball", 476, "Intense");
            exc[10] = new Exercise("Wrestling", 340, "Intense");
            exc[11] = new Exercise("Jogging", 420, "Intense");
            exc[12] = new Exercise("Running", 490, "Intense"); //5 mph
            exc[13]= new Exercise("Bicycling", 490, "Intense");
            exc[14] = new Exercise("Occupation", 500, "Intense");
            exc[15] = new Exercise("Occupation", 250, "Normal");
            exc[16] = new Exercise("Occupation", 100, "Light");

            for(int i=0; i<17; i++){
                exerciseMap.put(exc[i].getName(), exc[i]);
                FoodsAndExcercises.addExcercise(exc[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
