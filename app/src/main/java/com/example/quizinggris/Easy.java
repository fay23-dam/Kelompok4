package com.example.quizinggris;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Easy extends AppCompatActivity implements View.OnClickListener {

    private final List<QuizList> quizlist = new ArrayList<>();
    private TextView mScoreView , mQuestionView, juml, nosol;
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4, ne;

    private DatabaseReference dtref = FirebaseDatabase.getInstance().getReferenceFromUrl
            ("https://englishquiz-a0014-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private String mAnswer, level;
    private int mScore = 0;
    private int mQuestionNumber = 0; //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);
        ne = findViewById(R.id.next);
        ne.setOnClickListener(this);
        mButtonChoice1.setOnClickListener(this);
        mButtonChoice2.setOnClickListener(this);
        mButtonChoice3.setOnClickListener(this);
        mButtonChoice4.setOnClickListener(this);
        nosol = findViewById(R.id.nosoal);
        level = getIntent().getStringExtra("lev");

        dtref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot quizz : snapshot.child(level).getChildren()){
                    String getSoal = quizz.child("soal").getValue(String.class);
                    String getPil1 = quizz.child("pilihan1").getValue(String.class);
                    String getPil2 = quizz.child("pilihan2").getValue(String.class);
                    String getPil3 = quizz.child("pilihan3").getValue(String.class);
                    String getPil4 = quizz.child("pilihan4").getValue(String.class);
                    String getJawaban = (quizz.child("jawaban").getValue(String.class));
                    QuizList quiz = new QuizList(getSoal,getPil1,getPil2,getPil3,getPil4,getJawaban);
                    quizlist.add(quiz);
                }
                selectquiz(mQuestionNumber);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Easy.this, "Gagal Ambil Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selectquiz(int quizposition){
        if(mQuestionNumber<quizlist.size() ) {
            mQuestionView.setText(quizlist.get(quizposition).getSoal());
            mButtonChoice1.setText(quizlist.get(quizposition).getPil1());
            mButtonChoice2.setText(quizlist.get(quizposition).getPil2());
            mButtonChoice3.setText(quizlist.get(quizposition).getPil3());
            mButtonChoice4.setText(quizlist.get(quizposition).getPil4());
            mAnswer = quizlist.get(quizposition).getJawaban();
            nosol.setText("QUIZ "+(quizposition + 1));
            mQuestionNumber++;
            updateScore(mScore);
        }else {
            Intent intent = new Intent(Easy.this, Result.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            startActivity(intent);
            finish();
        }
    }
    private void updateScore(int point) {
        mScoreView.setText("SKOR " + mScore+"/"+quizlist.size()+0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.choice1:
                String pil1 = mButtonChoice1.getText().toString();
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice1.setEnabled(false);
                mButtonChoice4.setEnabled(false);
                if (pil1.equals(mAnswer)){
                    mScore = mScore + 10;
                    mButtonChoice1.setBackground(getResources().getDrawable(R.drawable.cusbutben));
                    Toast.makeText(Easy.this, "Benar!", Toast.LENGTH_SHORT).show();
                }else {
                    mButtonChoice1.setBackground(getResources().getDrawable(R.drawable.cusbutsal));
                    Toast.makeText(Easy.this, "Salah!", Toast.LENGTH_SHORT).show();
                }
                updateScore(mScore);
                break;
            case R.id.choice2:
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice1.setEnabled(false);
                mButtonChoice4.setEnabled(false);
                String pil2 = mButtonChoice2.getText().toString();
                if (pil2.equals(mAnswer)){
                    mScore = mScore + 10;
                    mButtonChoice2.setBackground(getResources().getDrawable(R.drawable.cusbutben));
                    Toast.makeText(Easy.this, "Benar!", Toast.LENGTH_SHORT).show();
                }else {
                    mButtonChoice2.setBackground(getResources().getDrawable(R.drawable.cusbutsal));
                    Toast.makeText(Easy.this, "Salah!", Toast.LENGTH_SHORT).show();
                }
                updateScore(mScore);
                break;
            case R.id.choice3:
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice1.setEnabled(false);
                mButtonChoice4.setEnabled(false);
                String pil3 = mButtonChoice3.getText().toString();
                if (pil3.equals(mAnswer)){
                    mScore = mScore + 10;
                    mButtonChoice3.setBackground(getResources().getDrawable(R.drawable.cusbutben));
                    Toast.makeText(Easy.this, "Benar!", Toast.LENGTH_SHORT).show();
                }else {
                    mButtonChoice3.setBackground(getResources().getDrawable(R.drawable.cusbutsal));
                    Toast.makeText(Easy.this, "Salah!", Toast.LENGTH_SHORT).show();
                }
                updateScore(mScore);
                break;
            case R.id.choice4:
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice1.setEnabled(false);
                mButtonChoice4.setEnabled(false);
                String pil4 = mButtonChoice4.getText().toString();
                if (pil4.equals(mAnswer)){
                    mScore = mScore + 10;
                    mButtonChoice4.setBackground(getResources().getDrawable(R.drawable.cusbutben));
                    Toast.makeText(Easy.this, "Benar!", Toast.LENGTH_SHORT).show();
                }else {
                    mButtonChoice4.setBackground(getResources().getDrawable(R.drawable.cusbutsal));
                    Toast.makeText(Easy.this, "Salah!", Toast.LENGTH_SHORT).show();
                }
                updateScore(mScore);
                break;
            case R.id.next:
                mButtonChoice2.setEnabled(true);
                mButtonChoice3.setEnabled(true);
                mButtonChoice1.setEnabled(true);
                mButtonChoice4.setEnabled(true);
                selectquiz(mQuestionNumber);
                mButtonChoice1.setBackground(getResources().getDrawable(R.drawable.cusbut));
                mButtonChoice2.setBackground(getResources().getDrawable(R.drawable.cusbut));
                mButtonChoice3.setBackground(getResources().getDrawable(R.drawable.cusbut));
                mButtonChoice4.setBackground(getResources().getDrawable(R.drawable.cusbut));
        }
    }
}