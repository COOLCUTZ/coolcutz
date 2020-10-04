package com.example.coolcutz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class Details extends AppCompatActivity {

    EditText txtbeauty, txtcusname, txtphone, phone;
    Button button, btnadd, btndelete, btnedits;
    TextView textView;
    TextView date;
    Appoinment appo;
    private TextView count;
    long updateDate;

    private static final String TAG = "MainActivity";
    private TextView theDate;
    private Button btnGoCalendar;
    private DBHandler_m dbHandler;
    private Context context;
    DatabaseReference dbRef;
    private Object EditText;
    private boolean Validationphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        theDate = (TextView) findViewById(R.id.date);
        btnGoCalendar = (Button) findViewById(R.id.btnGoCalendar);

        date = findViewById(R.id.date);
        txtbeauty = findViewById(R.id.edittxtbeauty);
        txtcusname = findViewById(R.id.edittxtcusname);
        txtphone = findViewById(R.id.edittxtphone);

        btnadd = findViewById(R.id.btnadd);
        btnedits = findViewById(R.id.btnedits);
        btndelete = findViewById(R.id.btndelete);
        //validatebtn = findViewById(R.id.validatebtn);

        context = this;
        dbHandler = new DBHandler_m(context);

        appo = new Appoinment();


////INSERT DATA
//
//        btnadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String txtbeautyname = txtbeauty.getText().toString();
//                String txtcustomername = txtcusname.getText().toString();
//                String txtphonenumber = txtphone.getText().toString();
//                long started = System.currentTimeMillis();
//                Toast.makeText(getApplicationContext(), "Successfully entered", Toast.LENGTH_SHORT).show();
//
//                Appoinment appoinment = new Appoinment(txtbeautyname, txtcustomername, txtphonenumber, started, 0);
//                dbHandler.addAppoinment(appoinment);
//                startActivity(new Intent(context, MainActivityMeth.class));
//            }
//        });

        //INSERT DATA

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Validatebeauty() ){
                    return;
                }
                String txtbeautyname = txtbeauty.getText().toString();
                if (!Validatecustomername() ){
                    return;
                }
                String txtcustomername = txtcusname.getText().toString();

                if (!Validatephone() ){
                    return;
                }
                String txtphonenumber = txtphone.getText().toString();

                long started = System.currentTimeMillis();
                Toast.makeText(getApplicationContext(), "Successfully entered", Toast.LENGTH_SHORT).show();

                Appoinment appoinment = new Appoinment(txtbeautyname, txtcustomername, txtphonenumber, started, 0);
                dbHandler.addAppoinment(appoinment);
                startActivity(new Intent(context, MainActivityMeth.class));
            }
        });



//VALIDATA PHONE NUMBER

//        btnadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Validationphone(txtphone);
//
//                if(Validationphone == true) {
//                    String txtbeautyname = txtbeauty.getText().toString();
//                    String txtcustomername = txtcusname.getText().toString();
//                    long started = System.currentTimeMillis();
//
//                    Appoinment appoinment = new Appoinment(txtbeautyname, txtcustomername, started, 0);
//                    Boolean checkinsertdata = dbHandler.addAppoinment(appoinment);
//                    if (checkinsertdata == true)
//                        Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(getApplicationContext(), "Not added", Toast.LENGTH_SHORT).show();
//
//                    startActivity(new Intent(context, MainActivityMeth.class));
//
//
//                }
//
//
//            }
//        });

//CALENDER INPUT
        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        theDate.setText(date);

        Button b1 = (Button) findViewById(R.id.btnGoCalendar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details.this, MainActivity4.class);
                startActivity(intent);
            }
        });


        Button b2 = (Button) findViewById(R.id.btnedits);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details.this, Edit_Appoinment.class);
                startActivity(intent);
            }
        });



    }

    //validation
    private boolean Validatebeauty() {

        String value = txtbeauty.getText().toString();
        if (value.isEmpty()){
            txtbeauty.setError("This field can not be empty");
            return false;
        } else {
            txtbeauty.setError(null);
            return true;
        }

    }

    //validation
    private boolean Validatecustomername() {

        String value = txtcusname.getText().toString();
        if (value.isEmpty()){
            txtcusname.setError("This field can not be empty");
            return false;
        } else {
            txtcusname.setError(null);
            return true;
        }

    }


    //validation
    private boolean Validatephone() {

        String value = txtphone.getText().toString();
        if (value.isEmpty() ){
            txtphone.setError("This field can not be empty");
            return false;
        } else {
            txtphone.setError(null);
            return true;
        }

    }

}







