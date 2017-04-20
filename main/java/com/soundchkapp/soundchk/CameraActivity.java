package com.soundchkapp.soundchk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.net.Uri;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Activity activity = this;

        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt(getString(R.string.text_read_QR));
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String link;

        if (result != null) {
            if(result.getContents() == null) {
                Toast t = Toast.makeText(this, "Cancelled Scan", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER, 0, 0);
                t.show();
                finish();
            }
            else {
                Intent intent;
                link = result.getContents();

                switch (link.toString()) {

                    // QR code: Intro Video
                    case "https://www.youtube.com/watch?v=1iEd1aVe7R0&feature=youtu.be":
                        Uri uri = Uri.parse(link); // missing 'http://' will cause crashed
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        finish();
                        startActivity(intent);

                        break;


                    // CHANGE YOUTUBE LINK TO FINAL!!!!!!
                    case "http://sound-chk-00-introVID":
                        intent = new Intent(getBaseContext(), VideoActivity.class);
                        intent.putExtra("video", "intro");
                        finish();
                        startActivity(intent);

                        break;


                    // QR code: Dr. Griffs Story Page
                    case "http://sound-chk-01-griffs":
                    //case "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/griffs_outline.png?alt=media&token=6fecdebe-e75c-4fbf-8a9a-0d577e693fad":
                    //case "market://detailsintroVID":

                        //getView().findViewById(buttonId).setBackground(getResources().getDrawable(drawableId));
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "griffs");
                        intent.putExtra("locked", "griffs");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor = preferences1.edit();
                        editor.putString("storemedia_griffs","griffs");
                        editor.apply();

                        break;

                    // QR code: Little Box Story Page
                    case "http://sound-chk-02-little":
                        //case "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/little_box_full.PNG?alt=media&token=85a6529b-a605-42cd-acd9-19ab313e4583":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        Log.d("TAG", "little working");
                        intent.putExtra("unlocked", "little");
                        intent.putExtra("locked", "little");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences4 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor4 = preferences4.edit();
                        editor4.putString("storemedia_little","little");
                        editor4.apply();

                        break;

                    // QR code: Juicy Connotation Story Page
                    case "http://sound-chk-03-juicy":
                    //case "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "juicy");
                        intent.putExtra("locked", "juicy");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor2 = preferences2.edit();
                        editor2.putString("storemedia_juicy","juicy");
                        editor2.apply();

                        break;

                    // FINISHED!
                    // QR code: Album Review: Del Paxton
                    case "http://sound-chk-04-paxton":
                    //case "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "paxton");
                        intent.putExtra("locked", "paxton");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor3 = preferences3.edit();
                        editor3.putString("storemedia_paxton","paxton");
                        editor3.apply();

                        break;

                    // FINISHED!
                    // QR code: Album Review: Rosehip
                    case "http://sound-chk-06-rosehip":
                    //case "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/album_full.jpg?alt=media&token=f2e785e0-b285-45ea-9b9e-84659ea69b64":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "rosehip");
                        intent.putExtra("locked", "rosehip");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences5 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor5 = preferences5.edit();
                        editor5.putString("storemedia_rosehip","rosehip");
                        editor5.apply();

                        break;

                    // FINISHED!
                    // QR code: Album Review: Wagoneer
                    case "http://sound-chk-05-wagoneer":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "wagoneer");
                        intent.putExtra("locked", "wagoneer");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences6 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor6 = preferences6.edit();
                        editor6.putString("storemedia_wagoneer","wagoneer");
                        editor6.apply();

                        break;

                    // FINISHED!
                    // QR code: Gig Review: Art Awake 2017
                    case "http://sound-chk-07-artawake":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "artawake");
                        intent.putExtra("locked", "artawake");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences8 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor8 = preferences8.edit();
                        editor8.putString("storemedia_artawake","artawake");
                        editor8.apply();

                        break;

                    // FINISHED!
                    // QR code: Gig Review: Bugjar
                    case "http://sound-chk-08-bugjar":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "bugjar");
                        intent.putExtra("locked", "bugjar");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences7 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor7 = preferences7.edit();
                        editor7.putString("storemedia_bugjar","bugjar");
                        editor7.apply();

                        break;

                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

