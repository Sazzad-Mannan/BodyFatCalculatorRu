package com.riftech.bodyfatcalculatorru;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String h_unit,w_unit,gender,wi_unit,n_unit,p_unit;
    double height,weight,bmi,waist,neck,hip,bfp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button)findViewById(R.id.button);
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
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your height, weight,waist, neck and hip measurements.", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    weight = Float.parseFloat(editText2.getText().toString());
                    height = Float.parseFloat(editText1.getText().toString());
                    waist = Float.parseFloat(editText3.getText().toString());
                    neck = Float.parseFloat(editText4.getText().toString());
                    hip = Float.parseFloat(editText5.getText().toString());
                    if (Objects.equals(h_unit, "футов")) {
                        height = height * 30.48;
                    }

                    if (Objects.equals(w_unit, "фунтов")) {
                        weight = weight * 0.45359237;
                    }
                    if (Objects.equals(wi_unit, "дюймов")) {
                        waist = waist * 2.54;
                    }
                    if (Objects.equals(n_unit, "дюймов")) {
                        neck = neck * 2.54;
                    }
                    if (Objects.equals(p_unit, "дюймов")) {
                        hip = hip * 2.54;
                    }
                    if(Objects.equals(gender, "Мужчина")){
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
                    startActivity(intent);
                }
            }
        });

        //get the spinner from the xml.

//create a list of items for the spinner.
        String[] items = new String[]{"футов", "см"};
        String[] items1 = new String[]{"кг", "фунтов"};
        String[] items2 = new String[]{"Женский", "Мужчина"};
        String[] items3 = new String[]{"дюймов", "см"};

//create an adapter to describe how the items are displayed, adapters are used дюймов several places дюймов android.
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