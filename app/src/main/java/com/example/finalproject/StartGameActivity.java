package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class StartGameActivity extends AppCompatActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start_game);
    b1 = (Button) findViewById(R.id.btnFirst);
    b2 = (Button) findViewById(R.id.btnSecond);
    b3 = (Button) findViewById(R.id.btnThird);
    b4 = (Button) findViewById(R.id.btnFourth);
    b5 = (Button) findViewById(R.id.button5);


  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }



  int counter=1;
  int level=0;
  int levelcounter=0;
  Button b1,b2,b3, b4,b5;
  Handler handler = new Handler();
  Handler handler2 = new Handler();
  ArrayList<Integer> game_sequence =new ArrayList<>(4);
  ArrayList<Integer> player_sequence =new ArrayList<>(4);

  int time = 1000;

  public void check(){
    final Toast txtlooser = Toast.makeText(getApplicationContext(), "You lost", Toast.LENGTH_SHORT);

    if (game_sequence.size() == player_sequence.size()) {//if the size of the two is equal
      for (int i = 0; i < game_sequence.size(); i++) {//go through the array
        if (game_sequence.get(i).equals(player_sequence.get(i))) {//check they are the same
          popup();
          levelcounter=level;
        } else {

          Intent showGameOver = new Intent(this, GameOverActivity.class);
          showGameOver.putExtra("score", levelcounter);
          startActivity(showGameOver);
          game_sequence.clear();//reset the arrays
          player_sequence.clear();
          txtlooser.show(); //if you fail show message
          level=0;//restart the level

        }
      }
    }
  }

  public void sequence() {
    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b1.setBackgroundColor(Color.parseColor("#FFEA4D39"));
        stop();
        player_sequence.add(1);
        check();
      }
    });
    b3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b3.setBackgroundColor(Color.parseColor("#FF73FF0E"));
        stop();
        player_sequence.add(2);
        check();
      }
    });
    b3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b3.setBackgroundColor(Color.parseColor("#FFF2D200"));
        stop();
        player_sequence.add(3);
        check();
      }
    });
    b4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b4.setBackgroundColor(Color.parseColor("#FF02AAFF"));
        stop();
        player_sequence.add(4);
        check();
      }
    });
  }
  public void stop() {
    handler.postDelayed(new Runnable() {//apagamos los botones
      @Override
      public void run() {
        b1.setBackgroundColor(Color.parseColor("#FF560A00"));
        b2.setBackgroundColor(Color.parseColor("#FF005000"));
        b3.setBackgroundColor(Color.parseColor("#FF705B00"));
        b4.setBackgroundColor(Color.parseColor("#FF00476B"));
      }
    },  150);//wait to turn on and turn off
  }
  // }
  public void game(View game) throws InterruptedException {//we must always pass a view so that it recognizes it in the content
    level++;
    game(level);//we increase the level as we progress
    b5.setText(" ");
  }

  public void popup() {
    //we show the message in the start button
    TextView txtPuntos = (TextView) findViewById(R.id.button5);
    txtPuntos.setText("Level: " +level+" passed  \n Press again \n when you are ready");
  }
  public void game(int level) throws InterruptedException {// game execution
    this.level=level;
    for (int i = 0; i < level; i++) {//increases difficulty

      handler2.postDelayed(new Runnable() {
        @Override

        public void run() {

          int random = (int) Math.floor(Math.random() * 4 + 1);

          if (random == 1) {

            game_sequence.add(1);
            b1.setBackgroundColor(Color.parseColor("#FFEA4D39"));
            stop();
          } else if (random == 2) {

            game_sequence.add(2);
            b2.setBackgroundColor(Color.parseColor("#FF73FF0E"));
            stop();
          } else if (random == 3) {
            game_sequence.add(3);
            b3.setBackgroundColor(Color.parseColor("#FFF2D200"));
            stop();
          } else if (random == 4) {

            game_sequence.add(4);
            b4.setBackgroundColor(Color.parseColor("#FF02AAFF"));
            stop();
          }
          final Toast txtlooser = Toast.makeText(getApplicationContext(), "Your go", Toast.LENGTH_SHORT);
        }
      }, time * i + 30); //increases the waiting time for each button and illuminates
    }
    sequence();//we call the player's keystrokes to proceed to the comparison
    final Toast txtlooser = Toast.makeText(getApplicationContext(), "Your go", Toast.LENGTH_SHORT);

  }


}


