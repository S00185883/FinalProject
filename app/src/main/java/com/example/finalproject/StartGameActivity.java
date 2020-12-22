package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
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
    b1 = (Button) findViewById(R.id.button1);
    b2 = (Button) findViewById(R.id.button2);
    b3 = (Button) findViewById(R.id.button3);
    b4 = (Button) findViewById(R.id.button4);
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
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  MediaPlayer mp,mp1,mp2,mp3,mp4;//sonidos



  int contador=1;
  int level=0;

  Button b1,b2,b3, b4,b5;
  Handler handler = new Handler();//hilo 1
  Handler handler2 = new Handler();//hilo 2
  ArrayList<Integer>generate_game =new ArrayList<>(4); //array for game
  ArrayList<Integer>press_player=new ArrayList<>(4);// player array

  int time = 1000;



  // e comprueba con el aaraylist del jugador y el generado por el juego
  public void comprobar(){
    mp=MediaPlayer.create(this,R.raw.error_dog);
    final Toast txtlooser = Toast.makeText(getApplicationContext(), "You lost", Toast.LENGTH_SHORT);

    if (generate_game.size() == press_player.size()) {//si el tamaño de los dos es igual
      for (int i = 0; i < generate_game.size(); i++) {//recorro el array
        if (generate_game.get(i).equals(press_player.get(i))) {//compruebo que sean iguales
          visualizar();
        } else {
          mp.start();
          generate_game.clear();//borra arrays
          press_player.clear();
          txtlooser.show(); //si fallas muestra mensaje
          level=0;//reinicia el nivel

        }

      }



    }
  }

  public void sequence() {//pulsacion de cada boton en cada uno se añade un dato al array
    mp1=MediaPlayer.create(this,R.raw.sol);
    mp2=MediaPlayer.create(this,R.raw.re);
    mp3=MediaPlayer.create(this,R.raw.mi);
    mp4=MediaPlayer.create(this,R.raw.fa);



    //cada vez que pulsa el boton comprueba el tamaño del array
    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) { //ilumino la pulsacion
        b1.setBackgroundColor(Color.parseColor("#FFEA4D39"));
        pausa();//apago el boton
        press_player.add(1);//añado al array
        comprobar(); //comprobamos posicion

        mp1.start();// reproduce sonido

      }
    });
    b3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b3.setBackgroundColor(Color.parseColor("#FF73FF0E"));
        pausa();
        press_player.add(2);
        comprobar();
        mp2.start();


      }
    });
    b3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b3.setBackgroundColor(Color.parseColor("#FFF2D200"));
        pausa();
        press_player.add(3);
        comprobar();
        mp3.start();

      }
    });
    b4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        b4.setBackgroundColor(Color.parseColor("#FF02AAFF"));
        pausa();
        press_player.add(4);
        comprobar();
        mp4.start();


      }
    });


  }


  public void pausa() {

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
  public void game(View jugar) throws InterruptedException {//we must always pass a view so that it recognizes it in the content
    level++;
    game(level);//we increase the level as we progress

    b5.setText(" ");





  }

  public void visualizar() {
    //we visualize the punctuation in the start button
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

            generate_game.add(1);
            b1.setBackgroundColor(Color.parseColor("#FFEA4D39"));


            pausa();

            mp1.start();



          } else if (random == 2) {

            generate_game.add(2);
            b2.setBackgroundColor(Color.parseColor("#FF73FF0E"));
            pausa();
            mp2.start();




          } else if (random == 3) {
            generate_game.add(3);
            b3.setBackgroundColor(Color.parseColor("#FFF2D200"));
            pausa();
            mp3.start();




          } else if (random == 4) {

            generate_game.add(4);
            b4.setBackgroundColor(Color.parseColor("#FF02AAFF"));
            pausa();
            mp4.start();





          }


        }
      }, time * i + 30); //increases the waiting time for each button and illuminates


    }
    sequence();//we call the player's keystrokes to proceed to the comparison
  }


}


