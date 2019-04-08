package com.tom123my.personaltrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class nutritionMain extends AppCompatActivity {

    private TextView userCalories;
    private TextView userFats;
    private TextView userProtein;
    private TextView userCarbs;
    private EditText currentWeight;
    private Button updateMacros;
    public static int calIntake = 0;
    public static int proteinIntake = 0;
    public static int carbsIntake = 0;
    public static int fatIntake = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_main);

        //Setup
        //nutritionButton = (Button) findViewById(R.id.nutritionButton);
        currentWeight = (EditText) findViewById(R.id.currentWeightValue);
        updateMacros = (Button) findViewById(R.id.updateMacros);
        userCalories = (TextView) findViewById(R.id.userCal);
        userFats = (TextView) findViewById(R.id.userFat);
        userProtein = (TextView) findViewById(R.id.userProtein);
        userCarbs = (TextView) findViewById(R.id.userCarbs);


        updateMacros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateMacronutritions();
            }
        });
    }

    public void updateMacronutritions(){
        String value = currentWeight.getText().toString();
        int currentWeightValue = Integer.parseInt(value);
        calIntake = (int) ((66.5 + (13.8 * currentWeightValue) + 5 * 177.8 - (6.8*20)) * 0.65);
        fatIntake = (int)((0.30 * calIntake)/9);
        proteinIntake = (int) ((0.30 * calIntake)/4);
        carbsIntake = (int)((0.40 * calIntake)/4);
        userCalories.setText(Integer.toString(calIntake));
        userFats.setText(Integer.toString(fatIntake));
        userProtein.setText(Integer.toString(proteinIntake));
        userCarbs.setText(Integer.toString(carbsIntake));
    }
}
