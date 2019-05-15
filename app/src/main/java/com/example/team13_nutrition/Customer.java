package com.example.team13_nutrition;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.*;

public class Customer {
    private final String Username;
    private final String Name;
    private final String Surname;
    private String password;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private static jobtype jobtype;
    private Nutrition_Goal.Nutrition_Goal_Type goals;
    private Set<FoodConsumption> foodConsumptions;
    private Set<ExcercisePerformance> excercisePerformances;
    private Set<WeightStatus> weightStatuses;
    private Set<Nutrition_Goal> nutriton_goals;


    public Customer(String Username, String password, String Name, String Surname, String gender, int age, double height, double weight, String goal, String job, double targetWeight) throws Exception {
        try {
            check(Username);
            check(Surname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.Username = Username;
        this.password = password;
        this.Name = Name;
        this.Surname = Surname;
        this.gender = gender;
        nutriton_goals = new HashSet<>();
        excercisePerformances = new HashSet<>();
        foodConsumptions = new HashSet<>();
        excercisePerformances = new HashSet<>();
        weightStatuses = new HashSet<>();
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setGoals(goal, targetWeight);
        setjobtype(job);
    }

    public void changeGender() {//for JUnit
        if (getGender().equals("male")) gender = "female";
        else gender = "male";
    }

    public void setjobtype(String job) {
        if (job.equals("Light")) jobtype = Customer.jobtype.Light;
        else if (job.equals("Normal")) jobtype = Customer.jobtype.Normal;
        else jobtype = Customer.jobtype.Intense;
    }

    public void setGoals(String goal, double target) throws Exception {
        if (goal.equals("Maintain_Weight")) {
            goals = Nutrition_Goal.Nutrition_Goal_Type.Maintain_Weight;
        } else if (goal.equals("Weight_Loss")) {
            goals = Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss;
            if (target >= weight) throw new Exception();
        } else {
            goals = Nutrition_Goal.Nutrition_Goal_Type.Gain_Weight;
            if (target <= weight) throw new Exception();
        }
        nutriton_goals.add(new Nutrition_Goal(goal, target));
    }

    public void check(String characteristic) throws Exception {
        for (int i = 0; i < characteristic.length(); i++)
            if (!Character.isLetter(characteristic.charAt(i))) throw new NameException();
    }

    public void checkAge(int age) throws Exception {
        if (age < 10 || age > 99) throw new AgeException();
    }

    public void checkHeight(double height) throws Exception {
        if (height < 0 || height > 230) throw new HeightException();
    }

    public void checkWeight(double weight) throws Exception {
        if (weight < 0) throw new WeightException();
    }

    public void checkPassword(String password) throws Exception {
        if (password.length() < 7) throw new PasswordException();
        int sum = 0;
        boolean sum2 = false, sum3 = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetter(password.charAt(i)))
                sum++;
            else if (Character.isDigit(password.charAt(i))) sum2 = !sum2;
            else sum3 = !sum3;
        }
        if (sum < 5 || !sum2 || !sum3) throw new PasswordException();
    }

    public Set<ExcercisePerformance> getExcercisePerformances() {
        return excercisePerformances;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        try {
            checkHeight(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.height = height;
    }

    public Set<FoodConsumption> getFoodConsumptions() {
        return foodConsumptions;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        checkAge(age);
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws Exception {
        checkWeight(weight);
        this.weight = weight;
    }

    public Nutrition_Goal.Nutrition_Goal_Type getGoals() {
        return goals;
    }

    public Set<WeightStatus> getWeightStatuses() {
        return weightStatuses;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) throws Exception {
        checkPassword(password);
        this.password = password;
    }

    public String getSurname() {
        return Surname;
    }

    public String getUsername() {
        return Username;
    }

    public void addFoodConsumption(FoodConsumption fc) {
        foodConsumptions.add(fc);
    }

    public void addExcercisePerformance(ExcercisePerformance ep) {
        excercisePerformances.add(ep);
    }

    public double BMR(double w) throws Exception {
        double[] lm = {17.7, 15.1, 11.5, 11.9, 8.4};
        double[] lf = {13.4, 14.8, 8.3, 9.2, 9.8};
        int[] bm = {657, 692, 873, 700, 821};
        int[] bf = {692, 487, 687, 687, 624};
        double[] choosel;
        int[] chooseb;
        if (gender.equals("male")) {
            choosel = lm;
            chooseb = bm;
        } else {
            choosel = lf;
            chooseb = bf;
        }
        int i = 0;
        int[] boundary_ages = {18, 30, 60, 75};
        for (int j = 0; j < 4; j++) {
            if (boundary_ages[j] > age) break;
            i++;
        }
        double bmr = choosel[i] * w + chooseb[i];
        if (BMI(w) < 18.5)
            bmr = bmr + 500;
        else if (BMI(w) > 25 && BMI(w) < 30)
            bmr = bmr - 500;
        else if (BMI(w) > 30 && BMI(w) < 40) {
            bmr = 5 + 10 * w + 6.25 * height - 5 * age;
            if (gender.equals("female")) bmr -= 166;
        } else if (BMI(w) > 40)
            throw new BMIException();
        return bmr;
    }

    public double BMI(double w) {
        return w / (height * height);
    }

    public void addWeightSatus() throws Exception {
        weightStatuses.add(new WeightStatus(weight, BMR(this.weight), BMI(this.weight)));
    }

    public double PAL() {

        ExcercisePerformance ep = null;
        for (ExcercisePerformance e : excercisePerformances)
            ep = e;
        Excercise ex = ep.getExcercise();
        Excercise.TypeSport ts;
        ts = ex.getType();
        int pal_int;
        if (jobtype.equals(Customer.jobtype.Light)) {
            if (ts.equals(Excercise.TypeSport.Light)) {
                return 1.4;
            } else if (ts.equals(Excercise.TypeSport.Normal)) {
                return 1.5;
            } else if (ts.equals(Excercise.TypeSport.Intense)) {
                return 1.6;
            } else {
                return -1;
            }
        } else if (jobtype.equals(Customer.jobtype.Normal)) {
            double pal;
            if (ts.equals(Excercise.TypeSport.Light)) {
                pal_int = 16;
            } else if (ts.equals(Excercise.TypeSport.Normal)) {
                pal_int = 17;
            } else if (ts.equals(Excercise.TypeSport.Intense)) {
                pal_int = 18;
            } else {
                return -1;
            }
            if (gender.equals("female")) {
                pal_int--;
            }
            pal = (double) pal_int / 10;
            return pal;
        } else {
            double pal;
            if (ts.equals(Excercise.TypeSport.Light)) {
                pal_int = 17;
            } else if (ts.equals(Excercise.TypeSport.Normal)) {
                pal_int = 18;
            } else if (ts.equals(Excercise.TypeSport.Intense)) {
                pal_int = 19;
            } else {
                return -1;
            }
            if (gender.equals("female")) {
                pal_int = pal_int - 2;
            }
            pal = (double) pal_int / 10;
            return pal;
        }
    }

    public double callories(double w) throws Exception {
        double callories = PAL() * BMR(w);
        if (BMI(w) >= 18.5 && BMI(w) <= 25) {
            return callories;
        } else if (BMI(w) < 18.5) {
            return callories + 500;
        } else if (BMI(w) > 25 && BMI(w) <= 30) {
            return callories - 500;
        } else if (BMI(w) > 30 && BMI(w) <= 40) {
            return BMR(w) * 1.4 - 500;
        }
        return -1;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public HashMap calculateFoodsAndExcercises() throws Exception {
        //link :https://www.healthline.com/nutrition/how-many-calories-per-day#section1
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<String> fe = new ArrayList<>();
        fe.add("food");
        fe.add("excersice");
        ArrayList<Food> neededfoods = new ArrayList<>();
        ArrayList<Excercise> neededexcersice = new ArrayList<>();
        double targetweight = 0;
        for (Nutrition_Goal ng : nutriton_goals) {
            if (ng.isActive()) {
                targetweight = ng.getTargetWeight();
            }
        }
        if (targetweight == weight) return null;
        else {
            //case1
            ArrayList<Food> foods = FoodsAndExcercises.getFoods();
            ArrayList<Excercise> excercises = FoodsAndExcercises.getExcercises();
            double neededCallories = callories(targetweight);
            if (neededCallories < callories(this.weight)) {
                foods.stream().sorted(Comparator.comparing(Food::getCallories));
                for (Food f : foods) {
                    neededfoods.add(f);
                    neededCallories += f.getCallories();
                    if (neededCallories > callories(this.weight)) break;
                }
            } else {
                excercises.stream().sorted(Comparator.comparing(Excercise::getLoss_callories));
                for (Excercise e : excercises) {
                    neededexcersice.add(e);
                    neededCallories -= e.getLoss_callories();
                    if (neededCallories < callories(this.weight)) break;
                }
            }
            hashMap.put(fe.get(0), neededfoods);
            hashMap.put(fe.get(1), neededexcersice);
            return hashMap;

        }
    }

    public enum jobtype {Light, Normal, Intense}


}

