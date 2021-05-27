package com.android.myvirtualnutritionist.ui.diary.nutrition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myvirtualnutritionist.R;

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

        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_nutrients_table, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        if (nutrients_dataList != null && nutrients_dataList.size() > 0) {

            NutrientsTableDataModel model = nutrients_dataList.get(position);
            holder.tableBodyDataNutrients.setText(model.getNutrientsName());
            holder.tableBodyDataTotal.setText(model.getTotal());
            holder.tableBodyDataGoal.setText(model.getGoal());
            holder.tableBodyDataLeft.setText(model.getLeft());
        } else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return nutrients_dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tableBodyDataNutrients;
        TextView tableBodyDataTotal;
        TextView tableBodyDataGoal;
        TextView tableBodyDataLeft;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tableBodyDataNutrients = itemView.findViewById(R.id.tableBodyDataNutrients);
            tableBodyDataTotal = itemView.findViewById(R.id.tableBodyDataTotal);
            tableBodyDataGoal = itemView.findViewById(R.id.tableBodyDataGoal);
            tableBodyDataLeft = itemView.findViewById(R.id.tableBodyDataLeft);
        }
    }
}
