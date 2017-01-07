package com.test.ctn;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }
    /*public void menu(View view) {
        System.out.println("function started");
        button1 = (Button) findViewById(R.id.b1);
        button1.setTextColor(Color.parseColor("#0000ff"));
        button1.setTextColor(getApplication().getResources().getColor(R.color.colorgreen));
        button1.setBackground(this.getResources().getDrawable(R.drawable.yourimage));
        System.out.println("Functions ");
        button1.setTextSize(20);
        //button1.setBackground(R.drawable.yourimage);
        System.out.println("in fn");
        List_frag ff = new List_frag();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, ff);
        Bundle args = new Bundle();
        FragmentManager fm = getSupportFragmentManager();
        fm.popBackStack();
        args.putIntArray("ts", items);
        ff.setArguments(args);
        ft.commit();

    }

    public void cart(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Order_frag of = new Order_frag();
        Bundle args = new Bundle();
        args.putIntArray("ts", items);
        of.setArguments(args);
        ft.replace(R.id.fragment_container, of);
        ft.addToBackStack(null);
        ft.commit();
        System.out.println("OVER");

    }

    public void profile(View view) {
        if (present != 0) {
            present = 0;
            List_frag ff = new List_frag();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Bundle reset = new Bundle();
            for (int i = 0; i < 8; i++) {
                items[i] = 0;
            }
            FragmentManager fm = getSupportFragmentManager();
            reset.putIntArray("ts", items);
            ff.setArguments(reset);
            ft.replace(R.id.fragment_container, ff);
            fm.popBackStack();
            //ft.addToBackStack(null);
            ft.commit();
        }
    }*/
}
