/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.DonViBUS;
import BUS.LoaiHangBUS;
import BUS.MatHangBUS;
import DTO.DonViDTO;
import DTO.LoaiHangDTO;
import DTO.MatHangDTO;
import com.toedter.calendar.JCalendar;
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
import com.toedter.calendar.JDateChooser;
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
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
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
    private  JLabel title,btnadd,btnimg;
    private JLabel txtmamh,txtten,txtgiamua,txtgiaban, txtngaysanxuat,txthansudung,txtslnhap,txtslban, txtngaynhap,txtvat,txtmalh,txtmadvt ;
    public JTextField tfmamh,tften,tfgiamua,tfgiaban,tfslnhap,tfslban,tfvat,tfmalh,tfmadvt;
    public JDateChooser datengaysanxuat,datehansudung,datengaynhap;
        private MatHangBUS mathangBUS;
        public  JComboBox cmbloaihang,cmbdvt;
        public String temp="",temp1="",temp2="";
        private MatHangGUI mhGUI;
  
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
        mathangBUS= new MatHangBUS();
        
        txtmamh= new JLabel("Mã sản phẩm");
        txtmamh.setBounds(30,50,150,25);
        txtmamh.setFont(new Font("Serif",1,18));
        add(txtmamh);
        txtten = new JLabel("Tên sản phẩm");
        txtten.setBounds(30,80,150,25);
        txtten.setFont(new Font("Serif",1,18));
        add(txtten);
        txtgiamua = new JLabel("Giá mua");
        txtgiamua.setBounds(30,110,150,25);
        txtgiamua.setFont(new Font("Serif",1,18));
        add(txtgiamua);
        txtgiaban= new JLabel("Giá bán");
        txtgiaban.setBounds(30,140,150,25);
        txtgiaban.setFont(new Font("Serif",1,18));
        add(txtgiaban);
        txtngaysanxuat= new JLabel("Ngày sản xuất");
        txtngaysanxuat.setBounds(30,170,150,25);
        txtngaysanxuat.setFont(new Font("Serif",1,18));
        add(txtngaysanxuat);
        datengaysanxuat = new JDateChooser();
        datengaysanxuat.setDateFormatString("dd/MM/yyyy");
        datengaysanxuat.setBounds(160, 170, 200, 25);
        add(datengaysanxuat);
        txthansudung= new JLabel("Hạn sử dụng");
        txthansudung.setBounds(30,200,150,25);
        txthansudung.setFont(new Font("Serif",1,18));
        add(txthansudung);
        datehansudung = new JDateChooser();
        datehansudung.setDateFormatString("dd/MM/yyyy");
        datehansudung.setBounds(160, 200, 200, 25);
        add(datehansudung);
        txtslnhap= new JLabel("SL nhập");
        txtslnhap.setBounds(30,230,150,25);
        txtslnhap.setFont(new Font("Serif",1,18));
        add(txtslnhap);
        txtslban= new JLabel("SL bán");
        txtslban.setBounds(30,260,150,25);
        txtslban.setFont(new Font("Serif",1,18));
        add(txtslban);
        txtngaynhap= new JLabel("Ngày nhập");
        txtngaynhap.setBounds(30,290,150,25);
        txtngaynhap.setFont(new Font("Serif",1,18));
        add(txtngaynhap);
        datengaynhap = new JDateChooser();
        datengaynhap.setDateFormatString("dd/MM/yyyy");
        datengaynhap.setBounds(160, 290, 200, 25);
        add(datengaynhap);
        txtvat= new JLabel("VAT");
        txtvat.setBounds(30,320,150,25);
        txtvat.setFont(new Font("Serif",1,18));
        add(txtvat);
        txtmalh= new JLabel("Mã LH");
        txtmalh.setBounds(30,350,150,25);
        txtmalh.setFont(new Font("Serif",1,18));
        add(txtmalh);
        txtmadvt = new JLabel("Mã ĐVT");
        txtmadvt.setBounds(30,380,150,25);
        txtmadvt.setFont(new Font("Serif",1,18));
        add(txtmadvt);
        
        
        tfmamh = new JTextField();
        tfmamh.setBounds(160,50,200,25);
        add(tfmamh);
        tften= new JTextField();
        tften.setBounds(160, 80, 200, 25);
        add(tften);
        tfgiamua= new JTextField();
        tfgiamua.setBounds(160, 110, 200, 25);
        add(tfgiamua);
        tfgiaban= new JTextField();
        tfgiaban.setBounds(160, 140, 200, 25);
        add(tfgiaban);
        tfslnhap= new JTextField();
        tfslnhap.setBounds(160, 230, 200, 25);
        add(tfslnhap);
        tfslban= new JTextField();
        tfslban.setBounds(160, 260, 200, 25);
        add(tfslban);
        tfvat= new JTextField();
        tfvat.setBounds(160, 320, 200, 25);
        add(tfvat);
        cmbloaihang= new JComboBox();
        cmbloaihang.setBounds(160, 350, 200, 25);
        add(cmbloaihang);
        cmbdvt= new JComboBox();
        cmbdvt.setBounds(160, 380, 200, 25);
        addDVT();
        addLoaiHang();
        add(cmbdvt);
        btnadd= new JLabel();
        btnadd.setIcon(new ImageIcon(dleditMatHangGUI.class.getResource("/images/btnEdit_150px.png")));
        btnadd.setBounds(50, 550,200, 50);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnadd);
        
        btnadd.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                String Mamh = tfmamh.getText();
                String tenmh = tften.getText();
                String giamua = tfgiamua.getText();
                double sogiamua=Double.valueOf(giamua);
                String giaban = tfgiaban.getText();
                double sogiaban= Double.valueOf(giaban);
                Date ngaysx = datengaysanxuat.getDate();
                Date hansudung = datehansudung.getDate();
                String slnhap = tfslnhap.getText();
                double soslnhap= Double.valueOf(slnhap);
                String slban = tfslban.getText();
                double soslban= Double.valueOf(slban);
                Date ngaynhap = datengaynhap.getDate();
                String vat= tfvat.getText();
                double sovat= Double.valueOf(vat);
                String malhtemp=cmbloaihang.getSelectedItem().toString();
                    String malh = LoaiHangBUS.getIntance().laymatheotenloaihang(malhtemp);
                    String madvttemp=cmbdvt.getSelectedItem().toString();
                    String madvt = DonViBUS.getIntance().laymatheotendonvitinh(madvttemp);
                String img=temp2;
                MatHangDTO mh= new MatHangDTO(Mamh,tenmh,sogiamua,sogiaban,ngaysx,hansudung,soslnhap,soslban,ngaynhap,sovat,malh,madvt,img);
                mathangBUS.capnhat(mh);
                 MatHangGUI mhGUI= new MatHangGUI(1300);
                    mhGUI.getDSSPFull();
                cleanView();
                //setVisible(false);
            }
            
            
            
        });
        
        btnimg= new JLabel();
        btnimg.setIcon(new ImageIcon(dladdMatHangGUI.class.getResource("/images/btnFile.png")));
        btnimg.setBounds(250,550,200,50);
        btnimg.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btnimg);
        btnimg.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mhGUI = new MatHangGUI(1300);
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG images", "jpg", "png");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        mhGUI.i = ImageIO.read(file); // Lấy hình
                        //C:\Users\Admin\OneDrive\Documents\NetBeansProjects\QLST_MINI\Source Packages\images\bau.jpg
                        temp=mathangBUS.getAnh(mhGUI.HinhAnh);
                        
                        
                        temp2=file.toString().substring(84, file.toString().length());
         
                        // Thay đổi hình hiển thị
                        ImageIcon icon = new ImageIcon(mhGUI.i.getScaledInstance(215, 180, Image.SCALE_SMOOTH));
                        mhGUI.img.setIcon(icon);
                        
                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                        Logger.getLogger(dladdMatHangGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
//    public void loadData()
//    {
//        MatHangGUI mhGUI= new  MatHangGUI(1300);
//        mhGUI.tb1.setRowCount(0);
//        ArrayList<MatHangDTO> ds = mathangBUS.getList();
//        for(MatHangDTO mh: ds)
//        {
//            Vector vec = new Vector();  
//            vec.add(mh.getMaMh());
//            vec.add(mh.getTenMh());
//            vec.add(mh.getMaLH());
//            vec.add(mh.getSlNhap()-mh.getSlBan());
//            vec.add(mh.getMaDVT());
//            vec.add(mh.getGiaBan());
//            mhGUI.tb1.addRow(vec);
//        }
//        
//    }
    public void cleanView()
    {
        tfmamh.setText("");
        tften.setText("");
        tfgiamua.setText("");
        tfgiaban.setText("");
        tfslnhap.setText("");
        tfslban.setText("");
        tfvat.setText("");
        cmbloaihang.setSelectedItem("Chọn loại");
        cmbdvt.setSelectedItem("Chọn ĐVT");
    }
    public void addLoaiHang()
    {
        Vector<String> vec= new Vector();
        vec.add("Chọn loại");
        for(LoaiHangDTO lh: LoaiHangBUS.getIntance().getList())
        {
            vec.add(lh.getTenLh());
        }
        DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(vec);
        cmbloaihang.setModel(cbmodel);
    }
    public void addDVT()
    {
        Vector<String> vec= new Vector();
        vec.add("Chọn ĐVT");
        for(DonViDTO lh: DonViBUS.getIntance().getList())
        {
            vec.add(lh.getTenDvt());
        }
        DefaultComboBoxModel<String>cbmodel=new DefaultComboBoxModel<>(vec);
        cmbdvt.setModel(cbmodel);
    }
   
}


 
    
    

