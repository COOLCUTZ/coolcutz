package com.example.coolcutz;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity5 extends AppCompatActivity {
    EditText txtbeauty, txtcusname, txtphone, idtxt;
    Button btnupdate;
    Button btndelete;
    Button btnsee;
    DBHandler_m db;
    Long updateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        db = new DBHandler_m(this);

        idtxt = (EditText) findViewById(R.id.txtid);
//        txtbeauty = (EditText) findViewById(R.id.updatebeautyname);
//        txtcusname = (EditText) findViewById(R.id.updatecusname);
//        txtphone = (EditText) findViewById(R.id.updatecusname);


//        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
//        btnsee = findViewById(R.id.btnsee);

        db = new DBHandler_m(this);
        updateDate = System.currentTimeMillis();

        deleteData();


    }
    public void deleteData()
    {
        btndelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleteRows = db.deleteData(idtxt.getText().toString());
                        if (deleteRows > 0)
                            Toast.makeText(MainActivity5.this, "Entry deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity5.this, "Entry not deleted", Toast.LENGTH_SHORT).show();


                    }
                });




    }
}

