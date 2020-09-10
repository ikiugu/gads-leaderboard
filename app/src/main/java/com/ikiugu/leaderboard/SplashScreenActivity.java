package com.ikiugu.leaderboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ikiugu.leaderboard.api.LeaderBoardClient;
import com.ikiugu.leaderboard.models.LearningLeadersResponse;
import com.ikiugu.leaderboard.models.SkillIQResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN_TIME_OUT = 2500;
    private LeaderBoardClient leaderBoardClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_splash_screen); no need for a view, the OS will handle this

        /*Intent mainActivityIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(mainActivityIntent);*/


        leaderBoardClient = LeaderBoardClient.getInstance();
        getLearnersLeaderBoard();

        getLearnersSkillIQ();


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

    private void getLearnersSkillIQ() {
        leaderBoardClient.getLeaderBoardResults().getSkillIQ().enqueue(new Callback<List<SkillIQResponse>>() {
            @Override
            public void onResponse(Call<List<SkillIQResponse>> call, Response<List<SkillIQResponse>> response) {
                System.out.println("A");
            }

            @Override
            public void onFailure(Call<List<SkillIQResponse>> call, Throwable t) {
                System.out.println("A");
            }
        });
    }

    private void getLearnersLeaderBoard() {
        leaderBoardClient.getLeaderBoardResults().getLearners().enqueue(new Callback<List<LearningLeadersResponse>>() {
            @Override
            public void onResponse(Call<List<LearningLeadersResponse>> call, Response<List<LearningLeadersResponse>> response) {
                System.out.println("A");
            }

            @Override
            public void onFailure(Call<List<LearningLeadersResponse>> call, Throwable t) {
                System.out.println("A");
            }
        });
    }
}