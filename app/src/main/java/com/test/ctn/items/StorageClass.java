package com.test.ctn.items;

import com.test.ctn.R;

import java.util.ArrayList;

/**
 * Created by rajat on 08-01-2017.
 */

public class StorageClass {

    public StorageClass(){

    }

    public ArrayList<FoodDetails> getData(){
        ArrayList<FoodDetails> foodItems = new ArrayList<>();

        foodItems.add(new FoodDetails(100,"Burger", R.drawable.burger));
        foodItems.add(new FoodDetails(100,"Vada Pav", R.drawable.vada_pav));
        foodItems.add(new FoodDetails(100,"Aloo Paratha", R.drawable.aloo_paratha));
        foodItems.add(new FoodDetails(100,"Bread Pakora", R.drawable.bread_pakora));
        foodItems.add(new FoodDetails(100,"Cheese Sandwich", R.drawable.cheese_sandwich));
        foodItems.add(new FoodDetails(100,"Chole Bhature", R.drawable.chole_bhature));
        foodItems.add(new FoodDetails(100,"Chole Kulche", R.drawable.chole_kulche));
        foodItems.add(new FoodDetails(100,"Idli Sambar", R.drawable.idli_sambar));
        foodItems.add(new FoodDetails(100,"Khamand", R.drawable.khamand));
        foodItems.add(new FoodDetails(100,"Masala Dosa", R.drawable.masala_dosa));
        foodItems.add(new FoodDetails(100,"Paneer Paratha", R.drawable.paneer_paratha));
        foodItems.add(new FoodDetails(100,"Pav Bhaji", R.drawable.pav_bhaji));
        foodItems.add(new FoodDetails(100,"Pizza", R.drawable.pizza));
        foodItems.add(new FoodDetails(100,"Cheese Pizza", R.drawable.pizza2));
        foodItems.add(new FoodDetails(100,"Rava Dosa", R.drawable.rava_dosa));
        foodItems.add(new FoodDetails(100,"Red Pasta", R.drawable.red_pasta));
        foodItems.add(new FoodDetails(100,"Samosa", R.drawable.samosa));
        foodItems.add(new FoodDetails(100,"Veg. Sandwich", R.drawable.veg_sandwich));
        foodItems.add(new FoodDetails(100,"White pasta", R.drawable.white_pasta));


        return foodItems;
    }


}
