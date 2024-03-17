package com.example.lecture_10_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main");
        finish();
        Intent screen = new Intent(this, OptionMenuActivity.class);
//        Intent screen = new Intent(this, ContextMenuActivity.class);
//        Intent screen = new Intent(this, PopupMenuActivity.class);
        startActivity(screen);
    }
}