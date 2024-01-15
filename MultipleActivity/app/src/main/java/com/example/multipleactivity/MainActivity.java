package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnFirst, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFirst = (Button) findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(this);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btnFirst) {
            Toast.makeText( this,"Call FirstActivity", Toast.LENGTH_SHORT).show();
            Intent launchFirst = new Intent( this, FirstActivity.class);
            startActivity(launchFirst); // call FirstActivity
        }
        else if (viewId == R.id.btnExit) {
            Toast.makeText( this,"Exit Main Activity", Toast.LENGTH_SHORT).show();
            finish(); // exit app
        }
    }
}