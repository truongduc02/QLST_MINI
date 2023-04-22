/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JPanel;
//import BUS.LoaiBUS;
//import BUS.NsxBUS;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//import DTO.SanPhamDTO;
//import BUS.SanPhamBUS;
//import DTO.LoaiDTO;
//import DTO.NsxDTO;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JDialog;
public class dleditMatHangGUI extends JDialog {
    public dleditMatHangGUI()
    {
        init();
    }
    private JLabel title,btnadd;
    private JLabel buttons[];
    private JTextField textfields[];
    public void init()
    {
        setTitle("Sửa chi  tiết sản phẩm");
        setSize(500, 730);
        setLayout(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(false);
        setLocationRelativeTo(null);
        
        title = new JLabel("Thông tin chi tiết sản phẩm");
        title.setFont(new Font("Serif",1,25));
        title.setBounds(0, 0, 500, 25);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);
        buttons=new JLabel[12];
        textfields= new JTextField[12];
        int toadoyButton=50;
        String[] arrBtn={"Mã SP","Tên SP","Giá mua","Giá bán","Ngày SX","Hạn SD","SL Nhập","SL Bán","Ngày nhập","VAT","Mã LH","MÃ ĐVT"};
        for(int i=0;i<12;i++)
        {
           buttons[i]=new JLabel(arrBtn[i]);
           buttons[i].setBounds(90, toadoyButton, 100, 25);
           buttons[i].setFont(new Font("Serif",Font.BOLD,20));
           textfields[i]=new JTextField();
           textfields[i].setBounds(190, toadoyButton, 200, 25);
           textfields[i].setFont(new Font("Serif",0,20));
           toadoyButton+=40; 
           add(buttons[i]); 
           add(textfields[i]);
        }
        btnadd= new JLabel();
        btnadd.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnEdit_150px.png")));
        btnadd.setBounds(180, 570,200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnadd);
    }
    
}
