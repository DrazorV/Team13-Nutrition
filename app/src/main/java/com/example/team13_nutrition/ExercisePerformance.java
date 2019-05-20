package com.example.team13_nutrition;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ExercisePerformance {
    private Date date;
    private double duration;
    private String dayperiod;
    private Exercise exercise;

    public ExercisePerformance(double duration, String dayperiod, Exercise exercise) throws Exception {
        TimeUnit.SECONDS.sleep(1);
        this.duration = duration;
        this.dayperiod = dayperiod;
        this.date = new Date();
        this.exercise = exercise;
    }

    public Date getDate() {
        return date;
    }

    public double getDuration() {
        return duration;
    }

    public String getDayperiod() {
        return dayperiod;
    }

    public Exercise getExercise() {
        return exercise;
    }

}
