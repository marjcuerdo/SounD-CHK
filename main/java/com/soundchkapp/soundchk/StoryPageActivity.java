package com.soundchkapp.soundchk;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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
import android.view.ViewGroup;
import android.os.Handler;
import java.util.ArrayList;

import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;

import com.google.android.youtube.player.YouTubePlayerView;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.ScrollView;


import java.util.Objects;

public class StoryPageActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public Intent intent;

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;

    boolean artawake = false;
    int little = 0;

    public String url_link = "STILL_LOCKED";

    YouTubePlayer mYoutubePlayer;
    ImageButton button_change_vid_next;

    public ArrayList<String> saved_vid_urls = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storypage);

        final TextView tv = (TextView) findViewById(R.id.textView);
        TextView lockedtext = (TextView) findViewById(R.id.lockedtext);
        TextView storyfree = (TextView) findViewById(R.id.story_free);
        TextView story_locked = (TextView) findViewById(R.id.story_locked);
        LinearLayout locked_holder = (LinearLayout) findViewById(R.id.locked_holder);
        final ImageButton iv1 = (ImageButton) findViewById(R.id.imglocked1);
        final ImageButton iv2 = (ImageButton) findViewById(R.id.imglocked2);
        final ImageButton iv3 = (ImageButton) findViewById(R.id.imglocked3);
        final ImageButton iv4 = (ImageButton) findViewById(R.id.imglocked4);
        final ImageButton iv5 = (ImageButton) findViewById(R.id.imglocked5);
        final ImageButton iv6 = (ImageButton) findViewById(R.id.imglocked6);
        final ImageButton iv7 = (ImageButton) findViewById(R.id.imglocked7);
        final ImageButton iv8 = (ImageButton) findViewById(R.id.imglocked8);
        final ImageButton iv9 = (ImageButton) findViewById(R.id.imglocked9);
        final ImageButton iv10 = (ImageButton) findViewById(R.id.imglocked10);
        final ImageButton iv11 = (ImageButton) findViewById(R.id.imglocked11);
        final ImageButton iv12 = (ImageButton) findViewById(R.id.imglocked12);
        final LinearLayout vid_holder = (LinearLayout) findViewById(R.id.vid_holder);
        final ImageButton button_scroll_down = (ImageButton) findViewById(R.id.button_scroll_down);
        final LinearLayout fave_button_holder = (LinearLayout) findViewById(R.id.fave_button_holder);
        final ImageButton button_fave = (ImageButton) findViewById(R.id.button_fave);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);


        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        final Button scan_button = (Button)findViewById(R.id.scan_btn);

        scan_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                scan_button.setBackgroundResource(R.drawable.roundedbutton_clicked);
                scan_button.setTextColor(Color.WHITE);

                Intent intent = new Intent(getBaseContext(), CameraActivity.class);
                finish();
                startActivity(intent);
            }
        });

        button_change_vid_next = (ImageButton)findViewById(R.id.button_change_vid_next);

        final SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = preferences1.edit();

        button_change_vid_next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Handler handler = new Handler();

                button_change_vid_next.setImageResource(R.drawable.right_arrow);
                button_change_vid_next.setBackgroundColor(getResources().getColor(R.color.color_home_dark));

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        button_change_vid_next.setImageResource(R.drawable.black_right_arrow);
                        button_change_vid_next.setBackgroundColor(getResources().getColor(R.color.colorWhiteBg));
                    }
                }, 150);

                if (Objects.equals(getIntent().getStringExtra("video"), "artawake")) {
                    String [] url_list = {"hFYIqk0uPyQ", "j457IfKBlFg"};
                    if (artawake == false) {
                        url_link = url_list[1];

                        artawake = true;
                    } else {
                        url_link = url_list[0];

                        artawake = false;
                    }
                    youTubeView.initialize(Config.YOUTUBE_API_KEY, StoryPageActivity.this);
                } else if (Objects.equals(getIntent().getStringExtra("video"), "bugjar")) {
                    String [] url_list = {"QWbt_8YPGOQ", "3anzbMIUwcA"};
                    if (!artawake) {
                        url_link = url_list[1];
                        artawake = true;
                    } else {
                        url_link = url_list[0];
                        artawake = false;
                    }
                } else if (Objects.equals(getIntent().getStringExtra("video"), "little")) {
                    String [] url_list = {"Jbd3MLbHgXs", "0jYboXw13II", "zCDkvJaqRT8"};
                    if (little == 0) {
                        url_link = url_list[1];
                        little = 1;
                    } else if (little == 1){
                        url_link = url_list[2];
                        little = 2;
                    } else if (little == 2) {
                        url_link = url_list[0];
                        little = 0;
                    }
                } else { }

                if(mYoutubePlayer!=null){
                    mYoutubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    mYoutubePlayer.cueVideo(url_link);
                }

            }

        });



        button_fave.setVisibility(View.GONE);
        button_fave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_fave.setImageResource(R.drawable.ic_notifications_white);
                button_fave.setBackgroundColor(getResources().getColor(R.color.color_home_dark));

                Toast t = Toast.makeText(getApplicationContext(), "Saved video to FAVORITES", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //myButton.setBackgroundColor(Color.BLACK); //set the color to black
                        button_fave.setImageResource(R.drawable.ic_notifications_black);
                        button_fave.setBackgroundColor(getResources().getColor(R.color.colorWhiteBg));
                    }
                }, 500);

                if (preferences1.contains(url_link)) {

                } else {

                    if (getIntent().getStringExtra("locked") != null) {
                        switch (getIntent().getStringExtra("locked")) {
                            case "griffs":
                                editor.putString("storefavevid_griffs", url_link);
                                editor.commit();
                                break;
                            case "little":
                                if (preferences1.contains("storefavevid_little1")) {
                                    editor.putString("storefavevid_little2", url_link);
                                    editor.commit();
                                } else if (preferences1.contains("storefavevid_little2")){
                                    editor.putString("storefavevid_little3", url_link);
                                    editor.commit();
                                } else if (preferences1.contains("storefavevid_little3")){

                                } else {
                                    editor.putString("storefavevid_little1", url_link);
                                    editor.commit();
                                }
                                break;
                            case "juicy":
                                editor.putString("storefavevid_juicy", url_link);
                                editor.commit();
                                break;
                            case "artawake":
                                if (preferences1.contains("storefavevid_artawake1")) {
                                    editor.putString("storefavevid_artawake2", url_link);
                                    editor.commit();
                                } else if (preferences1.contains("storefavevid_artawake2")){

                                } else {
                                    editor.putString("storefavevid_artawake1", url_link);
                                    editor.commit();
                                }
                                break;
                            case "bugjar":
                                if (preferences1.contains("storefavevid_bugjar1")) {
                                    editor.putString("storefavevid_bugjar2", url_link);
                                    editor.commit();
                                } else if (preferences1.contains("storefavevid_bugjar2")){

                                } else {
                                    editor.putString("storefavevid_bugjar1", url_link);
                                    editor.commit();
                                }
                                break;

                        }
                    }

                }
            }
        });


        String url1 = "";
        String url2 = "";
        String url3 = "";

        button_scroll_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_scroll_down.setImageResource(R.drawable.white_down_button1);
                button_scroll_down.setBackgroundColor(getResources().getColor(R.color.color_home_dark));

                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ScrollView scrollView = (ScrollView)findViewById(R.id.scroll_view);
                        View targetView = findViewById(R.id.lockedtext);
                        scrollView.smoothScrollTo(0,targetView.getTop());
                        //myButton.setBackgroundColor(Color.BLACK); //set the color to black
                        button_scroll_down.setImageResource(R.drawable.down_button1);
                        button_scroll_down.setBackgroundColor(getResources().getColor(R.color.colorWhiteBg));
                    }
                }, 200);
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

                    button_fave.setVisibility(View.VISIBLE);
                    button_change_vid_next.setVisibility(View.GONE);

                    youTubeView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 800));

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
                    iv7.setVisibility(View.GONE);
                    iv8.setVisibility(View.GONE);
                    iv9.setVisibility(View.GONE);
                    iv10.setVisibility(View.GONE);
                    iv11.setVisibility(View.GONE);
                    iv12.setVisibility(View.GONE);

                    if (Objects.equals(getIntent().getStringExtra("video"), "griffs")) {
                        url_link = "Uv1sFdhYDDI";
                    }

                    break;

                // DONE!!
                case "little":
                    toastFaveReminder();
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    button_fave.setVisibility(View.VISIBLE);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3621.jpg?alt=media&token=de197145-89b6-4ce2-9e08-65d20b40e258")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3679.jpg?alt=media&token=63cfb305-108e-411c-afc3-386b770fef04")
                            .into(iv2);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3686.jpg?alt=media&token=25029d12-79a9-48c6-90ad-4c2069190fe7")
                            .into(iv3);
                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3691.jpg?alt=media&token=193b2470-313d-40c6-9a4e-e7ac0a66c95a")
                            .into(iv4);

                    iv5.setVisibility(View.GONE);
                    iv6.setVisibility(View.GONE);
                    iv7.setVisibility(View.GONE);
                    iv8.setVisibility(View.GONE);
                    iv9.setVisibility(View.GONE);
                    iv10.setVisibility(View.GONE);
                    iv11.setVisibility(View.GONE);
                    iv12.setVisibility(View.GONE);

                    setSaveImgListeners(iv1, "little1", editor);
                    setSaveImgListeners(iv2, "little2", editor);
                    setSaveImgListeners(iv3, "little3", editor);
                    setSaveImgListeners(iv4, "little4", editor);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.little_long_text);

                    if (Objects.equals(getIntent().getStringExtra("video"), "little")) {
                        url_link = "Jbd3MLbHgXs";
                    }
                    break;

                // DONE!!!
                case "juicy":
                    toastFaveReminder();

                    button_fave.setVisibility(View.VISIBLE);

                    url1 = "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3728.jpg?alt=media&token=4bfae885-54cc-46e8-bffe-50784d0fa157";
                    url2 = "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3750.jpg?alt=media&token=6b971eb0-6a1b-4215-a8cd-507b4c227534";
                    url3 = "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3777.jpg?alt=media&token=af405f11-daba-4ff2-9f36-9ee21aa17811";

                    button_change_vid_next.setVisibility(View.GONE);

                    youTubeView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 800));

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
                    iv7.setVisibility(View.GONE);
                    iv8.setVisibility(View.GONE);
                    iv9.setVisibility(View.GONE);
                    iv10.setVisibility(View.GONE);
                    iv11.setVisibility(View.GONE);
                    iv12.setVisibility(View.GONE);

                    if (Objects.equals(getIntent().getStringExtra("video"), "juicy")) {
                        url_link = "CI0ykNQFF4w";
                    }

                    break;

                // DONE!!!
                case "paxton":
                    toastFaveReminder();
                    tv.setBackgroundResource(R.drawable.final_story_paxton);
                    tv.setText(R.string.del_paxton);

                    fave_button_holder.setVisibility(View.GONE);
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_paxton);
                    tv.setText(R.string.del_paxton);

                    setSaveImgListeners(iv2, "paxton1", editor);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.paxton_long_text);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bandcamp_button.png?alt=media&token=6d3e2af1-119c-45bb-8555-7a575585f8de")
                            .into(iv1);

                    iv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://delpaxton.bandcamp.com/"));
                            startActivity(intent);
                        }
                    });

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/PAXTON.jpg?alt=media&token=c6e70cb5-5f30-43e6-9826-afdf88d93e15")
                            .into(iv2);

                    youTubeView.setVisibility(View.GONE);
                    button_change_vid_next.setVisibility(View.GONE);
                    vid_holder.setVisibility(View.GONE);

                    iv3.setVisibility(View.GONE);
                    iv4.setVisibility(View.GONE);
                    iv5.setVisibility(View.GONE);
                    iv6.setVisibility(View.GONE);
                    iv7.setVisibility(View.GONE);
                    iv8.setVisibility(View.GONE);
                    iv9.setVisibility(View.GONE);
                    iv10.setVisibility(View.GONE);
                    iv11.setVisibility(View.GONE);
                    iv12.setVisibility(View.GONE);

                    break;

                case "rosehip":
                    toastFaveReminder();
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    fave_button_holder.setVisibility(View.GONE);
                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_rosehip);
                    tv.setText(R.string.title_rosehip);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.rosehip_long_text);

                    setSaveImgListeners(iv2, "rosehip1", editor);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bandcamp_button.png?alt=media&token=6d3e2af1-119c-45bb-8555-7a575585f8de")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/ROSEHIP.jpg?alt=media&token=932ba08d-7170-4aab-8b85-9476d0133dce")
                            .into(iv2);

                    iv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rosehip.bandcamp.com/"));
                            startActivity(intent);
                        }
                    });

                    youTubeView.setVisibility(View.GONE);
                    button_change_vid_next.setVisibility(View.GONE);
                    vid_holder.setVisibility(View.GONE);

                    iv3.setVisibility(View.GONE);
                    iv4.setVisibility(View.GONE);
                    iv5.setVisibility(View.GONE);
                    iv6.setVisibility(View.GONE);
                    iv7.setVisibility(View.GONE);
                    iv8.setVisibility(View.GONE);
                    iv9.setVisibility(View.GONE);
                    iv10.setVisibility(View.GONE);
                    iv11.setVisibility(View.GONE);
                    iv12.setVisibility(View.GONE);

                    break;

                case "wagoneer":
                    toastFaveReminder();
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);
                    fave_button_holder.setVisibility(View.GONE);
                    tv.setBackgroundResource(R.drawable.final_story_wagoneer);
                    tv.setText(R.string.title_wagoneer);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.wagoneer_long_text);

                    setSaveImgListeners(iv2, "wagoneer1", editor);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bandcamp_button.png?alt=media&token=6d3e2af1-119c-45bb-8555-7a575585f8de")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/GRAND%20WAGONEER.jpg?alt=media&token=ef743266-3978-4b84-b92c-ff392334842a")
                            .into(iv2);

                    iv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://grandwagoneer.bandcamp.com/"));
                            startActivity(intent);
                        }
                    });

                    youTubeView.setVisibility(View.GONE);
                    button_change_vid_next.setVisibility(View.GONE);
                    vid_holder.setVisibility(View.GONE);

                    iv3.setVisibility(View.GONE);
                    iv4.setVisibility(View.GONE);
                    iv5.setVisibility(View.GONE);
                    iv6.setVisibility(View.GONE);
                    iv7.setVisibility(View.GONE);
                    iv8.setVisibility(View.GONE);
                    iv9.setVisibility(View.GONE);
                    iv10.setVisibility(View.GONE);
                    iv11.setVisibility(View.GONE);
                    iv12.setVisibility(View.GONE);


                    break;

                // DONE!!!
                case "artawake":
                    toastFaveReminder();
                    button_fave.setVisibility(View.VISIBLE);

                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_artawake);
                    tv.setText("Art Awake 2017");

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.artawake_long_text);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/mon%20petit%20chou%201.JPG?alt=media&token=976b967f-4135-4263-b8cc-71118839f6fc")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/mon%20petit%20chou%202.JPG?alt=media&token=45e28631-198e-49b1-9297-15686600f86d")
                            .into(iv2);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%201.JPG?alt=media&token=02f1e10f-2527-4c5b-bf06-9b6dd4ddaf10")
                            .into(iv3);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%202.JPG?alt=media&token=edd5fe12-00ff-4845-b14b-b9a9366a0134")
                            .into(iv4);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%203.JPG?alt=media&token=f117879c-04c9-4176-b348-28fe7cf94d97")
                            .into(iv5);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%201.JPG?alt=media&token=4484dbb6-fc49-47b1-ab7d-456a198c6595")
                            .into(iv6);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%202.JPG?alt=media&token=dc12f924-2881-454e-9b03-f4b634c71972")
                            .into(iv7);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%203.JPG?alt=media&token=131fc03f-a923-425d-aadb-46941b6ce6f7")
                            .into(iv8);


                    setSaveImgListeners(iv1, "artawake1", editor);
                    setSaveImgListeners(iv2, "artawake2", editor);
                    setSaveImgListeners(iv3, "artawake3", editor);
                    setSaveImgListeners(iv4, "artawake4", editor);
                    setSaveImgListeners(iv5, "artawake5", editor);
                    setSaveImgListeners(iv6, "artawake6", editor);
                    setSaveImgListeners(iv7, "artawake7", editor);
                    setSaveImgListeners(iv8, "artawake8", editor);

                    iv9.setVisibility(View.GONE);
                    iv10.setVisibility(View.GONE);
                    iv11.setVisibility(View.GONE);
                    iv12.setVisibility(View.GONE);

                    if (Objects.equals(getIntent().getStringExtra("video"), "artawake")) {
                        url_link = "hFYIqk0uPyQ";
                    }

                    break;

                // DONE!!!!
                case "bugjar":
                    toastFaveReminder();

                    button_fave.setVisibility(View.VISIBLE);
                    lockedtext.setText("***UNLOCKED CONTENT***");
                    lockedtext.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.color_home));
                    locked_holder.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));

                    setUnlockedStoryPage(lockedtext, locked_holder, url1, iv1, url2, iv2, url3, iv3, story_locked);

                    tv.setBackgroundResource(R.drawable.final_story_bugjar);
                    tv.setText(R.string.title_bugjar);

                    scan_button.setVisibility(View.GONE);
                    story_locked.setVisibility(View.VISIBLE);
                    story_locked.setText(R.string.bugjar_long_text);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%201.JPG?alt=media&token=865a6b9d-afc4-4c3a-897e-7a97c373a4f4")
                            .into(iv1);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%202.JPG?alt=media&token=31d2354c-a0d2-41fb-9625-acf3c5a9e2d7")
                            .into(iv2);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%203.JPG?alt=media&token=da714dbe-8226-4a3b-8378-a6a420b0c793")
                            .into(iv3);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%204.JPG?alt=media&token=b77f1943-ecc8-4369-a65a-4ebdba9f44ae")
                            .into(iv4);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%201.JPG?alt=media&token=0760c4ae-1cee-4453-8584-345f64ffc755")
                            .into(iv5);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%202.JPG?alt=media&token=77cc85e0-ca24-4a4e-aca7-3957ca4a9830")
                            .into(iv6);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%203.JPG?alt=media&token=b180f20b-e804-4d1f-b93d-ffe998a8f8d3")
                            .into(iv7);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%204.JPG?alt=media&token=547a222c-3b8e-4c6d-b559-c67a1f263385")
                            .into(iv8);
                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%201.JPG?alt=media&token=5d9da18f-e244-470e-9bc7-1feb7facf262")
                            .into(iv9);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%202.JPG?alt=media&token=0a8a9d5e-1708-4223-9d95-e2676b8a5fbe")
                            .into(iv10);

                    Glide.with(this.getApplicationContext())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%203.JPG?alt=media&token=f3a524e6-d801-452f-8d8d-247deb6a6dad")
                            .into(iv11);

                    Glide.with(this.getApplicationContext())
                            //.using(new FirebaseImageLoader())
                            .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%204.JPG?alt=media&token=f600cde0-b3f5-46b5-89e1-0795b0db28aa")
                            .into(iv12);

                    setSaveImgListeners(iv1, "bugjar1", editor);
                    setSaveImgListeners(iv2, "bugjar2", editor);
                    setSaveImgListeners(iv3, "bugjar3", editor);
                    setSaveImgListeners(iv4, "bugjar4", editor);
                    setSaveImgListeners(iv5, "bugjar5", editor);
                    setSaveImgListeners(iv6, "bugjar6", editor);
                    setSaveImgListeners(iv7, "bugjar7", editor);
                    setSaveImgListeners(iv8, "bugjar8", editor);
                    setSaveImgListeners(iv9, "bugjar9", editor);
                    setSaveImgListeners(iv10, "bugjar10", editor);
                    setSaveImgListeners(iv11, "bugjar11", editor);
                    setSaveImgListeners(iv12, "bugjar12", editor);

                    if (Objects.equals(getIntent().getStringExtra("video"), "bugjar")) {
                        url_link = "QWbt_8YPGOQ";
                    }

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

        // when button held down
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Saved to FAVORITES", Toast.LENGTH_LONG).show();

                editor.putString("storefavevid_" + filename, filename);

                editor.commit();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        Button button = (Button)findViewById(R.id.scan_btn);

        button.setBackgroundResource(R.drawable.roundedbutton);
        button.setTextColor(getResources().getColor(R.color.colorBlack));
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        if (!b) {
            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);


            //Log.d("TAG", url_link);
            youTubePlayer.cueVideo(url_link);
            //Save reference of initialized player in class level attribute
            mYoutubePlayer = youTubePlayer;
        }

    }

    @Override
    public void onInitializationFailure (YouTubePlayer.Provider
                                                 provider, YouTubeInitializationResult youTubeInitializationResult){

    }
}
