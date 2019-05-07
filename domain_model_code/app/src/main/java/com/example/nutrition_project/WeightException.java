package com.example.nutrition_project;
public class WeightException extends Exception {
    public String toString(){
        return "Negative weights are not allowed";
    }
}
