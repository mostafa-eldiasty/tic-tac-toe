package com.forpracticing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class MainActivity extends Activity {

        Person player1,player2;
        int[] arr = {0,0,0,0,0,0,0,0,0};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                player1 = new Player1();
                player2 = new Player2();
        }

        public void playerClicked(View view) {
                if(Person.turn == 1) {
                        player1.play((ImageView) view);
                        Person.turn = 2;
                        arr[Integer.valueOf(view.getTag().toString())] = 1;

                        if(Person.checkWinner(arr)) {
                                Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show();
                                clear();
                                player1.setScore(player1.getScore() + 1);
                                TextView player1TextView = findViewById(R.id.player1TextView);
                                player1TextView.setText("Player1: " + player1.getScore());
                                Person.turn = 1;
                        }
                }
                else {
                        player2.play((ImageView) view);
                        Person.turn = 1;
                        arr[Integer.valueOf(view.getTag().toString())] = 2;

                        if(Person.checkWinner(arr)) {
                                Toast.makeText(this, "Player2 wins", Toast.LENGTH_SHORT).show();
                                clear();
                                player2.setScore(player2.getScore() + 1);
                                TextView player2TextView = findViewById(R.id.player2TextView);
                                player2TextView.setText("Player2: " + player2.getScore());
                                Person.turn = 2;
                        }
                }

                boolean isContainsZero = false;
                for(int element:arr)
                        if(element == 0){
                                isContainsZero = true;
                                break;
                        }

                if(!isContainsZero) {
                        Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
                        Person.turn = (Person.turn == 1)?2:1;
                        clear();
                }

        }

        public void clear(){
                for(int i = 0; i < arr.length; i++){
                        arr[i] = 0;
                        int id = getResources().getIdentifier("imageView" + i, "id", getPackageName());
                        ImageView pieceImage = findViewById(id);
                        pieceImage.setImageDrawable(null);
                }

        }
}