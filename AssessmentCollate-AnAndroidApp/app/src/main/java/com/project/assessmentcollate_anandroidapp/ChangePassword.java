package com.project.assessmentcollate_anandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Statement;

public class ChangePassword extends Activity {

    Button b1;
    Connection con;
    EditText password;
    String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        super.onCreate(savedInstanceState);
        final Bundle extra = getIntent().getExtras();
        final String a = extra.getString("usernam");

        b1 = (Button) findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    password = (EditText) findViewById(R.id.editText);
                    p = password.getText().toString();
                    ChangePassword.CheckLogin checkLogin = new ChangePassword.CheckLogin();// this is the Asynctask, which is used to process in background to reduce load on app process
                    checkLogin.execute(p,a);
                }
            });

        }

        private class CheckLogin extends AsyncTask<String,String,String> {
            String z = "";
            Boolean isSuccess = false;

            @Override
            protected void onPostExecute(String r) {

                Toast.makeText(ChangePassword.this, r, Toast.LENGTH_SHORT).show();

            }

            @Override
            protected String doInBackground(String... params) {

                String passwordd = params[0];
                String name = params[1];

                if ( passwordd.trim().equals(""))
                    z = "Please enter new Password";
                else {
                    try {
                        con = ConnectionPage.connect();        // Connect to database
                        if (con == null) {
                            z = "no net";
                        } else {
                            String pass;

                            pass=SymbolTable.enc(passwordd);
                            String query = "update login set password='"+ pass +"'  where id='"+name+"'";//"update details set Attendace='" + marks + "' where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(query);
                            z = "update successful";

                        }

                    } catch (Exception ex) {
                        isSuccess = false;
                        z = ex.getMessage();
                    }
                }
                int h = name.length();

                if (h < 6) {

                    Intent i = new Intent(ChangePassword.this, LecturePage.class);
                    i.putExtra("usernam", name);
                    startActivity(i);
                    finish();
                } else {

                    Intent j = new Intent(ChangePassword.this, StudentPage.class);
                    j.putExtra("usernam", name);
                    startActivity(j);
                    finish();

                }

                return z;
            }
        }
    }