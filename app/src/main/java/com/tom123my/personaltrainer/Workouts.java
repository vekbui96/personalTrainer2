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
import java.util.Calendar;



public class Workouts extends AppCompatActivity {

    private Button startButton;
    private TextView workoutOfDayLabel;
    public static int workoutInt = 1;
    private Calendar calendar = Calendar.getInstance();
    private Button workoutChangeButton;

    int day = calendar.get(Calendar.DAY_OF_WEEK);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);


        //Setup Buttons
        startButton = (Button) findViewById(R.id.startButton);

        workoutChangeButton = (Button) findViewById(R.id.workoutChange);
        workoutOfDayLabel = (TextView) findViewById(R.id.workoutOfDay);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreen();
            }
        });

        workoutChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (workoutInt == 4){
                    workoutInt = 1;
                } else {
                    workoutInt = workoutInt + 1;
                }
                refresh();
            }
        });
    }

    public void openStartScreen(){
        Intent intentNutrition = new Intent(this, workoutStartObject.class);
        startActivityForResult(intentNutrition, 4);
    }

    public void refresh(){
        if (workoutInt == 1){
            workoutOfDayLabel.setText("Chest");
        } else if (workoutInt == 2){
            workoutOfDayLabel.setText("Back");
        } else if (workoutInt == 3){
            workoutOfDayLabel.setText("Leg");
        } else if (workoutInt == 4){
            workoutOfDayLabel.setText("Rest");
        }
    }
}
