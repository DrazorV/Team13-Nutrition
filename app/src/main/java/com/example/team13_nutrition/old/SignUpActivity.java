//package com.example.team13_nutrition.old;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Toast;
//
//import com.example.team13_nutrition.R;
//
//public class SignUpActivity extends AppCompatActivity {
//    ImageView next;
//    ImageView back;
//    EditText username;
//    EditText password;
//    EditText rePassword;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//        back = findViewById(R.id.back);
//        next = findViewById(R.id.next);
//
//
//        back.setOnClickListener(v -> {
//            Intent it = new Intent(SignUpActivity.this, LoginActivityOld.class);
//            startActivity(it);
//        });
//
//        next.setOnClickListener(v -> {
//            username = findViewById(R.id.enter_username);
//            password = findViewById(R.id.enter_password);
//            rePassword = findViewById(R.id.reenter_password);
//            if(username.getText().length() < 4) Toast.makeText(getApplicationContext(), "Username too small!", Toast.LENGTH_SHORT).show();
//            else if(password.getText().length() < 3) Toast.makeText(getApplicationContext(), "Username too small!", Toast.LENGTH_SHORT).show();
//            else if(!password.getText().toString().equals(rePassword.getText().toString())) Toast.makeText(getApplicationContext(), "Passwords don't match!", Toast.LENGTH_SHORT).show();
//            else {
//                Intent it = new Intent(SignUpActivity.this, SignUpSecondActivity.class);
//                it.putExtra("username",username.getText().toString());
//                it.putExtra("password",password.getText().toString());
//                startActivity(it);
//            }
//        });
//    }
//}
