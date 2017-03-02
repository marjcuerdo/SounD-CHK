package com.soundchkapp.soundchk;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageFullViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full_view);

        ImageView fullImgView = (ImageView) findViewById(R.id.fullImgView);

        switch (getIntent().getStringExtra("fullimg")) {
            case "griffs1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7")
                        .into(fullImgView);
                break;

            case "griffs2":
                fullImgView.setBackgroundColor(Color.WHITE);
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/1.png?alt=media&token=96b9afec-389a-4a78-8889-cf924e11e8ee")
                        .into(fullImgView);
                break;

            case "griffs3":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266")
                        .into(fullImgView);
                break;

            case "juicy1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a")
                        .into(fullImgView);
                break;

            case "lavaque1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9")
                        .into(fullImgView);
                break;
        }


    }
}
