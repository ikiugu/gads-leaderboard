package com.ikiugu.leaderboard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ikiugu.leaderboard.R;
import com.ikiugu.leaderboard.db.LearningLeader;

import java.util.ArrayList;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {
    private ArrayList<LearningLeader> gadsLearningLeadersArray;

    public LearningLeadersAdapter(ArrayList<LearningLeader> gadsDevelopersArrayListHours) {
        this.gadsLearningLeadersArray = gadsDevelopersArrayListHours;
    }

    @Override
    public LearningLeadersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_leaders_layout, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(LearningLeadersAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(gadsLearningLeadersArray.get(position).getName());
        if (gadsLearningLeadersArray.get(position).getHours() != null) {
            holder.txtHours.setText(gadsLearningLeadersArray.get(position).getHours() + " learning hours");
        } else {
            holder.txtHours.setText("No learning hours");
        }
        holder.txtCountry.setText(gadsLearningLeadersArray.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return gadsLearningLeadersArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtHours, txtCountry;

        public ViewHolder(View itemView) {
            super(itemView);
            //Card View
            txtName = (TextView) itemView.findViewById(R.id.text_name);
            txtHours = (TextView) itemView.findViewById(R.id.txtLearningHours);
            txtCountry = (TextView) itemView.findViewById(R.id.txtCountry);
        }
    }
}
