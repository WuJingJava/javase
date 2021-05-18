package com.javastudy.designpattern.singleton;

import java.sql.*;
import java.text.DateFormat;
import java.util.Calendar;

public class SingletonHungerStatic2 {

    Calendar calendar = Calendar.getInstance();
    DateFormat dateFormat = DateFormat.getDateInstance();



    Connection conn = DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=DB;user=sa;password=");
    Statement statement=conn.createStatement();
    ResultSet rs=statement.executeQuery("select * from UserInfo");

    public SingletonHungerStatic2() throws SQLException {
    }
}