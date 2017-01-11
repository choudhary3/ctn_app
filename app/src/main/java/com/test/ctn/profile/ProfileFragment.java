package com.test.ctn.profile;

import android.os.Bundle;
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

        name.setText(Login.nameS);
        username.setText(Login.usernameS);

        return view;
    }
}
