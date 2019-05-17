package com.example.team13_nutrition;

import java.util.ArrayList;

public class FoodsAndExcercises {
    private static ArrayList<Food> foods;
    private static ArrayList<Exercise> exercises;

    public static void addFood(Food f){
        foods.add(f);
    }
    public static void addExcercise(Exercise e){
        exercises.add(e);
    }
    public static ArrayList<Food> getFoods(){
        return foods;
    }

    public static ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
