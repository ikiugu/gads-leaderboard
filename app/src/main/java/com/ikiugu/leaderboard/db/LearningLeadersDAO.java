package com.ikiugu.leaderboard.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LearningLeadersDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LearningLeader... learningLeaders);

    @Query("SELECT * FROM learningLeaders")
    LiveData<List<LearningLeader>> getAllLearningLeaders();

    @Query("DELETE FROM learningLeaders")
    void deleteAllLearners();
}
