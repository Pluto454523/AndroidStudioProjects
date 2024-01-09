package com.example.textviewedittextbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText dataText;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You Click me", Toast.LENGTH_SHORT).show();
            }
        });

        dataText = (EditText) findViewById(R.id.dataText);
        dataText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = dataText.getText().toString();
                Toast.makeText(MainActivity.this, "OnChanged" + text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    public void onClickEditText(View v) {
        String text = dataText.getText().toString();
        Toast.makeText(this, "You Click or Enter from edit text : " + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.btnAdd) {
            String text = dataText.getText().toString();
            Toast.makeText(this, "You Click Add Data Button : " + text, Toast.LENGTH_SHORT).show();
        }
    }
}