package com.example.basicloginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnClear;
    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnClear = (Button) findViewById(R.id.btnClear);
        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
//        btnLogin.setOnClickListener(this);
//        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int ViewId = v.getId();
        if (ViewId == R.id.btnLogin) {
            String password = passwordText.getText().toString();
            String username = usernameText.getText().toString();
            if (!password.isEmpty() && !username.isEmpty() ) {
                String message = "";
                message += "Username : " + usernameText.getText().toString();
                message += "\nPassword : " + passwordText.getText().toString();
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please input password and username", Toast.LENGTH_SHORT).show();
            }
        } else if (ViewId == R.id.btnClear) {
            passwordText.setText("");
            usernameText.setText("");
        }
    }
}