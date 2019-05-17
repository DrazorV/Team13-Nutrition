package com.example.team13_nutrition;

import java.util.Date;

public class WeightStatus {
    private double weight;
    private double bmr;
    private double bmi;
    private Date date;

    public WeightStatus(double weight, double bmr, double bmi) {
        this.weight = weight;
        this.bmr = bmr;
        this.bmi = bmi;
        date = new Date();
    }

    public double getWeight() {
        return weight;
    }

    public double getBmr() {
        return bmr;
    }

    public double getBmi() {
        return bmi;
    }

    public Date getDate() {
        return date;
    }
}
