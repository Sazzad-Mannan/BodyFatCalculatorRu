package com.riftech.bodyfatcalculatorru;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
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
        TextView txt3=(TextView)findViewById(R.id.textView13);
        TextView txt4=(TextView)findViewById(R.id.textView25);
        TextView txt5=(TextView)findViewById(R.id.textView24);
        TextView txt6=(TextView)findViewById(R.id.textView23);
        TextView txt7=(TextView)findViewById(R.id.textView22);
        TextView txt8=(TextView)findViewById(R.id.textView20);
        //ImageView img=(ImageView)findViewById(R.id.imageView);

        Intent intent = getIntent();
        double bfp = intent.getDoubleExtra("bfp",0.0);
        String gender = intent.getStringExtra("gender");
        if(Objects.equals(gender, getString(R.string.male))){


            // img.setImageResource(R.drawable.bfpm);
        }else{
            txt3.setText(getString(R.string.f));
            txt4.setText(getString(R.string.f1));
            txt5.setText(getString(R.string.f2));
            txt6.setText(getString(R.string.f3));
            txt7.setText(getString(R.string.f4));
            txt8.setText(getString(R.string.f5));

            // img.setImageResource(R.drawable.bfpf);
        }
        txt1.setText(String.valueOf(bfp)+"%");
        if(Objects.equals(gender, getString(R.string.female))){
            if(bfp<15){
                type=getString(R.string.l1);
                txt1.setTextColor(Color.parseColor("#FD6B22"));
            } else if (bfp<18) {
                type=getString(R.string.l2);
                txt1.setTextColor(Color.parseColor("#E0E1E3"));
            } else if (bfp<22) {
                type=getString(R.string.l3);
                txt1.setTextColor(Color.parseColor("#91BF77"));
            } else if (bfp<30) {
                type=getString(R.string.l4);
                txt1.setTextColor(Color.parseColor("#62C924"));
            }else if (bfp<40) {
                type=getString(R.string.l5);
                txt1.setTextColor(Color.parseColor("#FEAC2E"));
            }else {
                type=getString(R.string.l6);
                txt1.setTextColor(Color.parseColor("#FC1424"));
            }}
        if(Objects.equals(gender, getString(R.string.male))){
            if(bfp<5){
                type=getString(R.string.l1);
                txt1.setTextColor(Color.parseColor("#FD6B22"));
            } else if (bfp<8) {
                type=getString(R.string.l2);
                txt1.setTextColor(Color.parseColor("#E0E1E3"));
            } else if (bfp<12) {
                type=getString(R.string.l3);
                txt1.setTextColor(Color.parseColor("#91BF77"));
            } else if (bfp<20) {
                type=getString(R.string.l4);
                txt1.setTextColor(Color.parseColor("#62C924"));
            }else if (bfp<30) {
                type=getString(R.string.l5);
                txt1.setTextColor(Color.parseColor("#FEAC2E"));
            }else {
                type=getString(R.string.l6);
                txt1.setTextColor(Color.parseColor("#FC1424"));
            }}
        txt2.setText(type);
    }
}