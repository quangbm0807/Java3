package slide12;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author buimi
 */
public class DemoAWT extends Frame implements ActionListener {

    Button btnYellow, btnGray, btnExit;

    public DemoAWT(String text) {
        setTitle(text);
        setLayout(new FlowLayout());
        btnYellow = new Button("Yellow");
        add(btnYellow);
        btnGray = new Button("Gray");
        add(btnGray);
        btnExit = new Button("Exit");
        add(btnExit);
        btnYellow.addActionListener((ActionListener) this);
        btnGray.addActionListener((ActionListener) this);
        btnExit.addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Yellow")) {
            this.setBackground(Color.YELLOW);
        }
        if (cmd.equals("Gray")) {
            this.setBackground(Color.GRAY);
        }
        if (cmd.equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        DemoAWT fr = new DemoAWT("DemoAWT");
        fr.setSize(400, 250);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
        fr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
