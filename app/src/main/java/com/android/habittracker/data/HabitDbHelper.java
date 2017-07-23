package com.android.habittracker.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.android.habittracker.data.HabitContract.HabitEntry;

import static android.content.ContentValues.TAG;

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "habit.db";

    // Create the habit table
    private static final String SQL_CREATE_HABIT_TABLE =
            "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + "(" +
                    HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    HabitContract.HabitEntry.COLUMN_DATE + " TEXT NOT NULL, " +
                    HabitContract.HabitEntry.COLUMN_WORKOUT_TYPE + " INTEGER NOT NULL, " +
                    HabitContract.HabitEntry.COLUMN_WORKOUT_LENGTH + " INTEGER NOT NULL);";

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the habit table if it does not already exist
        Log.i("onCreate Db", "" + SQL_CREATE_HABIT_TABLE);
        db.execSQL(SQL_CREATE_HABIT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


    public Cursor readHabit() {

        // Open a readable instance of the database
        SQLiteDatabase db = getReadableDatabase();

        // Create the projection to select the columns to query for
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_DATE,
                HabitEntry.COLUMN_WORKOUT_TYPE,
                HabitEntry.COLUMN_WORKOUT_LENGTH
        };

        // Creating the cursor that holds the data from the query and log the response
        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection, null, null, null, null, null);

        return cursor;
    }
}
