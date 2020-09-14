package com.ikiugu.leaderboard;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ikiugu.leaderboard.api.GadsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        submitButton = findViewById(R.id.submit_project_button);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup_yes);

        final Button yesBtn = dialog.findViewById(R.id.popup_button_yes);
        final FloatingActionButton noBtn = dialog.findViewById(R.id.popup_image_button_close);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        final GadsApi request = retrofit.create(GadsApi.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            EditText txtFirstName, txtLastName, txtEmail, txtGithubLink;
            String firstName, lastName, emailAddress, githubLink;

            @Override
            public void onClick(View v) {
                txtFirstName = findViewById(R.id.editTextFirstName);
                txtLastName = findViewById(R.id.editTextLastName);
                txtEmail = findViewById(R.id.editTextEmailAddress);
                txtGithubLink = findViewById(R.id.editTextProjectOnGitHub);

                dialog.show();

                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                yesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        firstName = txtFirstName.getText().toString().trim();
                        lastName = txtLastName.getText().toString().trim();
                        emailAddress = txtEmail.getText().toString().trim();
                        githubLink = txtGithubLink.getText().toString().trim();


                        request.sendProjectDetails(firstName, lastName, emailAddress, githubLink)
                                .enqueue(new Callback<Void>() {
                                    @Override
                                    public void onResponse(Call<Void> call, Response<Void> response) {
                                        if (response.isSuccessful()) {
                                            dialog.setContentView(R.layout.popup_success);
                                            dialog.show();
                                        } else {
                                            dialog.setContentView(R.layout.popup_fail);
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Void> call, Throwable t) {
                                        Log.d("Error", t.getMessage());
                                        dialog.setContentView(R.layout.popup_fail);
                                        dialog.show();
                                        call.cancel();
                                    }
                                });
                    }
                });
            }
        });
    }
}