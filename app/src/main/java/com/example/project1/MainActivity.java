package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/* Created By: David Santiago
   Program Description: Project 1
   Creation Date: 9/27/2019
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating splash screen with 4 second delay
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(homeIntent);
            finish();
         },4000);
    }
}
