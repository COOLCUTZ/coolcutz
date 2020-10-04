package com.example.coolcutz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Booking1 extends AppCompatActivity {

    Button update;
    Context context;
    private Myhelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        update = findViewById(R.id.btnUp);
        context = this;
        dbhelper = new Myhelper(context);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Booking1.this, Booking2.class);
                startActivity(intent);
                /*DatabaseHelper myDB = new DatabaseHelper(MainActivity.this);



                String t1 = t1.getText().toString();
                long start = System.currentTimeMillis();

                todo todo = new todo(t1 ,start, 0);
                dbhelper.MainActivity(todo);*/
            }
        });


    }
}