package com.android.myvirtualnutritionist.ui.plans;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myvirtualnutritionist.R;
import com.android.myvirtualnutritionist.ui.home.HealthyTipsDataModel;
import com.android.myvirtualnutritionist.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.Date;

public class PlansFragment extends Fragment {

    private PlansViewModel plansViewModel;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<PlansDataModel> dataHolder;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        plansViewModel = new ViewModelProvider(this).get(PlansViewModel.class);
        View root = inflater.inflate(R.layout.fragment_plans, container, false);

        final TextView availablePlans = root.findViewById(R.id.text_availablePlans);
        plansViewModel.getAvailablePlans().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                availablePlans.setText(s);
            }
        });

        recyclerView = root.findViewById(R.id.plansRecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        PlansDataModel ob1 = new PlansDataModel(R.drawable.food, "Plan 1", "Available", "30-05-2021");
        dataHolder.add(ob1);

        PlansDataModel ob2 = new PlansDataModel(R.drawable.food, "Plan 2", "Currently unavailable", "31-05-2021");
        dataHolder.add(ob2);

        PlansDataModel ob3 = new PlansDataModel(R.drawable.food, "Plan 3", "Available", "01-06-2021");
        dataHolder.add(ob3);

        PlansDataModel ob4 = new PlansDataModel(R.drawable.food, "Plan 4", "Currently unavailable", "02-06-2021");
        dataHolder.add(ob4);

        recyclerView.setAdapter(new PlansAdapter(dataHolder));

        return root;
    }

    public PlansFragment() {
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
    public static PlansFragment newInstance(String param1, String param2) {
        PlansFragment fragment = new PlansFragment();
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