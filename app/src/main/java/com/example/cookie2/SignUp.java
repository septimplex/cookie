package com.example.cookie2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = (EditText) findViewById(R.id.ime);
        password = (EditText) findViewById(R.id.pass);
        repassword = (EditText) findViewById(R.id.repass);
        signup = (Button) findViewById(R.id.button3);
        DB = new DBhelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(SignUp.this,"Molim vas unesite sva polja!", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(SignUp.this,"Uspješna registracija korisnika!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginMain.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignUp.this,"Registracija korisnika nije uspjela!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp.this,"Korisničko ime već postoji!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(SignUp.this,"Lozinke se ne poklapaju, pokušajte ponovno!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });


    }
    public void ReturnMainPage(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}