package com.example.team13_nutrition;

public class ListViewItemClass {

    String name;
    boolean checked;
    int quantity;

    public ListViewItemClass(String name, boolean checked, int quantity){
        this.name = name;
        this.checked = checked;
        this.quantity = quantity;
    }

    public ListViewItemClass(){
        this.name = "new";
        this.checked = false;
        this.quantity = 1;
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
}
