package com.example.team13_nutrition;

public class ListViewExerciseClass {

    String name;
    boolean checked;
    int quantity;
    String intensity;

    public ListViewExerciseClass(String name, boolean checked, int quantity, String intensity){
        this.name = name;
        this.checked = checked;
        this.quantity = quantity;
        this.intensity = intensity;
    }

    public ListViewExerciseClass(){
        this.name = "new";
        this.checked = false;
        this.quantity = 1;
        this.intensity = "INTENSE";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
}
