package com.soundchkapp.soundchk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by marjorieanncuerdo on 11/16/16.
 */

public class FaveFragment extends Fragment implements View.OnClickListener {

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_favorites, container, false);

        ImageButton button_fave_vid = (ImageButton) v.findViewById(R.id.button_fave_vid);
        ImageButton button_fave_images = (ImageButton) v.findViewById(R.id.button_fave_images);
        ImageButton button_fave_audio = (ImageButton) v.findViewById(R.id.button_fave_audio);

        button_fave_audio.setOnClickListener(this);
        button_fave_images.setOnClickListener(this);
        button_fave_vid.setOnClickListener(this);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = preferences1.edit();
        editor.putString("status", "empty");
        editor.commit();

    }

    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.button_fave_vid:
                intent = new Intent(getActivity(), FaveActivity.class);
                intent.putExtra("fave", "vids");
                startActivity(intent);
                break;
            case R.id.button_fave_images:
                intent = new Intent(getActivity(), FaveActivity.class);
                intent.putExtra("fave", "images");
                startActivity(intent);
                break;
            case R.id.button_fave_audio:
                intent = new Intent(getActivity(), FaveActivity.class);
                intent.putExtra("fave", "audio");
                startActivity(intent);
                break;
        }
    }

}
