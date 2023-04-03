package com.example.pro4_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Text1,Text2;

    Switch switch1;
    RadioGroup RdoGroup;
    RadioButton rdoBtn1,rdoBtn2,rdoBtn3;

    Button Btn1,Btn2;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("202195031 이명진");

        Text1 = (TextView) findViewById(R.id.Text1);
        switch1 = (Switch) findViewById(R.id.switch1);

        Text2 = (TextView) findViewById(R.id.Text2);
        RdoGroup = (RadioGroup) findViewById(R.id.RdoGroup);
        rdoBtn1 = (RadioButton) findViewById(R.id.rdoBtn1);
        rdoBtn2 = (RadioButton) findViewById(R.id.rdoBtn2);
        rdoBtn3 = (RadioButton) findViewById(R.id.rdoBtn3);

        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn2 = (Button) findViewById(R.id.Btn2);

        image = (ImageView) findViewById(R.id.imageView4);

        image.setImageResource(0);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switch1.isChecked() == true) {
                    Text2.setVisibility(View.VISIBLE);
                    RdoGroup.setVisibility(View.VISIBLE);
                    Btn1.setVisibility(View.VISIBLE);
                    Btn2.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                }else {
                    Text2.setVisibility(View.INVISIBLE);
                    RdoGroup.setVisibility(View.INVISIBLE);
                    Btn1.setVisibility(View.INVISIBLE);
                    Btn2.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                }
            }
        });
        RdoGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdoBtn1:
                        image.setImageResource(R.drawable.dog);
                        break;

                    case R.id.rdoBtn2:
                        image.setImageResource(R.drawable.cat);
                        break;

                    case R.id.rdoBtn3:
                        image.setImageResource(R.drawable.rabbit);
                        break;
                }
            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch1.setChecked(false);
                rdoBtn1.setChecked(false);
                rdoBtn2.setChecked(false);
                rdoBtn3.setChecked(false);
                image.setImageResource(0);
            }
        });
    }
}