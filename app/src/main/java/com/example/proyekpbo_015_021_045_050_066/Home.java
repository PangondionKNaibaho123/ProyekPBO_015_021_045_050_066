package com.example.proyekpbo_015_021_045_050_066;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Home");
    }


    public void Pindah1(View view) {
        Intent intent1 = new Intent(Home.this, Create_QR_Code.class);
        startActivity(intent1);
    }

    public void Pindah2(View view) {
        Intent intent3 = new Intent(Home.this, History.class);
        startActivity(intent3);
    }
}
