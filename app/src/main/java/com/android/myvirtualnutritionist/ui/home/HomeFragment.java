package com.android.myvirtualnutritionist.ui.home;

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

import com.android.myvirtualnutritionist.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<HealthyTipsDataModel> dataHolder;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textViewCalc = root.findViewById(R.id.text_homeCaloriesCalc);
        final TextView textViewDesc = root.findViewById(R.id.text_homeCaloriesDesc);

        homeViewModel.getCaloriesCalc().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textViewCalc.setText(s);
            }
        });

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