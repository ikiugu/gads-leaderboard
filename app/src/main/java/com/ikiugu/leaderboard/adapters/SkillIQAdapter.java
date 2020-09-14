package com.ikiugu.leaderboard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ikiugu.leaderboard.R;
import com.ikiugu.leaderboard.db.SkillIQ;

import java.util.ArrayList;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.ViewHolder> {
    private ArrayList<SkillIQ> skillIQArrayList;

    public SkillIQAdapter(ArrayList<SkillIQ> gadsDevelopersArrayListHours) {
        this.skillIQArrayList = gadsDevelopersArrayListHours;
    }

    @Override
    public SkillIQAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SkillIQAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(skillIQArrayList.get(position).getName());
        if (skillIQArrayList.get(position).getScore() != null) {
            holder.txtScore.setText(skillIQArrayList.get(position).getScore() + " IQ points");
        } else {
            holder.txtScore.setText("No learning hours");
        }
        holder.txtCountry.setText(skillIQArrayList.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return skillIQArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtScore, txtCountry;

        public ViewHolder(View itemView) {
            super(itemView);
            //Card View
            txtName = (TextView) itemView.findViewById(R.id.text_name);
            txtScore = (TextView) itemView.findViewById(R.id.txtScore);
            txtCountry = (TextView) itemView.findViewById(R.id.txtCountry);
        }
    }
}
