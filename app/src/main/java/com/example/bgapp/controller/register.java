package com.example.bgapp.controller;
//package com.example.bgapp.model;

import androidx.appcompat.app.AppCompatActivity;
import java.sql.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bgapp.R;
import com.example.bgapp.model.sqlcon;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Result;

public class register extends AppCompatActivity {

    private TextInputEditText mname, mmail, mphone, mpassword ,mcpass;
    private static String URL_REGIST= "http://192.168.43.96/register_login/register.php";
    private Button btn_regit;
    private ProgressBar loading;
//    public static final String TAG = register.class.getSimpleName();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loading = findViewById(R.id.loading);
        mname = findViewById(R.id.Username);
        mmail = findViewById(R.id.Email);
        mphone = findViewById(R.id.phone);
        mpassword = findViewById(R.id.input_password);
        // cpass =  findViewById(R.id.c_password);
        btn_regit = findViewById(R.id.regit);
        btn_regit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 regit();
            }
        });

    }


    private void regit() {
        loading.setVisibility(View.GONE);
        btn_regit.setVisibility(View.VISIBLE);

        final String mname = this.mname.getText().toString().trim();
        final String mmail = this.mmail.getText().toString().trim();
        final String mpassword = this.mpassword.getText().toString().trim();
        /*this.mphone.getText().toString().trim().equals("")*/

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_REGIST, new Response.Listener<String>()  {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jO=new JSONObject(response);
                    System.out.println("@@@@@@@@"+response);
                    String success =jO.getString("success");
                    System.out.println("!!!!!!!!!!!"+success);


                    if (success.equals("1")){
                        Toast.makeText(register.this,"register success!",Toast.LENGTH_SHORT).show();

                        git add .      }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(register.this,"register error!"+ e.toString(),Toast.LENGTH_SHORT).show();
                    loading.setVisibility(View.GONE);
                    btn_regit.setVisibility(View.VISIBLE);
                }
            }
        },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(register.this,"register error!"+ error.toString(),Toast.LENGTH_SHORT).show();
                        loading.setVisibility(View.GONE);
                        btn_regit.setVisibility(View.VISIBLE);

                    }

                })
        {
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<>();

                params.put("namek",mname);
                params.put("emailk",mmail);
                params.put("passwordk",mpassword);
                //params.put("phonenok",mphone);
                //return super.getParams();
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}




