package com.example.sendingemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText to,sub,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to = findViewById(R.id.email);
        sub=findViewById(R.id.subject);
        msg = findViewById(R.id.text);
        send= findViewById(R.id.btn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(intent.EXTRA_EMAIL,new String[]{to.getText().toString()}); //array of string
                intent.putExtra(intent.EXTRA_SUBJECT,sub.getText().toString());
                intent.putExtra(intent.EXTRA_TEXT,msg.getText().toString());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose Mail app"));

            }
        });
    }
}
