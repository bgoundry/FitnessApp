package com.example.fitnessapp;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toBodyfat(View view){
        Intent intent = new Intent(MainActivity.this, BodyfatCalc.class);
        startActivity(intent);
    }

    public void toMacro(View view){
        Intent intent = new Intent(MainActivity.this, MacroTracker.class);
        startActivity(intent);
    }
}