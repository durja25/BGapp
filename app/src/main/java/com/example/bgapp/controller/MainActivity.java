package com.example.bgapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bgapp.R;

public class MainActivity extends AppCompatActivity {

    private EditText input_email,input_password;
    private Button mbtnin,mbtnup;
    public String minfo;
    public static final String EXTRA_MESSAGE =
            "asdasf";
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnin=findViewById(R.id.login);
        mbtnup=findViewById(R.id.signup);

        mbtnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, register.class);
                    startActivity(intent);
                            }
        });

        logo= findViewById(R.id.logo);

        }

        public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();

    }

    public void clgin(View view) {
        System.out.println("#############");
        minfo = getString(R.string.clg_info);
        displayToast(minfo);
        Intent intent =
                new Intent(MainActivity.this, clginfom.class);
        intent.putExtra(EXTRA_MESSAGE, minfo);
        startActivity(intent);
        //displayToast(getString(R.string.clg_info));


    }

}