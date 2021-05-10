package com.android.myvirtualnutritionist.ui.diary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.myvirtualnutritionist.R;

public class DiaryFragment extends Fragment {

    private DiaryViewModel diaryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        diaryViewModel = new ViewModelProvider(this).get(DiaryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_diary, container, false);

        final TextView textViewCalc = root.findViewById(R.id.text_diaryCaloriesCalc);
        final TextView textViewDesc = root.findViewById(R.id.text_diaryCaloriesDesc);

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
        return root;
    }
}