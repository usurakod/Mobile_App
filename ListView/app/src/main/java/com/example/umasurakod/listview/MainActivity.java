package com.example.umasurakod.listview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    EditText EnterItem;
    ListView myList;
    ArrayList<String> List;
    ArrayAdapter<String> listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addBtn = (Button) findViewById(R.id.AddBtn);
        EnterItem = (EditText) findViewById(R.id.EnterText);
        myList = (ListView) findViewById(R.id.list1);
        List = new ArrayList<String>();
        listViewAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, List);
        myList.setAdapter(listViewAdapter);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = EnterItem.getText().toString();

                /* to check whether item enterd or null */
                if(item.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setMessage("Please enter something to add to list")
                    .setNegativeButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                /* when there is something entered then add to list */
                else {
                    List.add(item);
                    listViewAdapter.notifyDataSetChanged();
                    EnterItem.setText(null);
                }
            }
        });
    }

}
