/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab5;

/**
 *
 * @author buimi
 */
import java.awt.AWTEventMulticaster;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class Bai1 {

    static JFrame fr = new JFrame("Menu Java3");
    static JMenuBar menuBar = new JMenuBar();
    // Tạo menu
    static JMenu fileMenu = new JMenu("File");
    static JPanel pn1 = new JPanel();

    // Tạo mục menu trong menu "File"
    static JMenuItem newItem = new JMenuItem("New");
    static JMenuItem openItem = new JMenuItem("Open");
    static JMenuItem saveItem = new JMenuItem("Save");

    static JMenu ColorMenu = new JMenu("Color");

    // Tạo mục menu trong menu "File"
    static JRadioButton RedItem = new JRadioButton("Red");
    static JRadioButton GreenItem = new JRadioButton("Green");
    static JRadioButton BlueItem = new JRadioButton("Blue");
    static JCheckBoxMenuItem TextColor = new JCheckBoxMenuItem("Text Color");

    static ButtonGroup btgr = new ButtonGroup();

    static JMenu SystemMenu = new JMenu("System");
    static JMenuItem AboutItem = new JMenuItem("About us");
    static JMenuItem ExitItem = new JMenuItem("Exit");

    static JEditorPane Jedit = new JEditorPane();
    static JTextField txtcmt = new JTextField(50);

    static void Menu() {
        //menu file
        fileMenu.add(newItem);
        ImageIcon NewItemicon = new ImageIcon("D:\\\\HocTap\\\\JAVA3\\\\icon\\\\Add.png");
        newItem.setIcon(NewItemicon);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        fileMenu.add(openItem);
        ImageIcon OpenItemIcon = new ImageIcon("D:\\\\HocTap\\\\JAVA3\\\\icon\\\\Open file.png");
        openItem.setIcon(OpenItemIcon);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        fileMenu.add(saveItem);
        ImageIcon SaveItemIcon = new ImageIcon("D:\\\\HocTap\\\\JAVA3\\\\icon\\\\Save.png");
        saveItem.setIcon(SaveItemIcon);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuBar.add(fileMenu);

        // menu color  
        ColorMenu.add(RedItem);
        ColorMenu.add(GreenItem);
        ColorMenu.add(BlueItem);
        ColorMenu.addSeparator();
        ColorMenu.add(TextColor);

        menuBar.add(ColorMenu);

        btgr.add(RedItem);
        btgr.add(GreenItem);
        btgr.add(BlueItem);

        SystemMenu.add(AboutItem);
        SystemMenu.add(ExitItem);
        menuBar.add(SystemMenu);

        JLabel NewText = new JLabel();
        JLabel aboutus = new JLabel();
        JLabel cancel = new JLabel();

        ImageIcon NewTextIcon = new ImageIcon("D:\\\\HocTap\\\\JAVA3\\\\icon\\\\Add.png");
        Image Sizenew = NewTextIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedIconnew = new ImageIcon(Sizenew);
        ImageIcon aboutusIcon = new ImageIcon("D:\\\\HocTap\\\\JAVA3\\\\icon\\\\User.png");
        Image Sizeaboutus = aboutusIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedIaboutus = new ImageIcon(Sizeaboutus);
        ImageIcon cancelIcon = new ImageIcon("D:\\\\HocTap\\\\JAVA3\\\\icon\\\\Log out.png");
        Image Sizecancel = cancelIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedIcancel = new ImageIcon(Sizecancel);

        NewText.setIcon(resizedIconnew);
        aboutus.setIcon(resizedIaboutus);
        cancel.setIcon(resizedIcancel);

        pn1.setLayout(new FlowLayout(FlowLayout.LEFT));
        pn1.add(NewText);
        pn1.add(aboutus);
        pn1.add(cancel);
        pn1.setBackground(Color.DARK_GRAY);
        Jedit.setContentType("text/plain");

    }

    static void ACLMenu() {
        // Thêm hành động cho mục menu "New"
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newFrame = new JFrame("New File");
                newFrame.setSize(300, 200);
                newFrame.setLocationRelativeTo(fr);
                newFrame.setVisible(true);
            }
        });

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fchon = new JFileChooser();
                int kq = fchon.showOpenDialog(null);
                if (kq == fchon.APPROVE_OPTION) {
                    try {
                        File fname = fchon.getSelectedFile();
                        Jedit.setPage("File:///" + fname.getPath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Thêm hành động cho mục menu "Save"
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fchon = new JFileChooser();
                int kq = fchon.showSaveDialog(null);
                if (kq == fchon.APPROVE_OPTION) {
                    try {
                        File fname = fchon.getSelectedFile();
                        PrintWriter pw = new PrintWriter(fname);
                        pw.println(Jedit.getText());
                        pw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        txtcmt.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Jedit.setText(txtcmt.getText());
                    txtcmt.setText("");
                    txtcmt.requestFocus();
                }
            }
        });
        RedItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jedit.setForeground(Color.red);
                Jedit.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
            }
        });
        BlueItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jedit.setForeground(Color.BLUE);
                Jedit.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
            }
        });
        GreenItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jedit.setForeground(Color.green);
                Jedit.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
            }
        });
        Jedit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem openItem1 = new JMenuItem("Open");
                    JMenuItem saveItem1 = new JMenuItem("Save");
                    JMenuItem newItem1 = new JMenuItem("New");
                    // Thêm hành động cho menuItem nếu cần
                    popupMenu.add(openItem1);
                    popupMenu.add(saveItem1);
                    popupMenu.add(newItem1);

                    popupMenu.show(Jedit, e.getX(), e.getY()); // Hiển thị menu ở vị trí chuột được nhấp
                } else {
                    super.mouseReleased(e);
                }
            }
        });
        TextColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color mau = JColorChooser.showDialog(null, "chon mau", null);
                Jedit.setForeground(mau);
                Jedit.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 20));
            }
        });
        Jedit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem openItem1 = new JMenuItem("Open");
                    JMenuItem saveItem1 = new JMenuItem("Save");
                    JMenuItem newItem1 = new JMenuItem("New");

                    // Add ActionListener for "Open" in the popup menu
                    openItem1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Add your code for "Open" action here
                            System.out.println("Open clicked");
                        }
                    });

                    // Add ActionListener for "Save" in the popup menu
                    saveItem1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Add your code for "Save" action here
                            System.out.println("Save clicked");
                        }
                    });

                    // Add ActionListener for "New" in the popup menu
                    newItem1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Add your code for "New" action here
                            System.out.println("New clicked");
                        }
                    });

                    popupMenu.add(openItem1);
                    popupMenu.add(saveItem1);
                    popupMenu.add(newItem1);

                    popupMenu.show(Jedit, e.getX(), e.getY());
                } else {
                    super.mouseReleased(e);
                }
            }
        });
    }

    static void Frame() {
        fr.setSize(650, 600); // Tăng chiều cao để có không gian cho JMenuBar và pn1
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new BorderLayout());

        // Gán JMenuBar cho JFrame
        fr.setJMenuBar(menuBar);

        // Thiết lập chiều cao tạm thời cho pn1
        pn1.setPreferredSize(new Dimension(650, 50)); // Thiết lập chiều cao tạm thời là 100px

        // Thêm pn1 vào phần content của JFrame
        fr.add(pn1, BorderLayout.NORTH); // Đặt pn1 ở phía trên cùng

        fr.add(Jedit);

        fr.add(txtcmt, BorderLayout.SOUTH);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        Menu();
        ACLMenu();
        Frame();
    }
}
