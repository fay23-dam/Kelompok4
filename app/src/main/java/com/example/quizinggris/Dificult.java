package com.example.quizinggris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dificult extends AppCompatActivity implements View.OnClickListener {

    private String level;
    private Button eas,med,hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificult);
        eas = findViewById(R.id.mudah);
        med = findViewById(R.id.sedang);
        hard = findViewById(R.id.sulit);

        eas.setOnClickListener(this);
        med.setOnClickListener(this);
        hard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Dificult.this, Easy.class);
        switch (v.getId()) {
            case R.id.mudah:
                level = "easy";
                intent.putExtra("lev", level);
                startActivity(intent);
                break;
            case R.id.sedang:
                level = "medium";
                intent.putExtra("lev", level);
                startActivity(intent);
                break;
            case R.id.sulit:
                level = "hard";
                intent.putExtra("lev", level);
                startActivity(intent);
        }

    }
}