package com.ikiugu.leaderboard.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ikiugu.leaderboard.db.GadsRepository;
import com.ikiugu.leaderboard.db.LearningLeader;
import com.ikiugu.leaderboard.db.SkillIQ;

import java.util.List;

public class GadsViewModel extends AndroidViewModel {

    private GadsRepository gadsRepository;
    private LiveData<List<LearningLeader>> learningLeadersLiveData;
    private LiveData<List<SkillIQ>> skillIQLiveData;

    public GadsViewModel(@NonNull Application application) {
        super(application);
        this.gadsRepository = new GadsRepository(application);
        learningLeadersLiveData = gadsRepository.getLeaders();
        skillIQLiveData = gadsRepository.getSkillIQs();
    }

    public void insertLeaders(LearningLeader... learningLeaders) {
        gadsRepository.insertLeaders(learningLeaders);
    }

    public LiveData<List<LearningLeader>> getLearningLeaders() {
        return learningLeadersLiveData;
    }

    public void insertSkills(SkillIQ... skillIQs) {
        gadsRepository.insertIQ(skillIQs);
    }

    public LiveData<List<SkillIQ>> getSkillIQs() {
        return skillIQLiveData;
    }
}