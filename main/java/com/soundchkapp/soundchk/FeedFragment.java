package com.soundchkapp.soundchk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.content.Context;

/**
 * Created by marjorieanncuerdo on 11/16/16.
 */

public class FeedFragment extends Fragment implements View.OnClickListener {

    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_feed, container, false);
        Button button1 = (Button) v.findViewById(R.id.button);
        Button button2 = (Button) v.findViewById(R.id.button2);
        Button button3 = (Button) v.findViewById(R.id.button3);
        Button button4 = (Button) v.findViewById(R.id.button4);
        Button button5 = (Button) v.findViewById(R.id.button5);
        Button button6 = (Button) v.findViewById(R.id.button6);
        Button button7 = (Button) v.findViewById(R.id.button7);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
      
        return v;
    }

    public void onClick(View v) {
        Intent intent;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "griffs");
                String name1 = preferences.getString("storemedia_griff", "");

                if (name1.equals("griff")) {
                    intent.putExtra("locked", "griffs");
                }
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "little");
                String name4 = preferences.getString("storemedia_little", "");
                if (name4.equals("little")) {
                    intent.putExtra("locked", "little");
                }
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "concert");
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "lavaque");
                String name2 = preferences.getString("storemedia_lavaque", "");
                if (name2.equals("lavaque")) {
                    intent.putExtra("locked", "lavaque");
                }
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "events");
                startActivity(intent);
                break;
            case R.id.button6:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "album");
                String name5 = preferences.getString("storemedia_album", "");
                if (name5.equals("album")) {
                    intent.putExtra("locked", "album");
                }
                startActivity(intent);
                break;
            case R.id.button7:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "juicy");
                String name3 = preferences.getString("storemedia_juicy", "");
                if (name3.equals("juicy")) {
                    intent.putExtra("locked", "juicy");
                }
                startActivity(intent);
                break;
        }
    }

}
