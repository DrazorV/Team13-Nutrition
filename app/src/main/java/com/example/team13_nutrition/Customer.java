package com.example.team13_nutrition;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.team13_nutrition.exceptions.AgeException;
import com.example.team13_nutrition.exceptions.HeightException;
import com.example.team13_nutrition.exceptions.NameException;
import com.example.team13_nutrition.exceptions.PasswordException;
import com.example.team13_nutrition.exceptions.WeightException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Customer {
    private static jobtype jobtype;
    private final String Username;
    private final String Name;
    private final String Surname;
    private String password;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private Nutrition_Goal.Nutrition_Goal_Type goals;
    private Set<FoodConsumption> foodConsumptions;
    private Set<ExercisePerformance> exercisePerformances;
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
        exercisePerformances = new HashSet<>();
        foodConsumptions = new HashSet<>();
        exercisePerformances = new HashSet<>();
        weightStatuses = new HashSet<>();
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setGoals(goal, targetWeight);
        setjobtype(job);
    }

    public static void check(String characteristic) throws Exception {
        for (int i = 0; i < characteristic.length(); i++)
            if (!Character.isLetter(characteristic.charAt(i))) throw new NameException();
    }

    public static void checkAge(int age) throws AgeException {
        if (age < 10 || age > 99) throw new AgeException();
    }

    public static void checkHeight(double height) throws HeightException {
        if (height < 1 || height > 2.3) throw new HeightException();
    }

    public static void checkWeight(double weight) throws WeightException {
        if (weight < 20 || weight > 200) throw new WeightException();
    }

    public static void checkPassword(String password) throws PasswordException {
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

    public void changeGender() {//for JUnit
        if (getGender().equals("Male")) gender = "Female";
        else gender = "Male";
    }

    public void setjobtype(String job) {
        if (job.equals("Light")) jobtype = Customer.jobtype.Light;
        else if (job.equals("Normal")) jobtype = Customer.jobtype.Normal;
        else jobtype = Customer.jobtype.Intense;
    }

    public void setGoals(String goal, double target) throws WeightException {
        if (goal.equals("Maintain_Weight")) {
            goals = Nutrition_Goal.Nutrition_Goal_Type.Maintain_Weight;
        } else if (goal.equals("Weight_Loss")) {
            goals = Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss;
            if (target >= weight) throw new WeightException();
        } else {
            goals = Nutrition_Goal.Nutrition_Goal_Type.Gain_Weight;
            if (target <= weight) throw new WeightException();
        }
        for (Nutrition_Goal v : nutriton_goals) v.deactivateGoal();
        nutriton_goals.add(new Nutrition_Goal(goal, target));
    }

    public Set<Nutrition_Goal> getNutriton_goals() {
        return nutriton_goals;
    }

    public Set<ExercisePerformance> getExercisePerformances() {
        return exercisePerformances;
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

    public void setAge(int age) throws AgeException {
        checkAge(age);
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws Exception {
        checkWeight(weight);
        weightStatuses.add(new WeightStatus(weight, BMR(weight), BMI(weight)));
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

    public void addExcercisePerformance(ExercisePerformance ep) {
        exercisePerformances.add(ep);
    }

    public double BMR(double w) throws Exception {
        double[] lm = {17.7, 15.1, 11.5, 11.9, 8.4};
        double[] lf = {13.4, 14.8, 8.3, 9.2, 9.8};
        int[] bm = {657, 692, 873, 700, 821};
        int[] bf = {692, 487, 687, 687, 624};
        double[] choosel;
        int[] chooseb;
        if (gender.equals("Male")) {
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
        return choosel[i] * w + chooseb[i];
    }

    public double BMI(double w) {
        return w / (height * height);
    }

    public double PAL() {

        ExercisePerformance ep = null;
        for (ExercisePerformance e : exercisePerformances) ep = e;

        if (ep == null) {
            return 1.4;
        } else {
            Exercise ex = ep.getExercise();
            Exercise.TypeSport ts;
            ts = ex.getType();
            int pal_int;
            if (jobtype.equals(Customer.jobtype.Light)) {
                if (ts.equals(Exercise.TypeSport.Light)) {
                    return 1.4;
                } else if (ts.equals(Exercise.TypeSport.Normal)) {
                    return 1.5;
                } else if (ts.equals(Exercise.TypeSport.Intense)) {
                    return 1.6;
                } else {
                    return -1;
                }
            } else if (jobtype.equals(Customer.jobtype.Normal)) {
                double pal;
                if (ts.equals(Exercise.TypeSport.Light)) {
                    pal_int = 16;
                } else if (ts.equals(Exercise.TypeSport.Normal)) {
                    pal_int = 17;
                } else if (ts.equals(Exercise.TypeSport.Intense)) {
                    pal_int = 18;
                } else {
                    return -1;
                }
                if (gender.equals("Female")) {
                    pal_int--;
                }
                pal = (double) pal_int / 10;
                return pal;
            } else {
                double pal;
                if (ts.equals(Exercise.TypeSport.Light)) {
                    pal_int = 17;
                } else if (ts.equals(Exercise.TypeSport.Normal)) {
                    pal_int = 18;
                } else if (ts.equals(Exercise.TypeSport.Intense)) {
                    pal_int = 19;
                } else {
                    return -1;
                }
                if (gender.equals("Female")) {
                    pal_int = pal_int - 2;
                }
                pal = (double) pal_int / 10;
                return pal;
            }
        }
    }

    public double callories() throws Exception {
        Nutrition_Goal activeGoal = null;
        for (Nutrition_Goal value : nutriton_goals) if (value.isActive()) activeGoal = value;
        double w = Objects.requireNonNull(activeGoal).getTargetWeight();
        double callories = PAL() * BMR(w);
        if (activeGoal.getGoal_Type().equals(Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss))
            return callories - 500;
        else if (activeGoal.getGoal_Type().equals(Nutrition_Goal.Nutrition_Goal_Type.Gain_Weight))
            return callories + 500;
        else return callories;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public HashMap calculateFoodsAndExcercises() throws Exception {
        //link :https://www.healthline.com/nutrition/how-many-calories-per-day#section1
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<String> fe = new ArrayList<>();
        fe.add("food");
        fe.add("exercise");
        ArrayList<Food> neededfoods = new ArrayList<>();
        ArrayList<Exercise> neededexcersice = new ArrayList<>();
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
            ArrayList<Exercise> exercises = FoodsAndExcercises.getExercises();
            double neededCallories = callories();
            if (neededCallories < callories()) {
                foods.stream().sorted(Comparator.comparing(Food::getCallories));
                for (Food f : foods) {
                    neededfoods.add(f);
                    neededCallories += f.getCallories();
                    if (neededCallories > callories()) break;
                }
            } else {
                exercises.stream().sorted(Comparator.comparing(Exercise::getLoss_callories));
                for (Exercise e : exercises) {
                    neededexcersice.add(e);
                    neededCallories -= e.getLoss_callories();
                    if (neededCallories < callories()) break;
                }
            }
            hashMap.put(fe.get(0), neededfoods);
            hashMap.put(fe.get(1), neededexcersice);
            return hashMap;

        }
    }

    public enum jobtype {Light, Normal, Intense}


}

