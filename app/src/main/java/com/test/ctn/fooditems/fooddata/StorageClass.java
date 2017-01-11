package com.test.ctn.fooditems.fooddata;

import com.test.ctn.R;

import java.util.ArrayList;

public class StorageClass {

    private static ArrayList<FoodDetails> foodItems;
    private static ArrayList<FoodDetails> foodCart;

    public StorageClass() {

    }

    public void setCatalogData() {
        if (foodItems == null) {
            foodItems = new ArrayList<>();

            foodItems.add(new FoodDetails(80, "Manchurian(Dry)", R.drawable.dry_machurian));
            foodItems.add(new FoodDetails(100, "Manchurian(Gravy)", R.drawable.manchurian_with_gravy));
            foodItems.add(new FoodDetails(80, "Pizza", R.drawable.pizza));
            foodItems.add(new FoodDetails(100, "Cheese Pizza", R.drawable.pizza2));
            foodItems.add(new FoodDetails(35, "Cheese Sandwich", R.drawable.cheese_sandwich));
            foodItems.add(new FoodDetails(50, "Veg. Sandwich", R.drawable.veg_sandwich));
            foodItems.add(new FoodDetails(100, "Red Pasta", R.drawable.red_pasta));
            foodItems.add(new FoodDetails(50, "Garlic Bread", R.drawable.garlic_bread));
            foodItems.add(new FoodDetails(110, "White pasta", R.drawable.white_pasta));
            foodItems.add(new FoodDetails(70, "French Fries", R.drawable.french_fries));
            foodItems.add(new FoodDetails(80, "Chowmein", R.drawable.chowmein));
            foodItems.add(new FoodDetails(60, "Hot Dog", R.drawable.hot_dog));
            foodItems.add(new FoodDetails(30, "Burger", R.drawable.burger));
            foodItems.add(new FoodDetails(80, "Fried Rice", R.drawable.fried_rice));
            foodItems.add(new FoodDetails(90, "Schezwan Rice", R.drawable.schezwan_rice));
            foodItems.add(new FoodDetails(40, "Aloo Paratha", R.drawable.aloo_paratha));
            foodItems.add(new FoodDetails(50, "Paneer Paratha", R.drawable.paneer_paratha));
            foodItems.add(new FoodDetails(20, "Vada Pav", R.drawable.vada_pav));
            foodItems.add(new FoodDetails(20, "Bread Pakora", R.drawable.bread_pakora));
            foodItems.add(new FoodDetails(40, "Chole Kulche", R.drawable.chole_kulche));
            foodItems.add(new FoodDetails(50, "Pav Bhaji", R.drawable.pav_bhaji));
            foodItems.add(new FoodDetails(30, "Samosa Chaat", R.drawable.samosa));
            foodItems.add(new FoodDetails(40, "Bhel", R.drawable.bhel));
            foodItems.add(new FoodDetails(50, "Dahi Vada", R.drawable.dahi_vada));
            foodItems.add(new FoodDetails(40, "Pani Puri", R.drawable.pani_puri));
            foodItems.add(new FoodDetails(40, "Idli Sambar", R.drawable.idli_sambar));
            foodItems.add(new FoodDetails(80, "Masala Dosa", R.drawable.masala_dosa));
            foodItems.add(new FoodDetails(80, "Rava Dosa", R.drawable.rava_dosa));
            foodItems.add(new FoodDetails(40, "Uttapam", R.drawable.uttapam));
            foodItems.add(new FoodDetails(50, "Chole Bhature", R.drawable.chole_bhature));
            foodItems.add(new FoodDetails(30, "Khamand", R.drawable.khamand));
        }
    }

    public ArrayList<FoodDetails> getCatalogData() {
        return foodItems;
    }

    public ArrayList<FoodDetails> getFoodCart() {
        if (foodCart == null) {
            foodCart = new ArrayList<>();
        }
        return foodCart;
    }
}
