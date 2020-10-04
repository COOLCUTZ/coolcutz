package com.example.coolcutz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class AddToDo extends AppCompatActivity {

    private EditText title, email, desc;
    private Button add2;
    private DbHandler_h dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        title = findViewById(R.id.editTextTitle);
        email = findViewById(R.id.editTextEmail);
        desc = findViewById(R.id.editTextDescription);
        add2 = findViewById(R.id.buttonAdd);
        context = this;
        dbHandler = new DbHandler_h(context);

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmailAddress(email);
                if (validateEmailAddress(email) == true) {
                    String userTitle = title.getText().toString();
                    String userDesc = desc.getText().toString();
                    long started = System.currentTimeMillis();

                    ToDo toDo = new ToDo(userTitle, userDesc, started, 0);
                    Boolean checkinsertdata = dbHandler.addToDo(toDo);
                    if (checkinsertdata == true)
                        Toast.makeText(AddToDo.this, "New Message Inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(AddToDo.this, "New Message Not Inserted", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(context, MainActivity6.class));
                }
            }
        });
    }
    private  boolean validateEmailAddress(EditText email){
        String emailInput = email.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Toast.makeText(context, "Email Validated Successfully!", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            Toast.makeText(context, "Invalid Email Address!", Toast.LENGTH_LONG).show();
            return false;
        }
    }

}