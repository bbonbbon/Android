package com.example.project6_15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnstart,  btnstop;
        final ViewFlipper viewFlipper;

        btnstart = (Button) findViewById(R.id.btnstart);
        btnstop = (Button) findViewById(R.id.btnstop);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setFlipInterval(1000);
                viewFlipper.startFlipping();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.stopFlipping();
            }
        });
    }
}