package com.example.lizbarraza.project1;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lizbarraza on 6/17/15.
 */
public class LocationFragment extends Fragment {


    Button btGetLocation, btGetDetails;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_details_layout, container, false);

        btGetLocation=(Button) rootView.findViewById(R.id.btGetLocation);
        btGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent n = new Intent(getActivity(), MapsActivity.class);
                startActivity(n);
            }
        });

        return rootView;

    }
}
