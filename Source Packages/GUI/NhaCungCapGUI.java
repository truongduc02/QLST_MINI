package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *c
 * @author Admin
 */
import javax.swing.JPanel;
import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import DAO.NhaCungCapDAO;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NhaCungCapGUI extends JPanel implements ActionListener{
    private int DEFALUT_WIDTH;
    public NhaCungCapGUI(int width)
    {
        DEFALUT_WIDTH=width;
        init();
    }
    private JTable ds;
    private String []mangNcc= new String[0];
    private JScrollPane jScrollPane1;
    private JLabel title,btnchonanh,txtrefresh,txtsearch,img,btnadd,btnedit,btndelete,lbmasp,lbloaisp,lbgiafrom,lbgiato,btnsearch,btnxuatfile,btnnhapfile;
    private JLabel buttons[];
    private JTextField textfields[],tftimkiem,tfmasp,tfloaisp;
    private ImageIcon icon1;
    private JPanel filter;
    private NhaCungCapBUS nhacungcapBus;
    private String []title1= { "Mã NCC", "Tên NCC", "Địa chỉ", "Điện thoại"};
    private DefaultTableModel tb1;
    public void init()
    {
        setLayout(null);
        setPreferredSize(new Dimension(1100,700));
        setBackground(new Color(0xEEEEEE));
        title= new JLabel("QUẢN LÍ NHÀ CUNG CẤP"); 
        title.setBounds(345, 10, 305, 40);
        title.setFont(new Font("Serif",Font.BOLD,25));
         add(title);
         
         //icon= new ImageIcon("/images/refresh_40px.png");
         txtrefresh = new JLabel();
         txtrefresh.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/refresh_40px.png")));
         txtrefresh.setBounds(650, 10,50, 50);
        txtrefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
         add(txtrefresh);
         
        buttons=new JLabel[6];
        textfields= new JTextField[6];
        int toadoyButton=90;
        String[] arrBtn={"Mã NCC","Tên NCC","Địa chỉ","Điện thoại"};
        for(int i=0;i<4;i++)
        {
           buttons[i]=new JLabel(arrBtn[i]);
           buttons[i].setBounds(100, toadoyButton, 100, 25);
           buttons[i].setFont(new Font("Serif",Font.BOLD,18));
           textfields[i]=new JTextField();
           textfields[i].setBounds(200, toadoyButton, 550, 25);
           textfields[i].setFont(new Font("Serif",0,15));
           textfields[i].setHorizontalAlignment(JTextField.CENTER);
           toadoyButton+=30; 
           add(buttons[i]); 
           add(textfields[i]);
        }
        
       
        tftimkiem = new JTextField();
        tftimkiem.setBackground(Color.WHITE);
        //tftimkiem.setOpaque(false);
        tftimkiem.setBounds(new Rectangle(330, 270, 400, 25));
        tftimkiem.setFont(new Font("Serif",0,20));
        add(tftimkiem);
        
        txtsearch = new JLabel();
        txtsearch.setBounds(new Rectangle(730, 262, 40, 40));
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
        
        nhacungcapBus = new NhaCungCapBUS();
        String mean[][]= null;
        tb1= new DefaultTableModel(mean,title1);
        
        ds = new JTable(tb1);
        ds.setFont(new Font("Serif",0,15));
        ds.getTableHeader().setForeground(Color.white);
	ds.getTableHeader().setBackground(new Color(52, 152, 219));
	ds.getTableHeader().setFont(new Font("erif", Font.BOLD, 15));
	ds.getTableHeader().setPreferredSize(new Dimension(700,30));
	ds.setRowHeight(25);
        ds.getColumnModel().getColumn(0).setPreferredWidth(10);
	ds.getColumnModel().getColumn(1).setPreferredWidth(200);
	ds.getColumnModel().getColumn(2).setPreferredWidth(200);
	ds.getColumnModel().getColumn(3).setPreferredWidth(10);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        ds.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        ds.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
             {
                int i = ds.getSelectedRow();
                
                textfields[0].setText(ds.getModel().getValueAt(i, 0).toString());
                textfields[1].setText(ds.getModel().getValueAt(i, 1).toString());
                textfields[2].setText(ds.getModel().getValueAt(i, 2).toString()); 
                textfields[3].setText(ds.getModel().getValueAt(i, 3).toString());        
             }
        });
       
       jScrollPane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       jScrollPane1.setBounds(80, 330,920, 300);
       jScrollPane1.setViewportView(ds);
       getDsncc();
       add(jScrollPane1);
       
       
       
    }
    
    public void getDsncc() {
//		"Mã SP","Tên SP","Đơn giá","Còn lại","Đơn vị tính","Hạn sử dụng"
		DefaultTableModel model = (DefaultTableModel) ds.getModel();
		for(int i=0;i<nhacungcapBus.getList().size();i++) {
			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getMaNcc());
			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getTenNcc());
			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getDiachi());			
			themPhanTuVaoMangNcc(nhacungcapBus.getList().get(i).getDienthoai());
			model.addRow(mangNcc);
			mangNcc= new String[0];
		}
	} 
        public void themPhanTuVaoMangNcc(String s) {
		int l=mangNcc.length;
		mangNcc=Arrays.copyOf(mangNcc, l+1);
		mangNcc[l]=s;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

