package com.example.team13_nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUpSecondActivity extends AppCompatActivity {
    ImageView next;
    ImageView back;
    EditText weight;
    EditText height;
    EditText age;

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
            weight.findViewById(R.id.enter_weight);
            height.findViewById(R.id.enter_height);
            age.findViewById(R.id.enter_age);
            Intent it= new Intent(SignUpSecondActivity.this,LoginActivity.class);
            startActivity(it);
        });
    }
}
