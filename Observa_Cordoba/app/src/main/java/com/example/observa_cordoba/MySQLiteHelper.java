package com.example.observa_cordoba;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MySQLiteHelper extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miObservadorDB dbHelper = new miObservadorDB(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


    }
}
