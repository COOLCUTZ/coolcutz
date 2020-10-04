package com.example.coolcutz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {

    private Button call;
    private Button email;
    private Button message;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        context = this;

        call = findViewById(R.id.call);
        email = findViewById(R.id.email);
        message = findViewById(R.id.message);

        //Call Button
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Cool Cutz");
                builder.setMessage("Contact us : 071 5412346");

                builder.setNeutralButton("Call Now", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent callIntent = new Intent(Intent.ACTION_CALL);

                        callIntent.setData(Uri.parse("tel:"+ "0716269412"));

                        try {
                            startActivity(callIntent);
                        }
                        catch (android.content.ActivityNotFoundException ex){
                            Toast.makeText(ContactUs.this,"SMS Faild,please try again later.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(context, ContactUs.class));
                    }
                });

                builder.show();
            }
        });

        //Email Button
        Intent intent = new Intent(Intent.ACTION_SEND);
        final Intent chooser;
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"coolcutz@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Get An Appoinment");
        intent.putExtra(Intent.EXTRA_TEXT,"Type your email here...");
        intent.setType("message/rfc822");
        chooser = Intent.createChooser(intent,"Send email test app");

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(chooser);
            }
        });


        //Message Button
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, MainActivity6.class));
            }
        });
    }


}