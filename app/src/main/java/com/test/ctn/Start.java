package com.test.ctn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (sp.getBoolean(Login.LOGIN_CHECK, false)) {
            Intent intent = new Intent(this, MainScreen.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }

    }
}
