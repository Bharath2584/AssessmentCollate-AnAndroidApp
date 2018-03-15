package com.project.assessmentcollate_anandroidapp;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class StudentPage extends Activity {




        Connection con;
        Button ch;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            Bundle extra = getIntent().getExtras();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.student_page);

            ch=(Button)findViewById(R.id.button11);
            final String a = extra.getString("usernam");
            ch.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v){

                    Intent i = new Intent(StudentPage.this, ChangePassword.class);
                    i.putExtra("usernam",a);
                    startActivity(i);
                    finish();

                }


            });
            StudentPage.Name name = new StudentPage.Name();// this is the Asynctask, which is used to process in background to reduce load on app process
            name.execute(a);

            Button l;
            l = (Button) findViewById(R.id.button3);

            l.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v){

                    Intent i = new Intent(StudentPage.this, LoginPage.class);
                    startActivity(i);
                    finish();

                }


            });

            StudentPage.Details detais = new StudentPage.Details();// this is the Asynctask, which is used to process in background to reduce load on app process
            detais.execute(a);




        }
        private class Details extends AsyncTask<String,String,String>
        {
            String z = "";
            Boolean isSuccess = false;


            @Override
            protected void onPostExecute(String r)
            {
                TextView tv=(TextView) findViewById(R.id.textView);
                tv.setText(z);



            }
            @Override
            protected String doInBackground(String... params)
            {
                String usernam=params[0];





                try
                {
                    con = ConnectionPage.connect();      // Connect to database
                    if (con == null)
                    {
                        z = "no net";
                    }
                    else
                    {
                        String result;//="";
                        String query = "select sname,first_ia,second_ia,third_ia,avg,attendace from details d,course c where c.sub_id=d.sub_id and usn='"+ usernam +"'  ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        ResultSetMetaData rsmd=rs.getMetaData();
                        int col=rsmd.getColumnCount();
                        result="SUB \t \t 1st \t \t 2nd \t \t 3rd \t \t AVG \t \t ATT\n";

                        while(rs.next()) {
                            for (int i = 1; i <= col; i++) {
                                result +=rs.getString(i) + "\t \t \t \t";

                            }
                            result +="\n";
                        }
                        z=result;

                        con.close();
                    }
                }

                catch (Exception ex)
                {
                    isSuccess = false;
                    z = ex.getMessage();
                }


                return z;
            }
        }

        private class Name extends AsyncTask<String,String,String>
        {
            String z = "welcome ";
            Boolean isSuccess = false;


            @Override
            protected void onPostExecute(String r)
            {
                TextView textView = (TextView) findViewById(R.id.textView3);
                textView.setText(z);
            }
            @Override
            protected String doInBackground(String... params)
            {
                String usernam=params[0];





                try
                {
                    con = ConnectionPage.connect();        // Connect to database
                    if (con == null)
                    {
                        z = "no net";
                    }
                    else
                    {
                        //  List<Example> mExampleList = new LinkedList<Example>();
                        String result;
                        String query = "select name from student where usn='"+ usernam +"'  ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);



                        rs.next();

                        result = rs.getString(1);



                        z=result;

                        con.close();
                    }
                }

                catch (Exception ex)
                {
                    isSuccess = false;
                    z = ex.getMessage();
                }


                return z;
            }
        }




       }

