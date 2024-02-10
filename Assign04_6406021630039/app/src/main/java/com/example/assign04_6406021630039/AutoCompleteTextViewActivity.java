package com.example.assign04_6406021630039;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class AutoCompleteTextViewActivity extends AppCompatActivity implements View.OnClickListener {
    private android.widget.AutoCompleteTextView acTextView;
    private MultiAutoCompleteTextView macTextView;
    private String [] inputs = { "Pakistan", "Iran","China", "India",
            "Thailand", "U.A.E", "Yemen", "Palestine",
            "America", "Australia", "Turkey", "England",
            "France", "Greece"};
    private TextView display;
    private ImageButton btnSave;
    private int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);
        acTextView = (android.widget.AutoCompleteTextView) findViewById(R.id.acTextView);
        macTextView=(MultiAutoCompleteTextView)findViewById(R.id.macTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, inputs);
        acTextView.setAdapter( adapter);
        macTextView.setAdapter( adapter);
        macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        btnSave = (ImageButton) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String message = "";
        message = "acTextView = " + acTextView.getText().toString();
        message += "\nmacTextView = " + macTextView.getText().toString();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}