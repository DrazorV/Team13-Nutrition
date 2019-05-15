package com.example.team13_nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    ImageView next;
    ImageView back;
    EditText username;
    EditText password;
    EditText rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        back = findViewById(R.id.back);
        next = findViewById(R.id.next);


        back.setOnClickListener(v -> {
            Intent it = new Intent(SignUpActivity.this,LoginActivity.class);
            startActivity(it);
        });

        next.setOnClickListener(v -> {
            username = findViewById(R.id.enter_username);
            password = findViewById(R.id.enter_password);
            rePassword = findViewById(R.id.reenter_password);
            if(username.getText().length() < 4) Toast.makeText(getApplicationContext(), "Username too small!", Toast.LENGTH_SHORT).show();
            else if(Customer.checkPassword) Toast.makeText(getApplicationContext(), "Username too small!", Toast.LENGTH_SHORT).show();
            else if(!password.getText().toString().equals(rePassword.getText().toString())) Toast.makeText(getApplicationContext(), "Passwords don't match!", Toast.LENGTH_SHORT).show();
            else {
                try {
                    Customer temp = new Customer(username.getText().toString(), password.getText().toString(), null, null, null, 0, 0, 0, null, null, 0);
                    CustomerMap.customerMap.put(username.getText().toString(), temp);
                } catch (Exception ignored) {
                }
                Intent it = new Intent(SignUpActivity.this, SignUpSecondActivity.class);
                startActivity(it);
            }
        });
    }
}
