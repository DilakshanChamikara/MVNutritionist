package com.android.myvirtualnutritionist.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.myvirtualnutritionist.FirstActivity;
import com.android.myvirtualnutritionist.R;

public class MeFragment extends Fragment {

    private MeViewModel meViewModel;

    double heightCM, heightM, weightKG;
    double BMI = 0.0;
    String BMIWeightStatus;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        meViewModel = new ViewModelProvider(this).get(MeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_me, container, false);

        final ImageView meProfilePic = root.findViewById(R.id.profilePic);
        meViewModel.getMeProfilePic().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                meProfilePic.setImageResource(integer);
            }
        });

        final TextView status = root.findViewById(R.id.status);
        meViewModel.getStatus().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                status.setText(s);
            }
        });

        final TextView fName = root.findViewById(R.id.text_meFirstName);
        meViewModel.getfName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                fName.setText(s);
            }
        });

        final TextView lName = root.findViewById(R.id.text_meLastName);
        meViewModel.getlName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                lName.setText(s);
            }
        });

        final TextView age = root.findViewById(R.id.text_meAge);
        final TextView gender = root.findViewById(R.id.text_meGender);
        final TextView height = root.findViewById(R.id.text_meHeight);
        final TextView weight = root.findViewById(R.id.text_meWeight);
        final TextView textBmi = root.findViewById(R.id.text_meBmi);
        final TextView weightStatus = root.findViewById(R.id.text_meWeightStatus);

        Intent intent = getActivity().getIntent();
        int passedAgeValue = intent.getIntExtra(FirstActivity.EXTRA_AGE, 0);
        double passedHeightCM = intent.getDoubleExtra(FirstActivity.EXTRA_HEIGHT, 0);
        double passedWeightKG = intent.getDoubleExtra(FirstActivity.EXTRA_WEIGHT, 0);
        String passedGender = intent.getStringExtra(FirstActivity.EXTRA_GENDER);

        /**
         * Body mass index **/
        heightCM = passedHeightCM;
        weightKG = passedWeightKG;
        heightM = heightCM / 100;
        BMI = (weightKG / ((heightM) * (heightM)));

        /**
         * Weight Status
         * Below 18.5	Underweight
         * 18.5—24.9	Healthy
         * 25.0—29.9	Overweight
         * 30.0 and Above	Obese
         * **/
        if (BMI < 18.5)
            BMIWeightStatus = "Underweight";
        else if (BMI >= 18.5 && BMI <= 24.9)
            BMIWeightStatus = "Healthy";
        else if (BMI >= 25.0 && BMI <= 29.9)
            BMIWeightStatus = "Overweight";
        else if (BMI >= 30.0)
            BMIWeightStatus = "Obese";

        age.setText("" + passedAgeValue);
        gender.setText("" + passedGender);
        height.setText("" + passedHeightCM);
        weight.setText("" + passedWeightKG);
        textBmi.setText("" + String.format("%.2f", BMI));
        weightStatus.setText(BMIWeightStatus);

        return root;
    }
}