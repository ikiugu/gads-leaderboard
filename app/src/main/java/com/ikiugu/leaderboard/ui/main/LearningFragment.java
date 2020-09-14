package com.ikiugu.leaderboard.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ikiugu.leaderboard.R;
import com.ikiugu.leaderboard.adapters.LearningLeadersAdapter;
import com.ikiugu.leaderboard.db.LearningLeader;

import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {

    RecyclerView recyclerView;
    LearningLeadersAdapter learningLeadersAdapter;

    public LearningFragment() {
        // Required empty public constructor
    }

    public static LearningFragment newInstance() {
        return new LearningFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning, container, false);
        recyclerView = view.findViewById(R.id.learningRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GadsViewModel gadsViewModel = ViewModelProviders.of(this).get(GadsViewModel.class);
        gadsViewModel.getLearningLeaders().observe(getViewLifecycleOwner(), new Observer<List<LearningLeader>>() {
            @Override
            public void onChanged(List<LearningLeader> learningLeaders) {
                ArrayList<LearningLeader> learningLeaderArrayList = (ArrayList<LearningLeader>) learningLeaders;
                learningLeadersAdapter = new LearningLeadersAdapter(learningLeaderArrayList);
                recyclerView.setAdapter(learningLeadersAdapter);
            }
        });
    }
}