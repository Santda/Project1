package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    private TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        txt1 = (TextView) findViewById(R.id.textView5);

        //import the logged in user's name from sharedprefs
        String name = prefs.getString("currentName", "--");

        //display name
        txt1.setText("Welcome " + name);
    }
}
