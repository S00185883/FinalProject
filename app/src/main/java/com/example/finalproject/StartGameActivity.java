package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartGameActivity extends AppCompatActivity implements SensorEventListener {

  int[] gameSequence = new int[120];
  private final int yellow = 1;
  private final int red = 2;
  private final int blue = 3;
  private final int green = 4;
  private SensorManager mSensorManager;
  private Sensor mSensor;

  int num = 0, usequence = -1, score = 0, count, round = 1;

  private final double NORTH_MOVE_FORWARD = 6;     // upper mag limit
  private final double NORTH_MOVE_BACKWARD = 9;      // lower mag limit

  private final double SOUTH_MOVE_FORWARD = 2;     // upper mag limit
  private final double SOUTH_MOVE_BACKWARD = 5;      // lower mag limit

  private final double EAST_MOVE_FORWARD = 1;     // upper mag limit
  private final double EAST_MOVE_BACKWARD = 0;      // lower mag limit

  private final double WEST_MOVE_FORWARD = 1;     // upper mag limit
  private final double WEST_MOVE_BACKWARD = 0;      // lower mag limit

  boolean highLimitNorth = false;      // detect high limit
  boolean highLimitSouth = false;      // detect high limit
  boolean highLimitEast = false;      // detect high limit
  boolean highLimitWest = false;      // detect high limit

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start_game);
    mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    gameSequence = getIntent().getIntArrayExtra("sequence");
    round = getIntent().getIntExtra("round", 1);
    score = getIntent().getIntExtra("score", 1);
    count = getIntent().getIntExtra("count", 3);

  }

  public void doClick(View view){
    score++;
    usequence++;

    switch (view.getId())
    {
      case(R.id.bRed) :
        num = 2;
        break;
      case(R.id.bYellow) :
        num = 1;
        break;
      case(R.id.bGreen) :
        num = 4;
        break;
      case(R.id.bBlue) :
        num = 3;
        break;
    }

    for( int i : gameSequence)
    {
      if(num == gameSequence[usequence])
      {

          round++;
          Intent mainIntent = new Intent(this, MainActivity.class);
          mainIntent.putExtra("score", score);
          mainIntent.putExtra("round", round);
          mainIntent.putExtra("counter", count);
          startActivity(mainIntent);

        return;

      }
      else if(num != gameSequence[usequence])
      {
        score=0;
        Intent gameOverActivity = new Intent(view.getContext(), GameOverActivity.class);
        gameOverActivity.putExtra("score", score);
        gameOverActivity.putExtra("round", round);

        startActivity(gameOverActivity);
        return;
      }
    }
  }
  protected void onResume() {
    super.onResume();
    mSensorManager.registerListener(this, mSensor,
            SensorManager.SENSOR_DELAY_NORMAL);
  }
  protected void onPause() {
    super.onPause();
    mSensorManager.unregisterListener(this);
  }
  @Override
  public void onSensorChanged(SensorEvent event) {
    float x = event.values[0];
    float y = event.values[1];
    float z = event.values[2];
    final Button northBtn = findViewById(R.id.bYellow);
    final Button southBtn = findViewById(R.id.bBlue);
    final Button eastBtn = findViewById(R.id.bGreen);
    final Button westBtn = findViewById(R.id.bRed);
    if ((x > NORTH_MOVE_FORWARD && z > 0) && (highLimitNorth == false)) {
      highLimitNorth = true;
    }
    if ((x < NORTH_MOVE_BACKWARD && z > 0) && (highLimitNorth == true)) {
      // we have a tilt to the NORTH
      highLimitNorth = false;

      Handler handler = new Handler();
      Runnable r = new Runnable() {
        public void run() {

          northBtn.setPressed(true);
          northBtn.invalidate();
          northBtn.performClick();
          Handler handler1 = new Handler();
          Runnable r1 = new Runnable() {
            public void run() {
              northBtn.setPressed(false);
              northBtn.invalidate();
            }
          };
          handler1.postDelayed(r1, 600);

        } // end runnable
      };
      handler.postDelayed(r, 600);


    }

    // South Movement
    if ((x < SOUTH_MOVE_FORWARD && z < 0) && (highLimitSouth == false)) {
      highLimitSouth = true;
    }
    if ((x > SOUTH_MOVE_BACKWARD && z < 0) && (highLimitSouth == true)) {
      highLimitSouth = false;


      Handler handler = new Handler();
      Runnable r = new Runnable() {
        public void run() {

          southBtn.setPressed(true);
          southBtn.invalidate();
          southBtn.performClick();
          Handler handler1 = new Handler();
          Runnable r1 = new Runnable() {
            public void run() {
              southBtn.setPressed(false);
              southBtn.invalidate();
            }
          };
          handler1.postDelayed(r1, 600);

        } // end runnable
      };
      handler.postDelayed(r, 600);


    }

    // East Movement
    if (y > EAST_MOVE_FORWARD && highLimitEast == false) {
      highLimitEast = true;
    }
    if (y < EAST_MOVE_BACKWARD && highLimitEast == true) {
      // we have a tilt to the EAST
      highLimitEast = false;


      Handler handler = new Handler();
      Runnable r = new Runnable() {
        public void run() {

          eastBtn.setPressed(true);
          eastBtn.invalidate();
          eastBtn.performClick();
          Handler handler1 = new Handler();
          Runnable r1 = new Runnable() {
            public void run() {
              eastBtn.setPressed(false);
              eastBtn.invalidate();
            }
          };
          handler1.postDelayed(r1, 600);

        }
      };
      handler.postDelayed(r, 600);


    }

    if (y < WEST_MOVE_FORWARD && highLimitWest == false) {
      highLimitWest = true;
    }
    if (y > WEST_MOVE_BACKWARD && highLimitWest == true) {
      highLimitWest = false;


      Handler handler = new Handler();
      Runnable r = new Runnable() {
        public void run() {

          westBtn.setPressed(true);
          westBtn.invalidate();
          westBtn.performClick();
          Handler handler1 = new Handler();
          Runnable r1 = new Runnable() {
            public void run() {
              westBtn.setPressed(false);
              westBtn.invalidate();
            }
          };
          handler1.postDelayed(r1, 600);

        } // end runnable
      };
      handler.postDelayed(r, 600);


    }

  }


  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {
    // not used
  }

  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
  }



}
