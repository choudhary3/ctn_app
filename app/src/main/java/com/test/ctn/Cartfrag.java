package com.test.ctn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Inspiron on 08-01-2017.
 */

public class Cartfrag extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //System.out.println("setcontenthere3");
        View view = inflater.inflate(R.layout.cart_frag, container, false);
        return view;
    }
}
