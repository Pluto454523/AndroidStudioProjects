package com.example.testradiobuttonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btnOK) {
            String message = "";
            if (radioButton1.isChecked()) {
                message = radioButton1.getText().toString();
            } else if (radioButton2.isChecked()) {
                message = radioButton2.getText().toString();
            } else if (radioButton3.isChecked()) {
                message = radioButton3.getText().toString();
            } else if (radioButton4.isChecked()) {
                message = radioButton4.getText().toString();
            } else if (radioButton5.isChecked()) {
                message = radioButton5.getText().toString();
            }

            Toast.makeText(this, "You choose : " + message, Toast.LENGTH_SHORT).show();
        }
    }
}