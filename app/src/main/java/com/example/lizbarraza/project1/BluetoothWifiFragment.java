package com.example.lizbarraza.project1;

import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lizbarraza on 6/19/15.
 */
public class BluetoothWifiFragment extends Fragment {


    private static final int BUTTON_ENABLE_RQST=0;
    private static final int BUTTON_ENABLE_DSCRY=0;
    Button btOn, btOff, btDisc, btWifiOn, btWifiOff;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.bluetooth_wifi_layout, container, false);


         btOn= (Button)rootView.findViewById(R.id.btOn);
         btOff= (Button)rootView.findViewById(R.id.btOff);
         btDisc= (Button)rootView.findViewById(R.id.btDisc);
         btWifiOn= (Button)rootView.findViewById(R.id.btWifiOn);
         btWifiOff= (Button)rootView.findViewById(R.id.btWifiOff);

        final BluetoothAdapter madpater= BluetoothAdapter.getDefaultAdapter();

       // Log.e(this.getClass().getName(), "btON " + btOn);
        btOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!madpater.isEnabled()){
                    Intent intent= new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent,BUTTON_ENABLE_RQST);

                }

            }


        });

        btDisc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!madpater.isDiscovering()){
                    Intent intent= new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent,BUTTON_ENABLE_DSCRY);

                }

            }


        });


        btOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                madpater.disable();

            }


        });

        btWifiOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi=(WifiManager)getActivity().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);

            }
        });

        btWifiOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi=(WifiManager)getActivity().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
            }
        });


        return rootView;
    }
}
