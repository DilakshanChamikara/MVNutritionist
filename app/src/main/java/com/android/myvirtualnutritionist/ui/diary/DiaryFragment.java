package com.android.myvirtualnutritionist.ui.diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    int BMR = 0;

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
            BMR = (int) (((10 * passedWeightKG) + (6.25 * passedHeightCM) - (5 * passedAgeValue) + 5) + 0.5);
        if (female.equals(passedGender))
            BMR = (int) (((10 * passedWeightKG) + (6.25 * passedHeightCM) - (5 * passedAgeValue) - 161) + 0.5);

        textViewCalc.setText("" + BMR + "");

        diaryViewModel.getCaloriesDesc().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewDesc.setText(s);
            }
        });

        diaryViewModel.getBreakfastCountItems().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewBreakfastIC.setText(s);
            }
        });

        diaryViewModel.getLunchCountItems().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewLunchIC.setText(s);
            }
        });

        diaryViewModel.getDinnerCountItems().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewDinnerIC.setText(s);
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