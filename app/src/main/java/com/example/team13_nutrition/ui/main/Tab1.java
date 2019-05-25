package com.example.team13_nutrition.ui.main;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.team13_nutrition.Customer;
import com.example.team13_nutrition.ExercisePerformance;
import com.example.team13_nutrition.FoodConsumption;
import com.example.team13_nutrition.MakeMap;
import com.example.team13_nutrition.R;
import com.example.team13_nutrition.WeightStatus;
import com.example.team13_nutrition.data.model.LoggedInUser;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    /**
     * Called when the new created view is visible to user for the first time.
     */
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

            int totalProteins = 0;
            int totalCarbs = 0;
            int totalFats = 0;
            int totalExercise = 0;


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

            int remainingCal = cal + totalExercise - totalProteins * 4 - totalCarbs * 4 - totalFats * 9;

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

            int Carb;
            int Protein;
            int Fat;

            if (customer.PAL() < 1.5) {
                Carb = (int) ((cal + totalExercise) * 0.5);
                Protein = (int) (customer.getWeight() * 4);
                Fat = cal + totalExercise - Carb - Protein;
            } else {
                Fat = (int) ((cal + totalExercise) * 0.2);
                Protein = (int) (customer.getWeight() * 1.5 * 4);
                Carb = cal + totalExercise - Fat - Protein;
            }
            carbs.setMax(Carb);
            carbs.setProgress(totalCarbs * 4);
            carbs2.setText((totalCarbs * 4) + "/" + Carb);
            proteins.setMax(Protein);
            proteins.setProgress(totalProteins * 4);
            proteins2.setText((totalProteins * 4) + "/" + Protein);
            fats.setMax(Fat);
            fats.setProgress(totalFats * 9);
            fats2.setText((totalFats * 9) + "/" + Fat);
        }
    }


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

    private void tryViewCreatedFirstSight() {
        if (mUserSeen && mViewCreated) {
            onViewCreatedFirstSight(getView());
        }
    }

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
    protected void onUserVisibleChanged(boolean visible) {
        if (visible) {
            onViewCreatedFirstSight(getView());
        }
    }
}