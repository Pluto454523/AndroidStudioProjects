package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// คลาส VatActivity สืบทอดจาก AppCompatActivity
// และ implement View.OnClickListener เพื่อจัดการกับการ Click ของ Button
public class VatActivity extends AppCompatActivity implements View.OnClickListener{

    // ประกาศตัวแปรชนิด Button
    private Button btnCalculate , btnBack;

    // ประกาศตัวแปรชนิด EditText
    private EditText inputPrice, textPriceProduct, textVatProduct, textTototalProduct;

    // เมธอด onCreate เรียกใช้เมื่อ activity เริ่มต้นทำงาน
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vat);

        // ส่วนนี้จะทำการ assign ค่า id ของแต่ละตัวแปรโดยใช้ findViewById เพื่อค้นหา id
        // และยังมีการ setOnClickListener ให้กับตัวแปรชนิด Button เพื่อจัดการกับการ Click
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
        // รับ ID ของ view ที่ถูกคลิก
        int viewId = v.getId();
        // ตรวจสอบว่าปุ่มที่ถูกคลิกคือปุ่ม btnCalVat หรือไม่
        if (viewId == R.id.btnCalVat) {

            // ตรวจสอบ inputPrice ไม่เป็นค่าว่าง
            // และทำการคำนวณค่าต่างๆ และแสดงผล
            if (! inputPrice.getText().toString().isEmpty()) {
                float price = Float.parseFloat(inputPrice.getText().toString());
                float vat = price * 0.07f;
                float total = price + vat;
                textPriceProduct.setText(String.format("%.2f", price) + "");
                textVatProduct.setText(String.format("%.2f", vat) + "");
                textTototalProduct.setText(String.format("%.2f", total) + "");
            } else {
                // ห่ากเป็นค่าว่างจะแสดงแจ้งเตือน Please input your product price
                Toast.makeText(this, "Please input your product price.", Toast.LENGTH_SHORT).show();
            }
        }
        if (viewId == R.id.btnVatBack) {
            // หากมีการกดปุ่ม btnVatBack จะทำการ finish หน้าจอนี้และกลับไปยัง MainActivity
            finish();
        }
    }
}