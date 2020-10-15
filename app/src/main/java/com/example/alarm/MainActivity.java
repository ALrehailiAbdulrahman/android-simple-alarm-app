package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText time;
    Button set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.editTextTime);
        set = findViewById(R.id.set);


        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the local time(current time)
                String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                //get the hours and minutes of current time
                int ch = Integer.parseInt(currentTime.substring(0, 2));
                int cm = Integer.parseInt(currentTime.substring(3, 5));

                //get the hours and minutes of the alarm
                int h = Integer.parseInt(time.getText().toString().substring(0, 2));
                int m = Integer.parseInt(time.getText().toString().substring(3, 5));

                if ((cm - m) == 0) {
                    if (h > ch)
                        Toast.makeText(getApplicationContext(), "Alarm set for " + (h - ch) + " hours from now.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Alarm set for " + (h - ch + 24) + " hours from now.", Toast.LENGTH_SHORT).show();
                } else if (h > ch) {
                    if (m > cm)
                        Toast.makeText(getApplicationContext(), "Alarm set for " + (h - ch) + " hours and " + (m - cm) + " minutes from now.", Toast.LENGTH_SHORT).show();
                    else if ((h - ch - 1) == 0)
                        Toast.makeText(getApplicationContext(), "Alarm set for " + (m - cm + 60) + " minutes from now.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Alarm set for " + (h - ch - 1) + " hours and " + (m - cm + 60) + " minutes from now.", Toast.LENGTH_SHORT).show();
                }
                else if((h-ch)==0){
                    if(m>cm)
                        Toast.makeText(getApplicationContext(), "Alarm set for " + (m - cm ) + " minutes from now.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Alarm set for "+(h - ch +23) + " hours and " + (m - cm +60) + " minutes from now.", Toast.LENGTH_SHORT).show();
                }
                else if(ch>h){
                    if (cm > m)
                        Toast.makeText(getApplicationContext(), "Alarm set for " + (h - ch+23) + " hours and " + (m - cm+60) + " minutes from now.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Alarm set for " + (h - ch +24 ) + " hours and " + (m - cm ) + " minutes from now.", Toast.LENGTH_SHORT).show();


                }


            }
        });
    }
}