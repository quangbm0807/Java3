/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoketnoi_mavent_sql;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author buimi
 */
public class Bai2 {

    ArrayList<Student> list = new ArrayList<Student>();
    int index = 0;
    String user = "sa";
    String password = "123456";
    String url = "jdbc:sqlserver://localhost:1433;databaseName=quanlysinhvien";
    private JFrame fr;
    private JTextField txtMasv;
    private JTextField txtHoten;
    private JTextField txtEmail;
    private JTextField txtSdt;
    private JTextArea txtDiaChi;
    private JRadioButton rbtnNam;
    private JRadioButton rbtnNu;

    public Bai2() {
        initComponent();
        LoadDataList();
        displayStudent(index);
    }

    public static void main(String[] args) {
        Bai2 main = new Bai2();
    }

    public void initComponent() {
        fr = new JFrame("Quản lý users");
        fr.setSize(500, 650);
        fr.setLocationRelativeTo(null);
        fr.setLayout(null);

        JLabel title = new JLabel("Quản lý users");
        title.setBounds(150, 20, 200, 30);
        title.setFont(new Font(null, Font.BOLD, 30));
        title.setForeground(Color.BLUE);

        JLabel lblMasv = new JLabel("Mã SV");
        lblMasv.setBounds(20, 100, 50, 50);
        txtMasv = new JTextField();
        txtMasv.setBounds(100, 100, 150, 50);

        JLabel lblHoten = new JLabel("Họ tên");
        lblHoten.setBounds(20, 160, 50, 50);
        txtHoten = new JTextField();
        txtHoten.setBounds(100, 160, 150, 50);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(20, 220, 50, 50);
        txtEmail = new JTextField();
        txtEmail.setBounds(100, 220, 150, 50);

        JLabel lblSdt = new JLabel("Số ĐT");
        lblSdt.setBounds(20, 280, 50, 50);
        txtSdt = new JTextField();
        txtSdt.setBounds(100, 280, 150, 50);

        ImageIcon addIcon = new ImageIcon("D:\\HocTap\\JAVA3\\icon\\icons8-add-48.png");
        JButton btnAdd = new JButton("Add", addIcon);
        btnAdd.setBounds(270, 100, 150, 50);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(url, user, password);
                    System.out.println("Ket noi thanh cong!");
                    String maSV = txtMasv.getText();
                    String hoTen = txtHoten.getText();
                    String email = txtEmail.getText();
                    String sdt = txtSdt.getText();
                    String diaChi = txtDiaChi.getText();
                    boolean gioiTinh = rbtnNam.isSelected();

                    String sql = "INSERT INTO Students (masv, hoten, email, sdt, diachi, gioitinh) "
                            + "VALUES ('" + maSV + "', '" + hoTen + "', '"
                            + email + "', '" + sdt + "', '"
                            + diaChi + "', " + (gioiTinh ? 1 : 0) + ")";
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(sql);
                    stm.close();
                    conn.close();
                    JOptionPane.showMessageDialog(fr, "Đã thêm sinh viên!");
                    LoadDataList();
                    index = list.size() - 1;
                    displayStudent(index);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(fr, "Lỗi khi thêm sinh viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ImageIcon deleteIcon = new ImageIcon("D:\\HocTap\\JAVA3\\icon\\icons8-delete-48.png");
        JButton btnDelete = new JButton("Delete", deleteIcon);
        btnDelete.setBounds(270, 160, 150, 50);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.size() > 0 && index >= 0 && index < list.size()) {
                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        Connection conn = DriverManager.getConnection(url, user, password);
                        System.out.println("Ket noi thanh cong!");

                        String maSV = list.get(index).getMaSV();

                        String sql = "DELETE FROM Students WHERE MaSV = '" + maSV + "'";

                        Statement stm = conn.createStatement();
                        stm.executeUpdate(sql);

                        stm.close();
                        conn.close();

                        JOptionPane.showMessageDialog(fr, "Đã xóa sinh viên!");
                        LoadDataList();
                        displayStudent(index - 1);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        // Hiển thị thông báo lỗi
                        JOptionPane.showMessageDialog(fr, "Lỗi khi xóa sinh viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(fr, "Danh sách sinh viên trống hoặc vị trí không hợp lệ!", "Lưu ý", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        ImageIcon updateIcon = new ImageIcon("D:\\HocTap\\JAVA3\\icon\\icons8-fix-64.png");
        JButton btnUpdate = new JButton("Update", updateIcon);
        btnUpdate.setBounds(270, 220, 150, 50);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.size() > 0 && index >= 0 && index < list.size()) {
                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        Connection conn = DriverManager.getConnection(url, user, password);
                        System.out.println("Ket noi thanh cong!");

                        String maSV = txtMasv.getText();
                        String hoTen = txtHoten.getText();
                        String email = txtEmail.getText();
                        String sdt = txtSdt.getText();
                        String diaChi = txtDiaChi.getText();
                        boolean gioiTinh = rbtnNam.isSelected();

                        String sql = "UPDATE Students SET Hoten = '" + hoTen + "', Email = '" + email + "',"
                                + " SDT = '" + sdt + "', Diachi = '" + diaChi + "', Gioitinh = " + (gioiTinh ? 1 : 0)
                                + " WHERE MaSV = '" + maSV + "'";
                        Statement stm = conn.createStatement();
                        stm.executeUpdate(sql);
                        stm.close();
                        conn.close();
                        JOptionPane.showMessageDialog(fr, "Đã cập nhật thông tin sinh viên!");
                        LoadDataList();
                        displayStudent(index);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(fr, "Lỗi khi cập nhật sinh viên: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(fr, "Danh sách sinh viên trống hoặc vị trí không hợp lệ!", "Lưu ý", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        ImageIcon saveIcon = new ImageIcon("D:\\HocTap\\JAVA3\\icon\\icons8-save-48.png");
        JButton btnSave = new JButton("Save", saveIcon);
        btnSave.setBounds(270, 280, 150, 50);

        rbtnNam = new JRadioButton("Nam");
        rbtnNu = new JRadioButton("Nữ");

        JLabel lblGender = new JLabel("Giới tính");
        lblGender.setBounds(20, 340, 100, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbtnNam);
        genderGroup.add(rbtnNu);

        rbtnNam.setBounds(100, 340, 70, 30);
        rbtnNu.setBounds(150, 340, 70, 30);
        JLabel lblDiaChi = new JLabel("Địa chỉ");
        lblDiaChi.setBounds(20, 400, 100, 30);

        txtDiaChi = new JTextArea();
        txtDiaChi.setBounds(100, 400, 320, 100);

        ImageIcon firstIcon = new ImageIcon("D:\\HocTap\\JAVA3\\icon\\first.png");
        JButton btnFirst = new JButton(firstIcon);
        btnFirst.setBounds(130, 520, 50, 50);
        btnFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index = 0;
                displayStudent(index);
            }

        });

        ImageIcon previousIcon = new ImageIcon("D:\\HocTap\\JAVA3\\icon\\previous.png");
        JButton btnPrevious = new JButton(previousIcon);
        btnPrevious.setBounds(190, 520, 50, 50);
        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index > 0) {
                    index--;
                    displayStudent(index);
                }
            }
        });

        ImageIcon nextIcon = new ImageIcon("D:\\HocTap\\JAVA3\\icon\\next.png");
        JButton btnNext = new JButton(nextIcon);
        btnNext.setBounds(250, 520, 50, 50);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < list.size() - 1) {
                    index++;
                    displayStudent(index);
                }
            }
        });

        ImageIcon lastIcon = new ImageIcon("D:\\HocTap\\JAVA3\\icon\\last.png");
        JButton btnLast = new JButton(lastIcon);
        btnLast.setBounds(310, 520, 50, 50);
        btnLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index = list.size() - 1;
                displayStudent(index);
            }
        });

        fr.add(title);
        fr.add(lblMasv);
        fr.add(txtMasv);
        fr.add(lblHoten);
        fr.add(txtHoten);
        fr.add(lblEmail);
        fr.add(txtEmail);
        fr.add(lblSdt);
        fr.add(txtSdt);
        fr.add(btnAdd);
        fr.add(btnDelete);
        fr.add(btnUpdate);
        fr.add(btnSave);
        fr.add(lblGender);
        fr.add(rbtnNam);
        fr.add(rbtnNu);
        fr.add(lblDiaChi);
        fr.add(txtDiaChi);
        fr.add(btnFirst);
        fr.add(btnPrevious);
        fr.add(btnNext);
        fr.add(btnLast);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setVisible(true);

    }

    public void displayStudent(int index) {
        if (index >= 0 && index < list.size()) {
            Student student = list.get(index);

            txtMasv.setText(student.getMaSV());
            txtHoten.setText(student.getHoten());
            txtEmail.setText(student.getEmail());
            txtSdt.setText(student.getSDT());
            txtDiaChi.setText(student.getDiachi());

            if (student.isGioitinh()) {
                rbtnNam.setSelected(true);
                rbtnNu.setSelected(false);
            } else {
                rbtnNam.setSelected(false);
                rbtnNu.setSelected(true);
            }
        } else {
            System.out.println("Index không hợp lệ");
        }
    }

    public void LoadDataList() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Ket noi thanh cong!");
            Statement stm = conn.createStatement();
            String sql = "select * from Students";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String masv = rs.getString(1);
                String hoten = rs.getString(2);
                String email = rs.getString(3);
                String sdt = rs.getString(4);
                String diachi = rs.getString(5);
                boolean gt = rs.getBoolean(6);
                Student sv = new Student(masv, hoten, email, sdt, diachi, gt);
                list.add(sv);
            }
            rs.close();
            stm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
