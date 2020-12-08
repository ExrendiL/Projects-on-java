package com.example.user.zvyk;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv1, iv2;
    private MediaPlayer cat, dog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1 = (ImageView) findViewById(R.id.imageView3);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        cat = MediaPlayer.create(this, R.raw.mew);
        dog = MediaPlayer.create(this, R.raw.bark);
        imcl();
    }

    public void imcl() {
        iv1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(cat);
                    }
                }
        );
        iv2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        soundPlay(dog);

                    }
                }
        );
    }

    public void soundPlay(MediaPlayer sound) {
        sound.start();

    }
}

