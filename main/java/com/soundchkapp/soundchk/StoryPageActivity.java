package com.soundchkapp.soundchk;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;


public class StoryPageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storypage);

        TextView tv = (TextView) findViewById(R.id.textView);
        ImageView iv1 = (ImageView) findViewById(R.id.imglocked1);
        ImageView iv2 = (ImageView) findViewById(R.id.imglocked2);
        ImageView iv3 = (ImageView) findViewById(R.id.imglocked3);

        switch (getIntent().getStringExtra("unlocked")) {
            case "griffs":
                tv.setBackgroundResource(R.drawable.griffs_full);
                tv.setText(R.string.dr_griffs_title_text);
                break;
            case "little":
                tv.setBackgroundResource(R.drawable.little_box_full);
                tv.setText(R.string.text_the_little_box);
                break;
            case "concert":
                tv.setBackgroundResource(R.drawable.pinegrove_full);
                tv.setText(R.string.text_concert_reviews);
                break;
            case "lavaque":
                tv.setBackgroundResource(R.drawable.lavaque_full);
                tv.setText(R.string.text_rob_lavaque);
                break;
            case "events":
                tv.setBackgroundResource(R.drawable.events_full);
                tv.setText(R.string.text_events);
                break;
            case "album":
                tv.setBackgroundResource(R.drawable.album_full);
                tv.setText(R.string.text_album_reviews);
                break;

        }

        if (getIntent().getStringExtra("locked") != null) {
            switch (getIntent().getStringExtra("locked")) {
                case "griffs":
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7")
                            .into(iv1);
                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/1.png?alt=media&token=96b9afec-389a-4a78-8889-cf924e11e8ee")

                            .into(iv2);
                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266")
                            .into(iv3);
                    break;
                case "little":
                    tv.setBackgroundResource(R.drawable.little_box_full);
                    tv.setText(R.string.text_the_little_box);
                    break;
                case "concert":
                    tv.setBackgroundResource(R.drawable.pinegrove_full);
                    tv.setText(R.string.text_concert_reviews);
                    break;
                case "lavaque":
                    tv.setBackgroundResource(R.drawable.lavaque_full);
                    tv.setText(R.string.text_rob_lavaque);
                    break;
                case "events":
                    tv.setBackgroundResource(R.drawable.events_full);
                    tv.setText(R.string.text_events);
                    break;
                case "album":
                    tv.setBackgroundResource(R.drawable.album_full);
                    tv.setText(R.string.text_album_reviews);
                    break;
            }
        }

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


    /*
    public static void scrollViewToPosition(View view, int position) {
        if (view instanceof ListView) {
            ListView listView = ((ListView) view);
            listView.smoothScrollToPosition(position);
        } else {
            Log.d("TAG", "This is not a list view.");
        }
    }*/


}
