package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.team13_nutrition.ui.main.SectionsPagerAdapter;
import com.example.team13_nutrition.ui.main.Tab1;
import com.example.team13_nutrition.ui.main.Tab2;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1(), "Summary");
        adapter.addFragment(new Tab2(), "Profile");


        viewPager.setAdapter(adapter);
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
    }
}