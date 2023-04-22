/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLSieuThi {
    public QLSieuThi()
    {
        init();
    }
    private JPanel header,nav,main;
    public void init()
    {
        header = new JPanel(null);
        header.setBackground(new Color(0x29B6F6));
        header.setPreferredSize(new Dimension(1300,40));
        nav = new JPanel(null);
        nav.setBackground(new Color(0x29B6F6));
        nav.setPreferredSize(new Dimension(220,730));
        
        main = new JPanel(null);
        main.setBackground(Color.WHITE);
        
        JScrollPane scroll = new JScrollPane(nav);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(1,100));
        scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_NEVER);
        JFrame fr= new JFrame("Quản lí siêu thị");
       fr.setLayout(new BorderLayout());
       fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       fr.setSize(new Dimension(1300,730));
       fr.setLocationRelativeTo(null);
       fr.setVisible(true);
       fr.add(header,BorderLayout.NORTH);
       fr.add(scroll,BorderLayout.WEST);
       // fr.add(main,BorderLayout.CENTER);
       //fr.add(new NhanVienGUI(),BorderLayout.CENTER);
       //fr.add(new MatHangGUI(1300),BorderLayout.CENTER);
       //fr.add(new KhachHangGUI(),BorderLayout.CENTER);
       fr.add(new NhaCungCapGUI(1300),BorderLayout.CENTER);
       //fr.add(new PhanQuyenGUI(),BorderLayout.CENTER);
       fr.repaint();
       fr.validate();
    }
    public static void main(String[] args) {
        new QLSieuThi();
    }
}
