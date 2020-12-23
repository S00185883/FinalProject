package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button yellowBtn, redBtn, greenBtn, blueBtn, FB;



TextView showScore;
    int counter, randomNumber = 0, round, score, count,increase;
    int[] game_pattern = new int[120];
    int arrayCount = 0;
    private final int yellow = 1;
    private final int red = 2;
    private final int blue = 3;
    private final int green = 4;

    CountDownTimer countDown1 = new CountDownTimer(6000,  1500) {

        public void onTick(long millis) {
            oneButton();
        }
        public void onFinish() {
            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("count", count);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDown2 = new CountDownTimer(9000,  1500) {

        public void onTick(long millis) {
            oneButton();
        }
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("count", count);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDown3 = new CountDownTimer(12000,  1500) {

        public void onTick(long millis) {
            oneButton();
        }
        public void onFinish() {
            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("count", count);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDown4 = new CountDownTimer(15000,  1500) {

        public void onTick(long millis) {
            oneButton();
        }
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("count", count);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDown5 = new CountDownTimer(18000,  1500) {

        public void onTick(long millis) {
            oneButton();
        }
        public void onFinish() {
            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));

            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("count", count);
            startActivity(patternInfo);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showScore=findViewById(R.id.tvScore);
        showScore.setText("Score: "+score);
        greenBtn = findViewById(R.id.bGreen);
        redBtn = findViewById(R.id.bRed);
        yellowBtn = findViewById(R.id.bYellow);
        blueBtn = findViewById(R.id.bBlue);
        counter=3+round;
        score = getIntent().getIntExtra("score", 0);
        round = getIntent().getIntExtra("round", 1);
        increase = getIntent().getIntExtra("increase", 2);

    }


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    CountDownTimer countDownTimerR1 = new CountDownTimer(6000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDownTimerR2 = new CountDownTimer(9000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDownTimerR3 = new CountDownTimer(12000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));

            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDownTimerR4 = new CountDownTimer(15000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            // start next activity

            // put the sequence into the next activity
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
            // start the next activity
        }
    };
    CountDownTimer countDownTimerR5 = new CountDownTimer(18000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));

            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);

        }
    };
    CountDownTimer countDownTimerR6 = new CountDownTimer(6000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDownTimerR7 = new CountDownTimer(9000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));

            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDownTimerR8 = new CountDownTimer(12000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDownTimerR9 = new CountDownTimer(15000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
        }
    };
    CountDownTimer countDownTimerR10 = new CountDownTimer(18000,  1500) {

        public void onTick(long millisUntilFinished) {
            oneButton();
        }

        @Override
        public void onFinish() {

            for (int i = 0; i< arrayCount; i++)
                Log.d("game sequence", String.valueOf(game_pattern[i]));
            Intent patternInfo = new Intent(MainActivity.this, StartGameActivity.class);
            patternInfo.putExtra("sequence", game_pattern);
            patternInfo.putExtra("round", round);
            patternInfo.putExtra("score", score);
            patternInfo.putExtra("increase", increase);
            startActivity(patternInfo);
        }
    };

    public void doPlay(View view) {

        switch  (round)
        {
            case(1):
                countDownTimerR1.start();
                break;
            case(2):
                countDownTimerR2.start();
                break;
            case(3):
                countDownTimerR3.start();
                break;
            case(4):
                countDownTimerR4.start();
                break;
            case(5):
                countDownTimerR5.start();
                break;
            case(6):
                countDownTimerR6.start();
                break;
            case(7):
                countDownTimerR7.start();
                break;
            case(8):
                countDownTimerR8.start();
                break;
            case(9):
                countDownTimerR9.start();
                break;
            case(10):
                countDownTimerR10.start();
                break;
        }
    }

    private void oneButton() {
        randomNumber = getRandom(counter);

counter=3+round;
        switch (randomNumber) {
            case 1:
                flashButton(yellowBtn);
                game_pattern[arrayCount++] = yellow;
                break;
            case 2:
                flashButton(redBtn);
                game_pattern[arrayCount++] = red;
                break;
            case 3:
                flashButton(blueBtn);
                game_pattern[arrayCount++] = blue;
                break;
            case 4:
                flashButton(greenBtn);
                game_pattern[arrayCount++] = green;
                break;
            default:
                break;
        }
    }

    private int getRandom(int maxValue) {
        return ((int) ((Math.random() * maxValue) + 1));
    }

    private void flashButton(Button button) {
        FB = button;
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {

                FB.setPressed(true);
                FB.invalidate();
                FB.performClick();
                Handler handler1 = new Handler();
                Runnable r1 = new Runnable() {
                    public void run() {
                        FB.setPressed(false);
                        FB.invalidate();
                    }
                };
                handler1.postDelayed(r1, 600);

            } // end runnable
        };
        handler.postDelayed(r, 600);
    }
};