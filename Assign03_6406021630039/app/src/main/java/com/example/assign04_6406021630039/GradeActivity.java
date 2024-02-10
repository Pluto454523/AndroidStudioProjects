package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// คลาส GradeActivity สืบทอดจาก AppCompatActivity
// และ implement View.OnClickListener เพื่อจัดการกับการ Click ของ Button
public class GradeActivity extends AppCompatActivity implements View.OnClickListener {

    // ประกาศตัวแปรชนิด EditText
    private EditText inputScore, textScore, textGrade;

    // ประกาศตัวแปรชนิด Button
    private Button btnCalculate , btnBack;

    // เมธอด onCreate เรียกใช้เมื่อ activity เริ่มต้นทำงาน
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        // ส่วนนี้จะทำการ assign ค่า id ของแต่ละตัวแปรโดยใช้ findViewById เพื่อค้นหา id
        // และยังมีการ setOnClickListener ให้กับตัวแปรชนิด Button เพื่อจัดการกับการ Click
        inputScore = (EditText) findViewById(R.id.inputScore);
        textScore = (EditText) findViewById(R.id.textScore);
        textGrade = (EditText) findViewById(R.id.textGrade);
        btnCalculate = (Button) findViewById(R.id.btnCalGrade);
        btnCalculate.setOnClickListener(this);
        btnBack = (Button) findViewById(R.id.btnGradeBack);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int viewId = v.getId(); // รับ ID ของ view ที่ถูกคลิก
        if (viewId == R.id.btnCalGrade) { // ตรวจสอบว่าปุ่มที่ถูกคลิกคือปุ่ม btnCalGrade หรือไม่

            // ตรวจสอบและแปลงคะแนนเป็นเกรด
            if (! inputScore.getText().toString().isEmpty()) {
                int score = Integer.parseInt(inputScore.getText().toString());
                String grade = "";
                if (score >= 80 && score <= 100) {
                    grade = "A";
                } else if (score >= 75 && score < 80) {
                    grade = "B+";
                } else if (score >= 70 && score < 75) {
                    grade = "B";
                } else if (score >= 65 && score < 70) {
                    grade = "C+";
                } else if (score >= 60 && score < 65) {
                    grade = "C";
                } else if (score >= 55 && score < 60) {
                    grade = "D+";
                } else if (score >= 50 && score < 55) {
                    grade = "D";
                } else if (score >= 0 && score < 50) {
                    grade = "F";
                } else {
                    grade = "You score is over.";
                }

                // แสดงผลลัพธ์
                textGrade.setText(grade);
                textScore.setText(score + "");
            } else {
                // หากคะแนนไม่มีค่า คือเป็นค่าว่างจะทำการ แสดง Toast ออกมาแจ้งเตือน
                Toast.makeText(this, "Please input your score.", Toast.LENGTH_SHORT).show();
            }

        } else if (viewId == R.id.btnGradeBack) {
            // หากมีการกดปุ่ม btnGradeBack จะทำการ finish หน้าจอนี้และกลับไปยัง MainActivity
            finish();
        }
    }
}