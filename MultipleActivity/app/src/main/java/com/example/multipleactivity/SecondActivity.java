package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnBackFirst, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnBackFirst = (Button) findViewById(R.id.btnBackFirst);
        btnBackFirst.setOnClickListener(this);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btnBackFirst) {
            Toast.makeText(this, "Finish Second Activity", Toast.LENGTH_SHORT).show();
            finish();
        } else if (viewId == R.id.btnExit) {
            finishAffinity();
        }
    }
}