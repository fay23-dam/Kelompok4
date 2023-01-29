package com.example.quizinggris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button ms;
        ms = findViewById(R.id.masuk);
        ms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Home.this, Dificult.class);
        switch (v.getId()) {
            case R.id.masuk:
                startActivity(intent);
        }
    }
}