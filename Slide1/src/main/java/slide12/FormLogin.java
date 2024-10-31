/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide12;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormLogin {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Form Login");
        fr.setLayout(new FlowLayout());
        fr.setSize(300, 300);

        JPanel comboBox = new JPanel();
        String data[] = {"Bun bo", "Com ga", "Pho bo"};
        JComboBox<String> food = new JComboBox<>(data);
        comboBox.add(food);
        
        JLabel thongtin = new JLabel("");
        
        JRadioButton a = new JRadioButton("Com");
        JRadioButton b = new JRadioButton("Pho");
        ButtonGroup ab = new ButtonGroup();
        ab.add(b);
        ab.add(a);
        JTextField monan = new JTextField(20);
        food.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFood = (String) food.getSelectedItem();
                monan.setText(selectedFood);
            }
        });
        fr.add(comboBox);
        fr.add(a);
        fr.add(b);
        fr.add(monan);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
