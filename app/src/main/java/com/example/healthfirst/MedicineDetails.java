package com.example.healthfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MedicineDetails extends AppCompatActivity {

    TextView tv1, tvcost;
    EditText et1;
    Button backbttn,addbttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_details);

        tv1 = findViewById(R.id.od);
        tvcost = findViewById(R.id.tVtotalcost);
        et1 = findViewById(R.id.editmultiline);
        et1.setKeyListener(null);
        backbttn = findViewById(R.id.buttonbacktomed);
        addbttn = findViewById(R.id.bttnaddtocart);

        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));
        et1.setText(intent.getStringExtra("text2"));
        tvcost.setText("Total Cost: "+intent.getStringExtra("text3")+"/-");

        backbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicineDetails.this,Medicine.class));
            }
        });
        addbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username","").toString();
                String product = tv1.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                DB db = new DB(getApplicationContext(),"healthfirst",null,1);

                if(db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();
                }else {
                    //db = new DB(getApplicationContext(),"healthfirst",null,1);
                    db.addCart(username,product,price,"medicine");
                    Toast.makeText(getApplicationContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MedicineDetails.this,Medicine.class));
                }
            }
        });



    }
}