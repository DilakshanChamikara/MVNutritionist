package com.android.myvirtualnutritionist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    private Button btnGo;
    private EditText age, height, weight;
    Double BMI = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        age = (EditText) findViewById(R.id.editTextAgeFirst);
        height = (EditText) findViewById(R.id.editTextHeightFirst);
        weight = (EditText) findViewById(R.id.editTextWeightFirst);

        btnGo = (Button) findViewById(R.id.goButton);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (age.getText().toString().length() == 0)
                    age.setError("Age is required!");
                else if (height.getText().toString().length() == 0)
                    height.setError("Height is required!");
                else if (weight.getText().toString().length() == 0)
                    weight.setError("Weight is required!");
                else {
                    Intent i = new Intent(FirstActivity.this, MainActivity.class);
                    startActivity(i);
                    calcBMI();
                }

            }
        });

    }

    public void calcBMI(){
        double heightCM, heightM, weightKG, result;
        heightCM = Double.parseDouble(height.getText().toString());
        weightKG = Double.parseDouble(weight.getText().toString());

        heightM = heightCM / 100;
        result = (weightKG / ((heightM) * (heightM)));
        Toast.makeText(getApplication().getApplicationContext(), "BMI is " + String.format("%.2f", result), Toast.LENGTH_LONG).show();
    }


}