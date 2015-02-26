package model;


import java.sql.*;
import java.util.ArrayList;

public class RegistrationDAO {

    public static boolean registrationInDB(String name, String email, String psw) {

        String yourName = name;
        String yourEmail = email;
        String yourPsw = psw;

        int[] res = null;
        boolean status = false;

        Connection conn = null;
        PreparedStatement pst = null;


        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("No Postgres JDBC Driver");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            String sql = "insert into users (email, username, password) values (?, ?, ?)";
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "pvl", "54321");
            pst = conn.prepareStatement(sql);
            pst.setString(1, yourEmail);
            pst.setString(2, yourName);
            pst.setString(3, yourPsw);
            pst.addBatch();
            res = pst.executeBatch();
            if (res != null) {
                status = true;
            }


        } catch (SQLException e) {
            System.out.println("Connection faild!");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}
