package com.android.myvirtualnutritionist.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myvirtualnutritionist.FirstActivity;
import com.android.myvirtualnutritionist.R;
import com.android.myvirtualnutritionist.ui.me.MeFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public static final String EXTRA_BMRNEED = "com.android.myvirtualnutritionist.ui.home.EXTRA_BMRNEED";
    public static final String EXTRA_BMRGOAL = "com.android.myvirtualnutritionist.ui.home.EXTRA_BMRGOAL";

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<HealthyTipsDataModel> dataHolder;

    String male = "Male";
    String female = "Female";
    int actualNeedBMR = 0;
    int goalBMR = 0;

    double heightCM, heightM;
    double calcWeight;
    double constantBMI = 21.7;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textViewCalc = root.findViewById(R.id.text_homeCaloriesCalc);
        final TextView textViewDesc = root.findViewById(R.id.text_homeCaloriesDesc);

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
        /**
         * passing values to the me fragment
         */
//        Intent intent1 = new Intent(getActivity().getApplicationContext(), MeFragment.class);
//        intent1.putExtra(EXTRA_BMRNEED, actualNeedBMR);
//        intent1.putExtra(EXTRA_BMRGOAL, goalBMR);
//        startActivity(intent1);

        homeViewModel.getCaloriesDesc().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewDesc.setText(s);
            }
        });

        recyclerView = root.findViewById(R.id.healthyTipsView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        HealthyTipsDataModel ob1 = new HealthyTipsDataModel(R.drawable.healthyfood, "Get Healthy Foods", "blah blah blah...");
        dataHolder.add(ob1);

        HealthyTipsDataModel ob2 = new HealthyTipsDataModel(R.drawable.exercise, "Get More Exercise", "blah blah blah...");
        dataHolder.add(ob2);

        HealthyTipsDataModel ob3 = new HealthyTipsDataModel(R.drawable.healthyfood, "Get Healthy Foods", "blah blah blah...");
        dataHolder.add(ob3);

        HealthyTipsDataModel ob4 = new HealthyTipsDataModel(R.drawable.exercise, "Get More Exercise", "blah blah blah...");
        dataHolder.add(ob4);

        HealthyTipsDataModel ob5 = new HealthyTipsDataModel(R.drawable.healthyfood, "Get Healthy Foods", "blah blah blah...");
        dataHolder.add(ob5);

        HealthyTipsDataModel ob6 = new HealthyTipsDataModel(R.drawable.exercise, "Get More Exercise", "blah blah blah...");
        dataHolder.add(ob6);

        recyclerView.setAdapter(new HealthyTipsAdapter(dataHolder));

        return root;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment datafragment.
     */
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

}