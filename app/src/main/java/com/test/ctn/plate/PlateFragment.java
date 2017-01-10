package com.test.ctn.plate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.test.ctn.R;
import com.test.ctn.fooditems.fooddata.StorageClass;

public class PlateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plate, container, false);

        final ListView listview = (ListView) view.findViewById(R.id.custom_ListView);


        listview.setAdapter(new PlateAdapter(getContext(),new StorageClass().getFoodCart()));


        /*listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //FoodDetails foodItem = (FoodDetails) listview.getItemAtPosition(position);
                Intent activity= new Intent(getContext(),SecondayActivity.class);
                //Bundle bundle = new Bundle();
                activity.putExtra("detail",position);
                System.out.println("in on click");
                startActivity(activity);

            }
        });*/
        return view;
    }
}
