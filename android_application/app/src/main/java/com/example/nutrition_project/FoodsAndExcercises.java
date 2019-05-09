package com.example.nutrition_project;

import com.example.nutrition_project.Excercise;
import com.example.nutrition_project.Food;

import java.util.ArrayList;

public class FoodsAndExcercises {
    private static ArrayList<Food> foods;
    private static ArrayList<Excercise> excercises;

    public static void addFood(Food f){
        foods.add(f);
    }
    public static void addExcercise(Excercise e){
        excercises.add(e);
    }
    public static ArrayList<Food> getFoods(){
        return foods;
    }

    public static ArrayList<Excercise> getExcercises() {
        return excercises;
    }
}
