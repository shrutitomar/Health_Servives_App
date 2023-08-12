package com.example.healthfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Medicine extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Amoxicillin 500 mg","","","","50"},
                    {"Ibuprofen 800 mg","","","","70"},
                    {"Cetirizine hydrochloride 10 mg","","","","90"},
                    {"Amlodipine besylate 10 mg","","","","80"},
                    {"Cyclobenzaprine hydrochloride 10 mg","","","","100"},
                    {"Dolo 650 Tablets","","","","30"},
                    {"Honitus Cough Syrup-100ml","","","","105"},
                    {"Aspirin 75mg","","","","20"},
                    {"Mylab CoviSelf - COVID-19 Rapid Antigen Self Test Kit","","","","250"},

            };
    private String[] package_details = {
            "It is used to treat bacterial infections, such as chest infections (including pneumonia) and dental abscesses.\n"+
                    "It can also be used together with other antibiotics and medicines to treat stomach ulcers.",
            "Ibuprofen is used to relieve pain from various conditions such as headache, dental pain, menstrual cramps, muscle aches, or arthritis.",
            "Cetirizine is an antihistamine medicine that helps the symptoms of allergies.\n"+
                   " It's used to treat: hay fever. conjunctivitis (red, itchy eye) eczema.",
            "Amlodipine is used to treat high blood pressure in adults and children 6 years and older.\n "+
                    "It is also used to treat certain types of angina (chest pain) and coronary artery disease (narrowing of the blood vessels that supply blood to the heart).",
            "Cyclobenzaprine is used with rest, physical therapy, and other measures to relax muscles and relieve pain and discomfort caused by strains, sprains, and other muscle injuries.",
             "Dolo 650 Tablet is a common painkiller for treating aches and pains and fever. \n"+
                     " Dolo 650 reduces pain and fever by inhibiting the production of chemical messengers that cause fever and pain.",
            "Honitus Cough Syrup is used for the treatment of a cough and cold.\n"+
                    "It is effective for treating dry cough. It reduces irritation caused by a dry cough. It works as a natural expectorant and draws in sputum.",
            "Aspirin is used to reduce fever and relieve mild to moderate pain from conditions such as muscle aches, toothaches, common cold, and headaches.\n"+
                    " It may also be used to reduce pain and swelling in conditions such as arthritis.",
            "It is a self test kit. This product will have minimum 3 months expiry at the time of order dispatch.\n"+
                    "before conducting the test. This kit can be used by adults of age 18 years and above, or with adult collected samples from individuals aged 2 years or older"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button back;
    Button tocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        lst = findViewById(R.id.layout);
        back = findViewById(R.id.buttonback);
        tocart = findViewById(R.id.bttntocart);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Medicine.this,Home.class));
            }
        });
        tocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Medicine.this,MedCart.class));
            }
        });

        list = new ArrayList();
        for (int i = 0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Consultant Fees: " +packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        //ListView lst = findViewById(R.id.layout);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(Medicine.this,MedicineDetails.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });


    }
}