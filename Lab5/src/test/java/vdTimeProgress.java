
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author buimi
 */
public class vdTimeProgress {

    static JTextField txtClock;
    static JProgressBar pror;
    static javax.swing.Timer t;

    public static void KhoiTao() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
                txtClock.setText(time.format(new Date()));
                int value = pror.getValue() + 1;
                pror.setValue(value <= 1000 ? value : 0);
            }
        };
        t = new Timer(1000, al);
    }
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setSize(400, 200);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        txtClock = new JTextField();
        txtClock.setBounds(100, 30, 200, 30);
        JButton btnStart = new JButton("Start");
        fr.add(btnStart);
        JButton btnStop = new JButton("Stop");
        fr.add(btnStop);
        btnStart.setBounds(100, 70, 70, 25);
        btnStop.setBounds(230, 70, 70, 25);
        pror = new JProgressBar();
        pror.setBounds(100, 110, 200, 30);
        fr.add(pror);
        fr.add(txtClock);
        fr.setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KhoiTao();
                t.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }
        });
    }

}
