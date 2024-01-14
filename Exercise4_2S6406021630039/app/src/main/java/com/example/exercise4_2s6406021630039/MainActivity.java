package com.example.exercise4_2s6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView viewNumber;

    private Button btnCountUP, btnCountDown, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewNumber = (TextView) findViewById(R.id.viewNumber);

        btnCountUP = (Button) findViewById(R.id.btnCountUP);
        btnCountUP.setOnClickListener(this);
        btnCountDown = (Button) findViewById(R.id.btnCountDown);
        btnCountDown.setOnClickListener(this);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        int viewValue = Integer.parseInt(viewNumber.getText().toString());

        if (viewId == R.id.btnCountUP) {
            viewValue++;
        } else if (viewId == R.id.btnCountDown) {
            viewValue--;
        } else if (viewId == R.id.btnReset) {
            viewValue = 0;
        }

        viewNumber.setText("" + viewValue);
        if ((viewValue%5) == 0) {
            Toast.makeText(this, viewValue + " can be division by 5.", Toast.LENGTH_SHORT).show();
        }
    }
}