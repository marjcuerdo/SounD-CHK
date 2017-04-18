package com.soundchkapp.soundchk;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubePlayer;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;


import android.media.MediaPlayer;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ScrollView;
import android.graphics.Point;


import java.util.Objects;

public class StoryPageActivity extends AppCompatActivity{

    public Intent intent;
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    public String url_link = "1iEd1aVe7R0";
    //final MediaPlayer mp = MediaPlayer.create(this, R.raw.samplesound);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storypage);

        final TextView tv = (TextView) findViewById(R.id.textView);
        TextView lockedtext = (TextView) findViewById(R.id.lockedtext);
        TextView story_locked = (TextView) findViewById(R.id.story_locked);
        LinearLayout locked_holder = (LinearLayout) findViewById(R.id.locked_holder);
        LinearLayout locked_holder2 = (LinearLayout) findViewById(R.id.extra_locked_holder);
        final ImageButton iv1 = (ImageButton) findViewById(R.id.imglocked1);
        final ImageButton iv2 = (ImageButton) findViewById(R.id.imglocked2);
        final ImageButton iv3 = (ImageButton) findViewById(R.id.imglocked3);
        final ImageButton iv4 = (ImageButton) findViewById(R.id.imglocked4);
        final ImageButton iv5 = (ImageButton) findViewById(R.id.imglocked5);
        final ImageButton iv6 = (ImageButton) findViewById(R.id.imglocked6);
        final ImageButton button_scroll_down = (ImageButton) findViewById(R.id.button_scroll_down);
        //youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

        //youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        final SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = preferences1.edit();

        String url1 = "";
        String url2 = "";
        String url3 = "";
        String url4 = "";

        button_scroll_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                intent.putExtra("fullimg", "little1");
                startActivity(intent);*/
                ScrollView scrollView = (ScrollView)findViewById(R.id.scroll_view);
                View targetView = findViewById(R.id.lockedtext);
                scrollView.smoothScrollTo(0,targetView.getTop());
                //targetView.getParent().requestChildFocus(targetView,targetView);
            }
        });




        // unlocked with QR; same access as open from feed button

        switch (getIntent().getStringExtra("unlocked")) {

            case "griffs":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/griffs_outline.png?alt=media&token=6fecdebe-e75c-4fbf-8a9a-0d577e693fad";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266";

                setLockedStoryPage(tv, R.drawable.final_story_griffs, R.string.dr_griffs_title_text, iv1, iv2, iv3, "griffs", url1, url2, url3, locked_holder);

                break;


            case "little":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";

                setLockedStoryPage(tv, R.drawable.final_story_little, R.string.text_the_little_box, iv1, iv2, iv3, "little", url1, url2, url3, locked_holder);

                break;

            case "juicy":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a";

                setLockedStoryPage(tv, R.drawable.final_story_juicy, R.string.text_juicy_title_text, iv1, iv2, iv3, "juicy", url1, url2, url3, locked_holder);

                break;

            case "paxton":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";

                setLockedStoryPage(tv, R.drawable.final_story_paxton, R.string.del_paxton, iv1, iv2, iv3, "paxton", url1, url2, url3, locked_holder);

                break;

            case "rosehip":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9";

                setLockedStoryPage(tv, R.drawable.final_story_rosehip, R.string.title_rosehip, iv1, iv2, iv3, "rosehip", url1, url2, url3, locked_holder);

                tv.setBackgroundResource(R.drawable.final_story_rosehip);
                tv.setText(R.string.title_rosehip);

                break;

            case "wagoneer":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";

                setLockedStoryPage(tv, R.drawable.final_story_wagoneer, R.string.title_wagoneer, iv1, iv2, iv3, "wagoneer", url1, url2, url3, locked_holder);

                break;

            case "artawake":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";

                setLockedStoryPage(tv, R.drawable.final_story_artawake, R.string.title_artawake, iv1, iv2, iv3, "artawake", url1, url2, url3, locked_holder);

                break;

            case "bugjar":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";

                setLockedStoryPage(tv, R.drawable.final_story_bugjar, R.string.title_bugjar, iv1, iv2, iv3, "bugjar", url1, url2, url3, locked_holder);

                break;



        }

        // increased access to content by QR code

        if (getIntent().getStringExtra("locked") != null) {
            switch (getIntent().getStringExtra("locked")) {

                // public void setUnlockedStoryPage(TextView unlockNotifyTxt, LinearLayout holder1, LinearLayout holder2, imgUrl1, imgUrl2, imgUrl3, TextView storyTxt)
                case "griffs":
                    toastFaveReminder();
                    url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7";
                    url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/1.png?alt=media&token=96b9afec-389a-4a78-8889-cf924e11e8ee";
                    url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266";

                    setUnlockedStoryPage(lockedtext, locked_holder, locked_holder2, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    setSaveImgListeners(iv1, "griffs1", editor);
                    setSaveImgListeners(iv2, "griffs2", editor);
                    setSaveImgListeners(iv3, "griffs3", editor);

                    url4 = "https://drive.google.com/file/d/0B-xS4tngSiksakJWaS14cWRIS3c/view?usp=sharing";
                    setSaveVidListeners(iv4, "griffs1", url4, editor);
                    setSaveVidListeners(iv5, "griffs2", url4, editor);
                    setSaveVidListeners(iv6, "griffs3", url4, editor);

                    break;


                case "little":
                    toastFaveReminder();
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583")
                            .into(iv2);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583")
                            .into(iv3);

                    story_locked.setVisibility(View.VISIBLE);

                    iv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "little1");
                            startActivity(intent);
                        }
                    });

                    // when held down
                    iv1.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            Toast.makeText(getApplicationContext(), "Saved to favorites!", Toast.LENGTH_LONG).show();
                            return false;
                        }
                    });

                    iv2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "little1");
                            startActivity(intent);
                        }
                    });

                    iv2.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            Toast.makeText(getApplicationContext(), "Saved to favorites!", Toast.LENGTH_LONG).show();
                            return false;
                        }
                    });

                    iv3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                            intent.putExtra("fullimg", "little1");
                            startActivity(intent);
                        }
                    });

                    iv3.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            Toast.makeText(getApplicationContext(), "Saved to favorites!", Toast.LENGTH_LONG).show();
                            return false;
                        }
                    });

                    break;


                case "juicy":
                    toastFaveReminder();

                    url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a";
                    url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a";
                    url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a";

                    setUnlockedStoryPage(lockedtext, locked_holder, locked_holder2, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    setSaveImgListeners(iv1, "juicy1", editor);
                    setSaveImgListeners(iv2, "juicy1", editor);
                    setSaveImgListeners(iv3, "juicy1", editor);

                    break;

                case "paxton":
                    toastFaveReminder();
                    tv.setBackgroundResource(R.drawable.final_story_paxton);
                    tv.setText(R.string.del_paxton);
                    break;

                case "rosehip":
                    toastFaveReminder();
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

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

                    // when held down
                    iv1.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            Toast.makeText(getApplicationContext(), "Saved to favorites!", Toast.LENGTH_LONG).show();
                            return false;
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

                    iv2.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            Toast.makeText(getApplicationContext(), "Saved to favorites!", Toast.LENGTH_LONG).show();
                            return false;
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

                    iv3.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            Toast.makeText(getApplicationContext(), "Saved to favorites!", Toast.LENGTH_LONG).show();
                            return false;
                        }
                    });

                    break;

                case "wagoneer":
                    toastFaveReminder();
                    tv.setBackgroundResource(R.drawable.final_story_wagoneer);
                    tv.setText(R.string.title_wagoneer);
                    break;

                case "artawake":
                    toastFaveReminder();
                    tv.setBackgroundResource(R.drawable.final_story_artawake);
                    tv.setText("Art Awake 2017");
                    break;

                case "bugjar":
                    toastFaveReminder();
                    tv.setBackgroundResource(R.drawable.final_story_bugjar);
                    tv.setText(R.string.title_bugjar);
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

    public void toastFaveReminder() {
        //for (int i = 0; i < 2; i++) {
            Toast t = Toast.makeText(getApplicationContext(), "Tap & Hold on item to FAVORITE", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
        //}
    }


    //
    public void setLockedStoryPage(TextView tv, int drawableId, int titleId, ImageButton iv1, ImageButton iv2, ImageButton iv3, String name, String url1, String url2, String url3, LinearLayout layout) {
        tv.setBackgroundResource(drawableId);
        tv.setText(titleId);
        iv1.setScaleType(ImageView.ScaleType.FIT_XY);
        iv2.setScaleType(ImageView.ScaleType.FIT_XY);
        iv3.setScaleType(ImageView.ScaleType.FIT_XY);

        if (Objects.equals(getIntent().getStringExtra("locked"), name)) {
            Glide.with(this.getApplicationContext())
                    .load(url1)
                    .into(iv1);
            Glide.with(this.getApplicationContext())
                    .load(url2)
                    .into(iv2);
            Glide.with(this.getApplicationContext())
                    .load(url3)
                    .into(iv3);

            layout.setVisibility(View.VISIBLE);
        }
    }

    public void setUnlockedStoryPage(TextView unlockNotifyTxt, LinearLayout holder1, LinearLayout holder2, String imgUrl1, ImageButton iv1, String imgUrl2, ImageButton iv2, String imgUrl3, ImageButton iv3, TextView storyTxt) {
        unlockNotifyTxt.setText("***UNLOCKED CONTENT***");
        unlockNotifyTxt.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
        holder1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
        holder2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
        holder2.setVisibility(View.VISIBLE);

        Glide.with(this.getApplicationContext())
                //.using(new FirebaseImageLoader())
                .load(imgUrl1)
                .into(iv1);

        Glide.with(this.getApplicationContext())
                .load(imgUrl2)
                .into(iv2);

        Glide.with(this.getApplicationContext())
                .load(imgUrl3)
                .into(iv3);

        storyTxt.setVisibility(View.VISIBLE);
    }

    public void setSaveImgListeners(ImageView iv, final String filename, final SharedPreferences.Editor editor) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(), ImageFullViewActivity.class);
                intent.putExtra("fullimg", filename);
                startActivity(intent);
            }
        });

        // when button held down
        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Saved to FAVORITES", Toast.LENGTH_LONG).show();

                editor.putString("storefaveimg_" + filename, filename);

                editor.commit();

                return false;
            }
        });
    }

    public void setSaveVidListeners(ImageView iv, final String filename, final String url, final SharedPreferences.Editor editor) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        });

        // when button held down
        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Saved to FAVORITES", Toast.LENGTH_LONG).show();

                editor.putString("storefavevid_" + filename, filename);

                editor.commit();

                return false;
            }
        });
    }

/*
    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
            player.setFullscreen(false);
            player.setShowFullscreenButton(true);
            player.cueVideo(url_link);
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }
*/
}
