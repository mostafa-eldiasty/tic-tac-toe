package com.forpracticing;

import android.widget.ImageView;

class Player2 extends Person {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void play(ImageView imageView) {
        if(imageView.getDrawable() == null) {
            imageView.setTranslationY(-1000);
            imageView.setImageResource(R.drawable.o);
            imageView.animate().translationYBy(1000).setDuration(1000);
        }
    }
}
