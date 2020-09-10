package com.ikiugu.leaderboard.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class GadsRepository {
    private LearningLeadersDAO learningLeadersDAO;
    private SkillIqDAO skillIqDAO;


    public GadsRepository(Application application) {
        GadsDatabase gadsDatabase = GadsDatabase.getInstance(application);
        learningLeadersDAO = gadsDatabase.learningLeadersDAO();
        skillIqDAO = gadsDatabase.skillIqDAO();
    }

    public void insertLeaders(LearningLeader... learningLeaders) {
        new InsertLeadersTask(learningLeadersDAO).execute(learningLeaders);
    }

    public LiveData<List<LearningLeader>> getLeaders() {
        return learningLeadersDAO.getAllLearningLeaders();
    }

    public void insertIQ(SkillIQ... skillIQS) {
        new InsertIQTask(skillIqDAO).execute(skillIQS);
    }

    public LiveData<List<SkillIQ>> getSkillIQs() {
        return skillIqDAO.getAllSkillIQ();
    }

    public static class InsertLeadersTask extends AsyncTask<LearningLeader, Void, Void> {

        private LearningLeadersDAO learningLeadersDAO;

        public InsertLeadersTask(LearningLeadersDAO learningLeadersDAO) {
            this.learningLeadersDAO = learningLeadersDAO;
        }

        @Override
        protected Void doInBackground(LearningLeader... learningLeaders) {
            learningLeadersDAO.insert(learningLeaders);

            return null;
        }
    }

    public static class InsertIQTask extends AsyncTask<SkillIQ, Void, Void> {

        private SkillIqDAO skillIqDAO;

        public InsertIQTask(SkillIqDAO skillIqDAO) {
            this.skillIqDAO = skillIqDAO;
        }

        @Override
        protected Void doInBackground(SkillIQ... skillIQS) {
            skillIqDAO.insert(skillIQS);
            return null;
        }
    }
}
