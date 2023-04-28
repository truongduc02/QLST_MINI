/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//import org.apache.xmlbeans.impl.store.Cursor;

public final class NhapHangGUI extends JPanel{
	private JPanel jPanel_menu_head, jPanel_nh, jPanel_qlpn, jPanel_table_pn;
    public JLabel jLabel_north, jLabel_logo, jLabel_ima_profile, jLabel_user;
    private ImageIcon icon_refresh, icon_delete;
    public JButton jButton_hidden, jButton_close, jButton_logout;
    public JTextField jTextField_maPN, jTextField_maNCC, jTextField_maNV, jTextField_ngayLap, jTextField_tongTien, jTextField_ctSanPham, jTextField_ctSoLuong, jTextField_ctDonGia, jTextField_ctThanhTien;
	public JLabel jLabel_nh, jLabel_qlpn;
	//Line
    Border lineBorder_exit_hidden = BorderFactory.createLineBorder(new Color(0x29B6F6), 1);
    Border lineBorder_viewMenu = BorderFactory.createLineBorder(Color.WHITE, 2);
    Border lineBorder_viewMenu1 = BorderFactory.createLineBorder(new Color(0xBDBDBD), 1); // line cho viewMenu
    Font font_jLabel_viewMenu_table = new Font("Arials", Font.BOLD, 40); // font cho phần ViewTable sản phẩm
    Font f_jLabel_viewMenu = new Font("Arials", Font.ITALIC, 15); // font trong cho nút "Nhập hàng", "Chi tiết"
    Font font_jLabel_viewMenu_ttsp = new Font("Arials", Font.BOLD, 25);
    Font font_jLabel_viewMenu_ttsp1 = new Font("Arials", Font.PLAIN, 15);
    Font font_menu_item = new Font("Arials", Font.BOLD, 15);
    
	public NhapHangGUI() {
		initComponents();
                addEvent();
	}
	public void initComponents() {
		this.setPreferredSize(new Dimension(1100,700));
		this.setLayout(null);
		
		//------Các thành phần trong viewmenu_center
        //------Các thành phần trong Menu_head
		icon_refresh=new ImageIcon("./src/IMG/icon_refresh.png");
		
        jLabel_nh = new JLabel("Nhập hàng", JLabel.CENTER);
        jLabel_nh.setBounds(0, 0, 100, 31);
        jLabel_nh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel_nh.setBorder(lineBorder_viewMenu);
        jLabel_nh.setBackground(Color.WHITE);
        jLabel_nh.setOpaque(true);
//        jLabel_nh.; //sự kiện
//        jLabel_nh.addMouseListener(mouse); //sự kiện chuột
//        jLabel_nh.setBorder(lineBorder_viewMenu);
        jLabel_nh.setFont(f_jLabel_viewMenu);

        jLabel_qlpn = new JLabel("Quản lý phiếu nhập", JLabel.CENTER);
        jLabel_qlpn.setBounds(100, 0, 149, 31);
        jLabel_qlpn.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        jLabel_qlpn.addMouseListener(mouse); //sự kiện chuột
        jLabel_qlpn.setBorder(lineBorder_viewMenu);
        jLabel_qlpn.setFont(f_jLabel_viewMenu);

        //------Menu_head
        jPanel_menu_head = new JPanel();
        jPanel_menu_head.setLayout(null);
        jPanel_menu_head.setBackground(new Color(0xE0E0E0));
        jPanel_menu_head.setBounds(0, 0, 1100, 30);
        jPanel_menu_head.setBorder(lineBorder_viewMenu);

        jPanel_menu_head.add(jLabel_nh);
        jPanel_menu_head.add(jLabel_qlpn);

        ///---Các thành phần trong ViewTable
        JLabel jLabel_khoHang = new JLabel("Nhập hàng"); // Kho hàng
        jLabel_khoHang.setBounds(245, 20, 220, 60);
        jLabel_khoHang.setFont(font_jLabel_viewMenu_table);

        JButton jButton_refresh = new JButton(icon_refresh); // nút refresh
        jButton_refresh.setBounds(465, 30, 50, 50);
        jButton_refresh.setBackground(new Color(0x29B6F6));
        jButton_refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_refresh.setOpaque(true);

        JLabel jLabel_timKiem = new JLabel("Tìm kiếm"); // Tìm kiếm
        jLabel_timKiem.setBounds(125, 105, 90, 30);
        jLabel_timKiem.setFont(f_jLabel_viewMenu);

        JTextField jTextField_timKiem = new JTextField(); // nhập
        jTextField_timKiem.setBounds(195, 105, 330, 30);

        JButton jButton_timKiem = new JButton("Tìm kiếm"); // nút tìm kiếm
        jButton_timKiem.setBounds(525, 104, 90, 30);
        jButton_timKiem.setBackground(new Color(0x29B6F6));
        jButton_timKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_timKiem.setOpaque(true);

        ////---View hiển thị thông tin table/ nằm trong View All Nhập Hàng
        JTable jTable_nhapHang = new JTable();

        //lấy đối tượng jtableheader từ jtable để đổi màu nền, màu chữ, font chữ
        JTableHeader tableHeader_nhapHang = jTable_nhapHang.getTableHeader();
        tableHeader_nhapHang.setBackground(new Color(0x29B6F6));
        tableHeader_nhapHang.setFont(font_menu_item);

        String[] columnHeaderNames_nhapHang = {"Mã SP", "Tên SP", "Tồn kho"}; // tạo column cho bảng table
        Object[][] data_nhapHang = {
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {}
        };
        // Thiết lập kích thước cho các cột
//        TableColumnModel columnModel = jTable_nhapHang.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(150); // Cột "Mã SP"
//        columnModel.getColumn(1).setPreferredWidth(320);  // Cột "Tên SP"
//        columnModel.getColumn(2).setPreferredWidth(150); // Cột "Tồn kho"

        //--------------------------------------------------------------------------------------
        DefaultTableModel model_nhapHang = new DefaultTableModel(data_nhapHang, columnHeaderNames_nhapHang); //dùng để thêm dữ liệu vào bảng
        jTable_nhapHang.setModel(model_nhapHang);

        //Tạo JScrollPane để chứa thằng JTable
        JScrollPane jScrollPane_jTable_nhapHang = new JScrollPane(jTable_nhapHang);
        jScrollPane_jTable_nhapHang.setBounds(0, 0, 720, 490);
//---------------------------------------------------------------------------------------------
        JPanel jPanel_scroll_table = new JPanel(); //JPanel này chứa thằng JScrollPane. JScrollPane thì chứa JTable
        jPanel_scroll_table.setLayout(null);
        jPanel_scroll_table.setBounds(10, 170, 720, 460);
        jPanel_scroll_table.setBackground(Color.WHITE);
        jPanel_scroll_table.setBorder(lineBorder_viewMenu1);

        jPanel_scroll_table.add(jScrollPane_jTable_nhapHang); // add thằng JScrollPane 

        ////---ViewTable hiển thị các thông tin/ nằm trong View All Nhập Hàng
        JPanel jPanel_showTable = new JPanel();
        jPanel_showTable.setLayout(null);
        jPanel_showTable.setBounds(0, 0, 740, 700);
        jPanel_showTable.setBackground(Color.WHITE);

        jPanel_showTable.add(jLabel_khoHang);
        jPanel_showTable.add(jButton_refresh);
        jPanel_showTable.add(jLabel_timKiem);
        jPanel_showTable.add(jTextField_timKiem);
        jPanel_showTable.add(jButton_timKiem);
        jPanel_showTable.add(jPanel_scroll_table);

        ///---Các thành phần trong View Thông tin sản phẩm
        JLabel jLabel_ThongTin = new JLabel("Thông tin sản phẩm"); // Thông tin sản phẩm
        jLabel_ThongTin.setBounds(55, 10, 250, 60);
        jLabel_ThongTin.setFont(font_jLabel_viewMenu_ttsp);

        JLabel jLabel_maSP = new JLabel("Mã SP");
        jLabel_maSP.setBounds(25, 90, 50, 30);
        jLabel_maSP.setFont(font_jLabel_viewMenu_ttsp1);

        JTextField jTextField_maSP = new JTextField();
        jTextField_maSP.setBounds(85, 90, 230, 30);

        JLabel jLabel_tenSP = new JLabel("Tên SP");
        jLabel_tenSP.setBounds(25, 130, 60, 30);
        jLabel_tenSP.setFont(font_jLabel_viewMenu_ttsp1);

        JTextField jTextField_tenSP = new JTextField();
        jTextField_tenSP.setBounds(85, 130, 230, 30);

        JLabel jLabel_soLuong = new JLabel("Số lượng nhập"); // 
        jLabel_soLuong.setBounds(125, 185, 250, 30);
        jLabel_soLuong.setFont(font_jLabel_viewMenu_ttsp1);

        JTextField jTextField_soLuong = new JTextField();
        jTextField_soLuong.setBounds(60, 215, 230, 30);

        JLabel jLabel_donGia = new JLabel("Đơn giá nhập"); // 
        jLabel_donGia.setBounds(130, 255, 250, 30);
        jLabel_donGia.setFont(font_jLabel_viewMenu_ttsp1);

        JTextField jTextField_donGia = new JTextField();
        jTextField_donGia.setBounds(60, 285, 230, 30);

        JButton jButton_nhapHang = new JButton("Vào hàng chờ"); // 
        jButton_nhapHang.setBounds(100, 335, 150, 30);
        jButton_nhapHang.setBackground(new Color(0x29B6F6));
        jButton_nhapHang.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ////---View hiển thị thông tin sản phẩm/ nằm trong View All Nhập Hàng
        JPanel jPanel_showThongTinSP = new JPanel();
        jPanel_showThongTinSP.setLayout(null);
        jPanel_showThongTinSP.setBounds(740, 10, 340, 390);
        jPanel_showThongTinSP.setBackground(Color.white);
        jPanel_showThongTinSP.setBorder(lineBorder_viewMenu1);

        jPanel_showThongTinSP.add(jLabel_ThongTin);
        jPanel_showThongTinSP.add(jLabel_maSP);
        jPanel_showThongTinSP.add(jTextField_maSP);
        jPanel_showThongTinSP.add(jLabel_tenSP);
        jPanel_showThongTinSP.add(jTextField_tenSP);
        jPanel_showThongTinSP.add(jLabel_soLuong);
        jPanel_showThongTinSP.add(jTextField_soLuong);
        jPanel_showThongTinSP.add(jLabel_donGia);
        jPanel_showThongTinSP.add(jTextField_donGia);
        jPanel_showThongTinSP.add(jButton_nhapHang);

        ///---Các thành phần trong View Thông tin phiếu nhập
        JLabel jLabel_ThongTinPN = new JLabel("Thông tin phiếu nhập"); // Thông tin phiếu nhập
        jLabel_ThongTinPN.setBounds(45, 20, 260, 60);
        jLabel_ThongTinPN.setFont(font_jLabel_viewMenu_ttsp);

        JLabel jLabel_ncc = new JLabel("Nhà cung cấp"); // Nhà cung cấp
        jLabel_ncc.setBounds(15, 80, 100, 30);
        jLabel_ncc.setFont(font_jLabel_viewMenu_ttsp1);

        JTextField jTextField_ncc = new JTextField();
        jTextField_ncc.setBounds(15, 110, 310, 30);

        JLabel jLabel_nv = new JLabel("Người nhập"); // Người đứng ra nhập hàng về cho cửa hàng
        jLabel_nv.setBounds(15, 160, 100, 30);
        jLabel_nv.setFont(font_jLabel_viewMenu_ttsp1);

        JTextField jTextField_nv = new JTextField();
        jTextField_nv.setBounds(15, 190, 310, 30);

        ////---View hiển thị thông tin phiếu nhập/ nằm trong View All Nhập Hàng
        JPanel jPanel_showThongTinPN = new JPanel();
        jPanel_showThongTinPN.setLayout(null);
        jPanel_showThongTinPN.setBounds(740, 400, 340, 300);
        jPanel_showThongTinPN.setBackground(Color.WHITE);
        jPanel_showThongTinPN.setBorder(lineBorder_viewMenu1);

        jPanel_showThongTinPN.add(jLabel_ThongTinPN);
        jPanel_showThongTinPN.add(jLabel_ncc);
        jPanel_showThongTinPN.add(jTextField_ncc);
        jPanel_showThongTinPN.add(jLabel_nv);
        jPanel_showThongTinPN.add(jTextField_nv);

        ////---View hiển thị thông tin table/ nằm trong View All Nhập Hàng
        /////---View All phần Nhập hàng
        jPanel_nh = new JPanel(); //phần view của nút "Nhập hàng"\
        jPanel_nh.setLayout(null);
        jPanel_nh.setBounds(0, 30, 1080, 700);
        jPanel_nh.setBackground(Color.WHITE);

        jPanel_nh.add(jPanel_showTable);
        jPanel_nh.add(jPanel_showThongTinSP);
        jPanel_nh.add(jPanel_showThongTinPN);

        //*********//
        jPanel_nh.setVisible(true);

//----------------------------------------------------------------------------------------------- 
        ///---Các thành phần trong "Quản lý phiếu nhập"
        //--- View Phiếu nhập/ là thành phần của JPanel_pn
        JLabel jLabel_phieuNhap = new JLabel("Phiếu nhập"); // Phiếu nhập
        jLabel_phieuNhap.setBounds(105, 10, 190, 60);
        jLabel_phieuNhap.setFont(font_jLabel_viewMenu_ttsp);

        JButton jButton_refresh_pn = new JButton(icon_refresh); // nút refresh
        jButton_refresh_pn.setBounds(250, 23, 40, 40);
        jButton_refresh_pn.setBackground(new Color(0x29B6F6));
        jButton_refresh_pn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton_refresh_pn.setOpaque(true);

        //---Panel_table/ nằm trong Panel_pn
        JTable jTable_phieuNhap = new JTable();

        String[] columnHeader_phieuNhap = {"Mã SP", "Tên SP", "Tồn kho"}; //tạo column cho bảng phiếu nhập
        Object[][] data_phieuNhap = {
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {}
        };
        DefaultTableModel model_phieuNhap = new DefaultTableModel(data_phieuNhap, columnHeader_phieuNhap);
        jTable_phieuNhap.setModel(model_phieuNhap);
        //Tạo JScrollPane để chứa thằng JTable
        JScrollPane jScrollPane_jTable_phieuNhap = new JScrollPane(jTable_phieuNhap);
        jScrollPane_jTable_phieuNhap.setBounds(0, 0, 390, 200);
        //lấy đối tượng jtableheader từ jtable để đổi màu nền, màu chữ, font chữ
        JTableHeader tableHeader_phieuNhap = jTable_phieuNhap.getTableHeader();
        tableHeader_phieuNhap.setBackground(new Color(0x29B6F6));
        tableHeader_phieuNhap.setFont(font_menu_item);

        //-------------------------------------
        jPanel_table_pn = new JPanel(); // chứa bảng ScrollPane và chứa bảng table
        jPanel_table_pn.setLayout(null);
        jPanel_table_pn.setBounds(5, 90, 390, 170);
        jPanel_table_pn.setBorder(lineBorder_viewMenu1);
        jPanel_table_pn.setBackground(Color.white);

        jPanel_table_pn.add(jScrollPane_jTable_phieuNhap);

        //---Các thành phần trong jPanel_tt --- thông tin phiếu nhập
        JLabel jLabel_maPN = new JLabel("Mã phiếu nhập");
        jLabel_maPN.setBounds(35, 5, 120, 30);
        jLabel_maPN.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_maPN = new JTextField(); //Mã phiếu nhập
        jTextField_maPN.setBounds(35, 35, 140, 30);
        jTextField_maPN.setBorder(lineBorder_viewMenu1);

        JLabel jLabel_maNCC = new JLabel("Mã nhà cung cấp"); //Mã NCC
        jLabel_maNCC.setBounds(205, 5, 140, 30);
        jLabel_maNCC.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_maNCC = new JTextField(); //Mã NV
        jTextField_maNCC.setBounds(205, 35, 140, 30);
        jTextField_maNCC.setBorder(lineBorder_viewMenu1);
//---
        JLabel jLabel_maNV = new JLabel("Mã nhân viên");
        jLabel_maNV.setBounds(35, 75, 90, 30);
        jLabel_maNV.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_maNV = new JTextField();
        jTextField_maNV.setBounds(35, 105, 140, 30);
        jTextField_maNV.setBorder(lineBorder_viewMenu1);

        JLabel jLabel_ngayLap = new JLabel("Ngày lập"); //Ngày lập
        jLabel_ngayLap.setBounds(205, 75, 110, 30);
        jLabel_ngayLap.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_ngayLap = new JTextField();
        jTextField_ngayLap.setBounds(205, 105, 140, 30);
        jTextField_ngayLap.setBorder(lineBorder_viewMenu1);

        JLabel jLabel_tongTien = new JLabel("Tổng tiền"); //Tổng tiền
        jLabel_tongTien.setBounds(35, 145, 110, 30);
        jLabel_tongTien.setFont(font_jLabel_viewMenu_ttsp1);

        jTextField_tongTien = new JTextField();
        jTextField_tongTien.setBounds(35, 175, 140, 30);
        jTextField_tongTien.setBorder(lineBorder_viewMenu1);

        JButton jButton_icon_delete = new JButton("Xóa", icon_delete);
        jButton_icon_delete.setBounds(5, 5, 135, 35);
        jButton_icon_delete.setBackground(new Color(0xE0E0E0));
        jButton_icon_delete.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel jPanel_delete = new JPanel();
        jPanel_delete.setLayout(null);
        jPanel_delete.setBounds(205, 165, 145, 45);
        jPanel_delete.setBorder(lineBorder_viewMenu1);
        jPanel_delete.setBackground(Color.WHITE);

        jPanel_delete.add(jButton_icon_delete);

        JPanel jPanel_tt = new JPanel(); // chứa các thông tin của phiếu nhập/ là con của panel_pn
        jPanel_tt.setLayout(null);
        jPanel_tt.setBackground(Color.white);
        jPanel_tt.setBounds(5, 60, 380, 220);
        jPanel_tt.setBorder(lineBorder_viewMenu1);

        jPanel_tt.add(jLabel_maPN);
        jPanel_tt.add(jTextField_maPN);
        jPanel_tt.add(jLabel_maNCC);
        jPanel_tt.add(jTextField_maNCC);
        jPanel_tt.add(jLabel_maNV);
        jPanel_tt.add(jTextField_maNV);
        jPanel_tt.add(jLabel_ngayLap);
        jPanel_tt.add(jTextField_ngayLap);
        jPanel_tt.add(jLabel_tongTien);
        jPanel_tt.add(jTextField_tongTien);
        jPanel_tt.add(jPanel_delete);

        JLabel jLabel_thongTinPhieuNhap = new JLabel("Thông tin phiếu nhập"); // Thông tin phiếu nhập
        jLabel_thongTinPhieuNhap.setBounds(65, 0, 270, 60);
        jLabel_thongTinPhieuNhap.setFont(font_jLabel_viewMenu_ttsp);

      //----------------Thông tin phiếu nhập---------------------------
        JPanel jPanel_ttpn = new JPanel(); //Panel chứa các thông tin phiếu nhập
        jPanel_ttpn.setLayout(null);
        jPanel_ttpn.setBounds(5, 270, 390, 390);
        jPanel_ttpn.setBorder(lineBorder_viewMenu1);
        jPanel_ttpn.setBackground(Color.white);

        jPanel_ttpn.add(jPanel_tt);
        jPanel_ttpn.add(jLabel_thongTinPhieuNhap);

        //------------------Phiếu nhập------Con của View chính---------------
        JPanel jPanel_pn = new JPanel(); //Phiếu nhập
        jPanel_pn.setLayout(null);
        jPanel_pn.setBounds(5, 5, 400, 700);
        jPanel_pn.setBorder(lineBorder_viewMenu1);
        jPanel_pn.setBackground(Color.white);

        jPanel_pn.add(jLabel_phieuNhap);
        jPanel_pn.add(jButton_refresh_pn);
        jPanel_pn.add(jPanel_ttpn);
        jPanel_pn.add(jPanel_table_pn);

        //----------Chi tiết phiếu nhập-----con của View chính
        ///---Các thành phần trong Chi tiết phiếu nhập---
        JLabel jLabel_chiTietPN = new JLabel("Chi tiết phiếu nhập"); // tiêu đề
        jLabel_chiTietPN.setBounds(170, 20, 380, 50);
        jLabel_chiTietPN.setFont(font_jLabel_viewMenu_table);

        JLabel jLabel_ctSanPham = new JLabel("Sản phẩm"); // chi tiết Sản phẩm
        jLabel_ctSanPham.setBounds(110, 95, 90, 30);
        jLabel_ctSanPham.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctSanPham = new JTextField();
        jTextField_ctSanPham.setBounds(110, 125, 200, 30);
        jTextField_ctSanPham.setBorder(lineBorder_viewMenu1);

        JLabel jLabel_ctSoLuong = new JLabel("Số lượng"); // chi tiết Số lượng
        jLabel_ctSoLuong.setBounds(370, 95, 90, 30);
        jLabel_ctSoLuong.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctSoLuong = new JTextField();
        jTextField_ctSoLuong.setBounds(370, 125, 200, 30);
        jTextField_ctSoLuong.setBorder(lineBorder_viewMenu1);

        JLabel jLabel_ctDonGia = new JLabel("Đơn giá"); // chi tiết Đơn giá
        jLabel_ctDonGia.setBounds(110, 175, 90, 30);
        jLabel_ctDonGia.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctDonGia = new JTextField();
        jTextField_ctDonGia.setBounds(110, 205, 200, 30);
        jTextField_ctDonGia.setBorder(lineBorder_viewMenu1);

        JLabel jLabel_ctThanhTien = new JLabel("Thành tiền"); // chi tiết Thành tiền
        jLabel_ctThanhTien.setBounds(370, 175, 90, 30);
        jLabel_ctThanhTien.setFont(font_jLabel_viewMenu_ttsp1);
        jTextField_ctThanhTien = new JTextField();
        jTextField_ctThanhTien.setBounds(370, 205, 200, 30);
        jTextField_ctThanhTien.setBorder(lineBorder_viewMenu1);

        //-----------------------------------------------------------
        JPanel jPanel_chiTietPN = new JPanel(); // chứa thông tin chi tiết phiếu nhập
        jPanel_chiTietPN.setLayout(null);
        jPanel_chiTietPN.setBounds(0, 0, 680, 260);
        jPanel_chiTietPN.setBackground(Color.white);

        jPanel_chiTietPN.add(jLabel_chiTietPN);
        jPanel_chiTietPN.add(jLabel_ctSanPham);
        jPanel_chiTietPN.add(jTextField_ctSanPham);
        jPanel_chiTietPN.add(jLabel_ctSoLuong);
        jPanel_chiTietPN.add(jTextField_ctSoLuong);
        jPanel_chiTietPN.add(jLabel_ctDonGia);
        jPanel_chiTietPN.add(jTextField_ctDonGia);
        jPanel_chiTietPN.add(jLabel_ctThanhTien);
        jPanel_chiTietPN.add(jTextField_ctThanhTien);

        //--------------------------------------------------------------
        //nằm trong jPanel_jTable_chiTietPN
        JTable jTable_ctPhieuNhap = new JTable();

        String[] columnHeader_ctPhieuNhap = {"Mã SP", "Số lượng", "Đơn giá", "Thành tiền"}; //tạo column cho bảng 
        Object[][] data_ctPhieuNhap = {
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {}
        };
        DefaultTableModel model_ctPhieuNhap = new DefaultTableModel(data_ctPhieuNhap, columnHeader_ctPhieuNhap);
        jTable_ctPhieuNhap.setModel(model_ctPhieuNhap);
        //Tạo JScrollPane để chứa thằng JTable
        JScrollPane jScrollPane_jTable_ctPhieuNhap = new JScrollPane(jTable_ctPhieuNhap);
        jScrollPane_jTable_ctPhieuNhap.setBounds(0, 0, 665, 380);
        //lấy đối tượng jtableheader từ jtable để đổi màu nền, màu chữ, font chữ
        JTableHeader tableHeader_ctPhieuNhap = jTable_ctPhieuNhap.getTableHeader();
        tableHeader_ctPhieuNhap.setBackground(new Color(0x29B6F6));
        tableHeader_ctPhieuNhap.setFont(font_menu_item);

        JPanel jPanel_jTable_chiTietPN = new JPanel(); // chứa bảng table
        jPanel_jTable_chiTietPN.setLayout(null);
        jPanel_jTable_chiTietPN.setBounds(5, 275, 665, 380);
        jPanel_jTable_chiTietPN.setBorder(lineBorder_viewMenu1);
        jPanel_jTable_chiTietPN.setBackground(Color.white);

        jPanel_jTable_chiTietPN.add(jScrollPane_jTable_ctPhieuNhap);

        JPanel jPanel_ctpn = new JPanel(); //Chi tiết phiếu nhập
        jPanel_ctpn.setLayout(null);
        jPanel_ctpn.setBounds(405, 5, 680, 700);
        jPanel_ctpn.setBorder(lineBorder_viewMenu1);
        jPanel_ctpn.setBackground(Color.white);

        jPanel_ctpn.add(jPanel_chiTietPN);
        jPanel_ctpn.add(jPanel_jTable_chiTietPN);

        /////---View All phần "Quản lý phiếu nhập"--- View chính-------------------------------------
        jPanel_qlpn = new JPanel();
        jPanel_qlpn.setLayout(null);
        jPanel_qlpn.setBounds(0, 30, 1080, 700);
        jPanel_qlpn.setBackground(Color.WHITE);

        jPanel_qlpn.add(jPanel_pn);
        jPanel_qlpn.add(jPanel_ctpn);

        jPanel_qlpn.setVisible(false);
       

        this.add(jPanel_menu_head);
        this.add(jPanel_nh);
        this.add(jPanel_qlpn);

		this.setBackground(Color.white);
		this.setVisible(true);
	}
	//-------------------------------------ViewMenu------------------------------------------
    //Nhấp chuột

    public void mousePressed_jLabel_qlpn() { //Sự kiện khi nhấp chuột vào "Quản lý phiếu nhập"
        jPanel_nh.setVisible(false);       
        jPanel_qlpn.setVisible(true);
        jLabel_qlpn.setOpaque(true);
        jLabel_qlpn.setBackground(Color.white);
        jLabel_nh.setOpaque(true);
        jLabel_nh.setBackground(new Color(0xE0E0E0));
    }

    public void mousePressed_jLabel_nh() { //Sự kiện khi nhấp chuột vào "Nhập hàng"
        jPanel_nh.setVisible(true);
        jPanel_qlpn.setVisible(false);
        jLabel_qlpn.setOpaque(true);
        jLabel_qlpn.setBackground(new Color(0xE0E0E0));
        jLabel_nh.setOpaque(true);
        jLabel_nh.setBackground(Color.WHITE);

    }
    public void addEvent()
    {
        jLabel_nh.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                 mousePressed_jLabel_nh();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        jLabel_qlpn.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
             
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed_jLabel_qlpn();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }

}

