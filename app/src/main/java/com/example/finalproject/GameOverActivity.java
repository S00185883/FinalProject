package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GameOverActivity extends AppCompatActivity {
    int score,playerScore;
    TextView scoreText;
    public EditText name;
    public DatabaseHandler databaseScores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
       // listView = findViewById(R.id.lv);
         playerScore = 7;
        scoreText=findViewById(R.id.tvScore);
        scoreText.setText("Your Score was "+String.valueOf(playerScore));
        name = findViewById(R.id.etName);

    }

    public void doPlayAgain(View view) {
        Intent playAgain = new Intent(view.getContext(), MainActivity.class);
        playAgain.putExtra("score", 0);
        startActivity(playAgain);
    }


    public void onAdd(View view) {
        List<HiScore> topHighScores;

        if(name.getText().toString() != ""){

            String userName = name.getText().toString();

            String date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());

            databaseScores.addHiScore(new HiScore(date, userName, score));

            topHighScores = databaseScores.getTopFiveScores();

            for (HiScore newHighScore : topHighScores) {
                String log =
                                "Id: " + newHighScore.getScore_id() +
                                " , Player: " + newHighScore.getPlayer_name() +
                                " , Score: " + newHighScore.getScore();

                // Writing HiScore to log
                Log.i("Score: ", log);
            }
        }


    }

    public void doHighScores(View view) {
        Intent showHiScore = new Intent(view.getContext(), HiScoreActivity.class);
        startActivity(showHiScore);
    }
}