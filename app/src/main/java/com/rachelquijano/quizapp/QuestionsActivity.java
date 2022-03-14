package com.rachelquijano.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView tvProgress;
    TextView tvQuestion;
    ImageView ivQuestion;
    TextView tvOption1, tvOption2, tvOption3, tvOption4;
    Button btnSubmit;

    private int currentQuestion = 1;
    private ArrayList<QuestionModel> questions;
    private int selectedQuestion = 0;
    private int correctAnswersCount = 0;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        progressBar = findViewById(R.id.pbQuestions);
        tvProgress = findViewById(R.id.tvProgress);
        tvQuestion = findViewById(R.id.tvQuestion);
        ivQuestion = findViewById(R.id.ivQuestionImage);
        tvOption1 = findViewById(R.id.tvOption1);
        tvOption2 = findViewById(R.id.tvOption2);
        tvOption3 = findViewById(R.id.tvOption3);
        tvOption4 = findViewById(R.id.tvOption4);
        btnSubmit = findViewById(R.id.btnSubmit);

        username = getIntent().getStringExtra("Username");
        questions = Constants.getQuestions();
        setQuestion();

        tvOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOptionsView(tvOption1, 1);
            }
        });
        tvOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOptionsView(tvOption2, 2);
            }
        });
        tvOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOptionsView(tvOption3, 3);
            }
        });
        tvOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedOptionsView(tvOption4, 4);
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedQuestion == 0){
                    currentQuestion++;

                    if(currentQuestion <= questions.size()){
                        setQuestion();
                    }else{
                        //Toast.makeText(getApplicationContext(), "You have completed the quiz", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                        i.putExtra("Username", username);
                        i.putExtra("CorrectAnswers", correctAnswersCount);
                        i.putExtra("TotalQuestions", questions.size());
                        startActivity(i);
                    }
                }else{
                    QuestionModel question = questions.get(currentQuestion - 1);
                    if(question.getCorrectOption() != selectedQuestion){
                        answerView(selectedQuestion, R.drawable.incorrect_option_border_bg);
                    }else{
                        correctAnswersCount++;
                    }
                    answerView(question.getCorrectOption(), R.drawable.correct_option_border_bg);

                    if(currentQuestion == questions.size()){
                        btnSubmit.setText("FINISH");
                    }else{
                        btnSubmit.setText("NEXT QUESTION");
                    }
                    selectedQuestion = 0;
                }
            }
        });
    }

    private void setQuestion(){

        QuestionModel question = questions.get(currentQuestion - 1);
        defaultOptionsView();
        if(currentQuestion == questions.size()){
            btnSubmit.setText("FINISH");
        }else{
            btnSubmit.setText("SUBMIT");
        }
        progressBar.setProgress(currentQuestion);
        tvProgress.setText("" + currentQuestion + "/" + progressBar.getMax());
        tvQuestion.setText(question.getQuestion());
        ivQuestion.setImageResource(question.getImage());
        tvOption1.setText(question.getOption1());
        tvOption2.setText(question.getOption2());
        tvOption3.setText(question.getOption3());
        tvOption4.setText(question.getOption4());
    }

    private void defaultOptionsView(){
        ArrayList<TextView> options = new ArrayList<>();
        options.add(tvOption1);
        options.add(tvOption2);
        options.add(tvOption3);
        options.add(tvOption4);

        for(TextView option : options){
            option.setTextColor(Color.GRAY);
            option.setTypeface(Typeface.DEFAULT);
            option.setBackground(ContextCompat.getDrawable(this, R.drawable.default_option_border_bg));
        }
    }

    private void selectedOptionsView(TextView tv, int selected){
        defaultOptionsView();
        selectedQuestion = selected;
        tv.setTextColor(Color.BLACK);
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg));
    }

    private void answerView(int answer, int view){
        if(answer == 1)
            tvOption1.setBackground(ContextCompat.getDrawable(this, view));
        else if(answer == 2)
            tvOption2.setBackground(ContextCompat.getDrawable(this, view));
        else if(answer == 3)
            tvOption3.setBackground(ContextCompat.getDrawable(this, view));
        else if(answer == 4)
            tvOption4.setBackground(ContextCompat.getDrawable(this, view));

    }

}