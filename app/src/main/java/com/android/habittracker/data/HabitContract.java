package com.android.habittracker.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import static android.content.ContentValues.TAG;

public final class HabitContract {

    // This class cannot be instantiated
    private HabitContract() {
    }

    public static final class HabitEntry implements BaseColumns {
        // The table name
        public static final String TABLE_NAME = "habit";

        // Columns in the table
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_DATE = "date"; // TEXT / String
        public static final String COLUMN_WORKOUT_TYPE = "workout_type"; // INTEGER // int
        public static final String COLUMN_WORKOUT_LENGTH = "workout_length"; // INTEGER / int

        // Workout type constants
        public static final int WORKOUT_STRENGTH = 0;
        public static final int WORKOUT_CARDIO = 1;
        public static final int WORKOUT_FLEXIBILITY = 2;
    }
}
