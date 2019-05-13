package com.example.team13_nutrition;
public class WeightException extends Exception {
    public String toString(){
        return "Negative weights are not allowed";
    }
}
