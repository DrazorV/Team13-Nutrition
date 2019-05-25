package com.example.team13_nutrition;

public class ListViewExerciseClass {

    private String name;
    private boolean checked;
    private int duration;
    private String intensity;

    ListViewExerciseClass(String name, boolean checked, int duration, String intensity) {
        this.name = name;
        this.checked = checked;
        this.duration = duration;
        this.intensity = intensity;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    int getDuration() {
        return duration;
    }

    String getIntensity() {
        return intensity;
    }

    void setIntensity(String intensity) {
        this.intensity = intensity;
    }
}
