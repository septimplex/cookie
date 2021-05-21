package com.example.cookie2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class SviRecepti extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> id, naslov;
    CustomAdapter customAdapter;
    DBhelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svi_recepti);

        recyclerView = (RecyclerView) findViewById(R.id.rview);

        db = new DBhelper(SviRecepti.this);
        id = new ArrayList<>();
        naslov = new ArrayList<>();

        pohraniPodatke();
        customAdapter= new CustomAdapter(SviRecepti.this,id,naslov);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SviRecepti.this));




    }

    void pohraniPodatke(){
        Cursor cursor = db.getAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(SviRecepti.this,"Nema podataka", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext() ){
                id.add(cursor.getString(0));
                naslov.add(cursor.getString(1));
            }
        }
    }

    public void Natrag(View v){
        Intent i = new Intent(this, LoginMain.class);
        startActivity(i);
    }
}