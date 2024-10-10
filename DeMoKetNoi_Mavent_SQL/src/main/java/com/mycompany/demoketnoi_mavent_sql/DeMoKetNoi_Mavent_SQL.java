package com.mycompany.demoketnoi_mavent_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeMoKetNoi_Mavent_SQL {

    public static void main(String[] args) {
        //khai bao duong dan den may chu co so du lieu, tai khoan, mat khau, ten database
        String user = "sa";
        String password = "123456";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QLSV";
        try {
            // nap Driver SQL server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // tao ket noi
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Ket noi thanh cong!");
                Statement stm = conn.createStatement();
                String sql = "select * from SINHVIEN";
                ResultSet rs = stm.executeQuery(sql);

                // Process the result set
                while (rs.next()) {
                    // Retrieve data from the result set
                    String masv = rs.getString("MaSV");
                    String hoten = rs.getString("HoTen");
                    String gioitinh = rs.getString("GioiTinh");
                    String diachi = rs.getString("DiaChi");
                    int score = rs.getInt("Diem");

                    // Do something with the retrieved data
                    System.out.println("MaSV: " + masv + ", HoTen: " + hoten
                            + ", GioiTinh: " + gioitinh + ", DiaChi: " + diachi + ", Diem: " + score);
                }

                // Close the result set, statement, and connection
                rs.close();
                stm.close();
                conn.close();
            } else {
                System.out.println("Ket noi that bai!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
