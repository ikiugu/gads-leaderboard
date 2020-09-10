package com.ikiugu.leaderboard.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SkillIqDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SkillIQ... skillIQS);

    @Query("Select * from skills")
    LiveData<List<SkillIQ>> getAllSkillIQ();
}
