package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private static int num = 0;
    private Button btn3;
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    private EditText edit5;
    private TextView txt3;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn3  = (Button) findViewById(R.id.btn3);

        edit1 = (EditText) findViewById(R.id.et3);
        edit2 = (EditText) findViewById(R.id.et4);
        edit3 = (EditText) findViewById(R.id.et5);
        edit4 = (EditText) findViewById(R.id.et6);
        edit5 = (EditText) findViewById(R.id.et7);
        txt3 = (TextView) findViewById(R.id.textView3);
        SharedPreferences sharedPref = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        //Submit Data
        btn3.setOnClickListener(v->{
            num++;

            //if any field is empty
            if(edit1.getText().toString().isEmpty() || edit2.getText().toString().isEmpty() || edit3.getText().toString().isEmpty() || edit4.getText().toString().isEmpty() || edit5.getText().toString().isEmpty())
                Toast.makeText(Main3Activity.this, "Please Fill in Each Textfield", Toast.LENGTH_SHORT).show();

            //if email field doesn't fit the email pattern
            else if (!Patterns.EMAIL_ADDRESS.matcher(new String(edit4.getText().toString())).matches())
                edit4.setError("Please enter a valid email address");

            //checking if entered password is required length
            else if ((edit1.getText().toString()).length() < 3 || (edit1.getText().toString()).length() > 30)
                edit1.setError("Password must be at least 3 characters and not more than 30 characters.");

            //adding entered data to sharedprefs
            else{
                String numb = String.valueOf(num);
                String record = "Record" + numb;
                String data = edit1.getText().toString() + "," + edit2.getText().toString() + "," + edit3.getText().toString() + "," + edit4.getText().toString() + "," + edit5.getText().toString();
                editor.putString(record, data);
                editor.putInt("num", num);
                editor.commit();

                //Navigate back to login page
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

}
