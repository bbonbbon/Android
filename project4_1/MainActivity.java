package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button bntAdd, btnSub,btnMul,btnDiv,btnRem;
    TextView TextResult;
    String num1, num2;
    Double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        bntAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnRem = (Button) findViewById(R.id.btnRem);

        TextResult = (TextView) findViewById(R.id.TextResult);

        bntAdd.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnRem.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Double.parseDouble(num1) % Double.parseDouble(num2);
                TextResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });
    }
}