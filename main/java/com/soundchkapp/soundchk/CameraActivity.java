package com.soundchkapp.soundchk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.net.Uri;
import android.util.Log;

import java.util.Objects;


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

        //File localFile = File.createTempFile("images", "jpg");

        if (result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
                finish();
            }
            else {
                Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();
                link = result.getContents();
                Uri uri = Uri.parse(link); // missing 'http://' will cause crashed
                Log.d("TAG", link.toString());

                if (Objects.equals(link.toString(), "http://www.qrstuff.com/")) {
                    Intent intent = new Intent(getBaseContext(), StoryPageActivity.class);
                    startActivity(intent);
                } else {
                    Log.d("TAG", "QR wrong");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }



            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}

