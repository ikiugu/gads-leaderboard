package com.ikiugu.leaderboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_splash_screen); no need for a view, the OS will handle this

        Intent mainActivityIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
        startActivity(mainActivityIntent);

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
}