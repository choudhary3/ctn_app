package com.test.ctn.fooditems.fooddata;
import java.io.Serializable;

public class FoodDetails implements Serializable{
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
