package com.example.healthfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText emailad,newuser,setpasscode,reenter;
    Button bttn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        emailad = findViewById(R.id.email);
        newuser = findViewById(R.id.newusername);
        setpasscode = findViewById(R.id.setpass);
        reenter = findViewById(R.id.reenterpass);
        textView = findViewById(R.id.olduser);
        bttn = findViewById(R.id.book);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, LoginActivity.class));

            }
        });
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailad.getText().toString();
                String newusername = newuser.getText().toString();
                String setpass = setpasscode.getText().toString();
                String reenterpass = reenter.getText().toString();
                DB db = new DB(getApplicationContext(),"healthfirst",null,1);
                if (email.length() == 0 || newusername.length() == 0 || setpass.length() == 0 || reenterpass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(setpass.compareTo(reenterpass) == 0){
                        if (check(setpass)) {
                            db.registration(newusername,email,setpass);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity((new Intent(Registration.this,LoginActivity.class)));
                    }
                        else {
                            Toast.makeText(getApplicationContext(), "Password must contain atleast 8 characters,having letters,digits and aplhabets and special character", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Passwords didn't Match", Toast.LENGTH_SHORT).show();

                }
                }
            }
        });

    }
    public static boolean check(String passcode){
        int a=0,b=0,c=0;
        if(passcode.length()<8){
            return false;}
        else{
            for(int p=0;p< passcode.length();p++){
                if(Character.isLetter(passcode.charAt(p))){
                    a=1;
                }
            }

        for(int r=0;r< passcode.length();r++){
            if (Character.isDigit(passcode.charAt(r))){
                b=1;
            }
        }
        for (int s=0;s< passcode.length();s++){
            char d = passcode.charAt(s);
            if (d>=33&&d<=46||d==64){
                c=1;
            }
        }
        if(a==1&&b==1&&c==1)
            return  true;
        return false;
        }
    }
}









