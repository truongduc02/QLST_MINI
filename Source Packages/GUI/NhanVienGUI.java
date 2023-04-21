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

public class NhanVienGUI extends JPanel {
    public NhanVienGUI()
    {
        init();
    }
    private JTable tb1;
    private JScrollPane jScrollPane1;
    private JLabel title,btnchonanh,txtrefresh,txtsearch,img,btnadd,btnedit,btndelete,lbdiachi,lbmasp,lbloaisp,lbgiafrom,lbgiato,btnsearch,btnxuatfile,btnnhapfile;
    private JLabel buttons[];
    private JTextField textfields[],tftimkiem,tfmasp,tfloaisp,tfgiafrom,tfgiato,tfdiachi;
    private ImageIcon icon1;
    private JPanel filter;
    private JComboBox Gender;
    public void init()
    {
        setLayout(null);
        setPreferredSize(new Dimension(1100,700));
        setBackground(new Color(0xEEEEEE));
        title= new JLabel("QUẢN LÍ NHÂN VIÊN"); 
        title.setBounds(390, 10, 305, 40);
        title.setFont(new Font("Serif",Font.BOLD,25));
         add(title);
         
         //icon= new ImageIcon("/images/refresh_40px.png");
         txtrefresh = new JLabel();
         txtrefresh.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/refresh_40px.png")));
         txtrefresh.setBounds(650, 10,50, 50);
        txtrefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
         add(txtrefresh);
         
        buttons=new JLabel[8];
        textfields= new JTextField[8];
        int toadoyButton=70;
        String[] arrBtn={"Mã NV","Họ Tên","Ngày Sinh","Phái","CCCD","Địa Chỉ","Điện thoại","Ngày Vào Làm" };
        for(int i=0;i<8;i++)
        {
           buttons[i]=new JLabel(arrBtn[i]);
           buttons[i].setBounds(275, toadoyButton, 135, 25);
           buttons[i].setFont(new Font("Serif",Font.BOLD,20));
           textfields[i]=new JTextField();
           textfields[i].setBounds(410, toadoyButton, 250, 25);
           textfields[i].setFont(new Font("Serif",0,20));
           toadoyButton+=30; 
           add(buttons[i]); 
           add(textfields[i]);
        }
        
       
        tftimkiem = new JTextField();
        tftimkiem.setBackground(Color.WHITE);
        //tftimkiem.setOpaque(false);
        tftimkiem.setBounds(new Rectangle(730,280, 250, 25));
        tftimkiem.setFont(new Font("Serif",0,20));
        add(tftimkiem);
        
        txtsearch = new JLabel();
        txtsearch.setBounds(new Rectangle(980, 270, 40, 40));
        txtsearch.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/search_25px.png")));
        txtsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(txtsearch);
        
        
        btnadd= new JLabel();
        btnadd.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnAdd_150px.png")));
        btnadd.setBounds(800, 65,200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnedit = new JLabel();
        btnedit.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnEdit_150px.png")));
        btnedit.setBounds(800, 115,200, 50);
        btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btndelete = new JLabel();
        btndelete.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnDelete_150px.png")));
        btndelete.setBounds(800, 165,200, 50);
        btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        btnchonanh= new JLabel();
//        btnchonanh.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnFile.png")));
//        btnchonanh.setBounds(800,215,200,50);
//        btnchonanh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnadd);
        add(btnedit);
        add(btndelete);
        //add(btnchonanh);
       
        filter= new JPanel();
        filter.setLayout(null);
        filter.setBounds(0,310,1300-220,50);
        add(filter);
        
        lbmasp= new JLabel("Mã NV");
        lbmasp.setBounds(110,15,60,25);
        lbmasp.setFont(new Font("Serif",0,15));
        tfmasp= new JTextField();
        tfmasp.setBounds(170,15, 100, 25);
        lbdiachi= new JLabel("Địa chỉ");
        lbdiachi.setBounds(285,15 ,200, 25);
        lbdiachi.setFont(new Font("Serif",0,15));
        tfdiachi= new JTextField();
        tfdiachi.setBounds(360, 15, 100, 25);
        String s[]={"Chọn giới tính","Nam","Nữ"};
        Gender= new JComboBox(s);
        Gender.setBounds(480, 15, 150, 25);
        Gender.setBackground(Color.WHITE);
        Gender.setFont(new Font("Serif",0,15));
        lbgiafrom= new JLabel("Ngày Vào Làm");
        lbgiafrom.setFont(new Font("Serif",0,15));
        lbgiafrom.setBounds(645,15 ,150 ,25 );
        tfgiafrom= new JTextField();
        tfgiafrom.setBounds(750,15,100,25);
        lbgiato= new JLabel("-");
        lbgiato.setBounds(860, 15, 20, 25);
        lbgiato.setFont(new Font("Serif",0,15));
        tfgiato= new JTextField();
        tfgiato.setBounds(870, 15, 100, 25);
        
        filter.add(lbmasp);
        filter.add(tfmasp);
        filter.add(lbdiachi);
        filter.add(tfdiachi);
        filter.add(Gender);
        filter.add(lbgiafrom);
        filter.add(tfgiafrom);
        filter.add(lbgiato);
        filter.add(tfgiato);
        
        
        
        btnsearch = new JLabel();
        btnsearch.setBounds(980, 0, 40, 40);
        btnsearch.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnSearch_40px.png")));
        btnsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        filter.add(btnsearch);
        
          
       tb1= new JTable();
       tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {             
            },
            new String [] {
                "Mã NV", "Họ Tên","Ngày Sinh","Phái","CCCD","Địa chỉ","Điện thoại","Ngày Làm"
            }
        ));
       tb1.getTableHeader().setForeground(Color.BLACK);
       tb1.getTableHeader().setBackground(new Color(0x29B6F6));
       tb1.getTableHeader().setFont(new Font("Serif",Font.BOLD,18));
       tb1.setFont(new Font("Serif",0,16));
       tb1.setRowHeight(25);
       
       jScrollPane1 = new javax.swing.JScrollPane();
       jScrollPane1.setBounds(80, 380,900, 250);
       jScrollPane1.setViewportView(tb1);
       add(jScrollPane1);
    }
}
