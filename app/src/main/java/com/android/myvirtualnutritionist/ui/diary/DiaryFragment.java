package com.android.myvirtualnutritionist.ui.diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.myvirtualnutritionist.R;
import com.android.myvirtualnutritionist.ui.diary.nutrition.NutritionMainActivity;
//import com.android.myvirtualnutritionist.ui.diary.nutrition.NutritionPlaceholderFragment;

public class DiaryFragment extends Fragment {

    private DiaryViewModel diaryViewModel;
    private Button btnDiaryNutrition;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        diaryViewModel = new ViewModelProvider(this).get(DiaryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_diary, container, false);

        final TextView textViewCalc = root.findViewById(R.id.text_diaryCaloriesCalc);
        final TextView textViewDesc = root.findViewById(R.id.text_diaryCaloriesDesc);

        final TextView textViewBreakfastIC = root.findViewById(R.id.text_breakfastCountItems);
        final TextView textViewLunchIC = root.findViewById(R.id.text_lunchCountItems);
        final TextView textViewDinnerIC = root.findViewById(R.id.text_dinnerCountItems);

        btnDiaryNutrition = (Button) root.findViewById(R.id.btn_diaryNutrition);

        diaryViewModel.getCaloriesCalc().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewCalc.setText(s);
            }
        });

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