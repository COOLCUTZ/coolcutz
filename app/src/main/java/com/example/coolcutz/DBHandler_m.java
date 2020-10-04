package com.example.coolcutz;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler_m extends SQLiteOpenHelper {
    ///////////

    private Context context;
    private static final int VERSION = 4;
    private static final String DB_NAME = "Appoinments";
    private static String TABLE_NAME = "Appoinments";

    //COLUM NAMES
    private static final String APPOINMENTID = "id";
    private static final String BEAUTYNAME = "beautyname";
    private static final String CUSTOMERNAME = "customername";
    private static final String PHONENUMBER = "phonenumber";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

/////
    public DBHandler_m(@Nullable Context context) {

        super(context, DB_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + APPOINMENTID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + BEAUTYNAME + " TEXT,"
                + CUSTOMERNAME + " TEXT,"
                + PHONENUMBER + " INTEGER,"
                + STARTED + " TEXT,"
                + FINISHED + " TEXT" +

                ");";

        db.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        //DROP IF EXIST
        db.execSQL(DROP_TABLE_QUERY);
        //CREATE AGAIN
        onCreate(db);
    }

    //add appoinmets
    public Boolean addAppoinment(Appoinment appoinment) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BEAUTYNAME, appoinment.getBeautyName());
        contentValues.put(CUSTOMERNAME, appoinment.getCusName());
        contentValues.put(PHONENUMBER, appoinment.getPhone());
        contentValues.put(STARTED, appoinment.getStarted());
        contentValues.put(FINISHED, appoinment.getFinished());

        //save to table
        long result =sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            Toast.makeText(context,"faild", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
        //close
        sqLiteDatabase.close();

        return null;
    }

    //update appoinmets

    public boolean updatedata(String id, String beauty, String cus, String phone, Long started, Long finished) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(APPOINMENTID, id);
        contentValues.put(BEAUTYNAME, beauty);
        contentValues.put(CUSTOMERNAME, cus);
        contentValues.put(PHONENUMBER, phone);
        contentValues.put(STARTED, started);
        contentValues.put(FINISHED, finished);

        db.update(TABLE_NAME, contentValues, "id = ?",new String[] {String.valueOf(id)});
        return true;
    }

    //delete data
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete( TABLE_NAME, "id = ?" ,
                new String[] {String.valueOf(id)});

    }
    //get data
    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from TABLE_NAME ", null);
        return cursor;

    }

    //count data
    public int countAppoinment() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();

    }

    //get data list
    public List<Appoinment> getAllAppoinmentlist() {
        String sql = "select *from" +TABLE_NAME;


        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        List<Appoinment> appoinments = new ArrayList<>();

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Appoinment appoinment = new Appoinment();

                appoinment.setAppoinmentID(cursor.getInt(0));
                appoinment.setBeautyName(cursor.getString(1));
                appoinment.setCusName(cursor.getString(2));
                appoinment.setPhone(cursor.getString(3));
                appoinment.setStarted(cursor.getLong(4));
                appoinment.setFinished(cursor.getLong(5));

                appoinments.add(appoinment);
            }
            while (cursor.moveToNext());
        }

        return appoinments;
    }


    // Get a single appoinment
    public Appoinment getSingleAppoinment(int id) {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{APPOINMENTID, BEAUTYNAME, CUSTOMERNAME, PHONENUMBER, STARTED, FINISHED},
                APPOINMENTID + "= ?", new String[]{String.valueOf(id)}
                , null, null, null, null);

        Appoinment appoinment;
        if (cursor != null) {
            cursor.moveToFirst();
            appoinment = new Appoinment(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getLong(4),
                    cursor.getLong(5)
            );
            return appoinment;
        }
        return null;
    }

    //retrive all data

    public Cursor getalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }




}
