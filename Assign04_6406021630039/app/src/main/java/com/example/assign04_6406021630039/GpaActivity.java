package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GpaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputGrade1, inputGrade2, inputGrade3, inputGrade4, textPoint, textCredit, textGpa;

    private Button btnCalculate , btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

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
        if (viewId == R.id.btnCalGpa) {

            String[] strGrade = new String[4];
            strGrade[0] = inputGrade1.getText().toString();
            strGrade[1] = inputGrade2.getText().toString();
            strGrade[2] = inputGrade3.getText().toString();
            strGrade[3] = inputGrade4.getText().toString();

            double point = 0;
            for (int i = 0; i < strGrade.length; i++) {
                if (strGrade[i].isEmpty()) {
                    Toast.makeText(this, "Please input your grade in field " + i, Toast.LENGTH_SHORT).show();
                    break;
                }
                point += 3 * convertGrade(strGrade[i]);
                if (i == strGrade.length-1) {
                    textPoint.setText(String.format("%.2f", point) + "");
                    textCredit.setText(String.format("%.2f", 12) + "");
                    textGpa.setText(String.format("%.2f", point / 12) + "");
                }
            }

        }
        if (viewId == R.id.btnGpaBack) {
            finish();
        }
    }

    public double convertGrade(String strGrade) {
        if (strGrade.equals("A")) {
            return 4.00;
        } else if (strGrade.equals("B+")) {
            return 3.50;
        } else if (strGrade.equals("B")) {
            return 3.00;
        } else if (strGrade.equals("C+")) {
            return 2.50;
        } else if (strGrade.equals("C")) {
            return 2.00;
        } else if (strGrade.equals("D+")) {
            return 1.50;
        } else if (strGrade.equals("D")) {
            return 1.00;
        }
        return  0.00;
    }
}