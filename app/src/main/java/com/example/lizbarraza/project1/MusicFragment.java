package com.example.lizbarraza.project1;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by lizbarraza on 6/18/15.
 */
public class MusicFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.music_layout, container, false);



        Button btPlay= (Button)rootView.findViewById(R.id.btPlay);

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp=MediaPlayer.create(rootView.getContext(),R.raw.crimen);
                try{
                    mp.start();
                }catch(Exception e){e.printStackTrace();}
            }
        });

        return rootView;
    }
}
