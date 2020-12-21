package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button bRed, bBlue, bOrange, bGreen, fb;
    int sequenceCount = 4, n = 0;
    private Object mutex = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bRed = findViewById(R.id.bRed);
        bBlue = findViewById(R.id.bBlue);
        bOrange = findViewById(R.id.bOrange);
        bGreen = findViewById(R.id.bGreen);
        DatabaseHandler db = new DatabaseHandler(this);

        db.emptyHiScores();     // empty table if required

        // Inserting hi scores
        Log.i("Insert: ", "Inserting ..");
        db.addHiScore(new HiScore("20 OCT 2020", "Frodo", 12));
        db.addHiScore(new HiScore("28 OCT 2020", "Dobby", 16));
        db.addHiScore(new HiScore("20 NOV 2020", "DarthV", 20));
        db.addHiScore(new HiScore("20 NOV 2020", "Bob", 18));
        db.addHiScore(new HiScore("22 NOV 2020", "Gemma", 22));
        db.addHiScore(new HiScore("30 NOV 2020", "Joe", 30));
        db.addHiScore(new HiScore("01 DEC 2020", "DarthV", 22));
        db.addHiScore(new HiScore("02 DEC 2020", "Gandalf", 132));


        // Reading all scores
        Log.i("Reading: ", "Reading all scores..");
        List<HiScore> hiScores = db.getAllHiScores();


        for (HiScore hs : hiScores) {
            String log =
                    "Id: " + hs.getScore_id() +
                            ", Date: " + hs.getGame_date() +
                            " , Player: " + hs.getPlayer_name() +
                            " , Score: " + hs.getScore();

            // Writing HiScore to log
            Log.i("Score: ", log);
        }

        Log.i("divider", "====================");

        HiScore singleScore = db.getHiScore(5);
        Log.i("High Score 5 is by ", singleScore.getPlayer_name() + " with a score of " +
                singleScore.getScore());

        Log.i("divider", "====================");

        // Calling SQL statement
        List<HiScore> top5HiScores = db.getTopFiveScores();

        for (HiScore hs : top5HiScores) {
            String log =
                    "Id: " + hs.getScore_id() +
                            ", Date: " + hs.getGame_date() +
                            " , Player: " + hs.getPlayer_name() +
                            " , Score: " + hs.getScore();

            // Writing HiScore to log
            Log.i("Score: ", log);
        }
        Log.i("divider", "====================");

        HiScore hiScore = top5HiScores.get(top5HiScores.size() - 1);
        // hiScore contains the 5th highest score
        Log.i("fifth Highest score: ", String.valueOf(hiScore.getScore()) );

        // simple test to add a hi score
        int myCurrentScore = 40;
        // if 5th highest score < myCurrentScore, then insert new score
        if (hiScore.getScore() < myCurrentScore) {
            db.addHiScore(new HiScore("08 DEC 2020", "Elrond", 40));
        }

        Log.i("divider", "====================");

        // Calling SQL statement
        top5HiScores = db.getTopFiveScores();

        for (HiScore hs : top5HiScores) {
            String log =
                    "Id: " + hs.getScore_id() +
                            ", Date: " + hs.getGame_date() +
                            " , Player: " + hs.getPlayer_name() +
                            " , Score: " + hs.getScore();

            // Writing HiScore to log
            Log.i("Score: ", log);
        }

    }

    public void doPlay(View view) {

        for (int i = 0; i < sequenceCount; i++) {
            // Need to generate a random sequence
            // start at 4 values, increase by 2 every time
            n = getRandom(sequenceCount);

            Toast.makeText(this, "Number = " + String.valueOf(n), Toast.LENGTH_SHORT).show();

            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch (n) {
                        case 1:
                            flashButton(bBlue);
                            break;
                        case 2:
                            flashButton(bRed);
                            break;
                        case 3:
                            flashButton(bOrange);
                            break;
                        case 4:
                            flashButton(bGreen);
                            break;
                        default:
                            break;
                    }   // end switch
                }
            }, 1000);
        }  // end loop
    }

    //
    // return a number between 1 and maxValue
    private int getRandom(int maxValue) {
        int rn = (int) ((Math.random() * maxValue) + 1);
        return (rn);
    }

    private void flashButton(Button button) {
        fb = button;
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {

                fb.setPressed(true);
                fb.invalidate();
                fb.performClick();
                Handler handler1 = new Handler();
                Runnable r1 = new Runnable() {
                    public void run() {
                        fb.setPressed(false);
                        fb.invalidate();
                    }
                };
                handler1.postDelayed(r1, 600);

            } // end runnable
        };
        handler.postDelayed(r, 600);
    }

    public void doTest(View view) {
        for (int i = 0; i < sequenceCount; i++) {
            int x = getRandom(sequenceCount);

            Toast.makeText(this, "Number = " + String.valueOf(x), Toast.LENGTH_SHORT).show();

            if (x == 1)
                flashButton(bBlue);
            else if (x == 2)
                flashButton(bRed);
            else if (x == 3)
                flashButton(bOrange);
            else if (x == 4)
                flashButton(bGreen);
        }

    }
}