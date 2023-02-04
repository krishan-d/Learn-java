package com.learning.advance.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class OracleDriverExample {
    public static void main(String[] args) throws IOException {

        Properties p = new Properties();
        p.load(new FileInputStream("src/main/resources/db.properties"));
        p.list(System.out);

        String userName = p.getProperty("oracle_username");
        String password = p.getProperty("oracle_password");

        try {
            //Load Driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            /*
            * Syntax:
            * jdbc:oracle:thin:@//[HOST][:PORT]:SID
            * OR
            * jdbc:oracle:thin:@//[HOST][:PORT]/SERVICE
            *
            * jdbc[API]:oracle[Database]:thin[Driver-Type]:@localhost[Server Name]:1521[Port Number]:XE[Oracle Service Name]
            * */
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", userName, password);
            //Creating Statement
            Statement s = con.createStatement();

            //Executing Statement
            String selectQuery = "SELECT * FROM TABLE_NAME";
            ResultSet rs = s.executeQuery(selectQuery);

            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }

            String insertQuery = "INSERT INTO TABLE_NAME VALUES(?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
            preparedStatement.setInt(1, 10004);
            preparedStatement.setString(2, "Eve");

            preparedStatement.executeUpdate();

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
