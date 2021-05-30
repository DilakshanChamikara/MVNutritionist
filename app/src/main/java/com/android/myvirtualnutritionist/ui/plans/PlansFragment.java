package com.android.myvirtualnutritionist.ui.plans;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.myvirtualnutritionist.R;

public class PlansFragment extends Fragment {

    private PlansViewModel plansViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        plansViewModel = new ViewModelProvider(this).get(PlansViewModel.class);
        View root = inflater.inflate(R.layout.fragment_plans, container, false);

//        final TextView textView = root.findViewById(R.id.text_plans);
//        plansViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        return root;
    }
}