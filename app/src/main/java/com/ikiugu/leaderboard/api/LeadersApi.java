package com.ikiugu.leaderboard.api;

import com.ikiugu.leaderboard.models.LearningLeadersResponse;
import com.ikiugu.leaderboard.models.SkillIQResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeadersApi {
    @GET("/api/hours")
    Call<List<LearningLeadersResponse>> getLearners();

    @GET("/api/skilliq")
    Call<List<SkillIQResponse>> getSkillIQ();
}
