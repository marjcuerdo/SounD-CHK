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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import android.support.v7.app.ActionBar.LayoutParams;

public class FaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fave);

        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences1.edit();

        LinearLayout container_faves = (LinearLayout) findViewById(R.id.container_faves);
        //LinearLayout container_parent = (LinearLayout) findViewById(R.id.container_parent);
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
                        emptyMessage(container_faves);
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
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638");
                    }
                    if (preferences1.contains("storefaveimg_griffs3")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266");
                    }
                    if (preferences1.contains("storefaveimg_griffs4")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3511.jpg?alt=media&token=979728d1-ce96-4e68-ad24-42b4f69dd991");
                    }
                    if (preferences1.contains("storefaveimg_griffs5")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3569.jpg?alt=media&token=1b3b7a6d-ceed-4cd9-8b8a-c39604207450");
                    }

                    if (preferences1.contains("storefaveimg_little1")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3621.jpg?alt=media&token=de197145-89b6-4ce2-9e08-65d20b40e258");
                    }

                    if (preferences1.contains("storefaveimg_little2")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3679.jpg?alt=media&token=63cfb305-108e-411c-afc3-386b770fef04");
                    }

                    if (preferences1.contains("storefaveimg_little3")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3686.jpg?alt=media&token=25029d12-79a9-48c6-90ad-4c2069190fe7");
                    }

                    if (preferences1.contains("storefaveimg_little4")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3691.jpg?alt=media&token=193b2470-313d-40c6-9a4e-e7ac0a66c95a");
                    }




                    if (preferences1.contains("storefaveimg_juicy1")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3728.jpg?alt=media&token=4bfae885-54cc-46e8-bffe-50784d0fa157");
                    }

                    if (preferences1.contains("storefaveimg_juicy2")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3750.jpg?alt=media&token=6b971eb0-6a1b-4215-a8cd-507b4c227534");
                    }

                    if (preferences1.contains("storefaveimg_juicy3")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3777.jpg?alt=media&token=af405f11-daba-4ff2-9f36-9ee21aa17811");
                    }

                    if (preferences1.contains("storefaveimg_juicy4")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3779.jpg?alt=media&token=b4bf7552-708b-4207-956f-18b7198d67af");
                    }

                    if (preferences1.contains("storefaveimg_juicy5")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3801.jpg?alt=media&token=afbe6ee2-f57b-4d1d-97b5-74907498f0c7");
                    }



                    if (preferences1.contains("storefaveimg_artawake1")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/mon%20petit%20chou%201.JPG?alt=media&token=976b967f-4135-4263-b8cc-71118839f6fc");
                    }

                    if (preferences1.contains("storefaveimg_artawake2")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/mon%20petit%20chou%202.JPG?alt=media&token=45e28631-198e-49b1-9297-15686600f86d");
                    }
                    if (preferences1.contains("storefaveimg_artawake3")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%201.JPG?alt=media&token=02f1e10f-2527-4c5b-bf06-9b6dd4ddaf10");
                    }
                    if (preferences1.contains("storefaveimg_artawake4")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%202.JPG?alt=media&token=edd5fe12-00ff-4845-b14b-b9a9366a0134");
                    }
                    if (preferences1.contains("storefaveimg_artawake5")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%203.JPG?alt=media&token=f117879c-04c9-4176-b348-28fe7cf94d97");
                    }
                    if (preferences1.contains("storefaveimg_artawake6")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%201.JPG?alt=media&token=4484dbb6-fc49-47b1-ab7d-456a198c6595");
                    }
                    if (preferences1.contains("storefaveimg_artawake7")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%202.JPG?alt=media&token=dc12f924-2881-454e-9b03-f4b634c71972");
                    }
                    if (preferences1.contains("storefaveimg_artawake8")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%203.JPG?alt=media&token=131fc03f-a923-425d-aadb-46941b6ce6f7");
                    }



                    if (preferences1.contains("storefaveimg_bugjar1")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%201.JPG?alt=media&token=865a6b9d-afc4-4c3a-897e-7a97c373a4f4");
                    }

                    if (preferences1.contains("storefaveimg_bugjar2")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%202.JPG?alt=media&token=31d2354c-a0d2-41fb-9625-acf3c5a9e2d7");
                    }
                    if (preferences1.contains("storefaveimg_bugjar3")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%203.JPG?alt=media&token=da714dbe-8226-4a3b-8378-a6a420b0c793");
                    }
                    if (preferences1.contains("storefaveimg_bugjar4")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%204.JPG?alt=media&token=b77f1943-ecc8-4369-a65a-4ebdba9f44ae");
                    }
                    if (preferences1.contains("storefaveimg_bugjar5")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%201.JPG?alt=media&token=0760c4ae-1cee-4453-8584-345f64ffc755");
                    }
                    if (preferences1.contains("storefaveimg_bugjar6")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%202.JPG?alt=media&token=77cc85e0-ca24-4a4e-aca7-3957ca4a9830");
                    }
                    if (preferences1.contains("storefaveimg_bugjar7")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%203.JPG?alt=media&token=b180f20b-e804-4d1f-b93d-ffe998a8f8d3");
                    }
                    if (preferences1.contains("storefaveimg_bugjar8")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%204.JPG?alt=media&token=547a222c-3b8e-4c6d-b559-c67a1f263385");
                    }
                    if (preferences1.contains("storefaveimg_bugjar9")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%201.JPG?alt=media&token=5d9da18f-e244-470e-9bc7-1feb7facf262");
                    }
                    if (preferences1.contains("storefaveimg_bugjar10")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%202.JPG?alt=media&token=0a8a9d5e-1708-4223-9d95-e2676b8a5fbe");
                    }
                    if (preferences1.contains("storefaveimg_bugjar11")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%203.JPG?alt=media&token=f3a524e6-d801-452f-8d8d-247deb6a6dad");
                    }
                    if (preferences1.contains("storefaveimg_bugjar12")) {
                        if (preferences1.contains("status")) {
                            editor.remove("status");
                            editor.commit();
                        }
                        addSavedImg(container_faves, "https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%204.JPG?alt=media&token=f600cde0-b3f5-46b5-89e1-0795b0db28aa");
                    }







                    if (preferences1.contains("status")) {
                        emptyMessage(container_faves);
                    }
                    break;
                case "audio":
                    if (preferences1.contains("status")) {
                        emptyMessage(container_faves);
                    }
                    break;
            }

    }

    public void addSavedImg(LinearLayout linearLayout, String url) {
        ImageView iv = new ImageView(this);
        //linearLayout.setWeightSum(2);
        //LinearLayout.LayoutParams lParams = (LinearLayout.LayoutParams) linearLayout.setLayoutParams(100, 100, );
        //lParams.weight = 1;
        //btn.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        iv.setMinimumHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        iv.setForegroundGravity(View.TEXT_ALIGNMENT_CENTER);
        iv.setScaleType(ImageView.ScaleType.FIT_START);
        iv.setBackgroundColor(getColor(R.color.colorBlack));
        //btn.setScaleType(ImageView.ScaleType.FIT_XY);
        //btn.setMaxHeight(750);

        //iv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,0.5f));
        //btn.setLayoutParams(lParams);

        Glide.with(this.getApplicationContext())
                //.using(new FirebaseImageLoader())
                .load(url)
                .into(iv);

        linearLayout.addView(iv);
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
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setPadding(75,75,75,75);
        linearLayout.stopNestedScroll();
        //linearLayout.canScrollHorizontally(1);
        linearLayout.addView(tv);
    }


}
