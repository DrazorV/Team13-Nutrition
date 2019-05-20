//package com.example.team13_nutrition.old;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.EditText;
//import android.widget.ImageView;
//
//import com.example.team13_nutrition.Customer;
//import com.example.team13_nutrition.MakeMap;
//import com.example.team13_nutrition.R;
//
//public class SignUpSecondActivity extends AppCompatActivity {
//    ImageView next;
//    ImageView back;
//    EditText weight;
//    EditText height;
//    EditText age;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up_second);
//
//        String username = getIntent().getStringExtra("username");
//        String password = getIntent().getStringExtra("password");
//
//        back = findViewById(R.id.back);
//        next = findViewById(R.id.next);
//        back.setOnClickListener(v -> {
//            Intent it = new Intent(SignUpSecondActivity.this, LoginActivityOld.class);
//            startActivity(it);
//        });
//
//        next.setOnClickListener(v -> {
//            weight.findViewById(R.id.enter_weight);
//            height.findViewById(R.id.enter_height);
//            age.findViewById(R.id.enter_age);
//            try {
//                Customer temp = new Customer(username, password, null, null, null, 0, 0, 0, null, null, 0);
//                MakeMap.customerMap.put(username,temp);
//            } catch (Exception ignored) {
//
//            }
//            Intent it = new Intent(SignUpSecondActivity.this, LoginActivityOld.class);
//            startActivity(it);
//        });
//    }
//}
