/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.DonViBUS;
import BUS.LoaiHangBUS;
import javax.swing.JPanel;
//import BUS.LoaiBUS;
//import BUS.NsxBUS;
import BUS.MatHangBUS;
import DTO.MatHangDTO;
import DAO.MatHangDAO;
import DTO.DonViDTO;
import DTO.LoaiHangDTO;
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
//import DTO.SanPhamDTO;
//import BUS.SanPhamBUS;
//import DTO.LoaiDTO;
//import DTO.NsxDTO;

import java.awt.event.MouseListener;

import java.util.Arrays;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableCellRenderer;



/**
 *
 * @author Admin
 */
public class MatHangGUI extends JPanel implements MouseListener{
    private int DEFALUT_WIDTH;
    public MatHangGUI(int width)
    {
        DEFALUT_WIDTH=width;
        init();
    }
    private JScrollPane jScrollPane1;
    private DecimalFormat dcf = new DecimalFormat("###,###");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private JLabel title,btnchonanh,txtrefresh,txtsearch,img,btnadd,btnedit,btndelete,lbmasp,lbloaisp,lbgiafrom,lbgiato,btnsearch,btnxuatfile,btnnhapfile;
    private JLabel buttons[];
    private JTextField textfields[],tftimkiem,tfmasp,tfloaisp,tfgiafrom,tfgiato;
    private ImageIcon icon1;
    private JPanel filter;
    private dladdMatHangGUI dl;
    private dleditMatHangGUI dl2;
    public JTable ds,dsfull;
    public DefaultTableModel tb1,tbfull;
    private MatHangBUS mathangBUS;
    private String[] title1={"Mã SP","Tên SP","Loại SP","Số lượng","Đơn vị tính","Đơn giá"};
    private String[] titlefull={"Mã SP","Tên SP","giamua","giaban","ngaysx","hansudung","slnhap","slban","ngaynhap","vat","malh","madvt"};
    private String []TTSP=new String[0];
    private String []TTSPFull = new String[0];
    public void init()
    {
        setLayout(null);
        setPreferredSize(new Dimension(1100,700));
        setBackground(new Color(0xEEEEEE));
        title= new JLabel("QUẢN LÍ SẢN PHẨM"); 
        title.setBounds(400, 10, 250, 40);
        title.setFont(new Font("Serif",Font.BOLD,25));
         add(title);
         
         //icon= new ImageIcon("/images/refresh_40px.png");
         txtrefresh = new JLabel();
         txtrefresh.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/refresh_40px.png")));
         txtrefresh.setBounds(650, 10,50, 50);
        txtrefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
         add(txtrefresh);
         txtrefresh.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                cleanView();
            }
             
         });
         
        buttons=new JLabel[6];
        textfields= new JTextField[6];
        int toadoyButton=70;
        String[] arrBtn={"Mã SP","Tên SP","Loại SP","Số lượng","Đơn vị tính","Đơn giá"};
        for(int i=0;i<6;i++)
        {
           buttons[i]=new JLabel(arrBtn[i]);
           buttons[i].setBounds(80, toadoyButton, 100, 25);
           buttons[i].setFont(new Font("Serif",Font.BOLD,18));
           textfields[i]=new JTextField();
           textfields[i].setBounds(180, toadoyButton, 320, 25);
           textfields[i].setFont(new Font("Serif",0,15));
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
        
        img= new JLabel("Image");
        img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        img.setFont(new Font("Serif",0,20));
        img.setHorizontalAlignment(SwingConstants.CENTER);
        img.setVerticalAlignment(SwingConstants.CENTER);
        img.setBounds(550, 65, 200, 180);
        //img.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/bau.jpg")).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH));
        add(img);
        
        btnadd= new JLabel();
        btnadd.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnAdd_150px.png")));
        btnadd.setBounds(800, 65,200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dl= new dladdMatHangGUI();
        btnadd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                dl.setVisible(true);
            }
         
        });
        btnedit = new JLabel();
        btnedit.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnEdit_150px.png")));
        btnedit.setBounds(800, 115,200, 50);
        btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dl2=new dleditMatHangGUI();
        btnedit.addMouseListener(new MouseAdapter (){
            @Override
            public void mouseClicked(MouseEvent e) {
                //dl2.setVisible(true);
            }
           
        });
        btndelete = new JLabel();
        btndelete.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnDelete_150px.png")));
        btndelete.setBounds(800, 165,200, 50);
        btndelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btndelete.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
                MatHangDTO mh= new MatHangDTO();
                mh.setMaMh(textfields[0].getText()); 
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
                if(i == 0)
                {
                      mathangBUS.delete(mh);
                    loadData();
                    cleanView();
                }
            }
            
            
        });
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
        
        lbmasp= new JLabel("Mã MH");
        lbmasp.setBounds(150,15,60,25);
        lbmasp.setFont(new Font("Serif",0,15));
        tfmasp= new JTextField();
        tfmasp.setBounds(210,15, 100, 25);
        lbloaisp= new JLabel("Mã Loại");
        lbloaisp.setBounds(320,15 ,60, 25);
        lbloaisp.setFont(new Font("Serif",0,15));
        tfloaisp= new JTextField();
        tfloaisp.setBounds(380, 15, 100, 25);
        lbgiafrom= new JLabel("Giá từ");
        lbgiafrom.setFont(new Font("Serif",0,15));
        lbgiafrom.setBounds(490,15 ,60 ,25 );
        tfgiafrom= new JTextField();
        tfgiafrom.setBounds(550,15,100,25);
        lbgiato= new JLabel("-");
        lbgiato.setBounds(660, 15, 20, 25);
        lbgiato.setFont(new Font("Serif",0,15));
        tfgiato= new JTextField();
        tfgiato.setBounds(680, 15, 100, 25);
        
        filter.add(lbmasp);
        filter.add(tfmasp);
        filter.add(lbloaisp);
        filter.add(tfloaisp);
        filter.add(lbgiafrom);
        filter.add(tfgiafrom);
        filter.add(lbgiato);
        filter.add(tfgiato);
        
        btnsearch = new JLabel();
        btnsearch.setBounds(790, 0, 40, 40);
        btnsearch.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnSearch_40px.png")));
        btnsearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        filter.add(btnsearch);
        
         
       
       
        mathangBUS = new MatHangBUS();
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
	ds.getColumnModel().getColumn(2).setPreferredWidth(100);
	ds.getColumnModel().getColumn(3).setPreferredWidth(10);
        ds.getColumnModel().getColumn(4).setPreferredWidth(10);
        ds.getColumnModel().getColumn(5).setPreferredWidth(100);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        ds.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        ds.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        ds.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
             {
                int i = ds.getSelectedRow();
                
                textfields[0].setText(ds.getModel().getValueAt(i, 0).toString());
                textfields[1].setText(ds.getModel().getValueAt(i, 1).toString());
                textfields[2].setText(ds.getModel().getValueAt(i, 2).toString()); 
                textfields[3].setText(ds.getModel().getValueAt(i, 3).toString());   
                textfields[4].setText(ds.getModel().getValueAt(i, 4).toString());    
                textfields[5].setText(ds.getModel().getValueAt(i, 5).toString());
                
                
                
             }
        });
       
       jScrollPane1 = new javax.swing.JScrollPane();
       jScrollPane1.setBounds(80, 380,900, 250);
       jScrollPane1.setViewportView(ds);
       add(jScrollPane1);
       getDSsp();
       
       
       btnnhapfile= new JLabel();
       btnnhapfile.setBounds(800, 215, 151, 44);
       btnnhapfile.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnNhapExcel.png")));
       btnnhapfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
       add(btnnhapfile);
       btnxuatfile= new JLabel();
       btnxuatfile.setBounds(800, 260, 151, 44);
       btnxuatfile.setIcon(new ImageIcon(MatHangGUI.class.getResource("/images/btnXuatExcel.png")));
       btnxuatfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
       add(btnxuatfile);
       
    }
    public void themphantuvaomang(String s)
    {
        int l =TTSP.length;
        TTSP=Arrays.copyOf(TTSP, l+1);
        TTSP[l]=s;
    }
    
    public void getDSsp() {
//		{"Mã SP","Tên SP","Loại SP","Số lượng","Đơn vị tính","Đơn giá"};
		DefaultTableModel model = (DefaultTableModel) ds.getModel();
		for(int i=0;i<mathangBUS.getList().size();i++) {
			themphantuvaomang(mathangBUS.getList().get(i).getMaMh());
			themphantuvaomang(mathangBUS.getList().get(i).getTenMh());
                        LoaiHangDTO lh= new LoaiHangDTO();
                        lh.setMaLh(mathangBUS.getList().get(i).getMaLH());
                        themphantuvaomang(LoaiHangBUS.getIntance().getLoaiHangByID(lh).getTenLh());
                        themphantuvaomang((mathangBUS.getList().get(i).getSlNhap()-mathangBUS.getList().get(i).getSlBan())+"");
                        DonViDTO dv=new DonViDTO();
			dv.setMaDvt(mathangBUS.getList().get(i).getMaDVT());
			themphantuvaomang(DonViBUS.getIntance().getDonViByID(dv).getTenDvt());
                        themphantuvaomang(dcf.format(mathangBUS.getList().get(i).getGiaBan()));
			model.addRow(TTSP);
			TTSP= new String[0];
		}
	}
   

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void loadData()
    {
        tb1.setRowCount(0);
        for(MatHangDTO mh: mathangBUS.getList())
        {
            Vector vec = new Vector();
            vec.add(mh.getMaMh());
            vec.add(mh.getTenMh());
            vec.add(mh.getMaLH());
            vec.add(mh.getSlNhap()-mh.getSlBan());
            vec.add(mh.getMaDVT());
            vec.add(mh.getGiaBan());
            tb1.addRow(vec);
        }
        
            //private String[] title1={"Mã SP","Tên SP","Loại SP","Số lượng","Đơn vị tính","Đơn giá"};
    }
    public void cleanView()
    {
        textfields[0].setText("");
         textfields[1].setText("");
         textfields[2].setText("");
         textfields[3].setText("");
         textfields[4].setText("");
         textfields[5].setText("");
         textfields[0].requestFocusInWindow();
         ds.clearSelection();
    }

    
}
