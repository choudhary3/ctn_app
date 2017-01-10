package com.test.ctn.plate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.ctn.R;
import com.test.ctn.fooditems.fooddata.FoodDetails;

import java.util.ArrayList;

/**
 * Created by rajat on 10-01-2017.
 */

public class PlateAdapter extends ArrayAdapter<FoodDetails> {
    public PlateAdapter (Context context, ArrayList<FoodDetails> storage){
        super(context,0,storage);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater customInflater = LayoutInflater.from(getContext());
            convertView = customInflater.inflate(R.layout.plate_list_layout,parent,false);
        }
        FoodDetails foodItem = getItem(position);
        ImageView ifoodimage = (ImageView) convertView.findViewById(R.id.listimage);
        TextView ifoodName = (TextView) convertView.findViewById(R.id.listname);
        TextView ifoodItems = (TextView) convertView.findViewById(R.id.listitem);

        ifoodimage.setImageResource(foodItem.getFoodImage());
        ifoodName.setText(foodItem.getFoodName());
        ifoodItems.setText(Integer.toString(foodItem.getFoodQuantity()));

        return convertView;
    }
}
