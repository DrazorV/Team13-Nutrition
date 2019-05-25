package com.example.team13_nutrition;

import java.util.Date;

public class DayStatus {
    private int totalProteins;
    private int totalCarbs;


    private int totalFats;
    private int totalExercise;
    private Date date;

    public DayStatus(int totalProteins, int totalCarbs, int totalFats, int totalExercise) {
        this.totalProteins = totalProteins;
        this.totalCarbs = totalCarbs;
        this.totalFats = totalFats;
        this.totalExercise = totalExercise;
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public int getTotalProteins() {
        return totalProteins;
    }

    public int getTotalCarbs() {
        return totalCarbs;
    }

    public int getTotalFats() {
        return totalFats;
    }

    public int getTotalExercise() {
        return totalExercise;
    }
}
