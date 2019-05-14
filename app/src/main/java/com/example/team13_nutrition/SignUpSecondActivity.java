package com.example.team13_nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SignUpSecondActivity extends AppCompatActivity {
    ImageView next;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_second);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        back.setOnClickListener(v -> {
            Intent it= new Intent(SignUpSecondActivity.this,LoginActivity.class);
            startActivity(it);
        });

        next.setOnClickListener(v -> {
            Intent it= new Intent(SignUpSecondActivity.this,LoginActivity.class);
            startActivity(it);
        });
    }
}
