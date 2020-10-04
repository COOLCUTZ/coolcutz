package com.example.coolcutz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity6 extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private TextView count;
    Context context;
    private DbHandler_h dbHandler;
    private List<ToDo> toDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        context = this;

        dbHandler = new DbHandler_h(context);
        add = findViewById(R.id.add);
        listView = findViewById(R.id.todolist);
        count = findViewById(R.id.todocount);
        toDos = new ArrayList<>();

        toDos = dbHandler.getAllToDos();

        ToDoAdapter adapter = new ToDoAdapter(context, R.layout.single_todo, toDos);
        listView.setAdapter(adapter);

        //get todo counts from the table
        int countTodo = dbHandler.countToDo();
        count.setText("You have  add "+countTodo+" Messages");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, AddToDo.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                final ToDo toDo = toDos.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(toDo.getTitle());
                builder.setMessage(toDo.getDescription());

                builder.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toDo.setFinished(System.currentTimeMillis());
                        dbHandler.updateSingleToDo(toDo);

                        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

                        smsIntent.setData(Uri.parse("smsto:"));
                        smsIntent.putExtra("address" , "071 6269412");
                        smsIntent.putExtra("sms_body" , String.valueOf(toDo.getDescription()));
                        smsIntent.setType("vnd.android-dir/mms-sms");

                        try {
                            startActivity(smsIntent);
                        }
                        catch (android.content.ActivityNotFoundException ex){
                            Toast.makeText(MainActivity6.this,"SMS Faild,please try again later.", Toast.LENGTH_LONG).show();
                        }

                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        boolean checkdeletedata = dbHandler.deleteToDo(toDo.getId());
                        if (checkdeletedata==true)
                            Toast.makeText(MainActivity6.this,"Message Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity6.this,"Message Not Deleted", Toast.LENGTH_LONG).show();

                        startActivity(new Intent(context, MainActivity6.class));
                    }
                });

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(context, EditToDo.class);
                        intent.putExtra("id",String.valueOf(toDo.getId()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }

}