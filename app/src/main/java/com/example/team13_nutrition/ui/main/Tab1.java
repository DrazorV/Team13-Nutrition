package com.example.team13_nutrition.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.team13_nutrition.CustomerMap;
import com.example.team13_nutrition.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Objects;

/**
 * A placeholder fragment containing a simple view.
 */
public class Tab1 extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String user = Objects.requireNonNull(getArguments()).getString("params");
        TextView name = view.findViewById(R.id.name2);
        name.setText(Objects.requireNonNull(CustomerMap.customerMap.get(user)).getName() + " " + Objects.requireNonNull(CustomerMap.customerMap.get(user)).getSurname());

        final GraphView graph = view.findViewById(R.id.graph);

        graph.setVisibility(View.VISIBLE);
        try {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                    new DataPoint(0, 1),
                    new DataPoint(1, 1),
                    new DataPoint(2, 2),
                    new DataPoint(3, 3),
                    new DataPoint(4, 4)
            });
            graph.addSeries(series);
        } catch (IllegalArgumentException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}