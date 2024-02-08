package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// คลาส MainActivity สืบทอดจาก AppCompatActivity
// และ implement View.OnClickListener เพื่อจัดการกับการ Click ของ Button
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // ประกาศตัวแปรชนิด Button
    private Button btnMenuCalGrade , btnMenuCalVat, btnMenuCalGpa, btnMenuShowGallery, btnMenuExit;


    // เมธอด onCreate เรียกใช้เมื่อ activity เริ่มต้นทำงาน
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ส่วนนี้จะทำการ assign ค่า id ของแต่ละตัวแปรโดยใช้ findViewById เพื่อค้นหา id
        // และยังมีการ setOnClickListener ไปยัง onClick ภายในคลาสเพื่อจัดการกับการ Click
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

    //เรียกใช้เมื่อมีการ Click ของ Button
    @Override
    public void onClick(View v) {
        // โดยมีการรับค่า v และนำมา id จาก v มาเก็บในตัวแปร viewId
        // เพื่อใข้ในการตรวจสอบ id ของ Button
        // หากมีการกดปุ่มที่ตรงกับเงื่อนไขจะทำการ startActivity ไปยังหน้า activity ต่อๆไป
        // โดยการ startActivity จะมี parameter ชนิด intent
        // ซึ่งเราจะ new ขึ้นมาตาม activirt class ที่เราต้องการจะไป
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