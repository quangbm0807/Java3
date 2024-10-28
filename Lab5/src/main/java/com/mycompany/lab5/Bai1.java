/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author buimi
 */
public class Bai1 {

    public static void main(String[] args) {
        JFrame fr = new JFrame("Demo Layout");
        fr.setLayout(new GridLayout(4, 1));
        fr.setSize(400, 500);
        fr.setLocationRelativeTo(null);
        JPanel pnl1 = new JPanel();
        pnl1.setSize(380, 100);
        JButton btnRed = new JButton("Red");
        JButton btnGreen = new JButton("Green");
        JButton btnYellow = new JButton("Yellow");
        pnl1.add(btnRed);
        pnl1.add(btnGreen);
        pnl1.add(btnYellow);
        pnl1.setBackground(Color.yellow);
        btnRed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl1.setBackground(Color.RED);
            }
        });

        btnGreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl1.setBackground(Color.GREEN);
            }
        });

        btnYellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnl1.setBackground(Color.YELLOW);
            }
        });

        JPanel pnl2 = new JPanel();
        pnl2.setLayout(new BorderLayout());
        JButton btnNorth = new JButton("North");
        JButton btnSouth = new JButton("South");
        JButton btnEast = new JButton("East");
        JButton btnWest = new JButton("West");
        JButton btnCenter = new JButton("Center");
        pnl2.add(btnNorth, BorderLayout.NORTH);
        pnl2.add(btnSouth, BorderLayout.SOUTH);
        pnl2.add(btnEast, BorderLayout.EAST);
        pnl2.add(btnWest, BorderLayout.WEST);
        pnl2.add(btnCenter, BorderLayout.CENTER);

        JTextField txtHello = new JTextField("Chào các bạn sinh viên FPOLY, JAVA 3");
        txtHello.setFont(new Font("Arial", Font.PLAIN, 18));
        txtHello.setForeground(Color.BLUE);

        JPanel pnl4 = new JPanel();
        pnl4.setLayout(new GridLayout(2, 5));

        for (int i = 1; i <= 10; i++) {
            JButton btn = new JButton("btn" + i);
            pnl4.add(btn);
        }
        fr.add(pnl1);
        fr.add(pnl2);
        fr.add(txtHello);
        fr.add(pnl4);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
