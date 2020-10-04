package com.example.coolcutz;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import androidx.annotation.Nullable;


public class DBHandler extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DB_NAME = "CoolCutz";
    public static final String TABLE_NAME = "Register";

    public static final String COLS_1= "ID";
    public static final String COLS_2= "name";
    public static final String COLS_3= "email";
    public static final String COLS_4 = "phone";
    public static final String COLS_5 = "password";

    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, phone TEXT, password TEXT)");}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }}

