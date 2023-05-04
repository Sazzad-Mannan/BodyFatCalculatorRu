package com.riftech.bodyfatcalculatorru;



import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String h_unit,w_unit,gender,wi_unit,n_unit,p_unit;
    double height,weight,bmi,waist,neck,hip,bfp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
        bar.setTitle(Html.fromHtml("<font color='#000000'>"+getString(R.string.app_name)+"</font>"));*/

        Button button=(Button)findViewById(R.id.button);
        ProgressBar pgsBar = (ProgressBar) findViewById(R.id.pBar);
        Spinner dropdown = findViewById(R.id.spinner);
        Spinner dropdown1 = findViewById(R.id.spinner3);
        Spinner dropdown2 = findViewById(R.id.spinner4);
        Spinner dropdown3 = findViewById(R.id.spinner6);
        Spinner dropdown4 = findViewById(R.id.spinner7);
        Spinner dropdown5 = findViewById(R.id.spinner8);
        EditText editText1 = (EditText)findViewById(R.id.editTextNumberDecimal3);
        EditText editText2 = (EditText)findViewById(R.id.editTextNumberDecimal5);
        EditText editText3 = (EditText)findViewById(R.id.editTextNumberDecimal6);
        EditText editText4 = (EditText)findViewById(R.id.editTextNumberDecimal8);
        EditText editText5 = (EditText)findViewById(R.id.editTextNumberDecimal10);
        TextView txt1=(TextView)findViewById(R.id.textView10);
        TextView txt2=(TextView)findViewById(R.id.textView2);
        TextView txt3=(TextView)findViewById(R.id.textView8);
        TextView txt4=(TextView)findViewById(R.id.textView4);
        TextView txt5=(TextView)findViewById(R.id.textView5);
        TextView txt6=(TextView)findViewById(R.id.textView9);
        TextView txt7=(TextView)findViewById(R.id.textView7);
        //dropdown.setPopupBackgroundResource(R.drawable.spinner);
        //ConstraintLayout main=(ConstraintLayout) findViewById(R.id.main);
        //RelativeLayout rl=(RelativeLayout)findViewById(R.id.progressLayout);


        txt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                pgsBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {



                        pgsBar.setVisibility(View.GONE);
                        startActivity(intent);

                        //main.setVisibility(View.VISIBLE);
                    }
                }, 5000);

            }
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {




                // click handling code
                h_unit = dropdown.getSelectedItem().toString();
                w_unit = dropdown1.getSelectedItem().toString();
                wi_unit = dropdown2.getSelectedItem().toString();
                n_unit = dropdown3.getSelectedItem().toString();
                p_unit = dropdown5.getSelectedItem().toString();
                gender = dropdown4.getSelectedItem().toString();
                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")|| editText3.getText().toString().equals("")|| editText4.getText().toString().equals("")|| editText5.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.toast), Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    pgsBar.setVisibility(View.VISIBLE);
                    weight = Float.parseFloat(editText2.getText().toString());
                    height = Float.parseFloat(editText1.getText().toString());
                    waist = Float.parseFloat(editText3.getText().toString());
                    neck = Float.parseFloat(editText4.getText().toString());
                    hip = Float.parseFloat(editText5.getText().toString());
                    if (Objects.equals(h_unit, getString(R.string.ft))) {
                        height = height * 30.48;
                    }

                    if (Objects.equals(w_unit, getString(R.string.lbs))) {
                        weight = weight * 0.45359237;
                    }
                    if (Objects.equals(wi_unit, getString(R.string.in))) {
                        waist = waist * 2.54;
                    }
                    if (Objects.equals(n_unit, getString(R.string.in))) {
                        neck = neck * 2.54;
                    }
                    if (Objects.equals(p_unit, getString(R.string.in))) {
                        hip = hip * 2.54;
                    }
                    if(Objects.equals(gender, getString(R.string.male))){
                        bfp=(495/(1.0324-(0.19077*Math.log10(waist-neck))+(0.15456*Math.log10(height))))-450;
                    }else{
                        bfp=(495/(1.29579-(0.35004*Math.log10(waist+hip-neck))+(0.22100*Math.log10(height))))-450;
                    }

                    bfp = Math.round(bfp * 10.0) / 10.0;

                    /*Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(bfp), Toast.LENGTH_SHORT);
                    toast.show();*/
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("bfp", bfp);
                    intent.putExtra("gender", gender);

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {



                            pgsBar.setVisibility(View.GONE);
                            startActivity(intent);

                            //main.setVisibility(View.VISIBLE);
                        }
                    }, 5000);

                }
            }
        });

        //get the spinner from the xml.

//create a list of items for the spinner.
        String[] items = new String[]{getString(R.string.ft), getString(R.string.cm)};
        String[] items1 = new String[]{getString(R.string.kg), getString(R.string.lbs)};
        String[] items2 = new String[]{getString(R.string.male),getString(R.string.female)};
        String[] items3 = new String[]{getString(R.string.in), getString(R.string.cm)};

//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown1.setAdapter(adapter1);
        dropdown2.setAdapter(adapter4);
        dropdown3.setAdapter(adapter3);
        dropdown4.setAdapter(adapter2);
        dropdown5.setAdapter(adapter5);
    }
}