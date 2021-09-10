package com.android.myvirtualnutritionist.ui.me;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

    AlertDialog dialogStatus, dialogFName, dialogLName;
    EditText editTextStatus, editTextFName, editTextLName;

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

        /**
         * Textview for EditText
         * For Profile Status**/
        final TextView status = root.findViewById(R.id.status);
        dialogStatus = new AlertDialog.Builder(getContext()).create();
        editTextStatus = new EditText(getContext());
        editTextStatus.setGravity(Gravity.CENTER);

        dialogStatus.setTitle("Status (Optional)");
        dialogStatus.setView(editTextStatus);
        dialogStatus.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                status.setText(editTextStatus.getText());
            }
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextStatus.setText(status.getText());
                dialogStatus.show();
            }
        });

        /**
         * Textview for EditText
         * For First Name**/
        final TextView fName = root.findViewById(R.id.text_meFirstName);
        dialogFName = new AlertDialog.Builder(getContext()).create();
        editTextFName = new EditText(getContext());
        editTextFName.setGravity(Gravity.CENTER);

        dialogFName.setTitle("First Name");
        dialogFName.setView(editTextFName);
        dialogFName.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                fName.setText(editTextFName.getText());
            }
        });
        fName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextFName.setText(fName.getText());
                dialogFName.show();
            }
        });

        /**
        * Textview for EditText
        * For Last Name**/
        final TextView lName = root.findViewById(R.id.text_meLastName);
        dialogLName = new AlertDialog.Builder(getContext()).create();
        editTextLName = new EditText(getContext());
        editTextLName.setGravity(Gravity.CENTER);

        dialogLName.setTitle("Last Name (Optional)");
        dialogLName.setView(editTextLName);
        dialogLName.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                lName.setText(editTextLName.getText());
            }
        });
        lName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextLName.setText(lName.getText());
                dialogLName.show();
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