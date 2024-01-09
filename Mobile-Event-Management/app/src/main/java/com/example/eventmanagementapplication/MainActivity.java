package com.example.eventmanagementapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // แบบที่ 1 Inner Class
        Button btnType1 = (Button) findViewById(R.id.btnType1);
        btnType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Event type 1 : Use Inner Class", Toast.LENGTH_SHORT).show();
            }
        });

        // แบบที่ 3 ใช้การ implement
        Button btnType3 = (Button) findViewById(R.id.btnType3);
        btnType3.setOnClickListener(this);

        Button btnType4 = (Button) findViewById(R.id.btnType4);
        btnType4.setOnClickListener(this);
    }

    // แบบที่ 2 Arttribute onClick ของปุ่ม
    public void buttonOnClick2(View v)
    {
        Toast.makeText(this, "Event Type 2 : Use attribute onCLick", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnType5(View v)
    {
        Toast.makeText(this, "onClickBtnType 5", Toast.LENGTH_SHORT).show();
    }


    // แบบที่ 3 method ที่ implement ถูกสืบทอดมาจากการ implement View.OnClickListener
    @Override
    public void onClick(View V) {
        int viewId = V.getId();
        if (viewId == R.id.btnType4) {
            Toast.makeText(this, "Event Type 4 : Use implement", Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.btnType3) {
            Toast.makeText(this, "Event Type 3 : Use implement", Toast.LENGTH_SHORT).show();
        }
    }
}