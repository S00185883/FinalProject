package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
       // listView = findViewById(R.id.lv);


    }

    public void doPlayAgain(View view) {
    }

    public void onClick(View view) {
    }

    public void doHighScores(View view) {
        Intent showHi = new Intent(view.getContext(), HiScoreActivity.class);

    }
}