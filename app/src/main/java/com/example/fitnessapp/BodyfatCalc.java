package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BodyfatCalc extends AppCompatActivity {

    private EditText height, weight, waist, hip, neck;
    private Button calculate;
    private TextView bodyfatResult, fatMassResult, leanMassResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bodyfat_calc);


        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        waist = (EditText) findViewById(R.id.waist);
        hip = (EditText) findViewById(R.id.neck);
        neck = (EditText) findViewById(R.id.neck);
        calculate = (Button) findViewById(R.id.button3);
        bodyfatResult = (TextView) findViewById(R.id.intbodyfatResult);
        fatMassResult = (TextView) findViewById(R.id.intfatMassResult);
        leanMassResult = (TextView) findViewById(R.id.intleanMassResult);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String HEIGHT = height.getText().toString().trim();
                String WEIGHT = weight.getText().toString().trim();
                String WAIST = waist.getText().toString().trim();
                String HIP = hip.getText().toString().trim();
                String NECK = neck.getText().toString().trim();


                if (HEIGHT.isEmpty()) {
                    height.setError("");
                } else if (WEIGHT.isEmpty()){
                    weight.setError("");
                } else if (WAIST.isEmpty()){
                    waist.setError("");
                } else if (HIP.isEmpty()){
                    hip.setError("");
                } else if (NECK.isEmpty()) {
                    neck.setError("");
                }  else {

                    int numHeight = Integer.parseInt(HEIGHT);
                    int numWeight = Integer.parseInt(WEIGHT);
                    int numWaist = Integer.parseInt(WAIST);
                    int numHip = Integer.parseInt(HIP);
                    int numNeck = Integer.parseInt(NECK);

                    int percent = (int) (86.01 * Math.log10(numWaist - numNeck) - 70.041 *
                                                Math.log10(numHeight) + 36.16);
                    int fatMass = percent * numWeight / 100;
                    int leanMass = numWeight - fatMass;

                    bodyfatResult.setText("" + percent);
                    fatMassResult.setText("" + fatMass);
                    leanMassResult.setText("" + leanMass);

                }
            }
        });
    }

}