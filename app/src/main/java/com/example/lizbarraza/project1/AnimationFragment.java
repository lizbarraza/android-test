package com.example.lizbarraza.project1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by lizbarraza on 6/19/15.
 */
public class AnimationFragment extends Fragment{

    ImageView image;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.animation_layout, container, false);

        image= (ImageView) rootView.findViewById(R.id.image);

        // fromCoordinate, to Coordinate vertical , and then  the other 2 horizontal
        TranslateAnimation animation=new TranslateAnimation(0.0f,150.0f,0.0f,0.0f);
        animation.setDuration(5000);
        animation.setRepeatMode(5);
        animation.setFillAfter(true);
        animation.setRepeatCount(2);
        image.startAnimation(animation);


        return rootView;
    }
}
