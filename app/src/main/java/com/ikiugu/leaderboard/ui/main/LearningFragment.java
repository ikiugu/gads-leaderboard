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
import com.ikiugu.leaderboard.db.LearningLeader;

import java.util.List;

public class LearningFragment extends Fragment {

    private GadsViewModel gadsViewModel;
    TextView count;

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
        count = view.findViewById(R.id.textView3);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gadsViewModel = ViewModelProviders.of(this).get(GadsViewModel.class);

        gadsViewModel.getLearningLeaders().observe(getActivity(), new Observer<List<LearningLeader>>() {
            @Override
            public void onChanged(List<LearningLeader> learningLeaders) {
                if (learningLeaders.size() > 0) {
                    count.setText("Total records are " + learningLeaders.size());
                }
            }
        });
    }
}