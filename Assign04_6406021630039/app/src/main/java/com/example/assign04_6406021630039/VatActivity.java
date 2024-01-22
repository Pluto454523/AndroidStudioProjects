package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VatActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCalculate , btnBack;
    private EditText inputPrice, textPriceProduct, textVatProduct, textTototalProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat);
        btnCalculate = (Button) findViewById(R.id.btnCalVat);
        btnCalculate.setOnClickListener(this);
        btnBack = (Button) findViewById(R.id.btnVatBack);
        btnBack.setOnClickListener(this);

        inputPrice = (EditText) findViewById(R.id.inputPrice);
        textPriceProduct = (EditText) findViewById(R.id.textPriceProduct);
        textVatProduct = (EditText) findViewById(R.id.textVatProduct);
        textTototalProduct = (EditText) findViewById(R.id.textTototalProduct);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btnCalVat) {
            if (! inputPrice.getText().toString().isEmpty()) {
                float price = Float.parseFloat(inputPrice.getText().toString());
                float vat = price * 0.07f;
                float total = price + vat;
                textPriceProduct.setText(String.format("%.2f", price) + "");
                textVatProduct.setText(String.format("%.2f", vat) + "");
                textTototalProduct.setText(String.format("%.2f", total) + "");
            } else {
                Toast.makeText(this, "Please input your product price.", Toast.LENGTH_SHORT).show();
            }
        }
        if (viewId == R.id.btnVatBack) {
            finish();
        }
    }
}