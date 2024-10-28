
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author buimi
 */
public class vdCardLayout extends JFrame implements ActionListener {

    JButton btn1, btn2, btn3;
    CardLayout card;
    Container cont;

    public vdCardLayout() {
        cont = getContentPane();
        card = new CardLayout(90, 60);
        cont.setLayout(card);
        btn1 = new JButton("Một");
        btn2 = new JButton("Hai");
        btn3 = new JButton("Ba");
        cont.add(btn1);
        cont.add(btn2);
        cont.add(btn3);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        card.next(cont);
    }

    public static void main(String[] args) {
        vdCardLayout fr = new vdCardLayout();
        fr.setSize(300, 200);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setTitle("Demo CardLayout");
        fr.setVisible(true);
    }
}
