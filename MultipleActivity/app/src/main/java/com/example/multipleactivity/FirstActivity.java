package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBackMain, btnNextSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toast.makeText(this, "Welcome to First Activity", Toast.LENGTH_SHORT).show();
        btnBackMain = (Button) findViewById(R.id.btnBackMain);
        btnBackMain.setOnClickListener(this);
        btnNextSecond = (Button) findViewById(R.id.btnNextSecond);
        btnNextSecond.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btnBackMain) {
            Toast.makeText(this, "Finish First Activity", Toast.LENGTH_SHORT).show();
            finish();
        } else if (viewId == R.id.btnNextSecond) {
            Toast.makeText( this,"Call Second Activity", Toast.LENGTH_SHORT).show();
            Intent launchSecond = new Intent( this, SecondActivity.class);
            startActivity(launchSecond); // call SecondActivity
        }
    }
}