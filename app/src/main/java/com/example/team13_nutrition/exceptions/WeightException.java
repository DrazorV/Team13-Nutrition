package com.example.team13_nutrition.exceptions;
public class WeightException extends Exception {
    public String toString(){
        return "Valid value is between 20 and 200 kilograms";
    }
}
