package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private EditText edit1;
    private EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SharedPreferences prefs = this.getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = prefs.edit();
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        edit1 = (EditText) findViewById(R.id.et1);
        edit2 = (EditText) findViewById(R.id.et2);
        int num = prefs.getInt("num", 0);

        //Login
        btn1.setOnClickListener(v->{
            String Recs[] = new String[num];
            String data = "";
            int emailMatch = 0, pwMatch = 0;
            editor.putString("currentName", " ");
            editor.commit();
            //Pulling records from sharedprefs, putting records in an array, splitting them into another array based on "," delimiter
            for(int x = 0; x< num; x++){
                String key = "Record";
                key += String.valueOf(x+1);
                Recs[x] = prefs.getString(key, "-_-");
                String [] z = Recs[x].split(",");

                //Searching for a match from editTexts
                if(edit1.getText().toString().equals(z[3]))
                    emailMatch += 1;
                if(edit2.getText().toString().equals(z[4]))
                    pwMatch += 1;

                //If email and password matches, set the current user's name
                if (emailMatch == 1 && pwMatch == 1) {
                    editor.putString("currentName", z[0] + " " + z[1]);
                    Log.d("omg", z[0] + " " + z[1]);
                    editor.commit();
                }
            }

            //If any field is empty
            if(edit1.getText().toString().isEmpty() || edit2.getText().toString().isEmpty())
                Toast.makeText(Main2Activity.this, "Please Fill in Each Textfield", Toast.LENGTH_SHORT).show();

            //If there are no matches in sharedprefs
            else if (emailMatch == 0 || pwMatch == 0){
                Toast.makeText(Main2Activity.this, "Incorrect email address or password. Please re-enter.", Toast.LENGTH_SHORT).show();
                edit1.setText("");
                edit2.setText("");
            }

            //There is a match. Navigate to the welcome page
            else {
                Intent intent = new Intent(this, Main4Activity.class);
                startActivity(intent);
            }

        });

        //Register
        btn2.setOnClickListener(v -> {
            Intent i = new Intent(this, Main3Activity.class);
            startActivity(i);
        });



    }
}
