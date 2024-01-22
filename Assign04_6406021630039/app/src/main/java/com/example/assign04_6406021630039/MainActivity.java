package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMenuCalGrade , btnMenuCalVat, btnMenuCalGpa, btnMenuShowGallery, btnMenuExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMenuCalGrade = (Button) findViewById(R.id.btnMenuCalGrade);
        btnMenuCalGrade.setOnClickListener(this);
        btnMenuCalVat = (Button) findViewById(R.id.btnMenuCalVat);
        btnMenuCalVat.setOnClickListener(this);
        btnMenuCalGpa = (Button) findViewById(R.id.btnMenuCalGpa);
        btnMenuCalGpa.setOnClickListener(this);
        btnMenuShowGallery = (Button) findViewById(R.id.btnMenuShowGallery);
        btnMenuShowGallery.setOnClickListener(this);
        btnMenuExit = (Button) findViewById(R.id.btnMenuExit);
        btnMenuExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btnMenuCalGrade) {
            Intent intent1 = new Intent(this, GradeActivity.class);
            startActivity(intent1);
        } else if (viewId == R.id.btnMenuCalVat) {
            Intent intent2 = new Intent(this, VatActivity.class);
            startActivity(intent2);
        } else if (viewId == R.id.btnMenuCalGpa) {
            Intent intent3 = new Intent(this, GpaActivity.class);
            startActivity(intent3);
        } else if (viewId == R.id.btnMenuShowGallery) {
            Intent intent4= new Intent(this, ShowGalleryActivity.class);
            startActivity(intent4);
        } else if (viewId == R.id.btnMenuExit) {
            finish();
        }
    }
}