package com.example.healthfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Appointment extends AppCompatActivity {
EditText ed1,ed2,ed3;
TextView tv;
Button bttndate;
Button bttntime;
Button book;
Button bttnback;

private DatePickerDialog datePickerDialog;
private TimePickerDialog timePickerDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        tv = findViewById(R.id.booktitle);
        ed1 = findViewById(R.id.drname);
        ed2 = findViewById(R.id.hadd);
        ed3 = findViewById(R.id.fee);
        bttndate = findViewById(R.id.datebttn);
        bttntime = findViewById(R.id.timebttn);
        book = findViewById(R.id.book);
        bttnback= findViewById(R.id.back);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String expertise = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText("Consultant Fees: "+fees+"/-");

        initDatePicker();
        bttndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                datePickerDialog.show();
            }
        });

        initTimePicker();
        bttntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });
        bttnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( Appointment.this,DoctorDetails.class));
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Your Appointment is booked.", Toast.LENGTH_SHORT).show();
               DB db = new DB(getApplicationContext(),"helathfirst",null,1);
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username","").toString();
                if(db.checkAppointmentexixts(username, title+" =>"+fullname,address,expertise,bttndate.getText().toString(),bttntime.getText().toString())==1){
                Toast.makeText(getApplicationContext(), "Your Appointment is already booked", Toast.LENGTH_SHORT).show();
            }
            else {
                db.addOrder(username,title+" =>"+fullname,address,null,0,bttndate.getText().toString(),bttntime.getText().toString(),Float.parseFloat(fees),"appointment");
                Toast.makeText(getApplicationContext(), "Your Appointment is booked successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Appointment.this,Home.class));
            }
            }
        });



    }



     private void initDatePicker(){
         DatePickerDialog.OnDateSetListener dateSetListner = new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                 i1=i1+1;
                 bttndate.setText(i2+"/"+i1+"/"+i);
             }
         };
         Calendar cal = Calendar.getInstance();
         int year = cal.get(Calendar.YEAR);
         int month = cal.get(Calendar.MONTH);
         int day = cal.get(Calendar.DAY_OF_MONTH);

         int style = AlertDialog.THEME_HOLO_DARK;
         datePickerDialog = new DatePickerDialog(this,style,dateSetListner,year,month,day);
         datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }
    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                bttntime.setText(i+":"+i1);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, mins, true);


    }
}
