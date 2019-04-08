package com.tom123my.personaltrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.tom123my.personaltrainer.Workouts.workoutInt;

public class workoutStartObject extends AppCompatActivity {

    private int[][] chest = {{0,10},{0,20},{30,50}};
    private int[][] back = {{0,0},{0,0},{0,0}};
    private int[][] legs = {{0,0},{0,0},{0,0}};
    private int i = 0;
    private TextView currentWorkout;
    private TextView lastLiftLabel;
    private TextView maxLiftLabel;
    private EditText updateWeights;
    private Button testButton;
    private Button skipWorkoutButton;
    private String workout1 = "Workout1";
    private String workout2 = "Workout2";
    private String workout3 = "Workout3";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_start_object);
        currentWorkout = (TextView) findViewById(R.id.currentWorkout);
        lastLiftLabel = (TextView) findViewById(R.id.lastLift);
        maxLiftLabel = (TextView) findViewById(R.id.maxLift);
        updateWeights = (EditText) findViewById(R.id.updateWorkout);

        testButton = (Button) findViewById(R.id.testButton);
        skipWorkoutButton = (Button) findViewById(R.id.skipWorkout);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        skipWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextWorkout();
            }
        });

        switch (workoutInt) {
            case 1:
                workout1 = "Bench";
                workout2 = "Dumbells";
                workout3 = "Incline Bench";
                break;
            case 2:
                workout1 = "Latpulldown";
                workout2 = "Rows";
                workout3 = "Deadlift";
                break;
            case 3:
                workout1 = "Squat";
                workout2 = "Hamstrings";
                workout3 = "Quads";
                break;
            case 4:
                break;
        }

        if(i == 0) {
            currentWorkout.setText(workout1);
            lastLiftLabel.setText(Integer.toString(chest[i][1]));
            maxLiftLabel.setText(Integer.toString(chest[i][0]));
        }
    }
    public void updateData(){
        String value = updateWeights.getText().toString();
        int newValue = Integer.parseInt(value);
        if (workoutInt == 1) {
            chest[i][1] = newValue;
            if (chest[i][0] < newValue) {
                chest[i][0] = newValue;
            }
            refreshScreen();
        } else if (workoutInt == 2){
            back[i][1] = newValue;
            if (back[i][0] < newValue) {
                back[i][0] = newValue;
            }
            refreshScreen();
        } else if ( workoutInt == 3){
            legs[i][1] = newValue;
            if (legs[i][0] < newValue) {
                legs[i][0] = newValue;
            }
        }
    }

    public void currentWorkout(){
        if (workoutInt == 1) {
            if (i == 0) {
                currentWorkout.setText("Bench");
            } else if (i == 1) {
                currentWorkout.setText("Dumbbells");
            } else if (i == 2) {
                currentWorkout.setText("Incline Bench");
            }
        } else if (workoutInt == 2){
            if (i == 0) {
                currentWorkout.setText("Latpulldown");
            } else if (i == 1) {
                currentWorkout.setText("Rows");
            } else if (i == 2) {
                currentWorkout.setText("Deadlift");
            }
        }  else if (workoutInt == 3){
            if (i == 0) {
                currentWorkout.setText("Squat");
            } else if (i == 1) {
                currentWorkout.setText("Hamstrings");
            } else if (i == 2) {
                currentWorkout.setText("Quads");
            }
        }
    }

    public void nextWorkout(){
        if ( i == 2){
            i = 0;
        } else {
            i = i+1;
        }
        refreshScreen();
    }

    public void refreshScreen(){
        currentWorkout();
        lastLiftLabel.setText(Integer.toString(chest[i][1]));
        maxLiftLabel.setText(Integer.toString(chest[i][0]));
    }

}
