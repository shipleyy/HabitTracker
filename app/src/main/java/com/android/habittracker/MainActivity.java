package com.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.habittracker.data.HabitContract.HabitEntry;
import com.android.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To access the database, we instantiate the subclass of SQLiteOpenHelper
        // and pass the context
        mDbHelper = new HabitDbHelper(this);

        // Insert data into the database
        insertWorkout();

        // Query the database for information
        readData();

    }

    private void insertWorkout() {

        // Create and/or open the database to write to it
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create the values to insert in the database
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_DATE, "15/07/2017");
        values.put(HabitEntry.COLUMN_WORKOUT_TYPE, HabitEntry.WORKOUT_STRENGTH);
        values.put(HabitEntry.COLUMN_WORKOUT_LENGTH, 68);

        // Insert the values created above into the database
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        // Log the new row id returned
        Log.v(TAG, "New row ID = " + newRowId);
    }

    private void readData() {
        // Query the database and return a cursor with data
        Cursor cursor = mDbHelper.readHabit();
        try {

            while (cursor.moveToNext()) {
                Log.v(TAG, "habit: " + cursor.getInt(0) + " - " + cursor.getString(1) +
                        " - " + cursor.getInt(2) + " - " + cursor.getInt(3));
            }

        } finally {
            cursor.close();
        }
    }
}
