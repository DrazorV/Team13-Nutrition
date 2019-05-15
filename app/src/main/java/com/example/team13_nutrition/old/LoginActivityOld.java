//package com.example.team13_nutrition.old;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.team13_nutrition.CustomerMap;
//import com.example.team13_nutrition.MainActivity;
//import com.example.team13_nutrition.R;
//
//import java.util.Objects;
//
//public class LoginActivityOld extends AppCompatActivity {
//    TextView signUp;
//    ImageView login;
//    EditText username;
//    EditText password;
//
//    //Customer c1 = new Customer("DrazorV","4522","Vagelis","Panos","male",21,1.88,86,"Maintain_Weight","Normal",84);
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_loginold);
//        signUp = findViewById(R.id.sign_up);
//        login = findViewById(R.id.login);
//        login.setOnClickListener(v -> {
//            username = findViewById(R.id.username);
//            password = findViewById(R.id.password);
//            if(CustomerMap.customerMap.keySet().contains(username.getText().toString())){
//                if(Objects.requireNonNull(CustomerMap.customerMap.get(username.getText().toString())).getPassword().equals(password.getText().toString())){
//                    Intent it = new Intent(LoginActivityOld.this, MainActivity.class);
//                    startActivity(it);
//                }else Toast.makeText(getApplicationContext(), "Wrong Password!", Toast.LENGTH_SHORT).show();
//            }else Toast.makeText(getApplicationContext(), "This Username doesn't exist please sign up below!", Toast.LENGTH_SHORT).show();
//        });
//
//        signUp.setOnClickListener(v -> {
//            Intent it = new Intent(LoginActivityOld.this, SignUpActivity.class);
//            startActivity(it);
//        });
//    }
//
//    public LoginActivityOld() throws Exception {
//
//    }
//
//}