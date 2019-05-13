package com.example.tean13_nutrition;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ExcercisePerformance {
    private Date date;
    private double duration;
    private String  dayperiod;
    private Excercise excercise;

    public ExcercisePerformance(double duration,String dayperiod,Excercise excercise)throws Exception{
        TimeUnit.SECONDS.sleep(1);
        this.duration=duration;
        this.dayperiod=dayperiod;
         this.date=new Date();
         this.excercise=excercise;
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
    public Excercise getExcercise(){
        return excercise;
    }

}
