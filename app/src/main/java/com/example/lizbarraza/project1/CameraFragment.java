package com.example.lizbarraza.project1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by lizbarraza on 6/17/15.
 */
public class CameraFragment extends Fragment {

    ImageView imgCaptured;
    Button btTakePhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.camera_layout, container, false);

        btTakePhoto = (Button) rootView.findViewById(R.id.btTakePhoto);
        imgCaptured = (ImageView) rootView.findViewById(R.id.imgCaptured);

        btTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
        return rootView;

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        Log.d("", "requestCode " + requestCode + " resultCode " + resultCode);

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != 0) {
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            imgCaptured.setImageBitmap(bp);
        }
    }
}
