package com.example.team13_nutrition;

import java.util.ArrayList;

class FoodsAndExercises {
    private static ArrayList<Food> foods = new ArrayList<>();
    private static ArrayList<Exercise> exercises = new ArrayList<>();

    static void addFood(Food f) {
        foods.add(f);
    }

    static void addExcercise(Exercise e) {
        exercises.add(e);
    }

    static ArrayList<Food> getFoods() {
        return foods;
    }

    static ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
