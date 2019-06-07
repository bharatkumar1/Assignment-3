package com.example.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Registration extends AppCompatActivity {


     Button register1;
     TextView already;
     EditText name, Father, phonenum,emailid,passwordUser;

     Dbhelper dbhelper;
     RadioGroup radioGroup1;
     RadioButton RB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

         name= (EditText)findViewById(R.id.etUserName);
         Father = (EditText)findViewById(R.id.etFname);
         phonenum= (EditText)findViewById(R.id.etUserPhone);
         emailid= (EditText)findViewById(R.id.etUserEmail);
        passwordUser= (EditText)findViewById(R.id.et_password);
        radioGroup1=findViewById(R.id.gender);
        int genderID= radioGroup1.getCheckedRadioButtonId();
        RB = findViewById(genderID);
        register1 = (Button) findViewById(R.id.Button_register);
        already = (TextView) findViewById(R.id.tvalready);

        dbhelper= new Dbhelper(this);

        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1 = name.getText().toString();
                String Fathom1 = Father.getText().toString();
                String  penumbra1= phonenum.getText().toString();
                String emailuser1= emailid.getText().toString();
                String password1= passwordUser.getText().toString();
                String getGender=RB.getText().toString();
               if(!user1.isEmpty() && !Fathom1.isEmpty() && !penumbra1.isEmpty() && !emailuser1.isEmpty() && !password1.isEmpty())
                {
                    boolean check =  dbhelper.insertion(user1, Fathom1, penumbra1, emailuser1, password1,getGender, 1);
                    if (check)
                    {
                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                        Intent intent121 = new Intent(Registration.this, Login.class);
                        startActivity(intent121);


                    }else
                        Toast.makeText(getApplicationContext(),"Failed", Toast.LENGTH_SHORT).show();

                } else
                         Toast.makeText(getApplicationContext(),"Please fill all fields", Toast.LENGTH_SHORT).show();

                }



        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentready= new Intent(Registration.this, Login.class);
                startActivity(intentready);
                finish();
            }
        });
    }
    }

