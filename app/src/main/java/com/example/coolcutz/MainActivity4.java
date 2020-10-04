package com.example.coolcutz;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    private static final String TAG ="COOLCUTZ";
    private CalendarView mCalenderView;

    //create object
    private Button btnok;
    //TextView txtusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mCalenderView = (CalendarView) findViewById(R.id.calendarView);

        mCalenderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date= (i1+1) + "/" + i2 + "/" + i;
                Log.d(TAG, "onSelectedDayChange : mm/dd/yyyy :" + date);

                Intent intent = new Intent(MainActivity4.this, Details.class);
                intent.putExtra("date",date);
                startActivity(intent);

            }
        });



//        Log.i(TAG,"onCreate");
//
//        //link button
//       // button = findViewById(R.id.btnok1);
//        txtusername = findViewById(R.id.txtusername);
//
//        //create intent
//        final Intent intent =getIntent();
//        String name = intent.getStringExtra("USER_NAME");
//
//        txtusername.setText(name);
//
//        //set lisnter
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //launch
//                startActivity(intent);
//            }
//        });
    }
}