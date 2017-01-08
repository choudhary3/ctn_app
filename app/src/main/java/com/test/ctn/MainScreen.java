package com.test.ctn;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v4.app.Fragment;
import android.widget.Button;

import com.test.ctn.items.*;
import com.test.ctn.plate.*;
import com.test.ctn.profile.*;

public class MainScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("In on create fn");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ItemsFragment itemsFragment = new ItemsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, itemsFragment,"Main_Menu");
        System.out.println("added fragment");
        ft.commit();
        Log.i("fragchecking ",Integer.toString(getFragmentManager().getBackStackEntryCount()));
    }


    /*
    *  handling the back press button
    *  below
     */


    @Override
    public void onBackPressed() {
        Fragment checking = getSupportFragmentManager().findFragmentByTag("Main_Menu");
        if (checking!=null && checking.isVisible()){
            super.onBackPressed();
        }
        else {
            ItemsFragment itemsFragment = new ItemsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, itemsFragment,"Main_Menu");
            FragmentManager fm = getSupportFragmentManager();


            fm.popBackStack();
            ft.commit();
            Log.i("fragchecking ",Integer.toString(getFragmentManager().getBackStackEntryCount()));

        }

       // super.onBackPressed();
    }

    public void homeButton(View view) {
        //buttonHome.setTextColor(Color.parseColor("#0000ff"));

        Fragment checking = getSupportFragmentManager().findFragmentByTag("Main_Menu");
        if (checking==null || !checking.isVisible()){
            ItemsFragment itemsFragment = new ItemsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, itemsFragment,"Main_Menu");
            FragmentManager fm = getSupportFragmentManager();

            /*

            checking the pop buttomns
            */

            //ft.addToBackStack("Main_Menu");
            ft.commit();
            Log.i("fragchecking ",Integer.toString(getFragmentManager().getBackStackEntryCount()));
        }


    }

    public void plateButton(View view) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        PlateFragment plateFragment = new PlateFragment();
        ft.replace(R.id.container, plateFragment);

        /*

        checking the pop buttomns
         */
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
        ft.commit();
        Log.i("fragchecking ",Integer.toString(getFragmentManager().getBackStackEntryCount()));

    }



    public void profileButton(View view) {

        ProfileFragment profileFragment = new ProfileFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, profileFragment);

        /*

        checking the pop buttomns
         */

        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
        ft.commit();

        Log.i("fragchecking ",Integer.toString(getFragmentManager().getBackStackEntryCount()));

    }

}
