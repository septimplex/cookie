package com.example.cookie2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Popis extends AppCompatActivity {
    ListView listview;
    ArrayList<String> lista1 = new ArrayList<String>();
    DBhelper db;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popis);
        db = new DBhelper(this);


        listview = (ListView) findViewById(R.id.popis);
        lista1 = getIntent().getStringArrayListExtra("lista");
        b = (Button) findViewById(R.id.recepti);


        ArrayAdapter<String> a1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista1);
        listview.setAdapter(a1);

    }





    public void BackMain(View v){
        Intent i = new Intent(this, LoginMain.class);
        startActivity(i);
    }

    public void Dalje(View v){
        Intent i = new Intent(this,Rezultat.class);
        i.putStringArrayListExtra("salji",lista1);
        startActivity(i);
    }


}
