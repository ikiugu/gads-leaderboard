package com.ikiugu.leaderboard.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ikiugu.leaderboard.R;
import com.ikiugu.leaderboard.db.SkillIQ;

import java.util.List;

public class SkillsFragment extends Fragment {

    private GadsViewModel gadsViewModel;

    private TextView textView;

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
        textView = view.findViewById(R.id.textView4);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gadsViewModel = ViewModelProviders.of(this).get(GadsViewModel.class);

        gadsViewModel.getSkillIQs().observe(getActivity(), new Observer<List<SkillIQ>>() {
            @Override
            public void onChanged(List<SkillIQ> skillIQS) {
                textView.setText("Total records are " + skillIQS.size());
            }
        });
    }
}