package com.example.newapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button login1;
    EditText et_email, pass1;
    TextView register2;
    public int test;
    Dbhelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        login1 = findViewById(R.id.button_login);
        register2 = findViewById(R.id.tvRegister);
        et_email = findViewById(R.id.etUserEmail);
        pass1 = findViewById(R.id.etUserpassword);

        helper = new Dbhelper(this);


        register2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent0 = new Intent(Login.this, Registration.class);
                startActivity(intent0);

            }

        });

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = et_email.getText().toString();
                String pass = pass1.getText().toString();

                if (!user.isEmpty() || !pass.isEmpty()) {
                    Cursor data = helper.information();

                    while (data.moveToNext()) {
                        if (user.equals(data.getString(6)) && pass.equals(data.getString(8))) {
                            test = 1;
                        }
                    }
                    if (test== 1) {

                        Intent intent12 = new Intent(Login.this, Menu.class);

                        intent12.putExtra("email", user);
                        startActivity(intent12);
                        finish();
                    } else
                        Toast.makeText(getApplicationContext(), "Not Valid", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(getApplicationContext(), "Enter User Email and Password", Toast.LENGTH_SHORT).show();

            }


        });
    }

    public void onBackPressed()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.Not_registered);
        builder.setMessage(R.string.Not_registered);
        builder.setPositiveButton("Exist", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.show();


    }



}
