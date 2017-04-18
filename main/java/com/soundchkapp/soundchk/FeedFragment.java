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

    Button button1, button2, button3, button4, button5, button6, button7, button8;

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
        button8 = (Button) v.findViewById(R.id.button8);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);

        return v;
    }

    public void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (preferences.contains("storemedia_griffs")) {
            button1.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button, R.drawable.final_button_griffs);
        }
        if (preferences.contains("storemedia_little")) {
            button2.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button2, R.drawable.final_button_little);
        }
        if (preferences.contains("storemedia_juicy")) {
            button3.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button3, R.drawable.final_button_juicy);
        }

        if (preferences.contains("storemedia_paxton")) {
            button4.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button4, R.drawable.final_button_paxton);
        }
        if (preferences.contains("storemedia_rosehip")) {
            button5.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button5, R.drawable.final_button_rosehip);
        }
        if (preferences.contains("storemedia_wagoneer")) {
            button6.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button6, R.drawable.final_button_wagoneer);
        }
        if (preferences.contains("storemedia_artawake")) {
            button7.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button7, R.drawable.final_button_artawake);
        }
        if (preferences.contains("storemedia_bugjar")) {
            button8.setTextColor(getResources().getColor(R.color.colorWhite));
            setButtonBg(R.id.button8, R.drawable.final_button_bugjar);
        }

    }

    public void onClick(View v) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        switch (v.getId()) {

            case R.id.button:
                openStoryPage("griffs", preferences, R.id.button, R.drawable.final_button_griffs);
                break;

            case R.id.button2:
                openStoryPage("little", preferences, R.id.button2, R.drawable.final_button_little);
                break;

            case R.id.button3:
                openStoryPage("juicy", preferences, R.id.button3, R.drawable.final_button_juicy);
                break;

            case R.id.button4:
                openStoryPage("paxton", preferences, R.id.button4, R.drawable.final_button_paxton);
                break;

            case R.id.button5:
                openStoryPage("rosehip", preferences, R.id.button5, R.drawable.final_button_rosehip);
                break;

            case R.id.button6:
                openStoryPage("wagoneer", preferences, R.id.button6, R.drawable.final_button_wagoneer);
                break;

            case R.id.button7:
                openStoryPage("artawake", preferences, R.id.button7, R.drawable.final_button_artawake);
                break;

            case R.id.button8:
                openStoryPage("bugjar", preferences, R.id.button8, R.drawable.final_button_bugjar);
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
        getView().findViewById(buttonId).setAlpha(1);
    }
}
