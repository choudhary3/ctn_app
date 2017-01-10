package com.test.ctn.fooditems.menuUi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.test.ctn.R;
import com.test.ctn.fooditems.solofoodUi.SelectedFood;
import com.test.ctn.fooditems.fooddata.FoodDetails;
import com.test.ctn.fooditems.fooddata.StorageClass;

public class ItemsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items, container, false);

        final GridView gridview = (GridView) view.findViewById(R.id.gridview);

        StorageClass foodStorage = new StorageClass();


        gridview.setAdapter(new FoodAdapter(getContext(),foodStorage.getData()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getContext(), "" + position,
                        Toast.LENGTH_SHORT).show();
                FoodDetails food = (FoodDetails) gridview.getItemAtPosition(position);
                Intent activity = new Intent(getContext(),SelectedFood.class);

               // Bundle bundle = new Bundle();

                activity.putExtra("myObject", food);
                startActivity(activity);
            }
        });
        return view;
    }
}
