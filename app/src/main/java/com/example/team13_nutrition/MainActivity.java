package com.example.team13_nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.team13_nutrition.data.model.LoggedInUser;
import com.example.team13_nutrition.ui.login.LoginActivity;
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
        String user = LoggedInUser.getUserId();
        CustomViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        Tab1 t1 = new Tab1();
        Tab2 t2 = new Tab2();

        adapter.addFragment(t1, "Summary");
        adapter.addFragment(t2, "Profile");

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        BoomMenuButton bmb = findViewById(R.id.bmb);

        HamButton.Builder builder = new HamButton.Builder().listener(index -> {
            Intent it = new Intent(MainActivity.this, AddFoodActivity.class);
            it.putExtra("params", user);
            startActivity(it);
        }).normalText("Add consumed foods").normalImageRes(R.drawable.peach);
        bmb.addBuilder(builder);

        HamButton.Builder builder2 = new HamButton.Builder().listener(index -> {
            Intent it = new Intent(MainActivity.this, AddExercisesActivity.class);
            it.putExtra("params", user);
            startActivity(it);
        }).normalText("Add done exercises").normalImageRes(R.drawable.peach);
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

    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        }
        else {
            Toast.makeText(getBaseContext(), "Tap back button in order to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }
}