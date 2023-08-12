package com.example.healthfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    Button backbutton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        backbutton = findViewById(R.id.logout);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username", " ").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+username, Toast.LENGTH_SHORT).show();


        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(Home.this, LoginActivity.class));
            }
        });
         CardView doctor = findViewById(R.id.cardDoctor);
         doctor.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(Home.this, Doctor.class));
             }
         });

        CardView medicine = findViewById(R.id.cardMedicine);
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity((new Intent(Home.this,Medicine.class)));
            }
        });

         CardView orderdetails = findViewById(R.id.orderdetailcard);
         orderdetails.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 startActivity(new Intent(Home.this,Orders.class));
             }
         });
        }

    }
