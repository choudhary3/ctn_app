package com.test.ctn;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.test.ctn.fooditems.fooddata.StorageClass;
import com.test.ctn.fooditems.menuUi.ItemsFragment;
import com.test.ctn.plate.*;
import com.test.ctn.profile.*;

public class MainScreen extends AppCompatActivity {
    public static final String EXIT = "EXIT";
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean(Login.LOGIN_CHECK, false);
                editor.commit();
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.exit:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Exit Application?");
                alertDialogBuilder
                        .setMessage("Click yes to exit!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        moveTaskToBack(true);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(1);
                                    }
                                })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
