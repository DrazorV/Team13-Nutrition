package com.example.team13_nutrition;

import java.util.HashMap;
import java.util.Map;

public class MakeMap {
    public static Map<String, Customer> customerMap = new HashMap<>();
    public static Map<String, Food> foodMap = new HashMap<>();
    public static Map<String, Exercise> exerciseMap = new HashMap<>();
    //


    public static void MakeCustomerMap() {

        try {
            Customer c1 = new Customer("vagelis", "123456", "Vagelis", "Panos", "Male", 21, 1.88, 86, "Weight_Loss", "Normal", 84);
            Customer c2 = new Customer("τ", "123456", "Nikolas", "Kotas", "Male", 22, 1.9, 80, "Gain_Weight", "Normal", 90);
            Customer c3 = new Customer("test", "123456", "Alexandra", "Kramitrou", "Female", 23, 1.78, 56, "Maintain_Weight", "Normal", 57);
            MakeMap.customerMap.put(c1.getUsername(), c1);
            MakeMap.customerMap.put(c2.getUsername(), c2);
            MakeMap.customerMap.put(c3.getUsername(), c3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void MakeFoodMap() { //source -> https://www.nutritionvalue.org/
        Food[] ff = new Food[16];
        ff[0] = new Food("apple", 59, 14, 85.56, 0.2, 0.3);
        ff[1] = new Food("chicken", 250.4, 4.1, 57.41, 18, 18); //100gr
        ff[2] = new Food("rice", 125.5, 28, 68.44, 0.3, 2.7);
        ff[3] = new Food("beef", 237.4, 0.6, 58.69, 15, 25);
        ff[4] = new Food("beans", 142.4, 25, 63.08, 0.4, 9.7);
        ff[5] = new Food("pork", 293.0, 0, 52.75, 21, 26);
        ff[6] = new Food("banana", 99.1, 23, 74.91, 0.3, 1.1);
        ff[7] = new Food("spaghetti", 119.6, 16, 73.16, 3.6, 5.8);
        ff[8] = new Food("fish", 156.8, 0, 69.63, 7.2, 23);
        ff[9] = new Food("tomato", 21.0, 3.9, 94.52, 0.2, 0.9);
        ff[10] = new Food("cucumber", 13.0, 2.2, 96.73, 0.2, 0.6);
        ff[11] = new Food("olive oil", 90.0, 0, 0, 10, 0); //10gr
        ff[12] = new Food("feta cheese", 261.4, 4.1, 55.22, 21, 14);
        ff[13] = new Food("bread", 268.8, 49, 35.2, 3.2, 11);
        ff[14] = new Food("lettuce", 19.0, 2.9, 94.98, 0.2, 1.4);
        ff[15] = new Food("sausage", 223.4, 2.6, 60.97, 17, 15);

        for (int i = 0; i < 16; i++) {
            double cal = (ff[i].getProtein()*4 + ff[i].getCarbohydrates()*4 + ff[i].getFat()*9);
            ff[i].setCalories(cal);
            foodMap.put(ff[i].getName(), ff[i]);
            FoodsAndExercises.addFood(ff[i]);
        }
    }

    public static void MakeExerciseMap() { //source -> http://calorielab.com/burned/
        Exercise[] exc = new Exercise[16];
        exc[0] = new Exercise("Basketball", 476);
        exc[1] = new Exercise("Boxing", 544);
        exc[2] = new Exercise("Football", 612);
        exc[3] = new Exercise("Handball", 748);
        exc[4] = new Exercise("Horseback riding", 374);
        exc[5] = new Exercise("Martial arts", 612);
        exc[6] = new Exercise("Rock climbing", 680);
        exc[7] = new Exercise("Skateboarding", 272);
        exc[8] = new Exercise("Tennis", 476);
        exc[9] = new Exercise("Volleyball", 476);
        exc[10] = new Exercise("Wrestling", 340);
        exc[11] = new Exercise("Jogging", 420);
        exc[12] = new Exercise("Running", 490); //5 mph
        exc[13] = new Exercise("Bicycling", 510);
        exc[14] = new Exercise("Occupation", 500);

        for (int i = 0; i < 15; i++) {
            exerciseMap.put(exc[i].getName(), exc[i]);
            FoodsAndExercises.addExcercise(exc[i]);
        }
    }

}
