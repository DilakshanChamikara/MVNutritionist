package com.android.myvirtualnutritionist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    public static final String EXTRA_AGE = "com.android.myvirtualnutritionist.EXTRA_AGE";
    public static final String EXTRA_HEIGHT = "com.android.myvirtualnutritionist.EXTRA_HEIGHT";
    public static final String EXTRA_WEIGHT = "com.android.myvirtualnutritionist.EXTRA_WEIGHT";
    public static final String EXTRA_GENDER = "com.android.myvirtualnutritionist.EXTRA_GENDER";

    private Button btnGo;
    private EditText age, height, weight;

    private RadioGroup rg;
    private RadioButton male, female;
    int gender, ageValue;
    String genderMale, genderFemale;

    double heightCM, heightM, weightKG;
    double BMI = 0.0;
    int BMR = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        age = (EditText) findViewById(R.id.editTextAgeFirst);
        rg = (RadioGroup) findViewById(R.id.radioGroupGender);
        male = (RadioButton) findViewById(R.id.radioMaleFirst);
        female = (RadioButton) findViewById(R.id.radioFemaleFirst);
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
                    openMainActivity();
                }
            }
        });

        /**
         * start python
         * if (!Python.isStarted()){
         *             Python.start(new AndroidPlatform(this));
         *         }
         * **/

        /**
         * creating python instance
         * Python python = Python.getInstance();
         */

        /**
         * creating python object
         * PyObject pyObject = python.getModule("myScript");
         */

        /**
         * call the function
         * PyObject pyObj = pyObject.callAttr("main");
         */

    }

    /**
     * passing values to the main activity **/
    public void openMainActivity(){
        ageValue = Integer.parseInt(age.getText().toString());
        heightCM = Double.parseDouble(height.getText().toString());
        weightKG = Double.parseDouble(weight.getText().toString());
        genderMale = String.valueOf(male.getText());
        genderFemale = String.valueOf(female.getText());

        Intent intent = new Intent(FirstActivity.this, MainActivity.class);
        intent.putExtra(EXTRA_AGE, ageValue);
        intent.putExtra(EXTRA_HEIGHT, heightCM);
        intent.putExtra(EXTRA_WEIGHT, weightKG);

        if (male.isChecked()){
            intent.putExtra(EXTRA_GENDER, genderMale);
        }
        if (female.isChecked()){
            intent.putExtra(EXTRA_GENDER, genderFemale);
        }

        startActivity(intent);
    }

   /**
    * Body mass index **/
    public void calcBMI(){
        heightCM = Double.parseDouble(height.getText().toString());
        weightKG = Double.parseDouble(weight.getText().toString());

        heightM = heightCM / 100;
        BMI = (weightKG / ((heightM) * (heightM)));
        Toast.makeText(getApplication().getApplicationContext(), "BMI is " + String.format("%.2f", BMI), Toast.LENGTH_LONG).show();
    }

    /**
     * For male female **/
    public void genderIdentifier() {
        if (male.isChecked()){
            gender = 0;
        }
        if (female.isChecked()){
            gender = 1;
        }
        Toast.makeText(getApplication().getApplicationContext(), "Gender is " + gender, Toast.LENGTH_LONG).show();
    }

    /**
     * Basal Metabolic Rate (BMR)
     * Mifflin-St Jeor Equation:
     * For men:
     * BMR = 10W + 6.25H - 5A + 5
     * For women:
     * BMR = 10W + 6.25H - 5A - 161
     * **/
    public void calcBmrMifflinEq(){
        heightCM = Double.parseDouble(height.getText().toString());
        weightKG = Double.parseDouble(weight.getText().toString());
        ageValue = Integer.parseInt(age.getText().toString());

        if (male.isChecked()){
            BMR = (int) (((10 * weightKG) + (6.25 * heightCM) - (5 * ageValue) + 5) + 0.5);
        }
        if (female.isChecked()){
            BMR = (int) (((10 * weightKG) + (6.25 * heightCM) - (5 * ageValue) - 161) + 0.5);
        }
        Toast.makeText(getApplication().getApplicationContext(), "calories " + BMR, Toast.LENGTH_LONG).show();
    }

    /**
     * Basal Metabolic Rate (BMR)
     * Revised Harris-Benedict Equation:
     * For men:
     * BMR = 13.397W + 4.799H - 5.677A + 88.362
     * For women:
     * BMR = 9.247W + 3.098H - 4.330A + 447.593
     * **/
    public void calcBmrHarrisEq(){
        heightCM = Double.parseDouble(height.getText().toString());
        weightKG = Double.parseDouble(weight.getText().toString());
        ageValue = Integer.parseInt(age.getText().toString());

        if (male.isChecked()){
            BMR = (int) ((13.397 * weightKG) + (4.799 * heightCM) - (5.677 * ageValue) + 88.362);
        }
        if (female.isChecked()){
            BMR = (int) ((9.247 * weightKG) + (3.098 * heightCM) - (4.330 * ageValue) + 447.593);
        }
        Toast.makeText(getApplication().getApplicationContext(), "calories " + BMR, Toast.LENGTH_LONG).show();
    }


}