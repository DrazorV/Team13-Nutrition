package com.example.team13_nutrition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    TextView signUp;
    ImageView login;
    EditText username;
    EditText password;
    Map<String,Customer> customerMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUp = findViewById(R.id.sign_up);
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login.setOnClickListener(v -> {
            hideKeyboard(this);
            if(customerMap.keySet().contains(username.getText().toString())){
                if(customerMap.get(username.getText().toString()).getPassword().equals(password.getText().toString())){
                    Intent it = new Intent(LoginActivity.this, LoginActivity.class);
                    startActivity(it);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Password!", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "This Username doesn't exist please sign up below!", Toast.LENGTH_SHORT).show();
            }
        });

        signUp.setOnClickListener(v -> {
            hideKeyboard(this);
            Intent it = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(it);
        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
