package com.android.myvirtualnutritionist.ui.diary.nutrition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NutrientsTableAdapter extends RecyclerView.Adapter<NutrientsTableAdapter.ViewHolder> {

    Context context;
    List<NutrientsTableDataModel> nutrients_dataList;

    public NutrientsTableAdapter(Context context, List<NutrientsTableDataModel> nutrients_dataList) {
        this.context = context;
        this.nutrients_dataList = nutrients_dataList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }
    }
}
