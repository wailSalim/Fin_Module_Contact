package com.wail.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calcul extends AppCompatActivity {
    public  int r1;
    public  int r2;
    public   TextView zero1,zero2;
    public   Button plusA1,plusB1,plusA2,plusB2,plusA3,plusB3,resA,resB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul2);
        zero1=findViewById(R.id.textView8);
        zero2=findViewById(R.id.textView7);
        plusA1=findViewById(R.id.buttonA1);
        plusA2=findViewById(R.id.button3A2);
        plusA3=findViewById(R.id.button5A3);
        plusB1 =findViewById(R.id.button2B1);
        plusB2=findViewById(R.id.button4B2);
        plusB3=findViewById(R.id.button6B3);
        resA=findViewById(R.id.button8AR);
        resB=findViewById(R.id.button7BR);
        plusA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               r1++;
                zero1.setText(String.valueOf(r1));
            }
        });
        plusA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1+=2;
                zero1.setText(String.valueOf(r1));
            }
        });
        plusA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1+=3;
                zero1.setText(String.valueOf(r1));
            }
        });
        plusB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2++;
                zero2.setText(String.valueOf(r2));
            }
        });
        plusB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2+=2;
                zero2.setText(String.valueOf(r2));
            }
        });
        plusB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2+=3;
                zero2.setText(String.valueOf(r2));
            }
        });
resA.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        r1=0;
        zero1.setText(String.valueOf(r1));
    }
});
        resB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
r2=0;
                zero2.setText(String.valueOf(r2));
            }
        });


    }}