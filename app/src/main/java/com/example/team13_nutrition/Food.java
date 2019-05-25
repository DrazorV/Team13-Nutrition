package com.example.team13_nutrition;

public class Food {
    private String name;
    private double calories;
    private double carbohydrates;
    private double liquids;
    private double fat;
    private double protein;


    public Food(String name, double calories, double carbohydrates, double liquids, double fat, double protein) {
        this.name = name;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.liquids = liquids;
        this.fat = fat;
        this.protein = protein;
    }


    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setLiquids(double liquids) {
        this.liquids = liquids;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getLiquids() {
        return liquids;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }


}

