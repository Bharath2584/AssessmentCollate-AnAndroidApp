package com.project.assessmentcollate_anandroidapp;

import android.annotation.SuppressLint;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;


 class ConnectionPage {


    @SuppressLint("NewApi")
     static Connection connect()
    {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");


            connection = DriverManager.getConnection("jdbc:mysql://192.168.43.177:3306/parent_collate","np","np");

        }
        catch (Exception e)

        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }
}
