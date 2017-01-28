package com.test.ctn.profile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.ctn.Login;
import com.test.ctn.R;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        TextView username = (TextView) view.findViewById(R.id.username);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getContext());
        name.setText(sp.getString(Login.NAME, "Noobie"));
        username.setText(sp.getString(Login.USERNAME, "noobie123"));

        return view;
    }
}
