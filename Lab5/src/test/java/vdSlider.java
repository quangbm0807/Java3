
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class vdSlider extends JFrame implements ActionListener {

    JButton btn1, btn2, btn3;
    Container cont;
    Hashtable<Integer, JLabel> data;
    JSlider sldThang, sldNgay, sldNam;
    Calendar ngay;
    JTextField txtNgay;

    public vdSlider() {
        cont = getContentPane();
        cont.setLayout(null);

        data = new Hashtable<>();
        String[] sMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < 12; i++) {
            data.put(i, new JLabel(sMonths[i]));
        }

        sldThang = new JSlider(JSlider.HORIZONTAL, 0, 11, 0);
        sldThang.setBounds(20, 20, 500, 50);
        sldThang.setLabelTable(data);
        sldThang.setPaintLabels(true);
        sldThang.setMajorTickSpacing(1);
        sldThang.setPaintTicks(true);

        sldNgay = new JSlider(JSlider.HORIZONTAL, 1, 31, 1);
        sldNgay.setBounds(20, 80, 500, 50);
        sldNgay.setMajorTickSpacing(7);
        sldNgay.setPaintTicks(true);
        sldNgay.setPaintLabels(true);

        sldNam = new JSlider(JSlider.HORIZONTAL, 2000, 2100, 2023);
        sldNam.setBounds(20, 140, 500, 50);
        sldNam.setMajorTickSpacing(10);
        sldNam.setPaintTicks(true);
        sldNam.setPaintLabels(true);

        txtNgay = new JTextField();
        txtNgay.setBounds(20, 200, 500, 30);
        txtNgay.setEditable(false);

        sldThang.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                displayDate();
            }
        });

        sldNgay.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                displayDate();
            }
        });

        sldNam.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                displayDate();
            }
        });

        cont.add(sldThang);
        cont.add(sldNgay);
        cont.add(sldNam);
        cont.add(txtNgay);

        setSize(550, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Demo Date Slider");
        setVisible(true);
    }

    public void displayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd - MMM - yyyy");
        int dd = sldNgay.getValue();
        int mm = sldThang.getValue();
        int yy = sldNam.getValue();
        Calendar calendar = Calendar.getInstance();
        calendar.set(yy, mm, dd);
        Date d = calendar.getTime();
        txtNgay.setText(sdf.format(d));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Your action handling code here (if needed)
    }

    public static void main(String[] args) {
        new vdSlider();
    }
}
