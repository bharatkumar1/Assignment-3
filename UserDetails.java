package com.example.newapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UserDetails extends AppCompatActivity {

    Dbhelper helper1;
    EditText get_name1,get_Fname1, get_phone1, get_email1,get_password1;
    Button updateInfo, editeInfo;
    RadioButton radioButton1;
    RadioGroup radioGroup1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_userdetail);

        get_name1 = findViewById(R.id.etUserName);
        get_Fname1 = findViewById(R.id.etFname);
        get_phone1 = findViewById(R.id.etUserPhone);
        get_email1 = findViewById(R.id.etUserEmail);
        get_password1 = findViewById(R.id.etUserAddress);
        updateInfo = findViewById(R.id.update_info);
        editeInfo = findViewById(R.id.edite_info);
        radioGroup1 = findViewById(R.id.e_gender);
        helper1 = new Dbhelper(this);
        Intent intent = getIntent();
        final String useremail = intent.getStringExtra("usermail");

        helper1 = new Dbhelper(this);
        Cursor data = helper1.information();

        while (data.moveToNext()) {
            if (useremail.equals(data.getString(5))) {
                get_name1.setText(data.getString(1));
                get_Fname1.setText(data.getString(2));
                get_phone1.setText(data.getString(5));
                get_email1.setText(data.getString(4));
                get_password1.setText(data.getString(3));
                if(data.getString(8).equals("Male"))
                {
                    ((RadioButton)radioGroup1.getChildAt(0)).setChecked(true);
                }
                else
                    ((RadioButton)radioGroup1.getChildAt(1)).setChecked(true);
            }
        }

        editeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name2=get_name1.getText().toString();
                String fname2=get_Fname1.getText().toString();
                String phone2=get_phone1.getText().toString();
                String email2=get_email1.getText().toString();
                String pass2=get_password1.getText().toString();
                int gendId=radioGroup1.getCheckedRadioButtonId();

                radioButton1= findViewById(gendId);
                boolean check =helper1.insertion(name2,fname2,phone2,email2,pass2,radioButton1.getText().toString(),2);
                if (check )
                    Toast.makeText(getApplicationContext(), "Edite Successful", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Edite failed", Toast.LENGTH_SHORT).show();

                finish();
            }
        });



    editeInfo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            updateInfo.setVisibility(View.VISIBLE);
            editeInfo.setVisibility(View.VISIBLE);
        }
    });

    }
}
