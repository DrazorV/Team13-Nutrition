package com.example.nutrition_project;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ExcercisePerformance {
    private Date date;
    private double duration;
    private String  dayperiod;

    public ExcercisePerformance(double duration,String dayperiod)throws Exception{
        TimeUnit.SECONDS.sleep(1);
        this.duration=duration;
        this.dayperiod=dayperiod;
         this.date=new Date();
    }
    public Date getDate(){
        return date;
    }
    public double getDuration(){
        return duration;
    }
    public String getDayperiod(){
        return dayperiod;
    }
}
