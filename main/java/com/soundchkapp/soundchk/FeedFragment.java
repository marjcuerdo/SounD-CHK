package com.soundchkapp.soundchk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;

/**
 * Created by marjorieanncuerdo on 11/16/16.
 */

public class FeedFragment extends Fragment implements View.OnClickListener {

    Button button1, button2, button3, button4, button5, button6, button7;

    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_feed, container, false);
        button1 = (Button) v.findViewById(R.id.button);
        button2 = (Button) v.findViewById(R.id.button2);
        button3 = (Button) v.findViewById(R.id.button3);
        button4 = (Button) v.findViewById(R.id.button4);
        button5 = (Button) v.findViewById(R.id.button5);
        button6 = (Button) v.findViewById(R.id.button6);
        button7 = (Button) v.findViewById(R.id.button7);



        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        return v;
    }

    public void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (preferences.contains("storemedia_griffs")) {
            button1.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button, R.drawable.griffs_full);
        }
        if (preferences.contains("storemedia_little")) {
            button2.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button2, R.drawable.little_box_full);
        }
        if (preferences.contains("storemedia_concert")) {
            button3.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button3, R.drawable.pinegrove_full);
        }
        if (preferences.contains("storemedia_lavaque")) {
            button4.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button4, R.drawable.lavaque_full);
        }
        if (preferences.contains("storemedia_events")) {
            button5.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button5, R.drawable.events_full);
        }
        if (preferences.contains("storemedia_album")) {
            button6.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button6, R.drawable.album_full);
        }
        if (preferences.contains("storemedia_juicy")) {
            button7.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button7, R.drawable.juicy_full);
        }

        /*String name1 = preferences.getString("storemedia_"+name, "");

        if (getContext().getStringExtra("locked") != null) {
            switch (getActivity().getIntent().getStringExtra("locked")) {
                case "griffs":
                    setButtonBg(R.id.button, R.drawable.griffs_full);
                    break;
            }
        }
        */
    }

    public void onClick(View v) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        switch (v.getId()) {
            case R.id.button:
                openStoryPage("griffs", preferences, R.id.button, R.drawable.griffs_full);
                break;

            case R.id.button2:
                openStoryPage("little", preferences, R.id.button2, R.drawable.little_box_full);
                break;

            case R.id.button3:
                openStoryPage("concert", preferences, R.id.button3, R.drawable.pinegrove_full);
                break;

            case R.id.button4:
                openStoryPage("lavaque", preferences, R.id.button4, R.drawable.lavaque_full);
                break;

            case R.id.button5:
                openStoryPage("events", preferences, R.id.button5, R.drawable.events_full);
                break;

            case R.id.button6:
                openStoryPage("album", preferences, R.id.button6, R.drawable.album_full);
                break;

            case R.id.button7:
                openStoryPage("juicy", preferences, R.id.button7, R.drawable.juicy_full);
                break;
        }
    }

    public void openStoryPage(String name, SharedPreferences sharedp, int buttonId, int drawableId) {
        Intent intent = new Intent(getActivity(), StoryPageActivity.class);
        intent.putExtra("unlocked", name);
        String name1 = sharedp.getString("storemedia_"+name, "");

        if (name1.equals(name)) {
            intent.putExtra("locked", name);
            getView().findViewById(buttonId).setBackground(getResources().getDrawable(drawableId));
        }
        startActivity(intent);
    }

    public void setButtonBg(int buttonId, int drawableId) {
        getView().findViewById(buttonId).setBackground(getResources().getDrawable(drawableId));
    }
}
