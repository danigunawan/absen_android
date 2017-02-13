package com.example.afif.aplikasipertama;

/**
 * Created by afif on 7/14/2016.
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;
import android.content.Context;
import android.content.SharedPreferences;

public class login extends AppCompatActivity  implements View.OnClickListener {


    //mendefinisikan views
    private Button btnLogin;
    private Button btnDaftar;
    private EditText textUsername;
    private EditText textPassword;
    public static final String session_username= "nameKey";
    public static final String session_login= "nameKey";

    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_design);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Initializing views
        textUsername = (EditText) findViewById(R.id.editTextUsername);
        textPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnDaftar = (Button) findViewById(R.id.buttonSignUp);
        //Setting listeners to button
        btnLogin.setOnClickListener(this);
        btnDaftar.setOnClickListener(this);


    }


    //Adding an employee
    private void prosesLogin(){

        final String username = textUsername.getText().toString().trim();
        final String password = textPassword.getText().toString().trim();

        class ProsesLogin extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(login.this,"Proses Login...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

                if (s.matches("1")){




                    startActivity(new Intent(login.this,MainActivity.class));
                    Toast.makeText(login.this,"Login Berhasil",Toast.LENGTH_LONG).show();


                }
                else {
                    Toast.makeText(login.this,s,Toast.LENGTH_LONG).show();
                }





            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_USERNAME,username);
                params.put(Config.KEY_PASSWORD,password);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_LOGIN, params);
                return res;
            }
        }

        if(username.matches("")) {
            Toast.makeText(login.this, "Username Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }
        else if(password.matches("")){

            Toast.makeText(login.this, "Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        }

        else
        {
            ProsesLogin ae = new ProsesLogin();
            ae.execute();

        }


    }
    @Override
    public void onClick(View v) {
        if(v == btnLogin){

            prosesLogin();
        }
    }
}
