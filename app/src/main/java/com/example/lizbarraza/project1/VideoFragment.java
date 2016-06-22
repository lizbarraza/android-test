package com.example.lizbarraza.project1;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by lizbarraza on 6/18/15.
 */
public class VideoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.video_layout, container, false);

        VideoView videoView =(VideoView)rootView.findViewById(R.id.videoView);

        MediaController mediaController= new MediaController(getActivity());
        mediaController.setAnchorView(videoView);

        //Uri uri=Uri.parse("/sdcard/media/1.mp4");
        Uri uri=Uri.parse("/storage/emulated/0/DCIM/Camera/video1.mp4");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        return rootView;
    }
}
