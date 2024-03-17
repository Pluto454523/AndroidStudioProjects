package com.example.assign05_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result1, result2;
    private final Button[] btnCalculator = new Button[17];
    private final float[] numbers = new float[2];
    private char currentSymbol;
    private String strNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setTitle("Calculator Application");

        /** ทำการ init ตัวแปรเข้ากับ Resource id ต่างๆ **/
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        btnCalculator[0] = (Button) findViewById(R.id.zero);
        btnCalculator[0].setOnClickListener(this);
        btnCalculator[1] = (Button) findViewById(R.id.one);
        btnCalculator[1].setOnClickListener(this);
        btnCalculator[2] = (Button) findViewById(R.id.two);
        btnCalculator[2].setOnClickListener(this);
        btnCalculator[3] = (Button) findViewById(R.id.three);
        btnCalculator[3].setOnClickListener(this);
        btnCalculator[4] = (Button) findViewById(R.id.four);
        btnCalculator[4].setOnClickListener(this);
        btnCalculator[5] = (Button) findViewById(R.id.five);
        btnCalculator[5].setOnClickListener(this);
        btnCalculator[6] = (Button) findViewById(R.id.six);
        btnCalculator[6].setOnClickListener(this);
        btnCalculator[7] = (Button) findViewById(R.id.seven);
        btnCalculator[7].setOnClickListener(this);
        btnCalculator[8] = (Button) findViewById(R.id.eight);
        btnCalculator[8].setOnClickListener(this);
        btnCalculator[9] = (Button) findViewById(R.id.nine);
        btnCalculator[9].setOnClickListener(this);
        btnCalculator[10] = (Button) findViewById(R.id.divide);
        btnCalculator[10].setOnClickListener(this);
        btnCalculator[11] = (Button) findViewById(R.id.multiply);
        btnCalculator[11].setOnClickListener(this);
        btnCalculator[12] = (Button) findViewById(R.id.plus);
        btnCalculator[12].setOnClickListener(this);
        btnCalculator[13] = (Button) findViewById(R.id.minus);
        btnCalculator[13].setOnClickListener(this);
        btnCalculator[14] = (Button) findViewById(R.id.dot);
        btnCalculator[14].setOnClickListener(this);
        btnCalculator[15] = (Button) findViewById(R.id.allClear);
        btnCalculator[15].setOnClickListener(this);
        btnCalculator[16] = (Button) findViewById(R.id.equal);
        btnCalculator[16].setOnClickListener(this);

        INIT();

    }

    private void calculation() {

        /**
         * เช็คว่า numbers ตำแหน่งที่ 0 มีค่าหรือเปล่า
         * true:    แสดงว่าตำแหน่งที่ 0 มีค่าจะเราค่าของ strNumber
         *          มาแปลงไว้ใน numbers ตำแหน่งที่ 1 และทำการคำนวณต่อไป
         * flase:   แสดงว่าตำแหน่งที่ 0 ยังไม่มีค่าจะทำการเอาค่าของ strNumber
         *          มาแปลงไว้ใน numbers ตำแหน่งที่ 0
         * */
        if (!Float.isNaN(numbers[0])) {

            numbers[1] = Float.parseFloat(strNumber);
            if (currentSymbol == '+')
                numbers[0] = (numbers[0] + numbers[1]);
            else if (currentSymbol == '-')
                numbers[0] = (numbers[0] - numbers[1]);
            else if (currentSymbol == '*')
                numbers[0] = (numbers[0] * numbers[1]);
            else if (currentSymbol == '/')
                numbers[0] = (numbers[0] / numbers[1]);

            result1.setText(formatNumber(numbers[0]) + "");
            strNumber = numbers[0] + "";

        } else {

            numbers[0] = Float.parseFloat(strNumber);
            result1.setText("0");
            strNumber = "0";
        }

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        if (viewId == R.id.backBtn) {
            finish();
        }
        /**
         * เป็นการเช็ตการกดปุ่มตัวเลข 0-9 และ จุดทสนิยม
         * แล้วแทนลงตัวแปร tempNumber เพื่อใช้ในการคำนวณ
         */
        char tempNumber = 0;
        if (viewId == R.id.zero) {
            tempNumber = '0';
        } else if (viewId == R.id.one) {
            tempNumber = '1';
        } else if (viewId == R.id.two) {
            tempNumber = '2';
        } else if (viewId == R.id.three) {
            tempNumber = '3';
        } else if (viewId == R.id.four) {
            tempNumber = '4';
        } else if (viewId == R.id.five) {
            tempNumber = '5';
        } else if (viewId == R.id.six) {
            tempNumber = '6';
        } else if (viewId == R.id.seven) {
            tempNumber = '7';
        } else if (viewId == R.id.eight) {
            tempNumber = '8';
        } else if (viewId == R.id.nine) {
            tempNumber = '9';
        } else if (viewId == R.id.dot) {
            tempNumber = '.';
        }

        /** เช็คความยาวของ strNumber เพื่อป้องกันการผิดพลาดหากไม่มีตัวอักษรใน String */
        if (strNumber.length() > 0) {

            /** ตัวแปรไว้เก็บตัวอักษรสุดท้ายของ strNumber เพื่อใช้ในการตรวจสอบ **/
            char endChar = strNumber.charAt(strNumber.length() - 1);

            /**
             * ทำการเช็คความยาวของ strNumber เพื่อป้องการผิดพลาด และ strNumber ตำแหน่งที่ 0 ต้องมีค่า 0
             * และเช็ค tempNumber เพื่อเป็นการต่อ String ที่ถูกต้อง
             * true:    ทำพการ assign ค่า strNumber จาก tempNumber
             * false:   ทำการต่อ String strNumber กับ tempNumber
             * */

            if (strNumber.length() == 1) {
                if (Character.isDigit(tempNumber)) {
                    if (strNumber.charAt(0) == '0') {
                        strNumber = String.valueOf(tempNumber);
                    } else  {
                        strNumber += tempNumber;
                    }
                } else {
                    strNumber += tempNumber;
                }
            } else if (strNumber.length() > 1) {
                if (Character.isDigit(tempNumber)) {
                    strNumber += tempNumber;
                } else if (tempNumber == '.' && !strNumber.contains(".")) {
                    strNumber += tempNumber;
                }
            }

            result1.setText(strNumber);

            /**
             * เช็คว่าตัวสุดท้ายไม่ได้เป็นเครื่องหมายดำเนินการถึงจะสามารถใส่เครื่องหมายดำเนินการได้
             **/
            if (endChar != '+' && endChar != '-' && endChar != '*' && endChar != '/' && endChar != '=') {
                if (viewId == R.id.divide) {
                    calculation();
                    currentSymbol = '/';
                    result2.setText(formatNumber(numbers[0]) + "" + currentSymbol);
                    strNumber = "0";
                } else if (viewId == R.id.multiply) {
                    calculation();
                    currentSymbol = '*';
                    result2.setText(formatNumber(numbers[0]) + "" + currentSymbol);
                    strNumber = "0";
                } else if (viewId == R.id.plus) {
                    calculation();
                    currentSymbol = '+';
                    result2.setText(formatNumber(numbers[0]) + "" + currentSymbol);
                    strNumber = "0";
                } else if (viewId == R.id.minus) {
                    calculation();
                    currentSymbol = '-';
                    result2.setText(formatNumber(numbers[0]) + "" + currentSymbol);
                    strNumber = "0";
                }
            }

            /** เช็คกดปุ่มเท่ากับ */
            if (viewId == R.id.equal && currentSymbol != '=') {
                result2.setText(numbers[0] + "" + currentSymbol + "" + strNumber + "=");
                calculation();
                currentSymbol = '=';
                numbers[0] = Float.NaN;
            }
        }

        /**
         * ทำการแยกเช็คปุ่ม allClear
         * true:    จะทำการ setText ของ result1 และ result2 เป็นค่าเริ่มต้น
         *          และเรียกใช้ method INIT เพื่อทำการกำหนดค่าเริ่มต้นตัวแปรใหม่
         **/
        if (viewId == R.id.allClear) {
            result1.setText("0");
            result2.setText("");
            INIT();
        }


    }

    private String formatNumber(float number) {
        if (number % 1 == 0) {
            return String.format("%.0f", number);
        }

        return String.format("%.4f", number);
    }

    private void INIT() {
        numbers[0] = Float.NaN;
        numbers[1] = Float.NaN;
        strNumber = "0";
    }

}