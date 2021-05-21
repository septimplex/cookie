package com.example.cookie2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Korisnik extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korisnik);

        t1 = findViewById(R.id.korisnik);

        String imekorisnika = getIntent().getStringExtra("key");
        t1.setText(imekorisnika);


    }

    public void Natrag(View v){
        Intent i = new Intent(this, LoginMain.class);
        startActivity(i);
    }
}