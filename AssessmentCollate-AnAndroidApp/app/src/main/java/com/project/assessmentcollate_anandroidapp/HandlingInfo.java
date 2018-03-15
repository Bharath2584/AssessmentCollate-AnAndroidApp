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


public class HandlingInfo extends Activity {

        Connection con;
        String fid;
        Button l;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            Bundle extra = getIntent().getExtras();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.handle_page);
            fid = extra.getString("usernam");

            l = (Button) findViewById(R.id.button12);

            l.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v){

                    Intent i = new Intent(HandlingInfo.this, LecturePage.class);
                    i.putExtra("usernam", fid);
                    startActivity(i);
                    finish();


                }


            });

            HandlingInfo.Handling attedence = new HandlingInfo.Handling();// this is the Asynctask, which is used to process in background to reduce load on app process
            attedence.execute(fid);

        }


        private class Handling extends AsyncTask<String, String, String> {
            String z = "";
            Boolean isSuccess = false;


            @Override
            protected void onPostExecute(String r) {

                TextView tv=(TextView) findViewById(R.id.textView2);
                tv.setText(z);

            }

            @Override
            protected String doInBackground(String... params) {
                String fid =params[0];

                try {
                    con = ConnectionPage.connect();        // Connect to database
                    if (con == null) {
                        z = "no net";
                    } else {
                        String result = "";
                        String query = "select sem,c.sub_id,sname,usn from handle h,faculty f,course c,details d where h.f_id=f.f_id and f.f_id='"+ fid +" ' and c.sub_id=h.sub_id and d.sub_id=c.sub_id";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int col = rsmd.getColumnCount();

                        while (rs.next()) {
                            for (int i = 1; i <= col; i++) {
                                result += rsmd.getColumnName(i) + ":" + rs.getString(i) + "\n";

                            }
                        }
                        z = result;
                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = ex.getMessage();
                }

                return z;
            }
        }


}
