package com.example.changenumberapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InsertGesture;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText decText;
    private Button btnCal;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decText = (EditText) findViewById(R.id.decText);
        btnCal = (Button) findViewById(R.id.btnCal);
        resultText = (TextView) findViewById(R.id.resultText);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String decStr = decText.getText().toString();
                if (decStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Empty input", Toast.LENGTH_SHORT).show();
                    return;
                }

                int dec;
                dec = Integer.parseInt(decStr);
                String binText = "";
                binText = dectoBin(dec);
                resultText.setText(binText);
                Toast.makeText(MainActivity.this, "Binary Number : " + binText, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private String dectoBin(int dec) {

        return "" + Integer.toBinaryString(dec);

    }


}