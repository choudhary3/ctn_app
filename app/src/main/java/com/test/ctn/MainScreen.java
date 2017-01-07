package com.test.ctn;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {
    Button menu_button = (Button) findViewById(R.id.menu);
    Button cart_button = (Button) findViewById(R.id.cart);
    Button profile_button = (Button) findViewById(R.id.profile);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }
    public void menu(View view) {
        System.out.println("function started");
        Menufrag mf = new Menufrag();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.middle_frame, mf);
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
        ft.commit();

    }

    public void cart(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Cartfrag cf = new Cartfrag();
        ft.replace(R.id.middle_frame, cf);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void profile(View view) {
        Profilefrag pf = new Profilefrag();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentManager fm = getSupportFragmentManager();
        ft.replace(R.id.middle_frame, pf);
        fm.popBackStack();
        ft.commit();
    }
}
