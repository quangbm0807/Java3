/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5;

/**
 *
 * @author buimi
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class bai2 {

    static JFrame fr = new JFrame("Quản lý Nhân Viên");

    static JPanel pn1 = new JPanel();
    static JPanel pn2 = new JPanel();
    static JPanel pn3 = new JPanel();
    static JPanel pn4 = new JPanel();

    static JLabel lbHo = new JLabel("Ho:");
    static JLabel lbBiDanh = new JLabel("Bí danh:");
    static JLabel lbTen = new JLabel("Tên:");
    static JLabel lbMatMa = new JLabel("Mặt mã:");

    static JTextField txtHo = new JTextField();
    static JTextField txtBiDanh = new JTextField();
    static JTextField txtTen = new JTextField();
    static JPasswordField txtMatMa = new JPasswordField();

    static JRadioButton rdoNam = new JRadioButton("Nam");
    static JRadioButton rdoNu = new JRadioButton("Nữ");
    static JRadioButton rdoKhongXacDinh = new JRadioButton("Không xác định");
    static ButtonGroup gr = new ButtonGroup();

    static JLabel lbQueQuan = new JLabel("Quê quán");
    static JLabel lbSoThich = new JLabel("Sở thích");
    static JLabel lbGhiChu = new JLabel("Ghi chú");

    static JComboBox<String> cbQueQuan = new JComboBox<>();

    static JButton btnOK = new JButton("OK");
    static JButton btnReset = new JButton("Reset");
    static JButton btnExit = new JButton("Exit");

    static JRadioButton rdoCoding = new JRadioButton("Nghe nhạc");
    static JRadioButton rdoCodingToTie = new JRadioButton("Đọc sách");
    static JRadioButton rdoCodingToDead = new JRadioButton("Chơi game");

    static JTextArea txtGhiChu = new JTextArea();

    static void Panel() {
        pn1.add(lbHo);
        pn1.add(lbTen);
        pn1.add(lbBiDanh);
        pn1.add(lbMatMa);
        lbHo.setBounds(70, 30, 40, 40);
        lbTen.setBounds(360, 30, 40, 40);
        lbBiDanh.setBounds(70, 60, 60, 40);
        lbMatMa.setBounds(360, 60, 60, 40);
        //add textField
        pn1.add(txtHo);
        pn1.add(txtBiDanh);
        pn1.add(txtTen);
        pn1.add(txtMatMa);
        //set textField
        txtHo.setBounds(130, 40, 150, 20);
        txtBiDanh.setBounds(130, 70, 150, 20);
        txtTen.setBounds(410, 40, 150, 20);
        txtMatMa.setBounds(410, 70, 150, 20);

        pn1.setBorder(new TitledBorder(new LineBorder(Color.BLACK),
                "Họ Tên", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 18), Color.red));
        pn1.setBackground(new Color(204, 255, 204));
        pn1.setLayout(null);
        pn1.setPreferredSize(new Dimension(0, 100));

        pn2.setBorder(new TitledBorder(new LineBorder(Color.BLACK),
                "Giới tính", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 18), Color.BLUE));
        pn2.setLayout(new FlowLayout(FlowLayout.LEFT));

        pn2.setBackground(new Color(255, 255, 153));

        gr.add(rdoNu);
        gr.add(rdoNam);
        gr.add(rdoKhongXacDinh);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
        radioPanel.add(rdoNam);
        radioPanel.add(rdoNu);
        radioPanel.add(rdoKhongXacDinh);

        pn2.add(radioPanel);
        pn2.setPreferredSize(new Dimension(0, 50));
        pn3.setBorder(new TitledBorder(new LineBorder(Color.BLACK),
                "Thông tin khác", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION,
                new Font("Arial", Font.BOLD, 18), Color.black));
        pn3.setBackground(new Color(255, 204, 204));
        // tao ra panel que quan 
        JPanel pnQueQuan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnQueQuan.add(lbQueQuan);
        pnQueQuan.add(Box.createHorizontalStrut(10));
        pnQueQuan.add(cbQueQuan);
        cbQueQuan.setPreferredSize(new Dimension(200, 30));
        String[] queQuanData = {"Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Nha Trang", "Huế"};
        cbQueQuan.setModel(new DefaultComboBoxModel(queQuanData));
        pnQueQuan.setBackground(new Color(255, 204, 204));

        // tao ra Pnel so thich
        JPanel pnSoThich = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnSoThich.add(lbSoThich);
        pnSoThich.add(Box.createHorizontalStrut(10));
        pnSoThich.add(rdoCoding);
        pnSoThich.add(rdoCodingToTie);
        pnSoThich.add(rdoCodingToDead);
        rdoCoding.setBackground(new Color(255, 204, 204));
        rdoCodingToTie.setBackground(new Color(255, 204, 204));
        rdoCodingToDead.setBackground(new Color(255, 204, 204));
        pnSoThich.setBackground(new Color(255, 204, 204));

        //tao panel cho ghi chu
        JPanel pnGhiChu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnGhiChu.add(lbGhiChu);
        pnGhiChu.add(Box.createHorizontalStrut(30));
        pnGhiChu.add(txtGhiChu);
        txtGhiChu.setPreferredSize(new Dimension(400, 100));
        pnGhiChu.setBackground(new Color(255, 204, 204));

        pn3.setLayout(new BoxLayout(pn3, BoxLayout.Y_AXIS));
        pn3.add(pnQueQuan);
        pn3.add(pnSoThich);
        pn3.add(pnGhiChu);
        pn3.setPreferredSize(new Dimension(500, 200));

        pn4.setLayout(new FlowLayout(FlowLayout.CENTER));
        pn4.add(btnOK);
        pn4.add(btnReset);
        pn4.add(btnExit);
    }

    static void Frame() {
        fr.setSize(650, 560);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setLayout(new BoxLayout(fr.getContentPane(), BoxLayout.Y_AXIS));
        fr.setVisible(true);

        fr.add(pn1);
        fr.add(pn2);
        fr.add(pn3);
        fr.add(pn4);
    }

    public static void main(String[] args) {
        Panel();
        ACLButton();
        Frame();
    }

    static void ACLButton() {
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBiDanh.setText("");
                txtHo.setText("");
                txtTen.setText("");
                txtMatMa.setText("");
                txtGhiChu.setText("");
                cbQueQuan.setSelectedIndex(0);
                gr.clearSelection();
                rdoCoding.setSelected(false);
                rdoCodingToTie.setSelected(false);
                rdoCodingToDead.setSelected(false);
            }
        });
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = "";
                str += "Họ tên: " + txtHo.getText();
                str += " " + txtTen.getText() + "\n";
                str += "Bí Danh: " + txtBiDanh.getText() + "\n";
                str += "Mật mã: " + new String(txtMatMa.getPassword())+ "\n";
                if (rdoNam.isSelected()) {
                    str += "Giới tính: Nam\n";
                }
                if (rdoNu.isSelected()) {
                    str += "Giới tính: Nữ\n";
                }
                if (rdoKhongXacDinh.isSelected()) {
                    str += "Giới tính: Không xác định\n";
                }
                str += "Quê quán: " + cbQueQuan.getSelectedItem() + "\n";
                if (rdoCoding.isSelected()) {
                    str += "Sở thích: Coding\n";
                }
                if (rdoCodingToTie.isSelected()) {
                    str += "Sở thích: Coding to tie\n";
                }
                if (rdoCodingToDead.isSelected()) {
                    str += "Sở thích: Coding to dead"
                            + "\n";
                }
                str += "Ghi chú: "+txtGhiChu.getText();
                JOptionPane.showMessageDialog(fr, str);
            }
        });
    }
}

