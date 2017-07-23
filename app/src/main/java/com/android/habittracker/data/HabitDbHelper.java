package com.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
