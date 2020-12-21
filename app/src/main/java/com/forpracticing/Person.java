package com.forpracticing;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public abstract class Person {
    public static int turn = 1;
    private int score = 0;

    public Person() {
    }

    public abstract void play(ImageView imageView);

    public static boolean checkWinner(int[] playersSymbols) {

        for (int i = 0; i < 9; i += 3)
            if (playersSymbols[i] == playersSymbols[i + 1] && playersSymbols[i] == playersSymbols[i + 2] && playersSymbols[i] != 0)
                return true;
        for (int i = 0; i < 3; i++)
            if (playersSymbols[i] == playersSymbols[i + 3] && playersSymbols[i] == playersSymbols[i + 6] && playersSymbols[i] != 0)
                return true;

        if (playersSymbols[0] == playersSymbols[4] && playersSymbols[0] == playersSymbols[8] && playersSymbols[0] != 0)
            return true;
        else if (playersSymbols[2] == playersSymbols[4] && playersSymbols[2] == playersSymbols[6] && playersSymbols[2] != 0)
            return true;

        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
