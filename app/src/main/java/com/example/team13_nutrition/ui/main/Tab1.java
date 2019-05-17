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
import com.example.team13_nutrition.CustomerMap;
import com.example.team13_nutrition.FoodConsumption;
import com.example.team13_nutrition.Nutrition_Goal;
import com.example.team13_nutrition.R;

import java.util.Objects;
import java.util.Set;

/**
 * A placeholder fragment containing a simple view.
 */
public class Tab1 extends Fragment {

    private boolean mUserSeen = false;
    private boolean mViewCreated = false;

    /**
     * Called when the new created view is visible to user for the first time.
     */
    @SuppressLint("SetTextI18n")
    protected void onViewCreatedFirstSight(View view) {
        if (mViewCreated) {
            String user = Objects.requireNonNull(getArguments()).getString("params");
            TextView name = view.findViewById(R.id.name2);
            TextView prog = view.findViewById(R.id.progr);
            name.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getName() + " " + Objects.requireNonNull(CustomerMap.customerMap.get(user)).getSurname());
            Customer customer = CustomerMap.customerMap.get(user);
            Set<Nutrition_Goal> set = Objects.requireNonNull(customer).getNutriton_goals();
            Set<FoodConsumption> set2 = customer.getFoodConsumptions();

            Nutrition_Goal activeGoal = null;
            int totalFood = 0;

            for (Nutrition_Goal value : set) if (value.isActive()) activeGoal = value;
            for (FoodConsumption v : set2)
                totalFood += (v.getFood().getCallories() * v.getQuantity());
            ProgressBar progressBar = view.findViewById(R.id.progressBar);

            try {
                double trg = Objects.requireNonNull(activeGoal).getTargetWeight();
                int call = (int) customer.callories(trg);
                progressBar.setMax(call);
                progressBar.setProgress(totalFood);
                prog.setText(totalFood + "/" + call);
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