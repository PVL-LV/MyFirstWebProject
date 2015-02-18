package model;

import java.sql.*;

public class DataBaseConnectionDAO {

    public static boolean validate(String name, String pass) {

        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        //String jdbcDriver = "org.postgresql.Driver";

        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("No Postgres JDBC Driver");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "pvl", "54321");

            pst = conn.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
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
