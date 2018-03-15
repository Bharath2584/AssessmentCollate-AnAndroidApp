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
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginPage extends Activity {

    EditText username;
    EditText password;
    String u;
    String p;
    Button b1;
    Connection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                username = (EditText) findViewById(R.id.etUserName);
                password = (EditText) findViewById(R.id.etPassword);
                u = username.getText().toString();
                p = password.getText().toString();
                CheckLogin checkLogin = new CheckLogin();// this is the Asynctask, which is used to process in background to reduce load on app process
                checkLogin.execute(u,p);
            }


        });
    }

        private class CheckLogin extends AsyncTask<String,String,String>
            {
                String z = "";
                Boolean isSuccess = false;


                @Override
                protected void onPostExecute(String r)
                {
                    Toast.makeText(LoginPage.this, r, Toast.LENGTH_SHORT).show();


                }

                @Override
                protected String doInBackground(String... params)
                {


                    String usernam =params[0];
                    String passwordd=params[1];

                    if(usernam.trim().equals("")|| passwordd.trim().equals(""))
                        z = "Please enter Username and Password";
                    else
                    {
                        try
                        {
                            con = ConnectionPage.connect();       // Connect to database
                            if (con == null)
                            {
                                z = "no net";
                            }
                            else
                            {


                                String query = "select password from login where ID= '" + usernam + "'  ";
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery(query);
                                z="wrong password";

                                if(rs.next())
                                {
                                    String msg=rs.getString(1);


                                    String enc_pass=SymbolTable.decpt(msg);

                                    if ((enc_pass.equals(passwordd))) {


                                        z = "Login successful";
                                        isSuccess = true;
                                        con.close();
                                    }



                                }
                                else
                                {
                                    z = "Invalid Credentials!";
                                    isSuccess = false;
                                }
                            }
                        }
                        catch (Exception ex)
                        {
                            isSuccess = false;
                            z = ex.getMessage();
                        }
                    }

                    if(isSuccess) {
                        int h = usernam.length();


                        if (h < 6) {

                            Intent i = new Intent(LoginPage.this, LecturePage.class);
                            i.putExtra("usernam", usernam);
                            startActivity(i);
                            finish();
                        } else {

                            Intent j = new Intent(LoginPage.this, StudentPage.class);
                            j.putExtra("usernam", usernam);
                            startActivity(j);
                            finish();

                        }
                    }


                    return z;
                }
            }


           }







