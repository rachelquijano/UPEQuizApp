package com.rachelquijano.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        etName = findViewById(R.id.etName);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please input a name", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i = new Intent(getApplicationContext(), QuestionsActivity.class);
                    i.putExtra("Username", etName.getText().toString());
                    startActivity(i);
                    //Closes the current activity
                    finish();
                }
            }
        });

    }
}