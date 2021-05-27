package com.android.myvirtualnutritionist.ui.diary.nutrition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myvirtualnutritionist.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NutrientsFragment extends Fragment {

    RecyclerView tableBodyRecyclerview;
    NutrientsTableAdapter nutrientsTableAdapter;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nutrients, container, false);

        tableBodyRecyclerview = view.findViewById(R.id.tableBodyRecyclerview);
        setRecyclerView();

        return view;
    }

    private void setRecyclerView() {
        tableBodyRecyclerview.setHasFixedSize(true);
        tableBodyRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        nutrientsTableAdapter = new NutrientsTableAdapter(getActivity(), getList());
        tableBodyRecyclerview.setAdapter(nutrientsTableAdapter);
    }

    private List<NutrientsTableDataModel> getList() {

        List<NutrientsTableDataModel> dataModelList = new ArrayList<>();

        dataModelList.add(new NutrientsTableDataModel("Protein", "0g", "104g", "104g"));
        dataModelList.add(new NutrientsTableDataModel("Carbohydrates", "0g", "1259g", "1259g"));
        dataModelList.add(new NutrientsTableDataModel("Fiber", "0g", "38g", "38g"));
        dataModelList.add(new NutrientsTableDataModel("Sugar", "0g", "78g", "78g"));
        dataModelList.add(new NutrientsTableDataModel("Fat", "0g", "69g", "69g"));
        dataModelList.add(new NutrientsTableDataModel("Saturated", "0g", "104g", "104g"));
        dataModelList.add(new NutrientsTableDataModel("Polyunsaturated", "0g", "1259g", "1259g"));
        dataModelList.add(new NutrientsTableDataModel("Monounsaturated", "0g", "38g", "38g"));
        dataModelList.add(new NutrientsTableDataModel("Trans", "0g", "78g", "78g"));
        dataModelList.add(new NutrientsTableDataModel("Cholesterol", "0g", "69g", "69g"));
        dataModelList.add(new NutrientsTableDataModel("Sodium", "0g", "78g", "78g"));
        dataModelList.add(new NutrientsTableDataModel("Potassium", "0g", "69g", "69g"));

        return dataModelList;
    }
}
