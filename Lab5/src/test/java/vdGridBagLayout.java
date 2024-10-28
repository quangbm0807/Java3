
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class vdGridBagLayout {

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setSize(300, 200);
        fr.setLocationRelativeTo(null);
        fr.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panel1 = new JPanel();
        panel1.add(new JButton("Bánh"));
        panel1.add(new JButton("Nước"));
        panel1.add(new JButton("Trái cây"));

        gbc.gridy = 0;
        fr.add(panel1, gbc);

        JPanel panel2 = new JPanel();
        JRadioButton rdoChon = new JRadioButton("Chọn");
        rdoChon.setSelected(true);
        JRadioButton rdoKhong = new JRadioButton("Không");
//        ButtonGroup btnGr = new ButtonGroup();
//        btnGr.add(rdoChon);
//        btnGr.add(rdoKhong);
        rdoChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdoKhong.setSelected(!rdoChon.isSelected());
            }
        });

        rdoKhong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rdoChon.setSelected(!rdoKhong.isSelected());
            }
        });
        gbc.gridx = 0;
        panel2.add(rdoChon, gbc);
        gbc.gridx = 2;
        panel2.add(rdoKhong, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        fr.add(panel2, gbc);
        JPanel panel3 = new JPanel();
        panel3.add(new JButton("Hủ tiếu Nam Vang"));
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        fr.add(panel3, gbc);

        fr.setVisible(true);
    }
}
