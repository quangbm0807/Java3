/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slide12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author buimi
 */
public class dialog {

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setSize(400, 400);
        fr.setLayout(new GridLayout(2, 2));
        JButton btnDialog = new JButton("DialogMessage");
        btnDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(fr, "Message");
            }
        });

        JButton btnInput = new JButton("DialogInput");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInputDialog(fr, "Input");
            }
        });

        JButton btnConfirm = new JButton("DialogConfirm");
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(fr, "Confirm","Ban co nguoi yeu chua?" ,JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(fr, "Ban da co nguoi yeu");
                } else {
                    JOptionPane.showMessageDialog(fr, "Ban chua co nguoi yeu");
                }
            }
        });

        JButton btnOption = new JButton("DialogOption");
        btnOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data[] = {"Java","C#","Python","Ruby","Pascal"};
                JOptionPane.showOptionDialog(fr, "Bạn thích ngôn ngữ nào nhất", "Chọn", 0, 0, null, data, null);
            }
        });
        fr.add(btnDialog);
        fr.add(btnInput);
        fr.add(btnConfirm);
        fr.add(btnOption);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
