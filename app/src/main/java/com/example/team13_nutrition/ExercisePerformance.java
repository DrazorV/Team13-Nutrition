package com.example.team13_nutrition;

import java.util.Date;

public class ExercisePerformance {
    private Date date;
    private double duration;
    private Exercise exercise;


    public ExercisePerformance(double duration, Exercise exercise) {
        this.duration = duration;
        this.date = new Date();
        this.exercise = exercise;
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


}
