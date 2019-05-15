package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.team13_nutrition.ui.main.SectionsPagerAdapter;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        BoomMenuButton bmb = findViewById(R.id.bmb);

        HamButton.Builder builder = new HamButton.Builder()
                .normalText("Add")
                .normalImageRes(R.drawable.peach);
        bmb.addBuilder(builder);

        HamButton.Builder builder2 = new HamButton.Builder()
                .normalText("Add2")
                .normalImageRes(R.drawable.peach);
        bmb.addBuilder(builder2);
        //FloatingActionButton fab = findViewById(R.id.fab);

        //fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show());
    }
}