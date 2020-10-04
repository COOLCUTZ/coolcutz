package com.example.coolcutz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class showAppointment extends AppCompatActivity {
    EditText nic,d1,d2,d3,t1,t2,t3;
    Button save,delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking2);

        //nic = findViewById(R.id.nic);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        save= findViewById(R.id.save);
        delete= findViewById(R.id.delete);
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Myhelper dbhelper = new Myhelper(Booking2.this );
                dbhelper.addbook(//nic.getText().toString().trim(),
                        d1.getText().toString().trim(),
                        d2.getText().toString().trim(),
                        d3.getText().toString().trim(),
                        t1.getText().toString().trim(),
                        t2.getText().toString().trim(),
                        t3.getText().toString().trim());



            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(showAppointment.this, Delete.class);
                startActivity(intent);
            }
        });

    }
}