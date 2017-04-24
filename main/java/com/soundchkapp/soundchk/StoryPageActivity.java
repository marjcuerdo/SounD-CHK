package com.soundchkapp.soundchk;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubePlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Handler;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;


import android.media.MediaPlayer;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ScrollView;
import android.graphics.Point;
import android.util.Log;


import java.util.Objects;

public class StoryPageActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public Intent intent;

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;

    public boolean tracker = false;

    public String url_link = "yQiIXCSHq3w";

    YouTubePlayer mYoutubePlayer;
    ImageButton button_change_vid_next, button_change_vid_prev;

    //final MediaPlayer mp = MediaPlayer.create(this, R.raw.samplesound);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storypage);

        final TextView tv = (TextView) findViewById(R.id.textView);
        TextView lockedtext = (TextView) findViewById(R.id.lockedtext);
        TextView storyfree = (TextView) findViewById(R.id.story_free);
        TextView story_locked = (TextView) findViewById(R.id.story_locked);
        LinearLayout locked_holder = (LinearLayout) findViewById(R.id.locked_holder);
        //LinearLayout locked_holder2 = (LinearLayout) findViewById(R.id.extra_locked_holder);
        final ImageButton iv1 = (ImageButton) findViewById(R.id.imglocked1);
        final ImageButton iv2 = (ImageButton) findViewById(R.id.imglocked2);
        final ImageButton iv3 = (ImageButton) findViewById(R.id.imglocked3);
        final ImageButton iv4 = (ImageButton) findViewById(R.id.imglocked4);
        final ImageButton iv5 = (ImageButton) findViewById(R.id.imglocked5);
        final ImageButton iv6 = (ImageButton) findViewById(R.id.imglocked6);
        final ImageButton button_scroll_down = (ImageButton) findViewById(R.id.button_scroll_down);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

        //YouTubePlayerFragment youTubePlayerFragment = YouTubePlayerFragment.newInstance();
        //youTubePlayerFragment.initialize(Config.YOUTUBE_API_KEY, this);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);




        final Button scan_button = (Button)findViewById(R.id.scan_btn);

        scan_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CameraActivity.class);
                startActivity(intent);
            }
        });


        button_change_vid_next = (ImageButton)findViewById(R.id.button_change_vid_next);
        button_change_vid_prev = (ImageButton)findViewById(R.id.button_change_vid_prev);


        button_change_vid_next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                final Handler handler = new Handler();

                button_change_vid_next.setImageResource(R.drawable.right_arrow);
                button_change_vid_next.setBackgroundColor(getResources().getColor(R.color.color_home_dark));

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //myButton.setBackgroundColor(Color.BLACK); //set the color to black
                        button_change_vid_next.setImageResource(R.drawable.black_right_arrow);
                        button_change_vid_next.setBackgroundColor(getResources().getColor(R.color.colorWhiteBg));
                    }
                }, 150);


                url_link = "yQiIXCSHq3w";

                if(mYoutubePlayer!=null){
                    mYoutubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    mYoutubePlayer.cueVideo(url_link);
                }


            }

        });

        button_change_vid_prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();

                button_change_vid_prev.setImageResource(R.drawable.left_arrow);
                button_change_vid_prev.setBackgroundColor(getResources().getColor(R.color.color_home_dark));

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //myButton.setBackgroundColor(Color.BLACK); //set the color to black
                        button_change_vid_prev.setImageResource(R.drawable.black_left_arrow);
                        button_change_vid_prev.setBackgroundColor(getResources().getColor(R.color.colorWhiteBg));
                    }
                }, 150);
            }


        });


        //////////


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

                button_scroll_down.setImageResource(R.drawable.down_arrow);
                button_scroll_down.setBackgroundColor(getResources().getColor(R.color.color_home_dark));

                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ScrollView scrollView = (ScrollView)findViewById(R.id.scroll_view);
                        View targetView = findViewById(R.id.lockedtext);
                        scrollView.smoothScrollTo(0,targetView.getTop());
                        //myButton.setBackgroundColor(Color.BLACK); //set the color to black
                        button_scroll_down.setImageResource(R.drawable.black_down_arrow);
                        button_scroll_down.setBackgroundColor(getResources().getColor(R.color.colorWhiteBg));
                    }
                }, 200);


                //ScrollView scrollView = (ScrollView)findViewById(R.id.scroll_view);
                //View targetView = findViewById(R.id.lockedtext);
                //scrollView.smoothScrollTo(0,targetView.getTop());

                //targetView.getParent().requestChildFocus(targetView,targetView);
            }
        });




        // unlocked with QR; same access as open from feed button

        switch (getIntent().getStringExtra("unlocked")) {

            //DONE!!!
            case "griffs":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/griffs_outline.png?alt=media&token=6fecdebe-e75c-4fbf-8a9a-0d577e693fad";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266";

                setLockedStoryPage(tv, R.drawable.final_story_griffs_2, R.string.dr_griffs_title_text, storyfree, R.string.griffs_short_text, iv1, iv2, iv3, "griffs", url1, url2, url3, locked_holder);

                break;


            case "little":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";

                setLockedStoryPage(tv, R.drawable.final_story_little, R.string.text_the_little_box, storyfree, R.string.little_short_text, iv1, iv2, iv3, "little", url1, url2, url3, locked_holder);

                break;

            case "juicy":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";

                setLockedStoryPage(tv, R.drawable.final_story_juicy_2, R.string.title_juicy_connotation, storyfree, R.string.juicy_short_text, iv1, iv2, iv3, "juicy", url1, url2, url3, locked_holder);

                break;

            case "paxton":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";

                setLockedStoryPage(tv, R.drawable.final_story_paxton, R.string.del_paxton, storyfree, R.string.paxton_short_text, iv1, iv2, iv3, "paxton", url1, url2, url3, locked_holder);

                break;

            case "rosehip":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9";

                setLockedStoryPage(tv, R.drawable.final_story_rosehip, R.string.title_rosehip, storyfree, R.string.rosehip_short_text, iv1, iv2, iv3, "rosehip", url1, url2, url3, locked_holder);

                tv.setBackgroundResource(R.drawable.final_story_rosehip);
                tv.setText(R.string.title_rosehip);

                break;

            case "wagoneer":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583";

                setLockedStoryPage(tv, R.drawable.wagon, R.string.title_wagoneer, storyfree, R.string.wagoneer_short_text, iv1, iv2, iv3, "wagoneer", url1, url2, url3, locked_holder);

                break;

            case "artawake":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";

                setLockedStoryPage(tv, R.drawable.final_story_artawake, R.string.title_artawake, storyfree, R.string.artawake_short_text, iv1, iv2, iv3, "artawake", url1, url2, url3, locked_holder);

                break;

            case "bugjar":
                url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";
                url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";
                url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64";

                setLockedStoryPage(tv, R.drawable.final_story_bugjar_2, R.string.title_bugjar, storyfree, R.string.bugjar_short_text, iv1, iv2, iv3, "bugjar", url1, url2, url3, locked_holder);

                break;



        }

        // increased access to content by QR code

        if (getIntent().getStringExtra("locked") != null) {
            switch (getIntent().getStringExtra("locked")) {

                // public void setUnlockedStoryPage(TextView unlockNotifyTxt, LinearLayout holder1, LinearLayout holder2, imgUrl1, imgUrl2, imgUrl3, TextView storyTxt)
                case "griffs":
                    toastFaveReminder();
                    url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7";
                    url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638";
                    url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266";

                    scan_button.setVisibility(View.GONE);

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    setSaveImgListeners(iv1, "griffs1", editor);
                    setSaveImgListeners(iv2, "griffs2", editor);
                    setSaveImgListeners(iv3, "griffs3", editor);
                    setSaveImgListeners(iv4, "griffs4", editor);
                    setSaveImgListeners(iv5, "griffs5", editor);
                    //setSaveImgListeners(iv3, "griffs3", editor);

                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.griffs_long_text);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3511.jpg?alt=media&token=979728d1-ce96-4e68-ad24-42b4f69dd991")
                            .into(iv4);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3569.jpg?alt=media&token=1b3b7a6d-ceed-4cd9-8b8a-c39604207450")
                            .into(iv5);

                    iv6.setVisibility(View.GONE);

                    url4 = "https://drive.google.com/file/d/0B-xS4tngSiksakJWaS14cWRIS3c/view?usp=sharing";
                    //setSaveVidListeners(iv4, "griffs1", url4, editor);
                    //setSaveVidListeners(iv5, "griffs2", url4, editor);
                    //setSaveVidListeners(iv6, "griffs3", url4, editor);

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

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.little_long_text);

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

                    url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3728.jpg?alt=media&token=4bfae885-54cc-46e8-bffe-50784d0fa157";
                    url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3750.jpg?alt=media&token=6b971eb0-6a1b-4215-a8cd-507b4c227534";
                    url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3777.jpg?alt=media&token=af405f11-daba-4ff2-9f36-9ee21aa17811";

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    setSaveImgListeners(iv1, "juicy1", editor);
                    setSaveImgListeners(iv2, "juicy2", editor);
                    setSaveImgListeners(iv3, "juicy3", editor);
                    setSaveImgListeners(iv4, "juicy4", editor);
                    setSaveImgListeners(iv5, "juicy5", editor);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.juicy_long_text);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3779.jpg?alt=media&token=b4bf7552-708b-4207-956f-18b7198d67af")
                            .into(iv4);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3801.jpg?alt=media&token=afbe6ee2-f57b-4d1d-97b5-74907498f0c7")
                            .into(iv5);

                    iv6.setVisibility(View.GONE);

                    break;

                case "paxton":
                    toastFaveReminder();
                    tv.setBackgroundResource(R.drawable.final_story_paxton);
                    tv.setText(R.string.del_paxton);

                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_paxton);
                    tv.setText(R.string.del_paxton);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.paxton_long_text);


                    break;

                case "rosehip":
                    toastFaveReminder();
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_rosehip);
                    tv.setText(R.string.title_rosehip);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.rosehip_long_text);


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
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_wagoneer);
                    tv.setText(R.string.title_wagoneer);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.wagoneer_long_text);

                    break;

                case "artawake":
                    toastFaveReminder();

                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_artawake);
                    tv.setText("Art Awake 2017");

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.artawake_long_text);

                    break;

                case "bugjar":
                    toastFaveReminder();

                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_bugjar);
                    tv.setText(R.string.title_bugjar);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.bugjar_long_text);

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
    public void setLockedStoryPage(TextView tv, int drawableId, int titleId, TextView tvStoryFree, int stringId, ImageButton iv1, ImageButton iv2, ImageButton iv3, String name, String url1, String url2, String url3, LinearLayout layout) {
        tv.setBackgroundResource(drawableId);
        tv.setText(titleId);
        tv.setAllCaps(true);
        tvStoryFree.setText(stringId);
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

    public void setUnlockedStoryPage(TextView unlockNotifyTxt, LinearLayout holder1, String imgUrl1, ImageButton iv1, String imgUrl2, ImageButton iv2, String imgUrl3, ImageButton iv3, TextView storyTxt) {
        unlockNotifyTxt.setText("***UNLOCKED CONTENT***");
        unlockNotifyTxt.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
        holder1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
        //holder2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
        //holder2.setVisibility(View.VISIBLE);

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

    public void setLockedText(TextView story_locked, int stringId) {
        story_locked.setText(stringId);
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
    public void onResume() {
        super.onResume();
        button_change_vid.setBackgroundColor(getResources().getColor(R.color.colorWhiteBg));
        button_change_vid.setImageResource(R.drawable.black_right_arrow);
    }*/

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {
            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
            youTubePlayer.cueVideo("WRmEgfJ1RIM");
            //Save reference of initialized player in class level attribute
            mYoutubePlayer = youTubePlayer;
        }

    }

    // create playlist for videos
    public String displayVideos() {

        if (getIntent().getStringExtra("locked") != null) {
            switch (getIntent().getStringExtra("locked")) {
                case "griffs":



            }
        }

        return url_link;
    }

    @Override
    public void onInitializationFailure (YouTubePlayer.Provider
                                                 provider, YouTubeInitializationResult youTubeInitializationResult){

    }
}
