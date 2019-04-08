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

import static com.tom123my.personaltrainer.nutritionMain.calIntake;
import static com.tom123my.personaltrainer.nutritionMain.carbsIntake;
import static com.tom123my.personaltrainer.nutritionMain.fatIntake;
import static com.tom123my.personaltrainer.nutritionMain.proteinIntake;

public class homeScreen extends AppCompatActivity {

    private Button progressButton;
    private Button workoutButton;
    private Button nutritionButton;
    private Button refreshButton;
    private Button addButton;
    private TextView caloriesLabel;
    private TextView fatsLabel;
    private TextView proteinLabel;
    private TextView carbsLabel;
    private TextView workoutOfDay;
    private EditText caloriesEdit;
    private EditText fatsEdit;
    private EditText carbsEdit;
    private EditText proteinEdit;
    private Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Setup Buttons
        nutritionButton = (Button) findViewById(R.id.nutritionButton);
        workoutButton = (Button) findViewById(R.id.workoutButton);
        progressButton = (Button) findViewById(R.id.progressButton);
        refreshButton = (Button) findViewById(R.id.refreshButton);
        addButton = (Button) findViewById(R.id.add);
        caloriesLabel = (TextView) findViewById(R.id.calLabel);
        fatsLabel = (TextView) findViewById(R.id.fatsLabel);
        proteinLabel = (TextView) findViewById(R.id.proteinLabel);
        carbsLabel = (TextView) findViewById(R.id.carbsLabel);
        workoutOfDay = (TextView) findViewById(R.id.whatWorkout);
        caloriesEdit = (EditText) findViewById(R.id.caloriesEdited);
        proteinEdit = (EditText) findViewById(R.id.proteinEdited);
        fatsEdit = (EditText) findViewById(R.id.fatsEdited);
        carbsEdit = (EditText) findViewById(R.id.carbsEdited);

        caloriesLabel.setText(Double.toString(calIntake));
        fatsLabel.setText(Double.toString(fatIntake));
        proteinLabel.setText(Double.toString(proteinIntake));
        carbsLabel.setText(Double.toString(carbsIntake));

        switch (day) {
            case Calendar.MONDAY:
                workoutOfDay.setText("Monday is Chest Day");
                break;
            case Calendar.TUESDAY:
                workoutOfDay.setText("Tuesday is Back Day");
                break;
            case Calendar.WEDNESDAY:
                workoutOfDay.setText("Wednesday is Leg day");
                break;
            case Calendar.THURSDAY:
                workoutOfDay.setText("Thursday ");
                break;
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCalories();
            }
        });

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshScreen();
            }
        });

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

    public void addCalories(){
        calIntake = calIntake - (Integer.parseInt(caloriesEdit.getText().toString()));
        fatIntake = fatIntake - (Integer.parseInt(fatsEdit.getText().toString()));
        carbsIntake = carbsIntake - (Integer.parseInt(carbsEdit.getText().toString()));
        proteinIntake = proteinIntake - (Integer.parseInt(proteinEdit.getText().toString()));
        refreshScreen();

    }

    public void refreshScreen(){
        caloriesLabel.setText(Double.toString(calIntake));
        fatsLabel.setText(Double.toString(fatIntake));
        proteinLabel.setText(Double.toString(proteinIntake));
        carbsLabel.setText(Double.toString(carbsIntake));
    }

    public void openNutritionScreen(){
        Intent intentNutrition = new Intent(this, nutritionMain.class);
        startActivityForResult(intentNutrition, 3);
        caloriesLabel.setText(Double.toString(calIntake));
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
