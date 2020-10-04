package com.example.coolcutz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditToDo extends AppCompatActivity {

    private EditText title, des;
    private Button edit;
    private DbHandler_h dbHandler;
    private Context context;
    private Long updateDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do);

        context = this;
        dbHandler = new DbHandler_h(context);
        title = findViewById(R.id.editToDoTextTitle);
        des = findViewById(R.id.editToDoTextDescription);
        edit = findViewById(R.id.buttonEdit);

        final String id = getIntent().getStringExtra("id");
        ToDo toDo = dbHandler.getSingleToDo(Integer.parseInt(id));

        title.setText(toDo.getTitle());
        des.setText(toDo.getDescription());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleText = title.getText().toString();
                String desText = des.getText().toString();
                updateDate = System.currentTimeMillis();

                ToDo toDo = new ToDo(Integer.parseInt(id), titleText, desText, updateDate, 0);
                int state = dbHandler.updateSingleToDo(toDo);
                if (state > 0)
                    Toast.makeText(EditToDo.this,"Message Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(EditToDo.this,"Message Not Updated", Toast.LENGTH_LONG).show();
                startActivity(new Intent(context, MainActivity6.class));
            }
        });

    }
}