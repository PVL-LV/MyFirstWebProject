package model;


import java.sql.*;

public class RegistrationDAO {

    public static boolean registrationInDB(String name, String email, String psw) {

        String yourName = name;
        String yourEmail = email;
        String yourPsw = psw;

        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        //ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("No Postgres JDBC Driver");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "pvl", "54321");


            pst = conn.prepareStatement("INSERT INTO users (email, username, password) VALUE (?, ?, ?)");
            pst.setString(1, yourEmail);
            pst.setString(2, yourName);
            pst.setString(3, yourPsw);

            ResultSet rs = pst.executeQuery();
            status = rs.next();

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
