package com.test.ctn;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.test.ctn.fooditems.fooddata.StorageClass;
import com.test.ctn.fooditems.menuUi.ItemsFragment;
import com.test.ctn.plate.*;
import com.test.ctn.profile.*;

public class MainScreen extends AppCompatActivity {

    // double tapping feature
    boolean backPressed ;
    // for double tap



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("In on create fn");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        /*
            setting data on creation of app
         */

        StorageClass foodStorage = new StorageClass();
        foodStorage.setData();
        /*
            setting data on creation of app
         */

        ItemsFragment itemsFragment = new ItemsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.container, itemsFragment,"Main_Menu");
        System.out.println("added fragment");

        getSupportFragmentManager().popBackStack();

        ft.commit();
        Log.i("fragchecking ",Integer.toString(getFragmentManager().getBackStackEntryCount()));

       backPressed = false;

    }


    /*
    *  handling the back press button
    *  below
    */


    @Override
    public void onBackPressed() {
        Fragment checking = getSupportFragmentManager().findFragmentByTag("Main_Menu");
        if (checking!=null && checking.isVisible()){
            if (backPressed){
                super.onBackPressed();
            }
            else {
                backPressed = true;
                Toast.makeText(this,"Press Again To Exit",Toast.LENGTH_SHORT).show();
            }
        }
        else {
            ItemsFragment itemsFragment = new ItemsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, itemsFragment,"Main_Menu");

            /*FragmentManager fm = getSupportFragmentManager();
            fm.popBackStack();*/

            ft.commit();
            Log.i("fragchecking ",Integer.toString(getFragmentManager().getBackStackEntryCount()));

        }

       // super.onBackPressed();
    }


    /*
    when home button is pressed below method executes ...
     */
    public void homeButton(View view) {
        //buttonHome.setTextColor(Color.parseColor("#0000ff"));
        backPressed = false;
        Fragment checking = getSupportFragmentManager().findFragmentByTag("Main_Menu");
        if (checking==null || !checking.isVisible()){
            Toast.makeText(this,"Menu Pressed",Toast.LENGTH_SHORT).show();


            ItemsFragment itemsFragment = new ItemsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, itemsFragment,"Main_Menu");


            /*

            checking the pop buttomns
            */

            //ft.addToBackStack("Main_Menu");

            //getSupportFragmentManager().popBackStack();
            ft.commit();
            Log.i("fragchecking ",Integer.toString(getFragmentManager().getBackStackEntryCount()));
        }
    }


    /*
    when PLATE button is pressed below method executes ...
     */
    public void plateButton(View view) {
        backPressed = false;
        Fragment checking = getSupportFragmentManager().findFragmentByTag("PLATE_VIEW");
        if (checking==null || !checking.isVisible()) {

            Toast.makeText(this,"Plate Pressed",Toast.LENGTH_SHORT).show();

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            PlateFragment plateFragment = new PlateFragment();
            ft.replace(R.id.container, plateFragment, "PLATE_VIEW");


            /*FragmentManager fm = getSupportFragmentManager();
            fm.popBackStack();*/
            ft.commit();
            Log.i("fragchecking ", Integer.toString(getFragmentManager().getBackStackEntryCount()));
        }
    }



    public void profileButton(View view) {
        backPressed = false;
        Fragment checking = getSupportFragmentManager().findFragmentByTag("PROFILE_VIEW");
        if (checking==null || !checking.isVisible()) {

            Toast.makeText(this,"Profile Pressed",Toast.LENGTH_SHORT).show();

            ProfileFragment profileFragment = new ProfileFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, profileFragment, "PROFILE_VIEW");


            /*FragmentManager fm = getSupportFragmentManager();
            fm.popBackStack();*/
            ft.commit();

            Log.i("fragchecking ", Integer.toString(getFragmentManager().getBackStackEntryCount()));
        }
    }

}
