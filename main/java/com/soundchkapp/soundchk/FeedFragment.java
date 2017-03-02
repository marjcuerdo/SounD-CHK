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

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        return v;
    }

    public void onClick(View v) {
        Intent intent;

        //SharedPreferences preferences = this.getActivity().getSharedPreferences("storemedia", Context.MODE_PRIVATE);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //String name = preferences.getString("storemedia", "");


        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "griffs");
                String name1 = preferences.getString("storemedia_griff", "");

                if (name1.equals("griff")) {
                    Log.d("TAG", "griff work");
                    //this.getActivity().getIntent().putExtra("locked", "griffs");
                    intent.putExtra("locked", "griffs");
                } else {
                    Log.d("TAG", "griff SUCK");
                }
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("unlocked", "little");
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
                    Log.d("TAG", "lavaque work");
                    intent.putExtra("locked", "lavaque");
                } else {
                    Log.d("TAG", "lavaque SUCK");
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
                startActivity(intent);
                break;
        }
    }

}
