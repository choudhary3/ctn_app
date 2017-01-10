package com.test.ctn.fooditems.solofoodUi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.test.ctn.R;
import com.test.ctn.fooditems.fooddata.FoodDetails;
import com.test.ctn.fooditems.fooddata.StorageClass;


public class SelectedFood extends AppCompatActivity {

    private StorageClass foodData;
    private int index;
    private TextView foodQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_selected_food);
        Intent dataRetrieve = getIntent();
        FoodDetails specificFood = (FoodDetails) dataRetrieve.getSerializableExtra("myObject");

        foodData = new StorageClass();  // giving memory to storageClass object ;
        try {
            index = searchForFood(specificFood);
            if (index >= 0){
                ImageView foodImage = (ImageView) findViewById(R.id.selectedimage);
                TextView foodName = (TextView) findViewById(R.id.selectedfood);
                TextView foodPrice = (TextView) findViewById(R.id.selectedprice);
                foodQuantity = (TextView) findViewById(R.id.selectednoofitems);
                foodImage.setImageResource(foodData.getData().get(index).getFoodImage());
                foodName.setText(foodData.getData().get(index).getFoodName());
                foodPrice.setText(Integer.toString(foodData.getData().get(index).getPrice()));


                System.out.println("Image set");

                foodQuantity.setText(Integer.toString(foodData.getData().get(index).getFoodQuantity()));
                //System.out.println("Image set");
            }
            else {
                throw new IllegalArgumentException("SELECTED_FOOD_NOT_IN_DATA");
            }

        }
        catch (IllegalArgumentException e){
            e.getMessage();
           // Toast.makeText(this," selected not Found ",Toast.LENGTH_SHORT).show();
        }


    }
    public void addbyone(View v){
        foodData.getData().get(index).incFoodQuantity();
        foodQuantity.setText(Integer.toString(foodData.getData().get(index).getFoodQuantity()));
    }

    private int searchForFood(FoodDetails specificFood){
        for (int i=0;i<=foodData.getData().size();i++){
            if (specificFood.getFoodName().equals(foodData.getData().get(i).getFoodName())){
                return i;
            }
        }
        return -1;
    }



}
