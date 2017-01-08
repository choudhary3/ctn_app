package com.test.ctn;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.ctn.items.*;
import com.test.ctn.plate.*;
import com.test.ctn.profile.*;

public class MainScreen extends AppCompatActivity {
    //Button buttonHome = (Button) findViewById(R.id.home);
    //Button buttonPlate = (Button) findViewById(R.id.home);
    //Button buttonProfile = (Button) findViewById(R.id.home);
    int present =0;
    int back=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("In on create fn");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ItemsFragment itemsFragment = new ItemsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, itemsFragment);
        System.out.println("added fragment");
        present=1;
        back=0;
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(back==1){
            present=1;
        }
    }

    public void homeButton(View view) {
        //buttonHome.setTextColor(Color.parseColor("#0000ff"));
        if(present!=1) {
            ItemsFragment itemsFragment = new ItemsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, itemsFragment);
            FragmentManager fm = getSupportFragmentManager();
            fm.popBackStack();
            ft.commit();
            present=1;
        }
    }
    public void plateButton(View view) {
        if(present!=2) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            PlateFragment plateFragment = new PlateFragment();
            ft.replace(R.id.container, plateFragment);
            if (present == 1) {
                ft.addToBackStack(null);
                back = 1;
            } else {
                FragmentManager fm = getSupportFragmentManager();
                fm.popBackStackImmediate();
            }
            present = 2;
            ft.commit();
        }
    }
    public void profileButton(View view) {
        if(present!=3) {
            ProfileFragment profileFragment = new ProfileFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, profileFragment);
            if (present == 1) {
                ft.addToBackStack(null);
                back = 1;
            } else {
                FragmentManager fm = getSupportFragmentManager();
                fm.popBackStackImmediate();
            }
            present = 3;
            ft.commit();
        }
    }
}
