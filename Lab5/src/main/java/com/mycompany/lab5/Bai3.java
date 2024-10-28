package com.mycompany.lab5;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author buimi
 */


public class Bai3 {

    static JFrame fr = new JFrame();
    static JSlider SdSize = new JSlider(0, 50, 25);
    static JLabel LbGiaTriHienTai = new JLabel("Giá trị hiện tại");
    static JTextField txtGiaTri = new JTextField();
    static JLabel lbFont = new JLabel("Font Size");
    static JButton btnSetValue = new JButton("Set value");

    static void Slider() {
        SdSize.setSize(585, 130);

        SdSize.setPaintTicks(true);
        SdSize.setMinorTickSpacing(10);

        SdSize.setPaintTicks(true);
        SdSize.setMajorTickSpacing(5);
        SdSize.setPaintLabels(true);

        LbGiaTriHienTai.setBounds(20, 170, 100, 30);
        LbGiaTriHienTai.setForeground(Color.BLUE);

        txtGiaTri.setBounds(120, 170, 50, 30);

        btnSetValue.setBounds(180, 170,100, 40);
        lbFont.setBounds(290,170,500,40);
        lbFont.setForeground(Color.BLUE);

        fr.add(btnSetValue);
        fr.add(lbFont);
        fr.add(txtGiaTri);
        fr.add(LbGiaTriHienTai);
        fr.add(SdSize);
    }

    static void Frame() {
        fr.setSize(600, 300);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setLayout(null);
        fr.setVisible(true);

    }

    public static void main(String[] args) {
        Slider();
        ACLN();
        Frame();
    }

    static void ACLN() {
        SdSize.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                txtGiaTri.setText(String.valueOf(SdSize.getValue()));
                lbFont.setFont(new Font("Tahoma",1,SdSize.getValue()));
            }
        });
        fr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                txtGiaTri.setText(String.valueOf(SdSize.getValue()));
                lbFont.setFont(new Font("Tahoma",1,SdSize.getValue()));
            }
        });
        btnSetValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SdSize.setValue(Integer.parseInt(txtGiaTri.getText()));
            }
        });
        
    }
}
