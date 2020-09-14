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
import com.ikiugu.leaderboard.adapters.SkillIQAdapter;
import com.ikiugu.leaderboard.db.SkillIQ;

import java.util.ArrayList;
import java.util.List;

public class SkillsFragment extends Fragment {

    RecyclerView recyclerView;
    SkillIQAdapter skillIQAdapter;

    public SkillsFragment() {
    }

    public static SkillsFragment newInstance() {
        return new SkillsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        recyclerView = view.findViewById(R.id.skillsRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GadsViewModel gadsViewModel = ViewModelProviders.of(this).get(GadsViewModel.class);

        gadsViewModel.getSkillIQs().observe(getViewLifecycleOwner(), new Observer<List<SkillIQ>>() {
            @Override
            public void onChanged(List<SkillIQ> skillIQS) {
                ArrayList<SkillIQ> skillIQArrayList = (ArrayList<SkillIQ>) skillIQS;
                skillIQAdapter = new SkillIQAdapter(skillIQArrayList);
                recyclerView.setAdapter(skillIQAdapter);
            }
        });
    }
}