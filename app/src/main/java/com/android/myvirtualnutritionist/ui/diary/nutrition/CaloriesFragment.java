package com.android.myvirtualnutritionist.ui.diary.nutrition;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.myvirtualnutritionist.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CaloriesFragment extends Fragment {

    private CaloriesViewModel caloriesViewModel;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        caloriesViewModel = new ViewModelProvider(this).get(CaloriesViewModel.class);
        View view = inflater.inflate(R.layout.fragment_calories, container, false);

        PieChart pieChart = view.findViewById(R.id.pieChart);

        ArrayList<PieEntry> pieCalories = new ArrayList<>();

        pieCalories.add(new PieEntry(350, "Breakfast"));
        pieCalories.add(new PieEntry(450, "Lunch"));
        pieCalories.add(new PieEntry(250, "Dinner"));
        pieCalories.add(new PieEntry(100, "Others"));

        PieDataSet pieDataSet = new PieDataSet(pieCalories, "Calories");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(25f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Calories");
        pieChart.animate();

        final TextView totalCalorieCalc = view.findViewById(R.id.text_Nutrition_totalCaloriesCalc);
        final TextView netCalorieCalc = view.findViewById(R.id.text_Nutrition_netCaloriesCalc);
        final TextView calorieGoal = view.findViewById(R.id.text_Nutrition_goalCalc);

        caloriesViewModel.getTotalCalories().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                totalCalorieCalc.setText(s);
            }
        });

        caloriesViewModel.getNetCalories().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                netCalorieCalc.setText(s);
            }
        });

        caloriesViewModel.getGoal().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                calorieGoal.setText(s);
            }
        });

        return view;
    }

    public CaloriesFragment(){
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
    public static CaloriesFragment newInstance(String param1, String param2) {
        CaloriesFragment fragment = new CaloriesFragment();
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
