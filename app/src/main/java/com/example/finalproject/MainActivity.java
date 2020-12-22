package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        Button b= (Button) findViewById(R.id.btnPlay);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                startActivity(new Intent(MainActivity.this,StartGameActivity.class ));
            }
        });

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