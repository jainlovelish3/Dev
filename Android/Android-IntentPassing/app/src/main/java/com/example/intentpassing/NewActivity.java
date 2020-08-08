package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        t1 = findViewById(R.id.tvnew);
        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname");
        String lname= intent.getStringExtra("lname");
        t1.setText("your name is : "+fname + " "+ lname);
    }
}
