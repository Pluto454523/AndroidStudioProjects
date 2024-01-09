package com.example.switchtoggleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Switch wifiSwitch, btSwitch;
    private ToggleButton toggleBtn1, toggleBtn2;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiSwitch = (Switch) findViewById(R.id.wifiSwitch);
        btSwitch = (Switch) findViewById(R.id.bluetoothSwitch);
        toggleBtn1 = (ToggleButton) findViewById(R.id.toggleButton);
        toggleBtn2 = (ToggleButton) findViewById(R.id.toggleButton2);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);

    }

    public void onClickSwitch(View v) {
        int viewId = v.getId();
        if (viewId == R.id.wifiSwitch) {
            if (wifiSwitch.isChecked()) {
                Toast.makeText(this, "WiFi ON!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "WiFi OFF!", Toast.LENGTH_SHORT).show();
            }
        } else if (viewId == R.id.bluetoothSwitch) {
            if (btSwitch.isChecked()) {
                Toast.makeText(this, "Bluetooth ON!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth OFF!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickToggle(View v) {
        int viewId = v.getId();
        if (viewId == R.id.toggleButton) {
            if (toggleBtn1.isChecked()) {
                Toast.makeText(this, "WiFi Toggle ON!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "WiFi Toggle OFF!", Toast.LENGTH_SHORT).show();
            }
        } else if (viewId == R.id.toggleButton2) {
            if (toggleBtn2.isChecked()) {
                Toast.makeText(this, "Bluetooth Toggle ON!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth Toggle OFF!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnOK) {
            String message = "";
            message += "\nWiFi Switch " + (wifiSwitch.isChecked() ? "ON" : "OFF");
            message += "\nBluetooth Switch " + (btSwitch.isChecked() ? "ON" : "OFF");
            message += "\nWiFI Toggle " + (toggleBtn1.isChecked() ? "ON" : "OFF");
            message += "\nBluetooth Toggle " + (toggleBtn2.isChecked() ? "ON" : "OFF");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}