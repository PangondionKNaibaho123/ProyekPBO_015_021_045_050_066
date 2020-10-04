package com.example.proyekpbo_015_021_045_050_066;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String COL_0 = "No";
    private static final String COL_1 = "Nama";
    private static final String COL_2 = "NIM";

    private static final String TABLE_NAME = "Daftar Kehadiran";


    public DatabaseHelper(Context context) {

        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table biodata(no integer primary key AUTOINCREMENT, nim text null, nama text null);";
        Log.d("Data", "onCreate: " + createTable);
        db.execSQL(createTable);
        createTable = "INSERT INTO biodata (nim, nama) VALUES ('11X11111', 'Student Name');";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nim, String nama) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nim);
        contentValues.put(COL_2, nama);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
