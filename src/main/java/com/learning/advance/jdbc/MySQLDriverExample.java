package com.learning.advance.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MySQLDriverExample {
    private static final String TABLE_NAME = "STUDENT";
    static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";

    public static void main(String[] args) throws IOException, SQLException {
        Properties p = new Properties();
        p.load(new FileInputStream("src/main/resources/db.properties"));
        String userName = p.getProperty("mysql_username");
        String password = p.getProperty("mysql_password");

        Connection connection = null;
        Statement s = null;

        try {
            Class.forName(DB_DRIVER);

            /*
             * "jdbc[API]:mysql[database]://localhost[server name]:3306[port]/test[database name]"
             * */
            String db = "PYTHON_DB";
            connection = DriverManager.getConnection(DB_URL + db, userName, password);

            s = connection.createStatement();

            String selectQuery = "SELECT * FROM " + TABLE_NAME;
            try (ResultSet rs = s.executeQuery(selectQuery)) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            String insertQuery = "INSERT INTO " + TABLE_NAME + " VALUES(?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                preparedStatement.setInt(6, 10004);
                preparedStatement.setString(1, "Eve");

                int i = preparedStatement.executeUpdate();
                System.out.println(i + " records inserted!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) connection.close();
        }
    }
}
