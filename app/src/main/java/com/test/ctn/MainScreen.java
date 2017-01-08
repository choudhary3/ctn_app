package com.test.ctn;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainScreen extends AppCompatActivity {
    Button buttonHome = (Button) findViewById(R.id.home);
    Button buttonPlate = (Button) findViewById(R.id.home);
    Button buttonProfile = (Button) findViewById(R.id.home);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        //ItemsFragment itemsFragment = new ItemsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ft.add(R.id.container, itemsFragment);
        ft.commit();
    }
    /*public void homeButton(View view) {
        buttonHome.setTextColor(Color.parseColor("#0000ff"));
        ItemsFragment itemsFragment = new ItemsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, itemsFragment);
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
        ft.commit();
    }*/
    /*public void plateButton(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        PlateFragment plateFragment = new PlateFragment();
        ft.replace(R.id.container, plateFragment);
        ft.addToBackStack(null);
        ft.commit();
    }*/
    /*public void profileButton(View view) {
        ProfileFragment profileFragment = new ProfileFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentManager fm = getSupportFragmentManager();
        ft.replace(R.id.container, profileFragment);
        fm.popBackStack();
        ft.commit();
    }*/
}
