package com.soundchkapp.soundchk;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "griffs3":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "griffs4":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3511.jpg?alt=media&token=979728d1-ce96-4e68-ad24-42b4f69dd991")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "griffs5":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3569.jpg?alt=media&token=1b3b7a6d-ceed-4cd9-8b8a-c39604207450")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "juicy1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3728.jpg?alt=media&token=4bfae885-54cc-46e8-bffe-50784d0fa157")
                        .into(fullImgView);
                break;

            case "juicy2":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3750.jpg?alt=media&token=6b971eb0-6a1b-4215-a8cd-507b4c227534")
                        .into(fullImgView);
                break;

            case "juicy3":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3777.jpg?alt=media&token=af405f11-daba-4ff2-9f36-9ee21aa17811")
                        .into(fullImgView);
                break;

            case "juicy4":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3779.jpg?alt=media&token=b4bf7552-708b-4207-956f-18b7198d67af")
                        .into(fullImgView);
                break;

            case "juicy5":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3801.jpg?alt=media&token=afbe6ee2-f57b-4d1d-97b5-74907498f0c7")
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
