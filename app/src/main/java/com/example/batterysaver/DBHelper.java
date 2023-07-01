package com.example.batterysaver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE users (username TEXT PRIMARY KEY, password TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE battery_apps (app_name TEXT, battery_level INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE user_logs (log_message TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE scheduled_mode (start_time TEXT, end_time TEXT, is_enabled INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS battery_apps");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user_logs");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS scheduled_mode");
        onCreate(sqLiteDatabase);
    }

    public Boolean insertData(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = sqLiteDatabase.insert("users", null, contentValues);
        return result != -1;
    }

    public Boolean checkUserName(String username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username = ?", new String[]{username});
        return cursor.getCount() > 0;
    }

    public Boolean checkUserPassword(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});
        return cursor.getCount() > 0;
    }

    public boolean insertBatteryApp(String appName, int batteryLevel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_name", appName);
        contentValues.put("battery_level", batteryLevel);
        long result = sqLiteDatabase.insert("battery_apps", null, contentValues);
        return result != -1;
    }

    public Cursor getAllBatteryApps() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM battery_apps", null);
    }

    public boolean insertUserLog(String logMessage) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("log_message", logMessage);
        long result = sqLiteDatabase.insert("user_logs", null, contentValues);
        return result != -1;
    }

    public boolean insertScheduledMode(String startTime, String endTime, int isEnabled) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("start_time", startTime);
        contentValues.put("end_time", endTime);
        contentValues.put("is_enabled", isEnabled);
        long result = sqLiteDatabase.insert("scheduled_mode", null, contentValues);
        return result != -1;
    }

    public Cursor getScheduledMode() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM scheduled_mode", null);
    }

}
