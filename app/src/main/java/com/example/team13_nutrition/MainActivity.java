package com.example.team13_nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.team13_nutrition.ui.main.CustomViewPager;
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
        String user = getIntent().getStringExtra("user");
        CustomViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("params", user);
        Tab1 t1 = new Tab1();
        Tab2 t2 = new Tab2();
        t1.setArguments(bundle);
        t2.setArguments(bundle);

        adapter.addFragment(t1, "Summary");
        adapter.addFragment(t2, "Profile");

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        BoomMenuButton bmb = findViewById(R.id.bmb);

        HamButton.Builder builder = new HamButton.Builder().listener(index -> {
            Intent it = new Intent(MainActivity.this, AddFoodActivity.class);
            startActivity(it);
        })
                .normalText("Add consumed foods.")
                .normalImageRes(R.drawable.peach);
        bmb.addBuilder(builder);

        HamButton.Builder builder2 = new HamButton.Builder().listener(index -> {
            Intent it = new Intent(MainActivity.this, AddExercisesActivity.class);
            startActivity(it);
        })
                .normalText("Add done exercises.")
                .normalImageRes(R.drawable.peach);
        bmb.addBuilder(builder2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings){
            Toast.makeText(this, "Action Item", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}