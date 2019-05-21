package com.example.team13_nutrition;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ExercisePerformance {
    private Date date;
    private double duration;
    private Exercise exercise;


    public ExercisePerformance(double duration, Exercise exercise) throws Exception {
        TimeUnit.SECONDS.sleep(1);
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
