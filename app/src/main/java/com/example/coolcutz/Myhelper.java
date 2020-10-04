package com.example.coolcutz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Myhelper extends SQLiteOpenHelper {


    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static  final int DATABASE_VERSION =1;

    private static final String TABLE_NAME = "my_library";
    private static final String COLUMN_ID = "_id";


    private static String COLUMN_APP = "appoinment1";
    private static String COLUMN_APP2 = "appoinment2";
    private static String COLUMN_APP3 = "appoinment3";
    private static String COLUMN_D1 = "day1";
    private static String COLUMN_D2 = "day2";
    private static String COLUMN_D3 = "day3";

    public Myhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_APP + " TEXT, " +
                COLUMN_APP2 + " TEXT, " +
                COLUMN_APP3 + " TEXT, " +
                COLUMN_D1 + " TEXT, " +
                COLUMN_D2 + " TEXT, " +
                COLUMN_D3 + " TEXT);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS  " + TABLE_NAME);

    }

    void addbook(String app1, String app2, String app3, String d1, String d2, String d3){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_APP, app1);
        cv.put(COLUMN_APP2, app2 );
        cv.put(COLUMN_APP3, app3 );
        cv.put(COLUMN_APP, d1 );
        cv.put(COLUMN_APP, d2 );
        cv.put(COLUMN_APP, d3 );
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();

        }
    }

}