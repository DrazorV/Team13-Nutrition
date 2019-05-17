package com.example.team13_nutrition;


public class Exercise {
    private String name;
    private double loss_calories;
    private double loss_carbohydrates;
    private double loss_liquids;
    private double loss_fat;
    private TypeSport type;

    public Exercise(String name, double loss_calories, String typesport) {
        this.name = name;
        this.loss_calories = loss_calories;
        if (typesport.equals("Light")) type = TypeSport.Light;
        else if (typesport.equals("Normal")) type = TypeSport.Normal;
        else if (typesport.equals("Intense")) type = TypeSport.Intense;
        else System.out.println("S");
    }

    public String getName() {
        return name;
    }

    public double getLoss_callories() {
        return loss_calories;
    }

    public double getLoss_carbohydrates() {
        return loss_carbohydrates;
    }

    public double getLoss_liquids() {
        return loss_liquids;
    }

    public double getLoss_fat() {
        return loss_fat;
    }

    public TypeSport getType() {
        return type;
    }

    public enum TypeSport {
        Light, Normal, Intense
    }

}
