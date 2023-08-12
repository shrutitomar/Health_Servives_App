package com.example.healthfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {


    private  String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr. Aradhana Singh ", "Address: Fortis Hospital, Noida " , "Expertise: high-risk pregnancies, treatment of cancer of the uterus, treatment of cancer of ovaries, and female reproductive system. " ,"Experience:  21 years ","Fees: 500"},
                    {"Doctor Name :  Dr. Padmapriya Vivek", " Address: Global Hospital, Chennai" ,"Expertise: Surgery for Uterus Cancer, Surgery for Ovarian Cancer & All Gynaecological Cancer Surgeries.", "Experience: 20 years " ,"Fees: 300"},
                    {"Doctor Name :  Dr. Sita Rajan", " Address:Columbia Asia Hospital, Bangalore " ,"Expertise: v Infertility Specialists,IVF & ART treatments. ", "Experience: 35 years" ,"Fees:500 "},
                    {"Doctor Name : Dr. Aanchal Agarwal ", "Address: BLK Super Speciality Hospital, New Delhi" ,"Expertise:  Female Infertility Treatment, High-Risk Pregnancy Care, Normal Vaginal Delivery (Painless), Laparoscopic Myomectomy, Laparoscopy Hysterectomy and more.  ", "Experience: 19+ years" ,"Fees:600 "}

    };
    private  String[][] doctor_details2 = {
            {"Doctor Name :  Dr. Praveen Gupta", "Address: Fortis Memorial Research Institute, Gurgaon" ,"Expertise: Neurology,Thrombolysis for Acute Stroke Management ", "Experience: 16 years" ,"Fees: 400 "},
            {"Doctor Name : Dr. Mukul Varma ", "Address:Indraprastha Apollo Hospital, New Delhi " ,"Expertise: Parkinson Disease,Persistent Headache ", "Experience: 28 years" ,"Fees: 600 "},
            {"Doctor Name : Dr. Dinesh Nayak ", " Address:Gleneagles Global Hospital, Perumbakkam, Chennai " ,"Expertise: Brain Aneurysm Surgery, Cerebrospinal Fluid Shunt,Vascular Surgery,Laminectomy", "Experience: 25 years" ,"Fees: 300"},
            {"Doctor Name : Dr. Anand Kumar Saxena ", " Address:Venkateshwar Hospital, New Delhi " ,"Expertise: Neurological dysfunction,Nerve and Muscle Disorders", "Experience: 26 years" ,"Fees: 500 "}
    };
    private  String[][] doctor_details3 = {
            {"Doctor Name :  Dr Ritika Malhotra ", " Address:  Fortis Memorial Research Institute, Gurugram, Delhi NCR" ,"Expertise:  ", "Experience:13 Years " ,"Fees: 200"},
            {"Doctor Name :  Dr Aman Popli ", "Address: Max Super Speciality Hospital, Saket " ,"Expertise:  ", "Experience: 32 years" ,"Fees:400 "},
            {"Doctor Name :   Dr Ateksha Bhardwaj Khanna", "Address: Medanta-The Medicity, Gurugram, Delhi NCR" ,"Expertise:  ", "Experience: 11 years " ,"Fees:300 "},
            {"Doctor Name :  Dr Rajesh Koppikar", " Address: KokilabenDhirubhai Ambani Hospital & Medical Research Institute, Mumbai " ,"Expertise:  ", "Experience: 28+ years " ,"Fees: 600"}
    };
    private  String[][] doctor_details4 = {
            {"Doctor Name : Dr. Ashok Seth ", "Address:  Fortis Hospital, New Delhi" ,"Expertise:  ", "Experience: 23+ years " ,"Fees: 1000"},
            {"Doctor Name :  Dr. Ashok Rajgopal", " Address: Medanta-The Medicity, Gurugram, Delhi NCR " ,"Expertise:  ", "Experience: " ,"Fees: "},
            {"Doctor Name : Dr. Naresh Trehan ", "Address: Apollo Hospital, New Delhi." ,"Expertise: 25 years ", "Experience: " ,"Fees: 800"},
            {"Doctor Name : Dr. Suresh H. Advani ", " Address: Jaslok Hospital, New Delhi " ,"Expertise:  L.", "Experience: 30+ years" ,"Fees: 900 "}
    };
    private  String[][] doctor_details5 = {
            {"Doctor Name : Dr. Ajay Kaul ", " Address:Fortis Hospital, Noida " ,"Expertise:  ", "Experience: 38 years " ,"Fees: 500"},
            {"Doctor Name :  Dr. Y K Mishra", "Address: Manipal Hospitals Dwarka, Delhi" ,"Expertise:  ", "Experience: 34 years" ,"Fees:600 "},
            {"Doctor Name : Dr. Nandkishore Kapadia ", " Address:Kokilaben Dhirubhai Ambani Hospital, Mumbai " ,"Expertise:  ", "Experience: 30 years " ,"Fees: 800 "},
            {"Doctor Name : Dr. Gobu ", "Address:Global Hospitals, Chennai " ,"Expertise:  ", "Experience: 21 years " ,"Fees: 400 "}
    };
    private  String[][] doctor_details6 = {
            {"Doctor Name : Dr. Narender Kumar Magu ", " Address: Bone & Joint Clinic,Rohtak, Haryana " ,"Expertise:  ", "Experience:35 years " ,"Fees: 200 "},
            {"Doctor Name : Dr. Yatinder Kharbanda ", " Address:Indraprastha Apollo Hospital, New Delhi " ,"Expertise:  ", "Experience: 33 years " ,"Fees: 1000"},
            {"Doctor Name : Dr. Ram Chidambaram  ", "Address: MGM Healthcare, Chennai " ,"Expertise:  ", "Experience: 29 years" ,"Fees: 300 "},
            {"Doctor Name : Dr. IPS Oberoi  ", " Address: Artemis Hospital, Gurgaon " ,"Expertise:  ", "Experience: 25 years" ,"Fees: 700"}
    };
    TextView tV;
    Button bttn;
    String [][] doctor_details = { };
    HashMap<String,String>  item;
     ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);


        tV = findViewById(R.id.DDtitle);
        bttn = findViewById(R.id.DDback);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tV.setText(title);

        if(title.compareTo("GYNECOLOGIST") ==0)
            doctor_details = doctor_details1;
        else if (title.compareTo("NEUROLOGIST")==0) {
            doctor_details = doctor_details2;
        }
        else if (title.compareTo("DENTIST")==0) {
            doctor_details = doctor_details3;
        }
        else if (title.compareTo("SURGEON")==0) {
            doctor_details = doctor_details4;
        }
        else if (title.compareTo("CARDEOLOGIST")==0) {
            doctor_details = doctor_details5;
        }
        else if (title.compareTo("ORTHOPEDIC")==0) {
            doctor_details = doctor_details6;
        }

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetails.this, Doctor.class));
            }
        });
        list = new ArrayList();
        for (int i = 0;i<doctor_details.length;i++){
             item = new HashMap<String,String>();
             item.put("line1", doctor_details[i][0]);
             item.put("line2", doctor_details[i][1]);
             item.put("line3", doctor_details[i][2]);
             item.put("line4", doctor_details[i][3]);
            item.put("line5", "Consultant Fees: " +doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.orderlist);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetails.this,Appointment.class);
                it.putExtra("text1",title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}