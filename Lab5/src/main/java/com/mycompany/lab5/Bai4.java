package com.mycompany.lab5;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author buimi
 */


public class Bai4 {

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setSize(500, 700);
        fr.setLayout(null);

        JLabel lblTitle = new JLabel("STUDENT REGISTRATION");
        lblTitle.setBounds(100, 10, 300, 20);

        Font titleFont = new Font("Arial", Font.BOLD, 20);
        lblTitle.setFont(titleFont);
        lblTitle.setForeground(Color.BLUE);

        JPanel details = new JPanel();
        Border borderDetails = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        details.setBorder(BorderFactory.createTitledBorder(borderDetails, "Personal Details"));
        details.setBounds(50, 40, 400, 240);
        details.setLayout(null);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(30, 20, 80, 30);
        JTextField txtFirstName = new JTextField();
        txtFirstName.setBounds(130, 20, 200, 30);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(30, 60, 80, 30);
        JTextField txtLastName = new JTextField();
        txtLastName.setBounds(130, 60, 200, 30);

        JLabel lblContact = new JLabel("Contact:");
        lblContact.setBounds(30, 100, 80, 30);
        JTextField txtContact = new JTextField();
        txtContact.setBounds(130, 100, 200, 30);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, 140, 80, 30);
        JTextArea txtAddress = new JTextArea();
        txtAddress.setBounds(130, 140, 200, 60);

        details.add(lblFirstName);
        details.add(txtFirstName);
        details.add(lblLastName);
        details.add(txtLastName);
        details.add(lblContact);
        details.add(txtContact);
        details.add(lblAddress);
        details.add(txtAddress);

        JPanel academicDetails = new JPanel();
        Border borderAcademic = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        academicDetails.setBorder(BorderFactory.createTitledBorder(borderAcademic, "Academic Details"));
        academicDetails.setBounds(50, 300, 400, 150);
        academicDetails.setLayout(null);

        JLabel lblQualification = new JLabel("Highest Qualification:");
        lblQualification.setBounds(30, 20, 150, 30);
        JTextField txtQualification = new JTextField();
        txtQualification.setBounds(180, 20, 150, 30);

        JLabel lblSpecification = new JLabel("Specification:");
        lblSpecification.setBounds(30, 60, 150, 30);
        JTextField txtSpecification = new JTextField();
        txtSpecification.setBounds(180, 60, 150, 30);

        JLabel lblEnrollFor = new JLabel("Enroll For:");
        lblEnrollFor.setBounds(30, 100, 150, 30);
        JTextField txtEnrollFor = new JTextField();
        txtEnrollFor.setBounds(180, 100, 150, 30);

        academicDetails.add(lblQualification);
        academicDetails.add(txtQualification);
        academicDetails.add(lblSpecification);
        academicDetails.add(txtSpecification);
        academicDetails.add(lblEnrollFor);
        academicDetails.add(txtEnrollFor);

        JPanel extracurricularDetails = new JPanel();
        extracurricularDetails.setLayout(null);
        extracurricularDetails.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Extracurricular Details"));
        extracurricularDetails.setBounds(50, 470, 400, 100);

        JLabel lblHobbies = new JLabel("Hobbies:");
        lblHobbies.setBounds(30, 20, 80, 30);
        JTextField txtHobbies = new JTextField();
        txtHobbies.setBounds(130, 20, 200, 30);

        JLabel lblSport = new JLabel("Sport:");
        lblSport.setBounds(30, 60, 80, 30);
        JTextField txtSport = new JTextField();
        txtSport.setBounds(130, 60, 200, 30);

        extracurricularDetails.add(lblHobbies);
        extracurricularDetails.add(txtHobbies);
        extracurricularDetails.add(lblSport);
        extracurricularDetails.add(txtSport);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(50, 600, 400, 50);
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(30, 10, 100, 30);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtFirstName.getText().trim().isEmpty()
                        || txtLastName.getText().trim().isEmpty()
                        || txtContact.getText().trim().isEmpty()
                        || txtQualification.getText().trim().isEmpty()
                        || txtSpecification.getText().trim().isEmpty()
                        || txtEnrollFor.getText().trim().isEmpty()
                        || txtHobbies.getText().trim().isEmpty()
                        || txtSport.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(fr, "Vui lòng nhập đầy đủ thông tin.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    StringBuilder information = new StringBuilder();
                    information.append("First Name: ").append(txtFirstName.getText()).append("\n")
                            .append("Last Name: ").append(txtLastName.getText()).append("\n")
                            .append("Contact: ").append(txtContact.getText()).append("\n")
                            .append("Address: ").append(txtAddress.getText()).append("\n")
                            .append("Highest Qualification: ").append(txtQualification.getText()).append("\n")
                            .append("Specification: ").append(txtSpecification.getText()).append("\n")
                            .append("Enroll For: ").append(txtEnrollFor.getText()).append("\n")
                            .append("Hobbies: ").append(txtHobbies.getText()).append("\n")
                            .append("Sport: ").append(txtSport.getText()).append("\n");

                    JOptionPane.showMessageDialog(fr, information.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(150, 10, 100, 30);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFirstName.setText("");
                txtLastName.setText("");
                txtContact.setText("");
                txtAddress.setText("");
                txtQualification.setText("");
                txtSpecification.setText("");
                txtEnrollFor.setText("");
                txtHobbies.setText("");
                txtSport.setText("");
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(270, 10, 100, 30);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(btnSave);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnExit);
        buttonPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

        fr.add(lblTitle);
        fr.add(details);
        fr.add(academicDetails);
        fr.add(extracurricularDetails);
        fr.add(buttonPanel);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
