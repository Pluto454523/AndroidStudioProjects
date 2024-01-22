package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GradeActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText inputScore, textScore, textGrade;

    private Button btnCalculate , btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
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
        int viewId = v.getId();
        if (viewId == R.id.btnCalGrade) {
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

                textGrade.setText(grade);
                textScore.setText(score + "");
            } else {
                Toast.makeText(this, "Please input your score.", Toast.LENGTH_SHORT).show();
            }

        } else if (viewId == R.id.btnGradeBack) {
            finish();
        }
    }
}