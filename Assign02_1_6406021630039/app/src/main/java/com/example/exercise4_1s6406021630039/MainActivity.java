package com.example.exercise4_1s6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputNumber;
    private TextView viewDecimal, viewBinary, viewOctal, viewHexa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputNumber = (EditText) findViewById(R.id.inputNumber);
        viewDecimal = (TextView) findViewById(R.id.viewDecimal);
        viewBinary = (TextView) findViewById(R.id.viewBinary);
        viewOctal = (TextView) findViewById(R.id.viewOctal);
        viewHexa = (TextView) findViewById(R.id.viewHexa);


    }

    public void onClickChange(View v) {
        if (inputNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "คุณยังไม่ได้ใส่ข้อมูล", Toast.LENGTH_SHORT).show();
        } else {
            int DecimalNumber = Integer.parseInt(inputNumber.getText().toString());
            viewDecimal.setText(viewDecimal.getText().toString() + DecimalNumber);
            viewBinary.setText(viewBinary.getText().toString() + Integer.toBinaryString(DecimalNumber));
            viewOctal.setText(viewOctal.getText().toString() + Integer.toOctalString(DecimalNumber));
            viewHexa.setText(viewHexa.getText().toString() + Integer.toHexString(DecimalNumber));
        }

    }

    @Override
    public void onClick(View v) {

    }
}
