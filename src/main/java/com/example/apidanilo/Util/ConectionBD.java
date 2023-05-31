package com.example.apidanilo.Util;
import java.sql.*;

import static java.lang.Class.forName;


public class ConectionBD {

   public static final String URL = "jdbc:mysql://localhost:3306/torres_uno";
   public static final String USER = "root";
   public static final String PASSWORD = "pablo";

   public static  Connection connectionMYSQL() throws SQLException{
       return DriverManager.getConnection(URL,USER, PASSWORD);
   }

   public static void close(Connection connection) throws SQLException {
       connection.close();
   }

    public static void close(PreparedStatement preparedStatement) throws SQLException{
        preparedStatement.close();
    }

    public static void close(Statement statement) throws SQLException{
        connectionMYSQL().close();
    }

    public static void close(ResultSet resultSet) throws SQLException{
        resultSet.close();
    }


//Patron singleton




}
