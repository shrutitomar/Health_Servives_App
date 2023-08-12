package com.example.healthfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MedCart extends AppCompatActivity {
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    TextView total;
    ListView lst;

    private DatePickerDialog datePickerDialog;
    private Button dateBttn,checkoutBttn,backBttn;
    private String[][] packages = {};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_cart);

        dateBttn = findViewById(R.id.datebttn);
       checkoutBttn = findViewById(R.id.buttoncheckout);
        backBttn = findViewById(R.id.backbutton);
        lst = findViewById(R.id.listview);
        total = findViewById(R.id.cost);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();

        DB db = new DB(getApplicationContext(),"healthfirst",null,1);

        float totalAmount = 0;
        ArrayList dbData = db.getCartData(username,"medicine");


        packages = new String[dbData.size()][];
        for(int i = 0; i<packages.length;i++){
            packages[i] = new String[5];

        }
       for (int i=0;i<dbData.size();i++){
           String arrData = dbData.get(i).toString();
           String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
           packages[i][0]= strData[0];
           packages[i][4]= "Cost: "+strData[1]+"/-";
           totalAmount = totalAmount + Float.parseFloat(strData[1]);

       }
       total.setText("Total Cost: "+totalAmount);

        list = new ArrayList();
        for (int i = 0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5",packages[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.orderlist);
        lst.setAdapter(sa);

        backBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedCart.this,Medicine.class));
            }
        });

        checkoutBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent it = new Intent(MedCart.this,BuyMedicine.class);
              it.putExtra("price",total.getText());
              it.putExtra("date",dateBttn.getText());
              startActivity(it);
            }
        });

        initDatePicker();
        dateBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });


    }


    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateBttn.setText(i2+"/"+i1+"/"+i);
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
}