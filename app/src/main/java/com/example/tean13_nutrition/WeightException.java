package com.example.tean13_nutrition;
public class WeightException extends Exception {
    public String toString(){
        return "Negative weights are not allowed";
    }
}
