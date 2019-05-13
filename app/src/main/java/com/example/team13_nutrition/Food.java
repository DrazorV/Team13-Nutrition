package com.example.team13_nutrition;

public class Food {
    private String name;
    private double callories;
    private double carbonhydrates;
    private double liquids;
    private double fat;
    private double energy;
    private double protein;


    public Food(String name, double callories, double carbonhydrates, double liquids, double fat, double energy, double portein) {
        this.name = name;
        this.callories = callories;
        this.carbonhydrates = carbonhydrates;
        this.liquids = liquids;
        this.fat = fat;
        this.energy = energy;
        this.protein = portein;
    }

    public String getName() {
        return name;
    }

    public double getCallories() {
        return callories;
    }

    public double getCarbonhydrates() {
        return carbonhydrates;
    }

    public double getLiquids() {
        return liquids;
    }

    public double getFat() {
        return fat;
    }

    public double getEnergy() {
        return energy;
    }

    public double getProtein() {
        return protein;
    }


}

