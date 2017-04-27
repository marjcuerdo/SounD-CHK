package com.soundchkapp.soundchk;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
                TextView tv = (TextView)getView().findViewById(R.id.scan_instructions);
                tv.setVisibility(View.GONE);
                button.setBackgroundResource(R.drawable.roundedbutton_clicked);
                button.setTextColor(Color.WHITE);
                Intent intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });


        ImageButton button_intro_vid = (ImageButton)v.findViewById(R.id.button_qr_code_example);

        button_intro_vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("video", "intro");
                startActivity(intent);
            }
        });

        return v;
    }


    public void onResume() {
        super.onResume();
        Button button = (Button)getView().findViewById(R.id.scan_btn);

        button.setBackgroundResource(R.drawable.roundedbutton);
        button.setTextColor(getResources().getColor(R.color.colorBlack));
    }

    ////
    public static CameraFragment newInstance(int page, String title) {
        CameraFragment fragmentSecond = new CameraFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentSecond.setArguments(args);
        return fragmentSecond;
    }

}

