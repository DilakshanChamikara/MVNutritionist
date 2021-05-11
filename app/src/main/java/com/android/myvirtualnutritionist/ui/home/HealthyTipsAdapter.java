package com.android.myvirtualnutritionist.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myvirtualnutritionist.R;

import java.util.ArrayList;

public class HealthyTipsAdapter extends RecyclerView.Adapter<HealthyTipsAdapter.tipsViewHolder> {
    ArrayList<HealthyTipsDataModel> dataHolder;

    public HealthyTipsAdapter(ArrayList<HealthyTipsDataModel> dataHolder){
        this.dataHolder = dataHolder;
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class tipsViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title ,desc;
        public tipsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.healthyTipsImage);
            title = itemView.findViewById(R.id.healthyTipsTitle);
            desc = itemView.findViewById(R.id.healthyTipsDescription);
        }
    }

    @NonNull
    @Override
    public tipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_healthytips, parent, false);
        return new tipsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tipsViewHolder holder, int position) {
        holder.img.setImageResource(dataHolder.get(position).getTipImage());
        holder.title.setText(dataHolder.get(position).getTipTitle());
        holder.desc.setText(dataHolder.get(position).getTipDesc());
    }

}
