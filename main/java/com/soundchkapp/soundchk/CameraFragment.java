package com.soundchkapp.soundchk;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.FileDownloadTask;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import android.support.annotation.NonNull;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
/**
 * Created by marjorieanncuerdo on 11/16/16.
 */

public class CameraFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_camera, container, false);

        final Button button = (Button)v.findViewById(R.id.scan_btn);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //button.setBackgroundColor(Color.BLUE);
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });

        ImageButton button_intro_vid = (ImageButton)v.findViewById(R.id.button_qr_code_example);

        button_intro_vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1iEd1aVe7R0&feature=youtu.be"));
                startActivity(intent);
            }
        });

        return v;
    }


}

