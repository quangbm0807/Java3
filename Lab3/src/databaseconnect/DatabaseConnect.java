/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author buimi
 */
public class DatabaseConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String user = "sa";
        String password = "123456";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV";
        try {
            // nap Driver SQL server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // tao ket noi
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi thanh cong!");
            Statement stm = conn.createStatement();
            String sql = "select * from SINHVIEN";
            ResultSet rs = stm.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                // Retrieve data from the result set
                String studentId = rs.getString("MaSV");
                String studentName = rs.getString("HoTen");
                String gender = rs.getString("GioiTinh");
                String address = rs.getString("DiaChi");
                int score = rs.getInt("Diem");

                // Do something with the retrieved data
                System.out.println("Student ID: " + studentId + ", Student Name: " + studentName
                        + ", Gender: " + gender + ", Address: " + address + ", Score: " + score);
            }

            // Close the result set, statement, and connection
            rs.close();
            stm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
