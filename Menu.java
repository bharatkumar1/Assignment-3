package com.example.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    ImageView imageInfo, imagesetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageInfo= (ImageView) findViewById(R.id.imageinfo);
        imagesetting=findViewById(R.id.imgesetting);

        imageInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent110 = new Intent(Menu.this, UserDetails.class);
                startActivity(intent110);
                finish();
            }
        });
        imagesetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent101 = new Intent(Menu.this, Setting.class);
                startActivity(intent101);
                finish();
            }
        });

    }
}
