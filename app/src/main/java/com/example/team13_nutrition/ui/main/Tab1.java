package com.example.team13_nutrition.ui.main;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.team13_nutrition.Customer;
import com.example.team13_nutrition.DayStatus;
import com.example.team13_nutrition.ExercisePerformance;
import com.example.team13_nutrition.Food;
import com.example.team13_nutrition.FoodConsumption;
import com.example.team13_nutrition.MainActivity;
import com.example.team13_nutrition.MakeMap;
import com.example.team13_nutrition.R;
import com.example.team13_nutrition.SuggestedFoodAdapter;
import com.example.team13_nutrition.SuggestedFoodClass;
import com.example.team13_nutrition.WeightStatus;
import com.example.team13_nutrition.data.model.LoggedInUser;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import github.nisrulz.stackedhorizontalprogressbar.StackedHorizontalProgressBar;

/**
 * A placeholder fragment containing a simple view.
 */
public class Tab1 extends Fragment {
    Customer customer;
    private boolean mUserSeen = false;
    private boolean mViewCreated = false;
    Set<WeightStatus> set2;
    public static Set<FoodConsumption> foodConsumptions;
    public static Set<ExercisePerformance> exercisePerformances;
    public static Set<DayStatus> dayStatuses;
    ArrayList<SuggestedFoodClass> suggestedFoodList;
    SuggestedFoodAdapter suggestedFoodAdapter;
    int totalProteins, totalCarbs, totalFats, totalExercise, remainingCal;
    int maxCarbs;
    int maxProteins;
    int maxFats;

    /**
     * Called when the new created view is visible to user for the first time.
     */
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("SetTextI18n")
    protected void onViewCreatedFirstSight(View view) {
        if (mViewCreated) {
            String user = LoggedInUser.getUserId();
            TextView name = view.findViewById(R.id.name2);
            name.setText(Objects.requireNonNull(MakeMap.customerMap.get(user)).getName() + " " + Objects.requireNonNull(MakeMap.customerMap.get(user)).getSurname());
            customer = MakeMap.customerMap.get(user);
            foodConsumptions = Objects.requireNonNull(customer).getFoodConsumptions();
            exercisePerformances = Objects.requireNonNull(customer).getExercisePerformances();
            set2 = customer.getWeightStatuses();

            totalProteins = 0;
            totalCarbs = 0;
            totalFats = 0;
            totalExercise = 0;


            for (FoodConsumption v : foodConsumptions) {
                totalProteins += (v.getFood().getProtein() * v.getQuantity());
                totalCarbs += (v.getFood().getCarbohydrates() * v.getQuantity());
                totalFats += (v.getFood().getFat() * v.getQuantity());
            }

            for (ExercisePerformance v : exercisePerformances)
                totalExercise += (v.getExercise().getLoss_callories() * (v.getDuration() / 60) * v.getConstant());

            int cal = (int) customer.calories();
            PieChart chart = view.findViewById(R.id.chart);
            List<PieEntry> entries = new ArrayList<>();

            remainingCal = cal + totalExercise - totalProteins * 4 - totalCarbs * 4 - totalFats * 9;

            if (remainingCal > 0) entries.add(new PieEntry(remainingCal, "Remaining Calories"));
            if (totalProteins > 0) entries.add(new PieEntry(totalProteins * 4, "Proteins"));
            if (totalCarbs > 0) entries.add(new PieEntry(totalCarbs * 4, "Carbs"));
            if (totalFats > 0) entries.add(new PieEntry(totalFats * 9, "Fats"));

            PieDataSet set = new PieDataSet(entries, "");
            set.setColors(Color.GRAY, Color.parseColor("#9ACD32"), Color.parseColor("#20B2AA"), Color.parseColor("#FA8072"));
            PieData data = new PieData(set);
            data.setValueTextSize(20);
            data.setValueTextColor(Color.BLACK);
            chart.setCenterText("Calories: " + (totalProteins * 4 + totalCarbs * 4 + totalFats * 9) + "/" + (cal + totalExercise));
            chart.setHoleColor(Color.parseColor("#FF5722"));
            chart.setCenterTextSize(20);
            chart.setData(data);
            chart.getDescription().setEnabled(false);
            chart.invalidate();


            StackedHorizontalProgressBar carbs = view.findViewById(R.id.carbs);
            TextView carbs2 = view.findViewById(R.id.carbstxt);
            StackedHorizontalProgressBar proteins = view.findViewById(R.id.proteins);
            TextView proteins2 = view.findViewById(R.id.prottxt);
            StackedHorizontalProgressBar fats = view.findViewById(R.id.fats);
            TextView fats2 = view.findViewById(R.id.fattxt);

            if (customer.PAL() < 1.5) {
                maxCarbs = (int) ((cal + totalExercise) * 0.5);
                maxProteins = (int) (customer.getWeight() * 4);
                maxFats = cal + totalExercise - maxCarbs - maxProteins;
            } else {
                maxFats = (int) ((cal + totalExercise) * 0.2);
                maxProteins = (int) (customer.getWeight() * 1.5 * 4);
                maxCarbs = cal + totalExercise - maxFats - maxProteins;
            }
            carbs.setMax(maxCarbs);
            carbs.setProgress(totalCarbs * 4);
            carbs2.setText((totalCarbs * 4) + "/" + maxCarbs);
            proteins.setMax(maxProteins);
            proteins.setProgress(totalProteins * 4);
            proteins2.setText((totalProteins * 4) + "/" + maxProteins);
            fats.setMax(maxFats);
            fats.setProgress(totalFats * 9);
            fats2.setText((totalFats * 9) + "/" + maxFats);

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            int delayInHour = hour < 6 ? 6 - hour : 24 - (hour - 6);

            System.out.println("Current Hour: " + hour);
            System.out.println("Commuted Delay for next 5 AM: " + delayInHour);

            scheduler.scheduleAtFixedRate(new MyTask(), delayInHour, 24, TimeUnit.HOURS);

            createSuggestedFoodList();
            ListView suggestedFoodListView = view.findViewById(R.id.suggested_food_listView);
            suggestedFoodAdapter = new SuggestedFoodAdapter(view.getContext(), suggestedFoodList);
            suggestedFoodListView.setAdapter(suggestedFoodAdapter);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!mUserSeen && isVisibleToUser) {
            mUserSeen = true;
            onUserFirstSight();
            tryViewCreatedFirstSight();
        }
        onUserVisibleChanged(isVisibleToUser);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewCreated = false;
        mUserSeen = false;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void tryViewCreatedFirstSight() {
        if (mUserSeen && mViewCreated) {
            onViewCreatedFirstSight(getView());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewCreated = true;
        tryViewCreatedFirstSight();
    }

    /**
     * Called when the fragment's UI is visible to user for the first time.
     *
     * <p>However, the view may not be created currently if in {@link android.support.v4.view.ViewPager}.
     */
    protected void onUserFirstSight() {
    }

    /**
     * Called when the visible state to user has been changed.
     */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onUserVisibleChanged(boolean visible) {
        if (visible) {
            onViewCreatedFirstSight(getView());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createSuggestedFoodList() {
        suggestedFoodList = new ArrayList<>();
        int remainingCarbs = maxCarbs - totalCarbs * 4;
        int remainingFats = maxFats - totalFats * 9;
        int remainingProteins = maxProteins - totalProteins * 4;
        SuggestedFoodClass added;
        if (remainingCal <= 0 || remainingCarbs <= 0 || remainingFats <= 0 || remainingProteins <= 0) {
            added = new SuggestedFoodClass("None", 0, 0, 0, 0);
            suggestedFoodList.add(added);
        } else {
            for (String key : MakeMap.foodMap.keySet()) {
                Food food = MakeMap.foodMap.get(key);
                double foodFats = Objects.requireNonNull(food).getFat();
                double foodProteins = food.getProtein();
                double foodCarbs = food.getCarbohydrates();
                if (remainingCarbs / (foodCarbs * 4) > 0 && remainingFats / (foodFats * 9) > 0 && remainingProteins / (foodProteins * 4) > 0) {

                    double qC = remainingCarbs / (foodCarbs * 4);
                    double qF = remainingCarbs / (foodFats * 9);
                    double qP = remainingCarbs / (foodProteins * 4);
                    int quantity = Integer.min((int) qC, (int) qF);
                    if (qP < quantity)
                        quantity = Integer.min((int) qC, (int) qP);
                    if (quantity > 5)
                        quantity = 5;
                    added = new SuggestedFoodClass(food.getName(), quantity, foodFats * quantity * 9, foodProteins * quantity * 4, foodCarbs * quantity * 4);
                    suggestedFoodList.add(added);
                    System.out.println(added.getFoodName());
                }//if
            }//for
        }//else
    }//create

    private class MyTask implements Runnable {
        @Override
        public void run() {
            DayStatus dayStatus = new DayStatus(totalProteins, totalCarbs, totalFats, totalExercise);
            dayStatuses.add(dayStatus);
            Intent it = new Intent(getActivity(), MainActivity.class);
            startActivity(it);
        }
    }
}