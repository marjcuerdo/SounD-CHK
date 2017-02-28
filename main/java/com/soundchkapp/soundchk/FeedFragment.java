package com.soundchkapp.soundchk;

import android.content.Intent;
import android.os.Bundle;
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
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("message", "griffs");
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("message", "little");
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("message", "concert");
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("message", "lavaque");
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("message", "events");
                startActivity(intent);
                break;
            case R.id.button6:
                intent = new Intent(getActivity(), StoryPageActivity.class);
                intent.putExtra("message", "album");
                startActivity(intent);
                break;
        }
    }

}
