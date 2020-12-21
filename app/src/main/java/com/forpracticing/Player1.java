package com.forpracticing;

import android.widget.ImageView;

class Player1 extends Person {
    private int score = 0;

    @Override
    public void play(ImageView imageView) {
        if(imageView.getDrawable() == null) {
            imageView.setTranslationY(-1000);
            imageView.setImageResource(R.drawable.x);
            imageView.animate().translationYBy(1000).setDuration(1000);
        }
    }


    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }
}
