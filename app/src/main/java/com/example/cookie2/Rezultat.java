package com.example.cookie2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Rezultat extends AppCompatActivity {


    ListView list;
    DBhelper db;
    ArrayList<String> lista = new ArrayList<String>();
    ArrayList<String> lista2 = new ArrayList<String>();
    ArrayList<String> provjera = new ArrayList<String>();
    ArrayList<String> rez = new ArrayList<String>();
    ArrayList<Integer> rezultati = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultat);


        db = new DBhelper(this);
        //string koji uzima sastojke s popisa
        lista = getIntent().getStringArrayListExtra("salji");
        list = (ListView) findViewById(R.id.lv);


        //dobavlja sve id_recept + naziv_sastojak
        DobaviRezultate();
        //provjera da li se sastojci poklapaju
        Provjera();
        rez(rezultati);




       ArrayAdapter<String> a1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,rez);
       list.setAdapter(a1);





    }

    private void rez(ArrayList<Integer> l1){
        Cursor m = db.Recept();
        if(m!= null && m.getCount()> 0){
            while(m.moveToNext()) {
                if(l1.contains(m.getInt(0))) {
                    rez.add(m.getString(1) + "\n" + m.getString(2));
                }
            }
        }
    }



    private void Provjera(){
        int brojrecepata = db.brojRecepata();
        int broj = 1;
            while(broj<=brojrecepata){
                for(int i = 0; i<lista2.size();i++){
                String red = (lista2.get(i));
                String[] r = red.split(",");
                String rednibr = r[0];
                String sastojak = r[1];
                int redni = Integer.valueOf(rednibr);
                if(redni==broj){
                    provjera.add(sastojak);
                }}
                if(lista.containsAll(provjera)){
                    rezultati.add(broj);
                    provjera.clear();
                    broj = broj+1;
                }
                else{
                    provjera.clear();
                    broj = broj+1;
                }
            }

    }





    private void DobaviRezultate(){
        Cursor m = db.Sastojci();
        if(m!= null && m.getCount()> 0){
            while(m.moveToNext()) {
                lista2.add(m.getString(0) + "," + m.getString(1));
            }
        }


            }




    public void BackMain(View v){
        Intent i = new Intent(this, LoginMain.class);
        startActivity(i);
    }


}