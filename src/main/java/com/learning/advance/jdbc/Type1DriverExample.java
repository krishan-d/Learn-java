package com.learning.advance.jdbc;

import java.sql.*;

public class Type1DriverExample {
    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            Connection con = DriverManager.getConnection("jdbc:odbc:Test", "", "");
            Statement s = con.createStatement();

            String query = "SELECT * FROM TABLE_NAME";
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt(1) + " name: " + rs.getString(2));
            }

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
