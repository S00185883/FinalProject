package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameOverActivity extends AppCompatActivity {
TextView score;
    int playerScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
       // listView = findViewById(R.id.lv);
        playerScore= getIntent().getIntExtra("score", -1);
        score=findViewById(R.id.tvScore);
        score.setText("Your Score was "+String.valueOf(playerScore));


    }

    public void doPlayAgain(View view) {
        Intent playAgain = new Intent(view.getContext(), MainActivity.class);
        startActivity(playAgain);
    }

    public void onClick(View view) {
    }

    public void doHighScores(View view) {
        Intent showHi = new Intent(view.getContext(), HiScoreActivity.class);
        showHi.putExtra("score", playerScore);
        startActivity(showHi);

    }
}