package slide12;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author buimi
 */
public class DemoSwing extends JFrame {

    static JFrame sw;
    static JButton btnClick;
    static JLabel lblText;

    public static void main(String[] args) {
        sw = new JFrame("SwingDemo");
        sw.setSize(600, 300);
        lblText = new JLabel();
        btnClick = new JButton("Click here");
        btnClick.setBounds(50, 100, 100, 30);
        sw.setLayout(null);
        sw.add(btnClick);
        lblText.setBounds(150, 50, 300, 40);
        sw.add(lblText);
        sw.setLocationRelativeTo(null);
        sw.setDefaultCloseOperation(sw.EXIT_ON_CLOSE);
        btnClick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblText.setText("Xin chao cac ban");
                lblText.setBounds(150, 50, 300, 40);
                sw.add(lblText);
            }
        });
        sw.setVisible(true);
    }
}
