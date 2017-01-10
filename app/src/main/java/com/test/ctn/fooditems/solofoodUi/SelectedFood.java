package com.test.ctn.fooditems.solofoodUi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.ctn.R;
import com.test.ctn.fooditems.fooddata.FoodDetails;

public class SelectedFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_food);
        Intent dataRetrieve = getIntent();
        FoodDetails specificFood = (FoodDetails) dataRetrieve.getSerializableExtra("myObject");
        ImageView foodImage = (ImageView) findViewById(R.id.foodimage);
        TextView foodName  = (TextView) findViewById(R.id.foodname);
        TextView foodPrice  = (TextView) findViewById(R.id.foodprice);
        foodImage.setImageResource(specificFood.getFoodImage());
        foodName.setText(specificFood.getFoodName());
        foodPrice.setText(Integer.toString(specificFood.getPrice()));
    }
}
