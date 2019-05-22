package com.example.team13_nutrition;

public class ListViewFoodClass {

    String name;
    boolean checked;
    int quantity;
    String mealType;

    public ListViewFoodClass(String name, boolean checked, int quantity, String mealType){
        this.name = name;
        this.checked = checked;
        this.quantity = quantity;
        this.mealType = mealType;
    }

    public ListViewFoodClass(){
        this.name = "new";
        this.checked = false;
        this.quantity = 1;
        this.mealType = "BREAKFAST";
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

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
