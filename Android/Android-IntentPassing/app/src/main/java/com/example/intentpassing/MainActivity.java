package com.example.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    EditText et1,et2,et3,et4;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.fname2);
        et2 = (EditText)findViewById(R.id.lname2);
        et3=(EditText)findViewById(R.id.uname2);
        et4=(EditText)findViewById(R.id.pass2);
        b1 = (Button)findViewById(R.id.display);
        b2 = (Button)findViewById(R.id.submitt);
        b3 = (Button)findViewById(R.id.reset);
        tv1 = (TextView)findViewById(R.id.res);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fname = et1.getText().toString();
                final String lname = et2.getText().toString();
                final String username = et3.getText().toString();
                final String password = et4.getText().toString();
                if (TextUtils.isEmpty(fname)){
                    et1.setError("please enter first name");
                }
                else if (TextUtils.isEmpty(lname)){
                    et2.setError("please enter last name");
                }
                else if (TextUtils.isEmpty(username)){
                    et3.setError("please enter username ");
                }
                else if (TextUtils.isEmpty(password) || !isValidPassword(password)){
                    et4.setError("please enter password in 3d format ");
                }
                else{
                    tv1.setText("First Name :"+fname+" , \n Last name : "+lname);
                }

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                tv1.setText("");
                et1.requestFocus();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname  = et1.getText().toString();
                String lname = et2.getText().toString();
                String uname = et3.getText().toString();
                String pass = et4.getText().toString();
                if (TextUtils.isEmpty(fname)){
                    et1.setError("please enter first name");
                }
                else if (TextUtils.isEmpty(lname)){
                    et2.setError("please enter last name ");
                }
                else if (TextUtils.isEmpty(uname)){
                    et3.setError("please enter username ");
                }
                else if (TextUtils.isEmpty(pass)|| !isValidPassword(pass)){
                    et4.setError("please enter password in 3d format");
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                    intent.putExtra("fname",et1.getText().toString());
                    intent.putExtra("lname",et2.getText().toString());
                    startActivity(intent);
                }
            }
        });


    }
    public static boolean isValidPassword(String password){
        Matcher matcher;
        Pattern pattern ;
        String pat = "^(?=.*[1-9])(?=.*[A-Z])(?=.*[#@$%!^&+])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(pat);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

}