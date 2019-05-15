package com.example.team13_nutrition.exceptions;
public class PasswordException extends Exception {
    public String toString(){
        return "Invalid password.The password must have  at least one number one symbol and five letters";
    }
}
