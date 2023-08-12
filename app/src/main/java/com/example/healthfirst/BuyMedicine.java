package com.example.healthfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicine extends AppCompatActivity {
    EditText eTname, eTadd, eTcode, eTphone;
    Button book,cancel;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        eTname = findViewById(R.id.fullname);
        eTadd = findViewById(R.id.address);
        eTcode = findViewById(R.id.pincode);
        eTphone = findViewById(R.id.phoneno);
       book = findViewById(R.id.book);
        cancel = findViewById(R.id.exit);


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicine.this,Medicine.class));
            }
        });

     Intent intent = getIntent();
     String[] price = intent.getStringArrayExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
     String date = intent.getStringExtra("date");

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                DB db = new DB(getApplicationContext(),"healhfirst",null,1);
                db.addOrder(username,eTname.getText().toString(),eTadd.getText().toString(),eTphone.getText().toString(), Integer.parseInt(eTcode.getText().toString()),date.toString(), " " ,Float.parseFloat(price[1].toString()),"medicine");
                db.removeCart(username, "medicine");
                Toast.makeText(getApplicationContext(), "Your booking is done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(BuyMedicine.this,Home.class));
            }
        });



    }


}