package com.example.proyekpbo_015_021_045_050_066;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editUsername;
    EditText editPassword;
    Button button;
    DatabaseHelper mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDB = new DatabaseHelper(this);
        initViews();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

        getSupportActionBar().setTitle("Login");

    }
    private void initViews() {
        editUsername = (EditText) findViewById(R.id.editText);
        editPassword = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

    }


    public void userLogin() {
        String username = editUsername.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (username.isEmpty()) {
            editUsername.setError("Email is required");
            editUsername.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editPassword.setError("Password is required");
            editPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editPassword.setError("Password harus paling sedikit 6 karakter    ");
            editPassword.requestFocus();
            return;
        }
        if (password.equalsIgnoreCase("student123") && username.equalsIgnoreCase("student")) {
            Intent i = new Intent(getApplicationContext(), QR_Code_Scanner.class);
            startActivity(i);
        }
        else if (password.equalsIgnoreCase("dosen123") && username.equalsIgnoreCase("dosen")) {
            Intent j = new Intent(getApplicationContext(), Home.class);
            startActivity(j);
        }
        else {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
