package com.riftech.bodyfatcalculatorru;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView txt1=(TextView)findViewById(R.id.textView3);
        TextView txt2=(TextView)findViewById(R.id.textView6);
        ImageView img=(ImageView)findViewById(R.id.imageView);

        Intent intent = getIntent();
        double bfp = intent.getDoubleExtra("bfp",0.0);
        String gender = intent.getStringExtra("gender");
        if(Objects.equals(gender, "Male")){
            img.setImageResource(R.drawable.bfpm);
        }else{
            img.setImageResource(R.drawable.bfpf);
        }
        txt1.setText(String.valueOf(bfp)+"%");
        if(Objects.equals(gender, "Female")){
            if(bfp<15){
                type="Low Fat Risk";
                txt1.setTextColor(Color.parseColor("#FD6B22"));
            } else if (bfp<18) {
                type="Ultra Lean";
                txt1.setTextColor(Color.parseColor("#E0E1E3"));
            } else if (bfp<22) {
                type="Lean";
                txt1.setTextColor(Color.parseColor("#91BF77"));
            } else if (bfp<30) {
                type="Moderately Fat";
                txt1.setTextColor(Color.parseColor("#62C924"));
            }else if (bfp<40) {
                type="Excess Fat";
                txt1.setTextColor(Color.parseColor("#FEAC2E"));
            }else {
                type="High Body Fat Risk";
                txt1.setTextColor(Color.parseColor("#FC1424"));
            }}
        if(Objects.equals(gender, "Male")){
            if(bfp<5){
                type="Low Fat Risk";
                txt1.setTextColor(Color.parseColor("#FD6B22"));
            } else if (bfp<8) {
                type="Ultra Lean";
                txt1.setTextColor(Color.parseColor("#E0E1E3"));
            } else if (bfp<12) {
                type="Lean";
                txt1.setTextColor(Color.parseColor("#91BF77"));
            } else if (bfp<20) {
                type="Moderately Fat";
                txt1.setTextColor(Color.parseColor("#62C924"));
            }else if (bfp<30) {
                type="Excess Fat";
                txt1.setTextColor(Color.parseColor("#FEAC2E"));
            }else {
                type="High Body Fat Risk";
                txt1.setTextColor(Color.parseColor("#FC1424"));
            }}
        txt2.setText(type);
    }
}