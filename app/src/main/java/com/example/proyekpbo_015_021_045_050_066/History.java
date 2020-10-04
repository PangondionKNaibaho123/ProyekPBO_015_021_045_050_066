package com.example.proyekpbo_015_021_045_050_066;

import android.arch.lifecycle.LiveData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    ListView lst;
    DatabaseHelper mDB;
    SQLiteDatabase db;
    ArrayList<String> dataUser;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setTitle("History");

       // lst = (ListView)findViewById(R.id.listView);

       // mDB = new DatabaseHelper(this);

       // isiList();
    }
/*
    private void isiList(){
        Cursor data = mDB.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        lst.setAdapter(adapter);
    } */
}
