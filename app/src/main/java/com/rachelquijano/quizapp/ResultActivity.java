package com.rachelquijano.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvUsername;
    TextView tvScore;
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvUsername = findViewById(R.id.tvUsername);
        tvScore = findViewById(R.id.tvScore);
        btnFinish = findViewById(R.id.btnFinish);

        String username = getIntent().getStringExtra("Username");
        Log.i("Username", "the username is " + username);
        tvUsername.setText(username);
        int totalQuestions = getIntent().getIntExtra("TotalQuestions", 0);
        int correctQuestions = getIntent().getIntExtra("CorrectAnswers", 0);
        tvScore.setText("Your score is " + correctQuestions + " out of " + totalQuestions);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

    }
}