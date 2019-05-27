package com.example.team13_nutrition;

public class SuggestedFoodClass {

    private String foodName;
    private int quantity;
    private double fats, carbs, proteins;

    public SuggestedFoodClass(String foodName, int quantity, double fats, double proteins, double carbs){
        this.foodName = foodName;
        this.quantity = quantity;
        this.carbs = carbs;
        this.proteins = proteins;
        this.fats = fats;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }
}
