package com.example.team13_nutrition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReportWeightActivity extends AppCompatActivity {
private Button report=findViewById(R.id.report);
private EditText weight=findViewById(R.id.weight);
private ReportWeightPresenter presenter=new ReportWeightPresenter(this);
public EditText getEditText(){
    return weight;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_weight);
         report.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 presenter.setWeight();
             }
         });
    }
}
