package com.example.lizbarraza.project1;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lizbarraza on 6/17/15.
 */
public class LogoutFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View rootView= inflater.inflate(R.layout.logout_layout,container,false);
        //return rootView;

        SharedPreferences sf=this.getActivity().getSharedPreferences(LoginActivity.MyPref, 0);

        Log.d(this.getClass().getName(), "---BEFORE LOGOUT "+ sf.getString("USER", ""));
        SharedPreferences.Editor editor=sf.edit();
        editor.putString("USER","");
        editor.commit();

        Log.d(this.getClass().getName(), "----- AFTER LOGOUT " + sf.getString("USER", ""));
        Intent n = new Intent(this.getActivity(), LoginActivity.class);
        startActivity(n);


        return null;

    }
}
