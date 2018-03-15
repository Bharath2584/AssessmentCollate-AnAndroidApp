package com.project.assessmentcollate_anandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LecturePage extends Activity {


        Connection con;
        Button b1;
        Button b2,ch;
        Button b3,b5;//report;
        Button att;
        EditText sub_id;
        EditText mks;
        EditText usn;
        String fid,u,k,s;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            final Bundle extra = getIntent().getExtras();
            setContentView(R.layout.lecture_page);
            final String a = extra.getString("usernam");


            LecturePage.Name name = new LecturePage.Name();// this is the Asynctask, which is used to process in background to reduce load on app process
            name.execute(a);

            b1 = (Button) findViewById(R.id.button2);
            b2 = (Button) findViewById(R.id.button4);
            b3 = (Button) findViewById(R.id.button5);
            att = (Button) findViewById(R.id.button6);
            b5=(Button)findViewById(R.id.button8);
            ch=(Button)findViewById(R.id.button10);
            //  report=(Button)findViewById(R.id.button13);

            Button l;
            l = (Button) findViewById(R.id.button7);

            l.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v){



                    Intent i = new Intent(LecturePage.this, LoginPage.class);
                    startActivity(i);
                    finish();

                }


            });

            ch.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v){

                    Intent i = new Intent(LecturePage.this, ChangePassword.class);
                    i.putExtra("usernam",a);
                    startActivity(i);
                    finish();

                }


            });

         /*   report.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    sub_id=(EditText)findViewById(R.id.editText2);
                    fid = extra.getString("usernam");
                    u = sub_id.getText().toString();

                    if(u.trim().equals("")) {

                        Toast.makeText(LecturePage.this, "enter sub", Toast.LENGTH_SHORT).show();

                    }
                    else {


                        LecturePage.Rep rep = new LecturePage.Rep();// this is the Asynctask, which is used to process in background to reduce load on app process
                        rep.execute(fid, u);
                    }


                }


            });*/

            b1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    sub_id=(EditText)findViewById(R.id.editText2);
                    mks=(EditText)findViewById(R.id.editText3) ;
                    usn=(EditText)findViewById(R.id.editText5);
                    fid = extra.getString("usernam");
                    u = sub_id.getText().toString();
                    k = mks.getText().toString();
                    s = usn.getText().toString();
                    if(ChechValue(u,k,s)) {


                        LecturePage.First_IA first_ia = new LecturePage.First_IA();// this is the Asynctask, which is used to process in background to reduce load on app process
                        first_ia.execute(fid, u, k, s);
                    }

                }


            });

            b2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    sub_id=(EditText)findViewById(R.id.editText2);
                    mks=(EditText)findViewById(R.id.editText3) ;
                    usn=(EditText)findViewById(R.id.editText5);
                    fid = extra.getString("usernam");
                    u = sub_id.getText().toString();
                    k = mks.getText().toString();
                    s = usn.getText().toString();

                    if(ChechValue(u,k,s)) {

                        LecturePage.Second_IA second_ia = new LecturePage.Second_IA();// this is the Asynctask, which is used to process in background to reduce load on app process
                        second_ia.execute(fid, u, k, s);
                    }

                }


            });

            b3.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    sub_id=(EditText)findViewById(R.id.editText2);
                    mks=(EditText)findViewById(R.id.editText3) ;
                    usn=(EditText)findViewById(R.id.editText5);
                    fid = extra.getString("usernam");
                    u = sub_id.getText().toString();
                    k = mks.getText().toString();
                    s = usn.getText().toString();
                    if(ChechValue(u,k,s)) {

                        LecturePage.Third_IA third_ia = new LecturePage.Third_IA();// this is the Asynctask, which is used to process in background to reduce load on app process
                        third_ia.execute(fid, u, k, s);
                    }

                }


            });

            b5.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    fid = extra.getString("usernam");
                    Intent i = new Intent(LecturePage.this, HandlingInfo.class);
                    i.putExtra("usernam",fid);
                    startActivity(i);
                    finish();


                }


            });


            att.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    sub_id=(EditText)findViewById(R.id.editText2);
                    mks=(EditText)findViewById(R.id.editText3) ;
                    usn=(EditText)findViewById(R.id.editText5);
                    fid = extra.getString("usernam");
                    u = sub_id.getText().toString();
                    k= mks.getText().toString();
                    s = usn.getText().toString();

                    if(ChechValue(u,k,s)) {

                        LecturePage.Attedence attedence = new LecturePage.Attedence();// this is the Asynctask, which is used to process in background to reduce load on app process
                        attedence.execute(fid, u, k, s);
                    }


                }


            });

        }


        private class First_IA extends AsyncTask<String,String,String>
        {
            String z = "";
            Boolean isSuccess = false;


            @Override
            protected void onPostExecute(String r)
            {
                Toast.makeText(LecturePage.this, r, Toast.LENGTH_SHORT).show();

            }
            @Override
            protected String doInBackground(String... params)
            {
                String fid =params[0];
                String sub=params[1];
                String mks =params[2];
                String usn=params[3];
                int marks=Integer.parseInt(mks);

                try
                {
                    con = ConnectionPage.connect();        // Connect to database
                    if (con == null)
                    {
                        z = "no net";
                    }


                    else {

                        String check = "select * from faculty f,handle h where f.f_id=h.f_id and f.f_id='" + fid + "' and h.sub_id='" + sub + "'";//"select name from student where usn='"+ usernam +"'  ";
                        Statement m = con.createStatement();
                        ResultSet rs = m.executeQuery(check);


                        if (rs.next()) {


                            String query = "update details set First_IA='" + marks + "' where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            String s = "select second_ia from details where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            String t = "select third_ia from details where USN='" + usn + "' and SUB_ID='" + sub + "'";


                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(query);
                            ResultSet srs = stmt.executeQuery(s);
                            srs.next();
                            String sec = srs.getString(1);
                            int s_mks = Integer.parseInt(sec);

                            ResultSet trs = stmt.executeQuery(t);
                            trs.next();
                            String tec = trs.getString(1);
                            int t_mks = Integer.parseInt(tec);


                            if (marks < s_mks) {
                                if (marks < t_mks) {
                                    marks = 0;
                                } else {
                                    t_mks = 0;
                                }
                            } else {
                                if (s_mks < t_mks) {
                                    s_mks = 0;
                                } else {
                                    t_mks = 0;
                                }
                            }
                            int tot = marks + t_mks + s_mks + 1;


                            int a = tot / 2;


                            String avg = "update details set avg='" + a + "' where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            Statement abc = con.createStatement();
                            abc.executeUpdate(avg);


                            z = "update successful";
                        }
                        else
                            z = "wrong details";
                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "wrong details";
                }

                return z;
            }
        }

        private class Second_IA extends AsyncTask<String,String,String>
        {
            String z = "";
            Boolean isSuccess = false;


            @Override
            protected void onPostExecute(String r)
            {
                Toast.makeText(LecturePage.this, r, Toast.LENGTH_SHORT).show();

            }
            @Override
            protected String doInBackground(String... params)
            {
                String fid =params[0];
                String sub=params[1];
                String mks =params[2];
                String usn=params[3];
                int marks=Integer.parseInt(mks);
                try
                {
                    con = ConnectionPage.connect();        // Connect to database
                    if (con == null)
                    {
                        z = "no net";
                    }


                    else {

                        String check = "select * from faculty f,handle h where f.f_id=h.f_id and f.f_id='" + fid + "' and h.sub_id='" + sub + "'";//"select name from student where usn='"+ usernam +"'  ";
                        Statement m = con.createStatement();
                        ResultSet rs = m.executeQuery(check);


                        if (rs.next()) {


                            String query = "update details set Second_ia='" + marks + "' where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            String s = "select first_ia from details where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            String t = "select third_ia from details where USN='" + usn + "' and SUB_ID='" + sub + "'";


                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(query);
                            ResultSet srs = stmt.executeQuery(s);
                            srs.next();
                            String sec = srs.getString(1);
                            int s_mks = Integer.parseInt(sec);

                            ResultSet trs = stmt.executeQuery(t);
                            trs.next();
                            String tec = trs.getString(1);
                            int t_mks = Integer.parseInt(tec);


                            if (marks < s_mks) {
                                if (marks < t_mks) {
                                    marks = 0;
                                } else {
                                    t_mks = 0;
                                }
                            } else {
                                if (s_mks < t_mks) {
                                    s_mks = 0;
                                } else {
                                    t_mks = 0;
                                }
                            }
                            int tot = marks + t_mks + s_mks + 1;


                            int a = tot / 2;

                            String avg = "update details set avg='" + a + "' where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            Statement abc = con.createStatement();
                            abc.executeUpdate(avg);


                            z = "update successful";
                        } else
                            z = "wrong details";
                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "wrong details";
                }

                return z;
            }
        }

        private class Third_IA extends AsyncTask<String,String,String>
        {
            String z = "";
            Boolean isSuccess = false;


            @Override
            protected void onPostExecute(String r)
            {
                Toast.makeText(LecturePage.this, r, Toast.LENGTH_SHORT).show();

            }
            @Override
            protected String doInBackground(String... params)
            {
                String fid =params[0];
                String sub=params[1];
                String mks =params[2];
                String usn=params[3];
                int marks=Integer.parseInt(mks);
                try
                {
                    con = ConnectionPage.connect();        // Connect to database
                    if (con == null)
                    {
                        z = "no net";
                    }


                    else {

                        String check = "select * from faculty f,handle h where f.f_id=h.f_id and f.f_id='" + fid + "' and h.sub_id='" + sub + "'";//"select name from student where usn='"+ usernam +"'  ";
                        Statement m = con.createStatement();
                        ResultSet rs = m.executeQuery(check);


                        if (rs.next()) {


                            String query = "update details set Third_ia='" + marks + "' where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            String s = "select second_ia from details where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            String t = "select first_ia from details where USN='" + usn + "' and SUB_ID='" + sub + "'";


                            Statement stmt = con.createStatement();
                            stmt.executeUpdate(query);
                            ResultSet srs = stmt.executeQuery(s);
                            srs.next();
                            String sec = srs.getString(1);
                            int s_mks = Integer.parseInt(sec);

                            ResultSet trs = stmt.executeQuery(t);
                            trs.next();
                            String tec = trs.getString(1);
                            int t_mks = Integer.parseInt(tec);


                            if (marks < s_mks) {
                                if (marks < t_mks) {
                                    marks = 0;
                                } else {
                                    t_mks = 0;
                                }
                            } else {
                                if (s_mks < t_mks) {
                                    s_mks = 0;
                                } else {
                                    t_mks = 0;
                                }
                            }
                            int tot = marks + t_mks + s_mks + 1;


                            int a = tot / 2;
                            String avg = "update details set avg='" + a + "' where USN='" + usn + "' and SUB_ID='" + sub + "'";
                            Statement abc = con.createStatement();
                            abc.executeUpdate(avg);


                            z = "update successful";
                        } else
                            z = "wrong details";
                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "wrong details";
                }

                return z;
            }
        }


        private class Attedence extends AsyncTask<String,String,String>
        {
            String z = "";
            Boolean isSuccess = false;


            @Override
            protected void onPostExecute(String r)
            {
                Toast.makeText(LecturePage.this, r, Toast.LENGTH_SHORT).show();

            }
            @Override
            protected String doInBackground(String... params)
            {
                String fid =params[0];
                String sub=params[1];
                String mks =params[2];
                String usn=params[3];
                int marks=Integer.parseInt(mks);


                try {
                    con = ConnectionPage.connect();        // Connect to database
                    if (con == null) {
                        z = "no net";
                    }

                    else {

                        String check = "select * from faculty f,handle h where f.f_id=h.f_id and f.f_id='" + fid + "' and h.sub_id='" + sub + "'";//"select name from student where usn='"+ usernam +"'  ";
                        Statement s = con.createStatement();
                        ResultSet rs = s.executeQuery(check);


                        if (rs.next()) {

                            String abc = "select * from details where  USN='" + usn + "' and SUB_ID='" + sub + "'";//"select name from student where usn='"+ usernam +"'  ";
                            Statement a = con.createStatement();
                            ResultSet x = a.executeQuery(abc);

                            if(x.next())
                            {
                                String query = "update details set Attendace='" + marks + "' where USN='" + usn + "' and SUB_ID='" + sub + "'";
                                Statement stmt = con.createStatement();
                                stmt.executeUpdate(query);

                                z = "update successful";

                            }

                            else{
                                z="wrong details";
                            }
                        } else
                            z = "wrong details";
                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = "wrong detailts";
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
                        String query = "select fname from faculty where f_id='"+ usernam +"'  ";
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


        private Boolean ChechValue(String u, String k, String s){
            if(u.trim().equals("")|| k.trim().equals("")|| s.trim().equals("")) {

                Toast.makeText(LecturePage.this, "all paremeters not entered", Toast.LENGTH_SHORT).show();
                return false;
            }
            try{
               // int marks=Integer.parseInt(k);
                return true;
            }
            catch (Exception e)

            {
                Toast.makeText(LecturePage.this, "enter integer value for mks/attendence", Toast.LENGTH_SHORT).show();
                return false;
            }


        }


      }

