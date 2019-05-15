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
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    TextView signUp;
    ImageView login;
    EditText username;
    EditText password;

    Customer c1 = new Customer("DrazorV","4522","Vagelis","Panos","male",21,1.88,86,"Maintain_Weight","Normal",84);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CustomerMap.customerMap.put(c1.getUsername(),c1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signUp = findViewById(R.id.sign_up);
        login = findViewById(R.id.login);
        login.setOnClickListener(v -> {
            hideKeyboard(this);
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            if(CustomerMap.customerMap.keySet().contains(username.getText().toString())){
                if(Objects.requireNonNull(CustomerMap.customerMap.get(username.getText().toString())).getPassword().equals(password.getText().toString())){
                    Intent it = new Intent(LoginActivity.this, LoginActivity.class);
                    startActivity(it);
                }else Toast.makeText(getApplicationContext(), "Wrong Password!", Toast.LENGTH_SHORT).show();
            }else Toast.makeText(getApplicationContext(), "This Username doesn't exist please sign up below!", Toast.LENGTH_SHORT).show();
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
    public LoginActivity() throws Exception {

    }

}
