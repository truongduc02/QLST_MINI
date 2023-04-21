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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PhanQuyenGUI extends JPanel {
    public PhanQuyenGUI()
    {
        init();
    }
    private JLabel title,lbnhomquyen,lbhanhdong,lbthem,lbsua,lbxoa,btnadd,btnedit,btndelete;
    private JCheckBox buttons[];
    private JComboBox<String> phanquyen;
    private JToggleButton test[][];
    public void init()
    {
        setLayout(null);
        setPreferredSize(new Dimension(1100,700));
        setBackground(new Color(0xEEEEEE));
        title= new JLabel("QUẢN LÍ PHÂN QUYỀN"); 
        title.setBounds(400, 10, 305, 40);
        title.setFont(new Font("Serif",Font.BOLD,25));
        add(title);
         
        lbnhomquyen= new JLabel("Nhóm quyền: ");
        lbnhomquyen.setBounds(390, 65,150, 25);
        lbnhomquyen.setFont(new Font("Serif",0,20));
        add(lbnhomquyen);
        phanquyen = new JComboBox<String>();
        phanquyen.setBounds(510, 65, 150, 25);
        phanquyen.addItem("Chọn nhóm");
        phanquyen.setFont(new Font("Serif",0,16));
        phanquyen.setBackground(Color.WHITE);
        add(phanquyen);
        
        lbhanhdong= new JLabel("Các hành động");
        lbhanhdong.setBounds(240, 110, 150, 25);
        lbhanhdong.setFont(new Font("Serif",0,20));
        add(lbhanhdong);
        
        lbthem= new JLabel();
        lbthem.setIcon(new ImageIcon(PhanQuyenGUI.class.getResource("/images/R.png")));
        lbthem.setBounds(600,110 ,30 ,30 );
        lbsua=new JLabel();
        lbsua.setIcon(new ImageIcon(PhanQuyenGUI.class.getResource("/images/S.png")));
        lbsua.setBounds(700, 110, 30, 30);
        lbxoa=new JLabel();
        lbxoa.setIcon(new ImageIcon(PhanQuyenGUI.class.getResource("/images/D.png")));
        lbxoa.setBounds(800, 110, 30, 30);
        add(lbthem);
        add(lbsua);
        add(lbxoa);
        
        test=new JToggleButton[10][10];
        int x=610;
        int y=160;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<3;j++)
            {
                test[i][j]=new JToggleButton();
                test[i][j].setBounds(x, y, 20, 20);
                x+=95;
                add(test[i][j]);
            }
            x=610;
            y+=35;
        }
        
        int toadoyButton=160;
        buttons=new JCheckBox[8];
        String[] arrBtn={"Quản lí sản phẩm","Quản lí nhân viên","Quản lí khách hàng","Quản lí hóa đơn","Quản lí nhà cung cấp","Quản lí thống kê","Quản lí nhập hàng","Quản lí tài khoản"};
        for(int i=0;i<8;i++)
        {
           buttons[i]=new JCheckBox(arrBtn[i]);
           buttons[i].setBounds(200, toadoyButton, 220, 25);
           buttons[i].setFont(new Font("Serif",Font.BOLD,20));
           toadoyButton+=35; 
           add(buttons[i]);
        }
        
        btnadd= new JLabel();
        btnadd.setIcon(new ImageIcon(PhanQuyenGUI.class.getResource("/images/btnAdd_150px.png")));
        btnadd.setBounds(260, 450,200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnedit = new JLabel();
        btnedit.setIcon(new ImageIcon(PhanQuyenGUI.class.getResource("/images/btnEdit_150px.png")));
        btnedit.setBounds(460, 450,200, 50);
        btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btndelete = new JLabel();
        btndelete.setIcon(new ImageIcon(PhanQuyenGUI.class.getResource("/images/btnDelete_150px.png")));
        btndelete.setBounds(660, 450,200, 50);
        btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnadd);
        add(btnedit);
        add(btndelete);
    }
}
