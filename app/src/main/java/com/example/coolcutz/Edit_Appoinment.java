package com.example.coolcutz;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Edit_Appoinment extends AppCompatActivity {

    EditText txtbeauty, txtcusname, txtphone, idtxt;
    Button btnupdate;
    Button btndelete;
    Button btnsee;
    DBHandler_m db;
    Long updateDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__appoinment);
        db = new DBHandler_m(this);

        idtxt = (EditText) findViewById(R.id.txtid);
        txtbeauty = (EditText) findViewById(R.id.updatebeautyname);
        txtcusname = (EditText) findViewById(R.id.updatecusname);
        txtphone = (EditText) findViewById(R.id.updatecusname);


        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);
        btnsee = findViewById(R.id.btnsee);

        db = new DBHandler_m(this);
        updateDate = System.currentTimeMillis();
        updatedata();


    }


    //UPDATA DATA
    public void updatedata() {
        btnupdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = db.updatedata((idtxt.getText().toString()), txtbeauty.getText().toString(),
                                txtcusname.getText().toString(), txtphone.getText().toString(), updateDate.longValue(), null);

                        if (isUpdate == true)
                            Toast.makeText(Edit_Appoinment.this, "Entry updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(Edit_Appoinment.this, "Entry not updated", Toast.LENGTH_SHORT).show();


                    }
                }
        );

//RETRIVE DATA
        btnsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.getalldata();
                if (res.getCount()==0){
                    Toast.makeText(Edit_Appoinment.this,"No entry",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("id:" +res.getString(0)+"\n");
                    buffer.append("Beautyname:" +res.getString(1)+"\n");
                    buffer.append("Cusname:" +res.getString(2)+"\n");
                    buffer.append("phone:" +res.getString(3)+"\n\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(Edit_Appoinment.this);
                builder.setCancelable(true);
                builder.setTitle("Our Appoinmets \n");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

        Button b2 = (Button) findViewById(R.id.btndelete);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Edit_Appoinment.this,MainActivity5.class);
                startActivity(intent);
            }

        });

    }






}
