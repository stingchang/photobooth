package com.picoria.photobooth.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;


public class TestJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://spring-course-instance.c5udk0ltfwse.us-west-1.rds.amazonaws.com:3306/spring";
        String user = "dev";
        String password = "developer";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Connecting to " + url);
            Connection con = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Connection succesful");

            System.out.println("\nView student table");
            String query = "SELECT * FROM student";
            // create the java statement
            Statement st = (Statement) con.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                // print the results
                System.out.format("%s, %s, %s\n", id, firstName, lastName);
            }
            System.out.println("\nClose database connection");
            con.close();
        } catch (Exception e) {
            System.out.println("Connection failed + " + e.getMessage());
        }

    }

}
