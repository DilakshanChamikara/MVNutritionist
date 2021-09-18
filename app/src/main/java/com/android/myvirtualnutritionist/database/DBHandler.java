package com.android.myvirtualnutritionist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MVN.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserProfile.UserEntry.TABLE_NAME + " (" +
                    UserProfile.UserEntry._ID + " INTEGER PRIMARY KEY," +
                    UserProfile.UserEntry.COLUMN_Username + " TEXT," +
                    UserProfile.UserEntry.COLUMN_UserStatus + " TEXT," +
                    UserProfile.UserEntry.COLUMN_Pwd + " TEXT," +
                    UserProfile.UserEntry.COLUMN_FName + " TEXT," +
                    UserProfile.UserEntry.COLUMN_LName + " TEXT," +
                    UserProfile.UserEntry.COLUMN_Age + " INTEGER," +
                    UserProfile.UserEntry.COLUMN_Gender + " TEXT," +
                    UserProfile.UserEntry.COLUMN_Height + " REAL," +
                    UserProfile.UserEntry.COLUMN_Weight + " REAL," +
                    UserProfile.UserEntry.COLUMN_BMI + " REAL," +
                    UserProfile.UserEntry.COLUMN_WeightStatus + " TEXT," +
                    UserProfile.UserEntry.COLUMN_CalNeed + " INTEGER," +
                    UserProfile.UserEntry.COLUMN_CalGoal + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserProfile.UserEntry.TABLE_NAME;

    /**
     * Create User Info
     */
    public long addInfo(String username, String status, String password, String firstName, String lastName, int age, String gender, double height, double weight, double bmi, String weightStatus, int calNeed, int calGoal){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(UserProfile.UserEntry.COLUMN_Username, username);
        values.put(UserProfile.UserEntry.COLUMN_UserStatus, status);
        values.put(UserProfile.UserEntry.COLUMN_Pwd, password);
        values.put(UserProfile.UserEntry.COLUMN_FName, firstName);
        values.put(UserProfile.UserEntry.COLUMN_LName, lastName);
        values.put(UserProfile.UserEntry.COLUMN_Age, age);
        values.put(UserProfile.UserEntry.COLUMN_Gender, gender);
        values.put(UserProfile.UserEntry.COLUMN_Height, height);
        values.put(UserProfile.UserEntry.COLUMN_Weight, weight);
        values.put(UserProfile.UserEntry.COLUMN_BMI, bmi);
        values.put(UserProfile.UserEntry.COLUMN_WeightStatus, weightStatus);
        values.put(UserProfile.UserEntry.COLUMN_CalNeed, calNeed);
        values.put(UserProfile.UserEntry.COLUMN_CalGoal, calGoal);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(UserProfile.UserEntry.TABLE_NAME, null, values);

        return newRowId;
    }

    /**
     * Update User Info
     */
    public Boolean updateInfo(String username, String status, String password, String firstName, String lastName, int age, String gender, double height, double weight, double bmi, String weightStatus, int calNeed, int calGoal){
        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(UserProfile.UserEntry.COLUMN_UserStatus, status);
        values.put(UserProfile.UserEntry.COLUMN_Pwd, password);
        values.put(UserProfile.UserEntry.COLUMN_FName, firstName);
        values.put(UserProfile.UserEntry.COLUMN_LName, lastName);
        values.put(UserProfile.UserEntry.COLUMN_Age, age);
        values.put(UserProfile.UserEntry.COLUMN_Gender, gender);
        values.put(UserProfile.UserEntry.COLUMN_Height, height);
        values.put(UserProfile.UserEntry.COLUMN_Weight, weight);
        values.put(UserProfile.UserEntry.COLUMN_BMI, bmi);
        values.put(UserProfile.UserEntry.COLUMN_WeightStatus, weightStatus);
        values.put(UserProfile.UserEntry.COLUMN_CalNeed, calNeed);
        values.put(UserProfile.UserEntry.COLUMN_CalGoal, calGoal);

        // Which row to update, based on the title
        String selection = UserProfile.UserEntry.COLUMN_Username + " LIKE ?";
        String[] selectionArgs = { username };

        int count = db.update(
                UserProfile.UserEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >= 1)
            return true;
        else
            return false;
    }

    /**
     * Delete User Info
     */
    public void deleteInfo(String username){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = UserProfile.UserEntry.COLUMN_Username + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { username };
        // Issue SQL statement.
        int deletedRows = db.delete(UserProfile.UserEntry.TABLE_NAME, selection, selectionArgs);
    }

    /**
     * Read All Info
     */
    public List readAllInfo(){
        SQLiteDatabase db = getReadableDatabase();
        String username = "dilakshan";

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                UserProfile.UserEntry.COLUMN_Username,
                UserProfile.UserEntry.COLUMN_UserStatus,
                UserProfile.UserEntry.COLUMN_Pwd,
                UserProfile.UserEntry.COLUMN_FName,
                UserProfile.UserEntry.COLUMN_LName,
                UserProfile.UserEntry.COLUMN_Age,
                UserProfile.UserEntry.COLUMN_Gender,
                UserProfile.UserEntry.COLUMN_Height,
                UserProfile.UserEntry.COLUMN_Weight,
                UserProfile.UserEntry.COLUMN_BMI,
                UserProfile.UserEntry.COLUMN_WeightStatus,
                UserProfile.UserEntry.COLUMN_CalNeed,
                UserProfile.UserEntry.COLUMN_CalGoal
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = UserProfile.UserEntry.COLUMN_Username + " = ?";
        String[] selectionArgs = { username };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                UserProfile.UserEntry.COLUMN_Username + " ASC";

        Cursor cursor = db.query(
                UserProfile.UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List usernames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_Username));
            usernames.add(user);
        }
        cursor.close();
        return usernames;
    }

    /**
     * Read All Info
     */
    public List readAllInfo(String username){
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                UserProfile.UserEntry.COLUMN_Username,
                UserProfile.UserEntry.COLUMN_UserStatus,
                UserProfile.UserEntry.COLUMN_Pwd,
                UserProfile.UserEntry.COLUMN_FName,
                UserProfile.UserEntry.COLUMN_LName,
                UserProfile.UserEntry.COLUMN_Age,
                UserProfile.UserEntry.COLUMN_Gender,
                UserProfile.UserEntry.COLUMN_Height,
                UserProfile.UserEntry.COLUMN_Weight,
                UserProfile.UserEntry.COLUMN_BMI,
                UserProfile.UserEntry.COLUMN_WeightStatus,
                UserProfile.UserEntry.COLUMN_CalNeed,
                UserProfile.UserEntry.COLUMN_CalGoal
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = UserProfile.UserEntry.COLUMN_Username + " LIKE ?";
        String[] selectionArgs = { username };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                UserProfile.UserEntry.COLUMN_Username + " ASC";

        Cursor cursor = db.query(
                UserProfile.UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List userInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String userName = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_Username));
            String status = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_UserStatus));
            String password = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_Pwd));
            String fName = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_FName));
            String lName = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_LName));
            int age = cursor.getInt(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_Age));
            String gender = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_Gender));
            double height = cursor.getDouble(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_Height));
            double weight = cursor.getDouble(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_Weight));
            double bmi = cursor.getDouble(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_BMI));
            String weightStatus = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_WeightStatus));
            int calNeed = cursor.getInt(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_CalNeed));
            int calGoal = cursor.getInt(cursor.getColumnIndexOrThrow(UserProfile.UserEntry.COLUMN_CalGoal));
            userInfo.add(userName);//index 0
            userInfo.add(status);//1
            userInfo.add(password);//2
            userInfo.add(fName);
            userInfo.add(lName);
            userInfo.add(age);
            userInfo.add(gender);
            userInfo.add(height);
            userInfo.add(weight);
            userInfo.add(bmi);
            userInfo.add(weightStatus);
            userInfo.add(calNeed);
            userInfo.add(calGoal);
        }
        cursor.close();
        return userInfo;
    }

}