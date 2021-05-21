package com.example.cookie2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button Login;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        Login = (Button) findViewById(R.id.button);
        DB = new DBhelper(this);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity.this,"Molim vas unesite sva polja!", Toast.LENGTH_SHORT).show();
                else{
                    boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass == true){

                        Toast.makeText(MainActivity.this,"Uspješna prijava!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),LoginMain.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(MainActivity.this, "Pogrešan unos, pokušajte ponovno!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }


    public void SignUpActivity(View v){
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }


}