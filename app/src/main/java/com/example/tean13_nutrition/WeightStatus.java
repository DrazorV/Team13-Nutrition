package com.example.tean13_nutrition;
import java.util.Date;

public class WeightStatus {
    private double weight;
    private double bmr;
    private double bmi;
    private Date date;
    private Customer customer;

    public WeightStatus(double weight,double bmr,double bmi){
        this.weight=weight;
        this.bmr=bmr;
        this.bmi=bmi;
        date=new Date();
    }
    private double getWeight(){
        return  weight;
    }
    private double getBmr(){
        return  bmr;
    }
    private double getBmi(){
        return bmi;
    }
    public Date getDate(){
        return date;
    }
}
