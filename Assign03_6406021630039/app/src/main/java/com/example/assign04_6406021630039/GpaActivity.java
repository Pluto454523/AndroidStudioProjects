package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// คลาส GpaActivity สืบทอดจาก AppCompatActivity
// และ implement View.OnClickListener เพื่อจัดการกับการ Click ของ Button
public class GpaActivity extends AppCompatActivity implements View.OnClickListener {

    // ประกาศตัวแปรชนิด EditText
    private EditText inputGrade1, inputGrade2, inputGrade3, inputGrade4, textPoint, textCredit, textGpa;

    // ประกาศตัวแปรชนิด Button
    private Button btnCalculate , btnBack;

    // เมธอด onCreate เรียกใช้เมื่อ GpaActivity เริ่มต้นทำงาน
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        // ส่วนนี้จะทำการ assign ค่า id ของแต่ละตัวแปรโดยใช้ findViewById เพื่อค้นหา id
        // และยังมีการ setOnClickListener ให้กับตัวแปรชนิด Button เพื่อจัดการกับการ Click
        btnCalculate = (Button) findViewById(R.id.btnCalGpa);
        btnCalculate.setOnClickListener(this);
        btnBack = (Button) findViewById(R.id.btnGpaBack);
        btnBack.setOnClickListener(this);

        inputGrade1 = (EditText) findViewById(R.id.inputGrade1);
        inputGrade2 = (EditText) findViewById(R.id.inputGrade2);
        inputGrade3 = (EditText) findViewById(R.id.inputGrade3);
        inputGrade4 = (EditText) findViewById(R.id.inputGrade4);

        textPoint = (EditText) findViewById(R.id.textPoint);
        textCredit = (EditText) findViewById(R.id.textCredit);
        textGpa = (EditText) findViewById(R.id.textGpa);

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        // ตรวจสอบว่าปุ่มที่ถูกคลิกคือปุ่ม btnCalGpa หรือไม่
        if (viewId == R.id.btnCalGpa) {

            // ประกาศตัวแปร array ชนิด String ขนาด 4 เพื่อใช้รับค่าเกรด
            // และ assign ค่าจาก inputGrade แต่ละตัว
            String[] strGrade = new String[4];
            strGrade[0] = inputGrade1.getText().toString();
            strGrade[1] = inputGrade2.getText().toString();
            strGrade[2] = inputGrade3.getText().toString();
            strGrade[3] = inputGrade4.getText().toString();

            // กำหนด ค่าคะแนนเริ่มต้นคือ 0
            float point = 0;

            // ทำการ loop ตามขนาดของ strGrade คือ 0 ถึง 3
            for (int i = 0; i < strGrade.length; i++) {

                // ทำการเช็ต strGrade[i] ของแต่ละรวมว่าเป็นคือว่างหรือไม่
                // หากเป็นค่าว่างจะทำการแจ้ง Please input your grade in field ของ field นั้นๆ
                // และหยุดการทำงาน loop
                if (strGrade[i].isEmpty()) {
                    Toast.makeText(this, "Please input your grade in field " + i, Toast.LENGTH_SHORT).show();
                    break;
                }

                // ทำการเพิ่มค่า point โดยนำค่าเกรดที่เก็บไว้ แปลงเเกรดป็นจำนวนเพื่อใช้ในการคำนวณ
                // โดยนำค่าได้แปลงแล้วมา คูณ 3 แล้วบวกเพิ่มให้กับตัวแปร point
                point += 3.0f * convertGrade(strGrade[i]);

                // เช็คว่าการทำงานของ loop มาถึงเกรดตัวสุดท้ายหรือยัง
                // ถ้าถึงแล้วให้ทำการแสดงข้อมูลที่ได้ทำการคำนวณแล้วออกมาแสดงยังหน้าจอ
                if (i == strGrade.length-1) {
                    textPoint.setText(String.format("%.2f", point) + "");
                    textCredit.setText(String.format("%.2f", 12.0f) + "");
                    textGpa.setText(String.format("%.2f", point / 12) + "");
                }
            }

        }

        // หากมีการกดปุ่ม btnGpaBack จะทำการ finish หน้าจอนี้และกลับไปยัง MainActivity
        else if (viewId == R.id.btnGpaBack) {
            finish();
        }
    }


    // ฟังชั่นการแปลงเกรดเป็นจำนวน เพื่อใช้ในการคำนวณ
    // มีการรับ parameter เป็น String คือเกรด
    // และเช็คเกรดแต่ละตัวหากตรงให้ return ค่าจำนวนของเกรดนั้นกลับออกไป
    public float convertGrade(String strGrade) {
        if (strGrade.equals("A")) {
            return 4.00f;
        } else if (strGrade.equals("B+")) {
            return 3.50f;
        } else if (strGrade.equals("B")) {
            return 3.00f;
        } else if (strGrade.equals("C+")) {
            return 2.50f;
        } else if (strGrade.equals("C")) {
            return 2.00f;
        } else if (strGrade.equals("D+")) {
            return 1.50f;
        } else if (strGrade.equals("D")) {
            return 1.00f;
        }
        return  0.00f;
    }
}