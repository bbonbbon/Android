package com.example.checkbutton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox chkDog, chkCat;
    ImageView imageDog, imageCat;
    RadioButton blueBtn, redBtn;
    View layout;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("202195031 이명진");

        chkDog = (CheckBox) findViewById(R.id.chkDog);
        chkCat = (CheckBox) findViewById(R.id.chkCat);
        imageDog = (ImageView) findViewById(R.id.imageDog);
        imageCat = (ImageView) findViewById(R.id.imageCat);

        imageDog.setImageResource(0);
        imageCat.setImageResource(0);

        layout = findViewById(R.id.layout);

        next = (Button) findViewById(R.id.next);

        chkDog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkDog.isChecked() == true)
                    //imageDog.setVisibility(View.VISIBLE);
                    imageDog.setImageResource(R.drawable.dog);
                else
                    //imageDog.setVisibility(View.INVISIBLE);
                    imageDog.setImageResource(0);
            }
        });

        chkCat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkCat.isChecked() == true)
                    //imageDog.setVisibility(View.VISIBLE);
                    imageCat.setImageResource(R.drawable.cat);
                else
                    //imageDog.setVisibility(View.INVISIBLE);
                    imageCat.setImageResource(0);
            }
        });

        blueBtn = (RadioButton) findViewById(R.id.blueBtn);
        redBtn = (RadioButton) findViewById(R.id.redBtn);

        blueBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (blueBtn.isChecked() == true)
                    //imageDog.setVisibility(View.VISIBLE);
                    layout.setBackgroundColor(Color.BLUE);
            }
        });

        redBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (redBtn.isChecked() == true)
                    //imageDog.setVisibility(View.VISIBLE);
                    layout.setBackgroundColor(Color.RED);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),activity_radio.class);
                startActivity(intent);
            }
        });
    }
}