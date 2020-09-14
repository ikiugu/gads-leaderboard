package com.ikiugu.leaderboard.api;

import com.ikiugu.leaderboard.db.LearningLeader;
import com.ikiugu.leaderboard.db.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GadsApi {
    @GET("/api/hours")
    Call<List<LearningLeader>> getLearners();

    @GET("/api/skilliq")
    Call<List<SkillIQ>> getSkillIQ();
}
