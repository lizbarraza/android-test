package com.example.lizbarraza.project1;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lizbarraza on 6/17/15.
 */
public class CallingSmsFragment extends Fragment {

    Button btCall, btSendMsg;
    EditText txMessage, txNumber;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calling_sms_layout, container, false);

        btCall = (Button) rootView.findViewById(R.id.btCall);
        btSendMsg = (Button) rootView.findViewById(R.id.btSendMsg);
        txNumber = (EditText) rootView.findViewById(R.id.txNumber);
        txMessage = (EditText) rootView.findViewById(R.id.txMessage);

        //sending message
        btSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = txNumber.getText().toString();
                String sms = txMessage.getText().toString();
                SmsManager Smst = SmsManager.getDefault();
                Smst.sendTextMessage(phone, null, sms, null, null);
            }
        });


        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + txNumber.getText().toString().trim()));
                startActivity(intent);

            }
        });

        return rootView;

    }
}
