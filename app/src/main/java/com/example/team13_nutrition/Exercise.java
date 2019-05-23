package com.example.team13_nutrition;


public class Exercise {
    private String name;
    private double loss_calories;

    public Exercise(String name, double loss_calories) {
        this.name = name;
        this.loss_calories = loss_calories;
    }

    public String getName() {
        return name;
    }

    public double getLoss_callories() {
        return loss_calories;
    }

}
