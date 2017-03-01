package com.soundchkapp.soundchk;

import android.content.Intent;
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
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
/**
 * Created by marjorieanncuerdo on 11/16/16.
 */

public class CameraFragment extends Fragment {

    private StorageReference mStorageRef;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_camera, container, false);

        Button button = (Button)v.findViewById(R.id.scan_btn);
        //final ImageView iv = (ImageView)v.findViewById(R.id.fireImage);

        //mStorageRef = FirebaseStorage.getInstance().getReference().child("gs://soundchk-98ed0.appspot.com/1.png");


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*Log.d("TAG", "firebase CLICKED");

                Glide.with(getContext())
                        //.using(new FirebaseImageLoader())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/soundchk_logo.png?alt=media&token=9daac771-ff45-4459-8c28-cf6077c7b8ba")
                        .into(iv);
                */

                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);

            }
        });
        return v;
    }


}

