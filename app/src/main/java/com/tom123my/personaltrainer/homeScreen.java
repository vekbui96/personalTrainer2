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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        progressButton = (Button) findViewById(R.id.progressButton);

        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProgressScreen();
            }
        });
    }

    public void openProgressScreen(){
        Intent intentProgress = new Intent(this, progressMainscreen.class);
        startActivityForResult(intentProgress, 1);
    }
}
