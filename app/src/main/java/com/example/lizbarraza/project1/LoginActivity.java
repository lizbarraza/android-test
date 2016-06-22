package com.example.lizbarraza.project1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lizbarraza on 6/17/15.
 */
public class LoginActivity extends Activity {
    Button btGuest;
    Button btUser;
    public static final String MyPref="myPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        SharedPreferences sff=getSharedPreferences(MyPref,0);


        btGuest= (Button) findViewById(R.id.btGuest);
        btUser= (Button) findViewById(R.id.btUser);
        btGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user="guest";
                SharedPreferences sf=getSharedPreferences(MyPref, 0);
                SharedPreferences.Editor editor=sf.edit();
                editor.putString("USER",user);
                editor.commit();
                Intent n = new Intent(LoginActivity.this, MainMenu.class);
                startActivity(n);
            }
        });

    }
}

