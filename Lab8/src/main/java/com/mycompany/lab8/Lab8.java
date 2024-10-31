/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab8;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class Lab8 {

    private static JTextField txtUsername, txtTo, txtSubject, txtAttachmentPath;
    private static JTextArea txtMessage;
    private static JFrame fr ;

    public static void main(String[] args) {
        fr = new JFrame();
        fr.setSize(450, 600);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setLayout(null);
        JLabel lblTitle = new JLabel("Send Mail");
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitle.setBounds(175, 20, 150, 50);

        JLabel lblSend = new JLabel("Send");
        lblSend.setFont(new Font("Arial", Font.BOLD, 12));
        lblSend.setBounds(20, 80, 50, 20);
        JPanel pnlSend = new JPanel();
        EtchedBorder etchedBorder = new EtchedBorder(EtchedBorder.LOWERED, null, null);
        pnlSend.setBorder(etchedBorder);
        pnlSend.setBounds(20, 100, 400, 100);
        pnlSend.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 10, 70, 30);
        JLabel lblPassWord = new JLabel("Password");
        lblPassWord.setBounds(10, 60, 70, 30);

        txtUsername = new JTextField("buiminhquang2002@gmail.com");
        txtUsername.setBounds(100, 10, 250, 30);

        JPasswordField txtPassword = new JPasswordField("dqzyrqtqqdwkjchx");
        txtPassword.setBounds(100, 60, 250, 30);

        pnlSend.add(lblUsername);
        pnlSend.add(lblPassWord);
        pnlSend.add(txtUsername);
        pnlSend.add(txtPassword);

        JLabel lblReceive = new JLabel("Receive");
        lblReceive.setBounds(20, 230, 50, 20);
        fr.add(lblReceive);
        JPanel pnlReceive = new JPanel();
        pnlReceive.setBounds(20, 250, 400, 280);
        pnlReceive.setLayout(null);
        pnlReceive.setBorder(etchedBorder);
        JLabel lblTo = new JLabel("To:");
        lblTo.setBounds(10, 10, 70, 30);
        JLabel lblSubject = new JLabel("Subject:");
        lblSubject.setBounds(10, 60, 70, 30);
        JLabel lblMessage = new JLabel("Message:");
        lblMessage.setBounds(10, 110, 70, 30);
        txtTo = new JTextField();
        txtTo.setBounds(100, 10, 250, 30);
        txtSubject = new JTextField();
        txtSubject.setBounds(100, 60, 250, 30);
        txtMessage = new JTextArea();
        txtMessage.setBounds(100, 110, 250, 70);
        JButton btnAttach = new JButton("Select File");
        btnAttach.setBounds(230, 230, 100, 30);

        txtAttachmentPath = new JTextField();
        txtAttachmentPath.setBounds(20, 190, 330, 30);
        txtAttachmentPath.setEditable(false);

        JButton btnSend = new JButton("Send");
        btnSend.setBounds(70, 230, 80, 30);

        btnAttach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String selectedFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    txtAttachmentPath.setText(selectedFilePath);
                }
            }
        });

        pnlReceive.add(lblTo);
        pnlReceive.add(lblSubject);
        pnlReceive.add(lblMessage);
        pnlReceive.add(txtTo);
        pnlReceive.add(txtSubject);
        pnlReceive.add(txtMessage);
        pnlReceive.add(btnAttach); // Attach File button
        pnlReceive.add(txtAttachmentPath); // Text field for file path
        pnlReceive.add(btnSend); // Send button

        fr.add(pnlSend);
        fr.add(pnlReceive);
        fr.add(lblSend);
        fr.add(lblTitle);
        fr.setVisible(true);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] toAddresses = txtTo.getText().split(","); // Split multiple email addresses by comma
                String attachmentPath = txtAttachmentPath.getText().trim();
                if (!attachmentPath.isEmpty()) {
                    sendEmail(toAddresses, txtSubject.getText(), txtMessage.getText(),
                            txtUsername.getText(), new String(txtPassword.getPassword()), attachmentPath);
                } else {
                    System.out.println("Please select a file to attach.");
                }
            }
        });
    }

    private static void sendEmail(String[] toAddresses, String subject, String message, String username, String password, String filePath) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(username));

            InternetAddress[] to = new InternetAddress[toAddresses.length];
            for (int i = 0; i < toAddresses.length; i++) {
                to[i] = new InternetAddress(toAddresses[i]);
            }
            emailMessage.setRecipients(Message.RecipientType.TO, to);

            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            if (filePath != null && !filePath.isEmpty()) {
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(message);

                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(new File(filePath));

                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                multipart.addBodyPart(attachmentPart);

                emailMessage.setContent(multipart);
            }

            Transport.send(emailMessage);

            JOptionPane.showMessageDialog(fr, "Gửi Email thành công!");

        } catch (MessagingException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
