package com.example.cookie2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LoginMain extends AppCompatActivity {


    DBhelper db;
    ArrayList<String> lista1 = new ArrayList<String>();
    ArrayList<String> lista2 = new ArrayList<String>();
    ArrayList<String> lista3 = new ArrayList<String>();
    ArrayList<String> lista4 = new ArrayList<String>();
    ArrayList<String> lista5 = new ArrayList<String>();
    ArrayList<String> sastojci = new ArrayList<>();
    ListView l1,l2,l3,l4,l5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);



        db = new DBhelper(this);
        l1= (ListView) findViewById(R.id.r1);
        l2 = (ListView) findViewById(R.id.r2);
        l3 = (ListView) findViewById(R.id.r3);
        l4 = (ListView) findViewById(R.id.r4);
        l5 = (ListView) findViewById(R.id.r5);


        DobaviMP();
        DobaviO();
        DobaviP();
        DobaviS();
        DobaviV();


        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tekst = l1.getItemAtPosition(position).toString();
                if (sastojci.contains(tekst))
                    Toast.makeText(LoginMain.this,"" +tekst+" je vec na popisu",Toast.LENGTH_SHORT).show();
                else{
                sastojci.add(tekst);
                Toast.makeText(LoginMain.this,"" +tekst+" dodano",Toast.LENGTH_SHORT).show();
                }

            }
        });

        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tekst = l2.getItemAtPosition(position).toString();
                if (sastojci.contains(tekst))
                    Toast.makeText(LoginMain.this,"" +tekst+" je vec na popisu",Toast.LENGTH_SHORT).show();
                else{
                    sastojci.add(tekst);
                    Toast.makeText(LoginMain.this,"" +tekst+" dodano",Toast.LENGTH_SHORT).show();
                }
            }
        });

        l3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tekst = l3.getItemAtPosition(position).toString();
                if (sastojci.contains(tekst))
                    Toast.makeText(LoginMain.this,"" +tekst+" je vec na popisu",Toast.LENGTH_SHORT).show();
                else{
                    sastojci.add(tekst);
                    Toast.makeText(LoginMain.this,"" +tekst+" dodano",Toast.LENGTH_SHORT).show();
                }
            }
        });

        l4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tekst = l4.getItemAtPosition(position).toString();
                if (sastojci.contains(tekst))
                    Toast.makeText(LoginMain.this,"" +tekst+" je vec na popisu",Toast.LENGTH_SHORT).show();
                else{
                    sastojci.add(tekst);
                    Toast.makeText(LoginMain.this,"" +tekst+" dodano",Toast.LENGTH_SHORT).show();
                }
            }
        });

        l5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tekst = l5.getItemAtPosition(position).toString();
                if (sastojci.contains(tekst))
                    Toast.makeText(LoginMain.this,"" +tekst+" je vec na popisu",Toast.LENGTH_SHORT).show();
                else{
                    sastojci.add(tekst);
                    Toast.makeText(LoginMain.this,"" +tekst+" dodano",Toast.LENGTH_SHORT).show();
                }
            }
        });



        
    }

    private void DobaviMP(){
        Cursor m = db.dobaviMP();
       // StringBuffer stringBuffer = new StringBuffer();
        if(m!= null && m.getCount()> 0){
            while(m.moveToNext()){
               // stringBuffer.append("" + res.getString(0) + "\n");
                lista1.add(m.getString(0));
            }
            //t1.setText(stringBuffer.toString());
            //stavlja u listu stringova Log.i("LoginMain", String.valueOf(l));
            ArrayAdapter<String> a1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista1);
            l1.setAdapter(a1);
        }
    }
    private void DobaviV(){
        Cursor m = db.dobaviV();
        if(m!= null && m.getCount()> 0){
            while(m.moveToNext()){

                lista2.add(m.getString(0));
            }
            ArrayAdapter<String> a1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista2);
            l2.setAdapter(a1);
        }
    }
    private void DobaviS(){
        Cursor m = db.dobaviS();
        if(m!= null && m.getCount()> 0){
            while(m.moveToNext()){

                lista3.add(m.getString(0));
            }
            ArrayAdapter<String> a1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista3);
            l3.setAdapter(a1);
        }
    }
    private void DobaviP(){
        Cursor m = db.dobaviP();
        if(m!= null && m.getCount()> 0){
            while(m.moveToNext()){

                lista4.add(m.getString(0));
            }
            ArrayAdapter<String> a1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista4);
            l4.setAdapter(a1);
        }
    }
    private void DobaviO(){
        Cursor m = db.dobaviO();
        if(m!= null && m.getCount()> 0){
            while(m.moveToNext()){

                lista5.add(m.getString(0));
            }
            ArrayAdapter<String> a1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista5);
            l5.setAdapter(a1);
        }
    }





    public void ReturnMainPage(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void KorisnikActivity(View v){
        Intent i = new Intent(this, Korisnik.class);
        startActivity(i);
    }
    public void Recepti(View v){
        Intent i = new Intent(this, SviRecepti.class);
        startActivity(i);
    }

    public void OtvoriPopis(View v){
        Intent i = new Intent(this, Popis.class);
        i.putStringArrayListExtra("lista", sastojci);
        startActivity(i);

    }
}