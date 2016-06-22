package com.example.lizbarraza.project1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by lizbarraza on 6/29/15.
 */
public class ContactsFragment extends Fragment {

    Button b;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contacts_layout, container, false);


//        Log.d(this.getClass().getName(), "intent " + getActivity().getIntent());
//        Log.d(this.getClass().getName(), "data " + getActivity().getIntent().getData());
//        String dataPath = getActivity().getIntent().getData().toString();
//        final Uri data = Uri.parse(dataPath + "people/");


        final Uri data = Uri.parse("content://contacts/people/");
        final Cursor c = getActivity().managedQuery(data, null, null, null, null);

        String[] from = new String[] {Contacts.People.DISPLAY_NAME};
        int[]  to = new int[] { R.id.itemTextView };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity().getApplicationContext(),
                R.layout.list_item_contact_layout,
                c, from, to);
        ListView lv = (ListView)rootView.findViewById(R.id.listView1);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {


                c.moveToPosition(pos);
                int rowId = c.getInt(c.getColumnIndexOrThrow(Contacts.People.NUMBER));  //_id
//                Uri outURI = Uri.parse(data.toString() + rowId);
//                Intent outData = new Intent();
//                outData.setData(outURI);
//                setResult(Activity.RESULT_OK, outData);
//                finish();


                int cols = c.getColumnCount();
                int index = c.getColumnIndexOrThrow(Contacts.People.NAME);
                String[] colNames = c.getColumnNames();

                StringBuffer sb = new StringBuffer();

                for (int i=0; i < cols; i++)
                {
                    //if ("number".equals(colNames[i]))

                    sb.append(colNames[i] + " = " + c.getString(i) +"\n");
                }
                sb.append("\n");

                Context context = getActivity().getApplicationContext();
                Toast.makeText(context, sb, Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }


}

