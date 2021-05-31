package com.android.myvirtualnutritionist.ui.me;

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

import com.android.myvirtualnutritionist.R;

public class MeFragment extends Fragment {

    private MeViewModel meViewModel;

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
        meViewModel.getAge().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                age.setText(s);
            }
        });

        final TextView gender = root.findViewById(R.id.text_meGender);
        meViewModel.getGender().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                gender.setText(s);
            }
        });

        final TextView diseaseType = root.findViewById(R.id.text_meDiseaseType);
        meViewModel.getDiseaseType().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                diseaseType.setText(s);
            }
        });

        final TextView height = root.findViewById(R.id.text_meHeight);
        meViewModel.getHeight().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                height.setText(s);
            }
        });

        final TextView weight = root.findViewById(R.id.text_meWeight);
        meViewModel.getWeight().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                weight.setText(s);
            }
        });

        return root;
    }
}