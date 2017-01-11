package com.test.ctn.plate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.test.ctn.R;
import com.test.ctn.fooditems.fooddata.StorageClass;
import com.test.ctn.fooditems.menuUi.ItemsFragment;

public class PlateFragment extends Fragment {
    ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_plate, container, false);

        listview = (ListView) view.findViewById(R.id.custom_ListView);
        listview.setAdapter(new PlateAdapter(getContext(),new StorageClass().getFoodCart()));

        FloatingActionButton addItems = (FloatingActionButton) view.findViewById(R.id.addItems);
        listview.setEmptyView(view.findViewById(R.id.empty_view));
        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Add Some Items",Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            }
        });

        return view;
    }



}
