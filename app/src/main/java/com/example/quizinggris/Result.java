package com.example.quizinggris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity implements View.OnClickListener {

    private Button cobalagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView txtScore = (TextView) findViewById(R.id.textScore);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        txtScore.setText("" + score);
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        cobalagi = findViewById(R.id.butcob);
        cobalagi.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butcob:
                Intent intent = new Intent(Result.this, Dificult.class);
                startActivity(intent);
        }

    }
}

