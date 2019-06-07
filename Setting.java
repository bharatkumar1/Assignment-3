package com.example.newapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Setting extends AppCompatActivity {
    Button updateSetting;
    Switch Push_notification , event_notification , sms_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        updateSetting = findViewById(R.id.Button_update);
        Push_notification = findViewById(R.id.swtch_Noti);
        event_notification= findViewById(R.id.eventswtch);
        sms_notification = findViewById(R.id.smsSwtch);


        SharedPreferences sharedPreferences= getSharedPreferences("settings",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        Push_notification.setChecked(sharedPreferences.getBoolean("push_state",false));

        Push_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    editor.putBoolean("push_state",true);


                }
                else
                {
                    editor.putBoolean("push_state",false);

                }
                editor.commit();
            }
        });

event_notification.setChecked(sharedPreferences.getBoolean("reminder_state",false));
    event_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){

                editor.putBoolean("reminder_state",true);

            }
            else {

                editor.putBoolean("reminder_state",false);
            }
            editor.commit();
        }
    });
    sms_notification.setChecked(sharedPreferences.getBoolean("sms_state",false));
    sms_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {

                editor.putBoolean("sms_state",true);


            }
            else
            {

                editor.putBoolean("sms_state",false);

            }
            editor.commit();
        }
    });
    updateSetting.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Setting.this,Menu.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Setting Updated",Toast.LENGTH_SHORT).show();
        }
    });
    }

}
