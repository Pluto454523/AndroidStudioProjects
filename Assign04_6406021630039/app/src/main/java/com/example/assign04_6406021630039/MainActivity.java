package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView[] btnMenu = new TextView[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMenu[0] = (TextView) findViewById(R.id.btnMenu0);
        btnMenu[0].setOnClickListener(this);
        btnMenu[1] = (TextView) findViewById(R.id.btnMenu1);
        btnMenu[1].setOnClickListener(this);
        btnMenu[2] = (TextView) findViewById(R.id.btnMenu2);
        btnMenu[2].setOnClickListener(this);
        btnMenu[3] = (TextView) findViewById(R.id.btnMenu3);
        btnMenu[3].setOnClickListener(this);
        btnMenu[4] = (TextView) findViewById(R.id.btnMenu4);
        btnMenu[4].setOnClickListener(this);
        btnMenu[5] = (TextView) findViewById(R.id.btnMenu5);
        btnMenu[5].setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btnMenu0) {
            Intent intnentScreen = new Intent(this, AutoCompleteTextViewActivity.class);
            startActivity(intnentScreen);
        } else if (viewId == R.id.btnMenu1) {
            Intent intnentScreen = new Intent(this, TextSwitcherActivity.class);
            startActivity(intnentScreen);
        } else if (viewId == R.id.btnMenu2) {
            Intent intnentScreen = new Intent(this, ImageSwitcherActivity.class);
            startActivity(intnentScreen);
        } else if (viewId == R.id.btnMenu3) {
            Intent intnentScreen = new Intent(this, AdapterViewFilpperActivity.class);
            startActivity(intnentScreen);
        } else if (viewId == R.id.btnMenu4) {
            Intent intnentScreen = new Intent(this, StackViewActivity.class);
            startActivity(intnentScreen);
        } else if (viewId == R.id.btnMenu5) {
            Intent intnentScreen = new Intent(this, ScrollViewActivity.class);
            startActivity(intnentScreen);
        }
    }
}