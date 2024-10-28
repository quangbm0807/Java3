
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author buimi
 */
public class vdGridBagLayout1 {

    public static void main(String[] args) {
        JFrame fr = new JFrame("Demo GridBag");
        fr.setSize(300, 200);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        GridBagLayout gbl = new GridBagLayout();
        JPanel pnl1 = new JPanel();
        pnl1.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = gbc.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnl1.add(new JButton("Bánh"),gbc);
//        pnl1.add(new JButton("Nước"),gbc);
//        pnl1.add(new JButton("Cơm"),gbc);

        fr.add(pnl1,gbc);

        JPanel secondRowPanel = new JPanel();
        JRadioButton chooseRadioButton = new JRadioButton("Chọn");
        JRadioButton notChooseRadioButton = new JRadioButton("Không");

        secondRowPanel.add(chooseRadioButton);
        secondRowPanel.add(notChooseRadioButton);

        JPanel thirdRowPanel = new JPanel();
        thirdRowPanel.add(new JButton("Hủ tiếu Nam Vang"));

        fr.setVisible(true);
    }
}
