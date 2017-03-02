package com.soundchkapp.soundchk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;

public class StoryPageActivity extends AppCompatActivity {

    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storypage);

        final TextView tv = (TextView) findViewById(R.id.textView);
        TextView lockedtext = (TextView) findViewById(R.id.lockedtext);
        TextView story_locked = (TextView) findViewById(R.id.story_locked);
        LinearLayout locked_holder = (LinearLayout) findViewById(R.id.locked_holder);
        final ImageButton iv1 = (ImageButton) findViewById(R.id.imglocked1);
        final ImageButton iv2 = (ImageButton) findViewById(R.id.imglocked2);
        final ImageButton iv3 = (ImageButton) findViewById(R.id.imglocked3);

        switch (getIntent().getStringExtra("unlocked")) {

            case "griffs":
                tv.setBackgroundResource(R.drawable.griffs_full);
                tv.setText(R.string.dr_griffs_title_text);
                iv1.setScaleType(ImageView.ScaleType.FIT_XY);
                iv2.setScaleType(ImageView.ScaleType.FIT_XY);
                iv3.setScaleType(ImageView.ScaleType.FIT_XY);

                if (getIntent().getStringExtra("locked") == "griffs") {
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7")
                            .into(iv1);
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/griffs_outline.png?alt=media&token=6fecdebe-e75c-4fbf-8a9a-0d577e693fad")
                            .into(iv2);
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266")
                            .into(iv3);
                }
                break;

            case "juicy":
                tv.setBackgroundResource(R.drawable.juicy_full);
                tv.setText(R.string.text_juicy_title_text);
                iv1.setScaleType(ImageView.ScaleType.FIT_XY);
                iv2.setScaleType(ImageView.ScaleType.FIT_XY);
                iv3.setScaleType(ImageView.ScaleType.FIT_XY);

                if (getIntent().getStringExtra("locked") == "griffs") {
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a")
                            .into(iv1);
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a")
                            .into(iv2);
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a")
                            .into(iv3);
                }

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

                iv1.setScaleType(ImageView.ScaleType.FIT_XY);
                iv2.setScaleType(ImageView.ScaleType.FIT_XY);
                iv3.setScaleType(ImageView.ScaleType.FIT_XY);

                if (getIntent().getStringExtra("locked") == "lavaque") {
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9")
                            .into(iv1);
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9")
                            .into(iv2);
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9")
                            .into(iv3);
                }

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
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/1.png?alt=media&token=96b9afec-389a-4a78-8889-cf924e11e8ee")
                            .into(iv2);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266")
                            .into(iv3);

                    story_locked.setVisibility(View.VISIBLE);

                    iv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "griffs1");
                            startActivity(intent);
                        }
                    });

                    iv2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "griffs2");
                            startActivity(intent);
                        }
                    });

                    iv3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "griffs3");
                            startActivity(intent);
                        }
                    });

                    break;

                case "juicy":
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a")
                            .into(iv2);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a")
                            .into(iv3);

                    story_locked.setVisibility(View.VISIBLE);

                    iv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "juicy1");
                            startActivity(intent);
                        }
                    });

                    iv2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "juicy1");
                            startActivity(intent);
                        }
                    });

                    iv3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "juicy1");
                            startActivity(intent);
                        }
                    });

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
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9")
                            .into(iv2);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9")
                            .into(iv3);

                    story_locked.setVisibility(View.VISIBLE);

                    iv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "lavaque1");
                            startActivity(intent);
                        }
                    });

                    iv2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "lavaque1");
                            startActivity(intent);
                        }
                    });

                    iv3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "lavaque1");
                            startActivity(intent);
                        }
                    });



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
