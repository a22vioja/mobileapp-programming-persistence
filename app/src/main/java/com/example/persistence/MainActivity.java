package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    DatabaseTables database;
    DatabaseTables.Bonsai bonsai;


    private long addMountain(String name, int height) {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Bonsai.COLUMN_NAME_NAME, name);
        values.put(DatabaseTables.Bonsai.COLUMN_NAME_AGE, height);
        return database.insert(DatabaseTables.Bonsai.TABLE_NAME, null, values);
    }

    private List<DatabaseTables.Bonsai> getMountains() {
        Cursor cursor = database.query(DatabaseTables.Bonsai.TABLE_NAME, null, null, null, null, null, null);
        List<DatabaseTables.Bonsai> mountains = new ArrayList<>();
        while (cursor.moveToNext()) {
            DatabaseTables.Bonsai mountain = new DatabaseTables.Bonsai(
                    cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseTables.Bonsai.COLUMN_NAME_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Bonsai.COLUMN_NAME_NAME)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTables.Bonsai.COLUMN_NAME_AGE))
            );
            mountains.add(mountain);
        }
        cursor.close();
        return bonsai;
    }

    private int deleteBonsai(long id) {
        String selection = DatabaseTables.Bonsai.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        return database.delete(DatabaseTables.Bonsai.TABLE_NAME, selection, selectionArgs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
