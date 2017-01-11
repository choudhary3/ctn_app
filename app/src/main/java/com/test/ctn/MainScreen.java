package com.test.ctn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.test.ctn.fooditems.fooddata.StorageClass;
import com.test.ctn.fooditems.menuUi.ItemsFragment;
import com.test.ctn.plate.*;
import com.test.ctn.profile.*;

public class MainScreen extends AppCompatActivity {

    boolean backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        StorageClass foodStorage = new StorageClass();
        Intent intent = getIntent();

        if (intent.getExtras().getString("From").equals("SelectedFood")) {
            View view = findViewById(R.id.plate);
            plateButton(view);
        } else {
            foodStorage.setCatalogData();
            View view = findViewById(R.id.home);
            homeButton(view);
        }
        backPressed = false;
    }

    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("MAIN_MENU");
        if (currentFragment != null && currentFragment.isVisible()) {
            if (backPressed) {
                super.onBackPressed();
            } else {
                backPressed = true;
                Toast.makeText(this, "Press Again To Exit", Toast.LENGTH_SHORT).show();
            }
        } else {
            ItemsFragment itemsFragment = new ItemsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, itemsFragment, "MAIN_MENU");
            ft.commit();
        }
    }

    public void homeButton(View view) {
        backPressed = false;
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("MAIN_MENU");
        if (currentFragment == null || !currentFragment.isVisible()) {
            ItemsFragment itemsFragment = new ItemsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, itemsFragment, "MAIN_MENU");
            ft.commit();
        }
    }

    public void plateButton(View view) {
        backPressed = false;
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("PLATE_VIEW");
        if (currentFragment == null || !currentFragment.isVisible()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            PlateFragment plateFragment = new PlateFragment();
            ft.replace(R.id.container, plateFragment, "PLATE_VIEW");
            ft.commit();
        }
    }

    public void profileButton(View view) {
        backPressed = false;
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("PROFILE_VIEW");
        if (currentFragment == null || !currentFragment.isVisible()) {
            ProfileFragment profileFragment = new ProfileFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, profileFragment, "PROFILE_VIEW");
            ft.commit();
        }
    }
}
