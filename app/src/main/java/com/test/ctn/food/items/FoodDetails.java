package com.test.ctn.food.items;

/**
 * Created by Pradeep on 1/8/2017.
 */

public class FoodDetails {
    private int price;
    private String foodName;
    private int foodImage;

    public FoodDetails(int mPrice, String mFoodName, int mFoodImage){
        price = mPrice;
        foodName = mFoodName;
        foodImage = mFoodImage;
    }

    public int getPrice() {
        return price;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public String getFoodName() {
        return foodName;
    }
}
