package com.example.coolcutz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText _txtphone1,_txtpw1;
    Button _register1, _logIn1;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper =new DBHandler(this);
        db=openHelper.getReadableDatabase();

        _logIn1=(Button)findViewById(R.id.button);
        _register1=(Button)findViewById(R.id.button2);

        _txtphone1 = (EditText)findViewById(R.id.editTextPhone);
        _txtpw1= (EditText)findViewById(R.id.editTextTextPassword);


        _logIn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = _txtphone1.getText().toString();
                String password = _txtpw1.getText().toString();

                cursor=db.rawQuery(" SELECT *  FROM " + DBHandler.TABLE_NAME+ " WHERE " + DBHandler.COLS_4+ "=? AND " + DBHandler.COLS_5+ "=? ", new String[]{phone,password});
                if(cursor!= null){
                    if(cursor.getCount()>0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(),"Login Successfuly",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

                    }
                }
            }

        });

        _register1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }}

