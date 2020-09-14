package com.ikiugu.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ikiugu.leaderboard.api.GadsClient;
import com.ikiugu.leaderboard.db.LearningLeader;
import com.ikiugu.leaderboard.db.SkillIQ;
import com.ikiugu.leaderboard.ui.main.GadsViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN_TIME_OUT = 2500;
    private GadsClient leaderBoardClient;
    private GadsViewModel gadsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_splash_screen); no need for a view, the OS will handle this

        gadsViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(GadsViewModel.class);

        leaderBoardClient = GadsClient.getInstance();

        getLearnersLeaderBoard();

        getLearnersSkillIQ();

        gadsViewModel.getSkillIQs().observe(this, new Observer<List<SkillIQ>>() {
            @Override
            public void onChanged(List<SkillIQ> skillIQS) {
                if (skillIQS != null && skillIQS.size() > 0) {
                    Intent mainActivityIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(mainActivityIntent);
                }
            }
        });


        // use a timer to show the splash screen...frowned upon but it works 🤷‍♂️
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainActivityIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);

                finish(); // to make sure this activity is not in the backstack
            }
        }, SPLASH_SCREEN_TIME_OUT);*/
    }


    private void getLearnersLeaderBoard() {
        leaderBoardClient.getLeaderBoardResults().getLearners().enqueue(new Callback<List<LearningLeader>>() {
            @Override
            public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {



                LearningLeader[] learningLeaders = response.body().toArray(new LearningLeader[response.body().size()]);
                gadsViewModel.insertLeaders(learningLeaders);
            }

            @Override
            public void onFailure(Call<List<LearningLeader>> call, Throwable t) {
                Toast.makeText(SplashScreenActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getLearnersSkillIQ() {
        leaderBoardClient.getLeaderBoardResults().getSkillIQ().enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                SkillIQ[] skillIQS = response.body().toArray(new SkillIQ[response.body().size()]);
                gadsViewModel.insertSkills(skillIQS);
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
                Toast.makeText(SplashScreenActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}