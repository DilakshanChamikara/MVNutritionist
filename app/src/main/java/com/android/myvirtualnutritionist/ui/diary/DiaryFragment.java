package com.android.myvirtualnutritionist.ui.diary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.myvirtualnutritionist.FirstActivity;
import com.android.myvirtualnutritionist.R;
import com.android.myvirtualnutritionist.ui.diary.nutrition.NutritionMainActivity;
//import com.android.myvirtualnutritionist.ui.diary.nutrition.NutritionPlaceholderFragment;

public class DiaryFragment extends Fragment {

    private DiaryViewModel diaryViewModel;
    private Button btnDiaryNutrition;

    String male = "Male";
    String female = "Female";
    int actualNeedBMR = 0;
    int goalBMR = 0;

    double heightCM, heightM;
    double calcWeight;
    double constantBMI = 21.7;

    AlertDialog dialogBreakfast, dialogLunch, dialogDinner;
    EditText editTextBreakfast, editTextLunch, editTextDinner;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        diaryViewModel = new ViewModelProvider(this).get(DiaryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_diary, container, false);

        final TextView textViewCalc = root.findViewById(R.id.text_diaryCaloriesCalc);
        final TextView textViewDesc = root.findViewById(R.id.text_diaryCaloriesDesc);

        final TextView textViewBreakfastIC = root.findViewById(R.id.text_breakfastCountItems);
        final TextView textViewLunchIC = root.findViewById(R.id.text_lunchCountItems);
        final TextView textViewDinnerIC = root.findViewById(R.id.text_dinnerCountItems);

        btnDiaryNutrition = (Button) root.findViewById(R.id.btn_diaryNutrition);

        Intent intent = getActivity().getIntent();
        int passedAgeValue = intent.getIntExtra(FirstActivity.EXTRA_AGE, 0);
        double passedHeightCM = intent.getDoubleExtra(FirstActivity.EXTRA_HEIGHT, 0);
        double passedWeightKG = intent.getDoubleExtra(FirstActivity.EXTRA_WEIGHT, 0);
        String passedGender = intent.getStringExtra(FirstActivity.EXTRA_GENDER);

        /**
         * Basal Metabolic Rate (BMR)
         * Mifflin-St Jeor Equation:
         * For men:
         * BMR = 10W + 6.25H - 5A + 5
         * For women:
         * BMR = 10W + 6.25H - 5A - 161
         * **/
        if (male.equals(passedGender))
            actualNeedBMR = (int) (((10 * passedWeightKG) + (6.25 * passedHeightCM) - (5 * passedAgeValue) + 5) + 0.5);
        if (female.equals(passedGender))
            actualNeedBMR = (int) (((10 * passedWeightKG) + (6.25 * passedHeightCM) - (5 * passedAgeValue) - 161) + 0.5);

        /**
         * Calculate Weight using ideal Body mass index
         * BMI = (weightKG / ((heightM) * (heightM)));
         * **/
        heightCM = passedHeightCM;
        heightM = heightCM / 100;

        calcWeight = (constantBMI * (heightM * heightM));

        /**
         * BMR Goal
         * **/
        if (male.equals(passedGender))
            goalBMR = (int) (((10 * calcWeight) + (6.25 * passedHeightCM) - (5 * passedAgeValue) + 5) + 0.5);
        if (female.equals(passedGender))
            goalBMR = (int) (((10 * calcWeight) + (6.25 * passedHeightCM) - (5 * passedAgeValue) - 161) + 0.5);

        textViewCalc.setText("" + actualNeedBMR + "\t\t\t\t\t\t\t\t\t\t\t\t\t" + goalBMR);

        diaryViewModel.getCaloriesDesc().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewDesc.setText(s);
            }
        });

        /**
         * Textview for EditText
         * For Add Food Breakfast**/
        final TextView addFoodB = root.findViewById(R.id.text_breakfastAddFood);
        dialogBreakfast = new AlertDialog.Builder(getContext()).create();
        editTextBreakfast = new EditText(getContext());
        editTextBreakfast.setGravity(Gravity.CENTER);

        dialogBreakfast.setTitle("Add Foods for Breakfast");
        dialogBreakfast.setView(editTextBreakfast);
        dialogBreakfast.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addFoodB.setText(editTextBreakfast.getText());
            }
        });
        addFoodB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextBreakfast.setText(addFoodB.getText());
                dialogBreakfast.show();
            }
        });

        /**
         * Textview for EditText
         * For Add Food Lunch**/
        final TextView addFoodL = root.findViewById(R.id.text_lunchAddFood);
        dialogLunch = new AlertDialog.Builder(getContext()).create();
        editTextLunch = new EditText(getContext());
        editTextLunch.setGravity(Gravity.CENTER);

        dialogLunch.setTitle("Add Foods for Lunch");
        dialogLunch.setView(editTextLunch);
        dialogLunch.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addFoodL.setText(editTextLunch.getText());
            }
        });
        addFoodL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextLunch.setText(addFoodL.getText());
                dialogLunch.show();
            }
        });

        /**
         * Textview for EditText
         * For Add Food Dinner**/
        final TextView addFoodD = root.findViewById(R.id.text_dinnerAddFood);
        dialogDinner = new AlertDialog.Builder(getContext()).create();
        editTextDinner = new EditText(getContext());
        editTextDinner.setGravity(Gravity.CENTER);

        dialogDinner.setTitle("Add Foods for Dinner");
        dialogDinner.setView(editTextDinner);
        dialogDinner.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                addFoodD.setText(editTextDinner.getText());
            }
        });
        addFoodD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextDinner.setText(addFoodD.getText());
                dialogDinner.show();
            }
        });

        btnDiaryNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), NutritionMainActivity.class);
                startActivity(i);
            }
        });

        return root;
    }

}