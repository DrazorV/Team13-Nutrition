package com.example.team13_nutrition;

import java.util.Date;

public class Nutrition_Goal {
    private Date startDate;
    private Date endDate;
    private double targetWeight;
    private boolean active;

    public enum Nutrition_Goal_Type {
        Maintain_Weight, Weight_Loss, Gain_Weight
    }

    private Nutrition_Goal_Type Goal_Type;

    Nutrition_Goal(String type, double targetWeight) {
        startDate = new Date();
        active = true;
        this.targetWeight = targetWeight;
        if (type.equals("Maintain_Weight")) Goal_Type = Nutrition_Goal_Type.Maintain_Weight;
        else if (type.equals("Weight_Loss")) Goal_Type = Nutrition_Goal_Type.Weight_Loss;
        else Goal_Type = Nutrition_Goal_Type.Gain_Weight;

    }

    void deactivateGoal() {
        this.endDate = new Date();
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    Date getStartDate() {
        return startDate;
    }

    Date getEndDate() {
        return endDate;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    Nutrition_Goal_Type getGoal_Type() {
        return Goal_Type;
    }
}