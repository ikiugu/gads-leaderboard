package com.ikiugu.leaderboard.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {LearningLeader.class, SkillIQ.class}, version = 1)
public abstract class GadsDatabase extends RoomDatabase {

    private static GadsDatabase gadsDatabase;

    public abstract LearningLeadersDAO learningLeadersDAO();

    public abstract SkillIqDAO skillIqDAO();

    public static synchronized GadsDatabase getInstance(Context context) {
        if (gadsDatabase == null) {
            gadsDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    GadsDatabase.class, "gads_db")
                    .build();
        }

        return gadsDatabase;
    }
}
