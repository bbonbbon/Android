package com.example.checkbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class activity_radio extends AppCompatActivity {

    Button button;
    RadioGroup radioGroup;
    RadioButton rdored, rdoblue, rdowhite;

    LinearLayout rbolayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        setTitle("202195031 이명진");

        rbolayout = findViewById(R.id.rbolayout);

        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.rgroup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        /*radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdored:
                        rbolayout.setBackgroundColor(Color.RED);
                        break;

                    case R.id.rboblue:
                        rbolayout.setBackgroundColor(Color.BLUE);
                        break;

                    case R.id.rbowhite:
                        rbolayout.setBackgroundColor(Color.WHITE);
                        break;
                }
            }
        });*/
    }
    public void Onclicked(View view){
        switch (view.getId()) {
            case R.id.rdored:
                rbolayout.setBackgroundColor(Color.RED);
                break;

            case R.id.rboblue:
                rbolayout.setBackgroundColor(Color.BLUE);
                break;

            case R.id.rbowhite:
                rbolayout.setBackgroundColor(Color.WHITE);
                break;
        }
    }
}