package com.android.myvirtualnutritionist.ui.plans;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myvirtualnutritionist.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PlansAdapter extends RecyclerView.Adapter<PlansAdapter.plansViewHolder> {

    ArrayList<PlansDataModel> dataHolder;

    public PlansAdapter(ArrayList<PlansDataModel> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class plansViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title, status, date;

        public plansViewHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.planCardImage);
            title = itemView.findViewById(R.id.planCardTitle);
            status = itemView.findViewById(R.id.planCardStatus);
            date = itemView.findViewById(R.id.planCardDate);
        }
    }

    @NonNull
    @NotNull
    @Override
    public plansViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_available_plans, parent, false);
        return new plansViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull plansViewHolder holder, int position) {
        holder.img.setImageResource(dataHolder.get(position).getPlanImage());
        holder.title.setText(dataHolder.get(position).getPlanTitle());
        holder.status.setText(dataHolder.get(position).getStatus());
        holder.date.setText(dataHolder.get(position).getPlanDate());
    }
}
