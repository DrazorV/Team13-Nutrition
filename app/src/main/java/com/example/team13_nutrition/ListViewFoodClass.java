package com.example.team13_nutrition;

public class ListViewFoodClass {

    private String name;
    private boolean checked;
    private int quantity;
    private String mealType;

    ListViewFoodClass(String name, boolean checked, int quantity, String mealType) {
        this.name = name;
        this.checked = checked;
        this.quantity = quantity;
        this.mealType = mealType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    boolean isChecked() {
        return checked;
    }

    void setChecked(boolean checked) {
        this.checked = checked;
    }

    int getQuantity() {
        return quantity;
    }

    String getMealType() {
        return mealType;
    }

    void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
