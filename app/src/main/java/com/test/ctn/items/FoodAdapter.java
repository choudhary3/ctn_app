package com.test.ctn.items;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.ctn.R;

import java.util.ArrayList;

/**
 * Created by rajat on 08-01-2017.
 */

public class FoodAdapter extends ArrayAdapter<FoodDetails> {

    public FoodAdapter (Context context,ArrayList<FoodDetails> storage){
        super(context,0,storage);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater customInflater = LayoutInflater.from(getContext());
            convertView = customInflater.inflate(R.layout.food_item,parent,false);
        }

        FoodDetails foodItem = getItem(position);

        ImageView ifoodimage = (ImageView) convertView.findViewById(R.id.foodimage);
        TextView ifoodName = (TextView) convertView.findViewById(R.id.foodname);
        TextView ifoodPrice = (TextView) convertView.findViewById(R.id.foodprice);

        ifoodimage.setImageResource(foodItem.getFoodImage());
        ifoodName.setText(foodItem.getFoodName());
        ifoodPrice.setText(Integer.toString(foodItem.getPrice()));

        return convertView;
    }
}
