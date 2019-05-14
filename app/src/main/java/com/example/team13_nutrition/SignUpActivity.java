package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        //back = findViewById(R.id.back);

//        back.setOnClickListener(v -> {
//            Intent it= new Intent(SignUpActivity.this,LoginActivity.class);
//            startActivity(it);
//        });
    }
}
