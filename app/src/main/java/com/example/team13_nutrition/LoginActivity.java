package com.example.team13_nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView signUp;
    ImageView login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUp = findViewById(R.id.sign_up);
        login = findViewById(R.id.login);

        login.setOnClickListener(v -> {
            Intent it = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(it);

        });

        signUp.setOnClickListener(v -> {
            Intent it = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(it);
        });
    }
}
