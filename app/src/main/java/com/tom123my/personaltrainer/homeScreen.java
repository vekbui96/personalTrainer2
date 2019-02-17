package com.tom123my.personaltrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class homeScreen extends AppCompatActivity {

    private Button progressButton;
    private Button workoutButton;
    private Button nutritionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Setup Buttons
        nutritionButton = (Button) findViewById(R.id.nutritionButton);
        workoutButton = (Button) findViewById(R.id.workoutButton);
        progressButton = (Button) findViewById(R.id.progressButton);

        nutritionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNutritionScreen();
            }
        });

        workoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkoutScreen();
            }
        });
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProgressScreen();
            }
        });
    }

    public void openNutritionScreen(){
        Intent intentNutrition = new Intent(this, nutritionMain.class);
        startActivityForResult(intentNutrition, 3);
    }

    public void openWorkoutScreen(){
        Intent intentWorkout = new Intent(this, Workouts.class);
        startActivityForResult(intentWorkout, 2);
    }

    public void openProgressScreen(){
        Intent intentProgress = new Intent(this, progressMainscreen.class);
        startActivityForResult(intentProgress, 1);
    }
}
