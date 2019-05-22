package com.example.team13_nutrition.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.team13_nutrition.Customer;
import com.example.team13_nutrition.ExercisePerformance;
import com.example.team13_nutrition.FoodConsumption;
import com.example.team13_nutrition.MakeMap;
import com.example.team13_nutrition.R;
import com.example.team13_nutrition.WeightStatus;

import java.util.Objects;
import java.util.Set;

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
            String user = Objects.requireNonNull(getArguments()).getString("params");
            TextView name = view.findViewById(R.id.name2);
            TextView prog = view.findViewById(R.id.progr);
            name.setText(Objects.requireNonNull(MakeMap.customerMap.get(user)).getName() + " " + Objects.requireNonNull(MakeMap.customerMap.get(user)).getSurname());
            customer = MakeMap.customerMap.get(user);
            foodConsumptions = Objects.requireNonNull(customer).getFoodConsumptions();
            exercisePerformances = Objects.requireNonNull(customer).getExercisePerformances();
            set2 = customer.getWeightStatuses();
            int totalFood = 0;
            int totalExercise = 0;
            for (FoodConsumption v : foodConsumptions)
                totalFood += (v.getFood().getCallories() * v.getQuantity());
            for (ExercisePerformance v : exercisePerformances)
                totalExercise += (v.getExercise().getLoss_callories() * v.getDuration());
            ProgressBar progressBar = view.findViewById(R.id.progressBar);
            try {
                int call = (int) customer.callories();
                progressBar.setMax(call);
                int Sum = totalFood - totalExercise;
                progressBar.setProgress(Sum);
                prog.setText(Sum + "/" + call);
            } catch (Exception e) {
                e.printStackTrace();
            }
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