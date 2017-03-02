package com.soundchkapp.soundchk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
                Toast.makeText(this, "You cancelled the scanning.", Toast.LENGTH_LONG).show();
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

                    // QR code: Dr. Griffs Story Page
                    case "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/griffs_outline.png?alt=media&token=6fecdebe-e75c-4fbf-8a9a-0d577e693fad":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "griffs");
                        intent.putExtra("locked", "griffs");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor = preferences1.edit();
                        editor.putString("storemedia_griff","griff");
                        editor.apply();

                        break;

                    // QR code: Juicy Connotation Story Page
                    case "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/juicy_full.jpg?alt=media&token=a2fd8e74-9974-4cb0-95d5-61438e35e25a":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "juicy");
                        intent.putExtra("locked", "juicy");
                        finish();
                        startActivity(intent);
                        break;

                    // QR code: Lavaque Story Page
                    case "https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/lavaque_full.jpg?alt=media&token=39196cd2-2e15-4ef6-a48a-057c0aeb49c9":
                        intent = new Intent(getBaseContext(), StoryPageActivity.class);
                        intent.putExtra("unlocked", "lavaque");
                        intent.putExtra("locked", "lavaque");
                        finish();
                        startActivity(intent);

                        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(this);
                        SharedPreferences.Editor editor2 = preferences2.edit();
                        editor2.putString("storemedia_lavaque","lavaque");
                        editor2.apply();

                        break;



                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

