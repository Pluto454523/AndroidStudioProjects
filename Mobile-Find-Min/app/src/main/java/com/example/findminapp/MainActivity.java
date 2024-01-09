package com.example.findminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnClear, btnMin;
    TextView labelShow;
    EditText numText;
    final String message = "Values Number Add:";
    int count = 0;
    int min, numArray[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnMin = (Button) findViewById(R.id.btnMin);
        labelShow = (TextView) findViewById(R.id.labelShow);
        numText = (EditText) findViewById(R.id.numText);

        btnMin.setEnabled(false);
        btnClear.setEnabled(false);
        numArray = new int[5];

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btnAdd) {
            if (count == 0) {
                btnMin.setEnabled(true);
                btnClear.setEnabled(true);
            }

            numArray[count] = Integer.parseInt(numText.getText().toString());
            count++;

            labelShow.setText(labelShow.getText().toString() + "\n -> " + numText.getText().toString());
            numText.setText("");

            if (count == numArray.length) {
                btnAdd.setEnabled(false);
                Toast.makeText(this, "Add 5 Numbers", Toast.LENGTH_SHORT).show();
            }

        } else if (viewId == R.id.btnMin) {
            min = findMin();
            Toast.makeText(this, "Minimum number is " + min, Toast.LENGTH_SHORT).show();
        } else if (viewId == R.id.btnClear) {

            numText.setText("");
            labelShow.setText(message);

            btnMin.setEnabled(false);
            btnClear.setEnabled(false);
            count = 0;
        }
    }

    public int findMin() {
        int min = numArray[0];
        for (int i = 0; i < count; i++) {
            if (min > numArray[i]) {
                min = numArray[i];
            }
        }
        return min;
    }
}