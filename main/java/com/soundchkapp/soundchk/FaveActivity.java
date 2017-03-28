package com.soundchkapp.soundchk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fave);

        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences1.edit();

        LinearLayout container_faves = (LinearLayout) findViewById(R.id.container_faves);
        LinearLayout container_parent = (LinearLayout) findViewById(R.id.container_parent);
        //ImageButton btnGreen = new ImageButton(this);

            switch (getIntent().getStringExtra("fave")) {
                case "vids":
                    if (preferences1.contains("storefavevid_griffs1")) {
                        editor.remove("status");
                        editor.commit();
                        addSavedVid(container_faves, "https://drive.google.com/file/d/0B-xS4tngSiksakJWaS14cWRIS3c/view?usp=sharing");
                    }
                    if (preferences1.contains("storefavevid_griffs2")) {
                        editor.remove("status");
                        editor.commit();
                        addSavedVid(container_faves, "https://drive.google.com/file/d/0B-xS4tngSiksakJWaS14cWRIS3c/view?usp=sharing");
                    }
                    if (preferences1.contains("storefavevid_griffs3")) {
                        editor.remove("status");
                        editor.commit();
                        addSavedVid(container_faves, "https://drive.google.com/file/d/0B-xS4tngSiksakJWaS14cWRIS3c/view?usp=sharing");
                    }
                    if (preferences1.contains("status")) {
                        emptyMessage(container_parent);
                    }
                    break;
                case "images":
                    if (preferences1.contains("storefaveimg_griffs1")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7");
                    }
                    if (preferences1.contains("storefaveimg_griffs2")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/1.png?alt=media&token=96b9afec-389a-4a78-8889-cf924e11e8ee");
                    }
                    if (preferences1.contains("storefaveimg_griffs3")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266");
                    }
                    if (preferences1.contains("storefaveimg_juicy1")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a");
                    }
                    if (preferences1.contains("status")) {
                        emptyMessage(container_parent);
                    }
                    break;
                case "audio":
                    if (preferences1.contains("status")) {
                        emptyMessage(container_parent);
                    }
                    break;
            }



    }

    public void addSavedImg(LinearLayout linearLayout, String url) {
        ImageButton btn = new ImageButton(this);

        Glide.with(this.getApplicationContext())
                //.using(new FirebaseImageLoader())
                .load(url)
                .into(btn);

        linearLayout.addView(btn);
    }

    public void addSavedVid(LinearLayout linearLayout, final String url) {
        ImageButton btn = new ImageButton(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        });

        linearLayout.addView(btn);
    }

    public void emptyMessage(LinearLayout linearLayout) {
        TextView tv = new TextView(this);
        tv.setText(R.string.text_no_saves);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(35);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setGravity(Gravity.CENTER);
        linearLayout.addView(tv);
    }


}
