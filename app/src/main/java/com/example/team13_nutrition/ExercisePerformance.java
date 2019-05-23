package com.example.team13_nutrition;

import java.util.Date;

public class ExercisePerformance {
    private Date date;
    private double duration;
    private Exercise exercise;
    private IntensityType intensityType;
    private double constant;


    public ExercisePerformance(double duration, Exercise exercise, String intensity) {
        this.duration = duration;
        this.date = new Date();
        this.exercise = exercise;
        if (intensity.equals("LIGHT")) {
            intensityType = IntensityType.Light;
            constant = 0.5;
        } else if (intensity.equals("NORMAL")) {
            intensityType = IntensityType.Normal;
            constant = 0.666666666;
        } else {
            intensityType = IntensityType.Intense;
            constant = 1;
        }

    }

    public Date getDate() {
        return date;
    }

    public double getDuration() {
        return duration;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public IntensityType getIntensityType() {
        return intensityType;
    }

    public void setIntensityType(IntensityType intensityType) {
        this.intensityType = intensityType;
    }

    public double getConstant() {
        return constant;
    }

    public enum IntensityType {
        Light, Normal, Intense
    }
}
