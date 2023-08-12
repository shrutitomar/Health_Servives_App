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

public class Doctor extends AppCompatActivity {
Button bttn;
Button bttn2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username", " ").toString();
        bttn = findViewById(R.id.Dlgout);
        bttn2 = findViewById(R.id.Dback);
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(Doctor.this, LoginActivity.class));
            }
        });
        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Doctor.this,Home.class));
            }
        });
        CardView Orthopedic = findViewById(R.id.Doctoro);
        Orthopedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Doctor.this, DoctorDetails.class);
                it.putExtra("title","ORTHOPEDIC");
                startActivity(it);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView Gynecologist = findViewById(R.id.cardDoctorg);
        Gynecologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent it = new Intent(Doctor.this, DoctorDetails.class);
               it.putExtra("title","GYNECOLOGIST");
               startActivity(it);
            }
        });

        CardView Neurologist = findViewById(R.id.cardDoctorn);
        Neurologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Doctor.this, DoctorDetails.class);
                it.putExtra("title","NEUROLOGIST");
                startActivity(it);
            }
        });
        CardView dentist = findViewById(R.id.cardDdentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Doctor.this, DoctorDetails.class);
                it.putExtra("title","DENTIST");
                startActivity(it);
            }
        });

        CardView surgeon = findViewById(R.id.cardDsurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Doctor.this, DoctorDetails.class);
                it.putExtra("title","SURGEON");
                startActivity(it);
            }
        });

        CardView cardeologist = findViewById(R.id.cardDcardeologist);
        cardeologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Doctor.this, DoctorDetails.class);
                it.putExtra("title","CARDEOLOGIST");
                startActivity(it);
            }
        });

    }
}