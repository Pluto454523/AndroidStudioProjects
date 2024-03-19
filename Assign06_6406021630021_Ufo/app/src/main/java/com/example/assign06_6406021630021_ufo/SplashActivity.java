package com.example.assign06_6406021630021_ufo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000); // กำหนดให้ sleep ก่อน 5 วิ
                } catch (InterruptedException e) {

                }
                Intent intent = new Intent(SplashActivity.this,
                        MainActivity.class);

                startActivity(intent);
                finish();

            }
        }).start();
    }
}