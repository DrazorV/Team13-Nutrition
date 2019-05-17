package com.example.team13_nutrition.exceptions;

import android.support.annotation.NonNull;

public class HeightException extends Exception {

    @NonNull
    public String toString(){
        return"Valid value is between 1 and 2.3 meters";

    }
}
