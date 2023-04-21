/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class NhanVienDAO {
    private  MySQLConnect mySQL = new MySQLConnect();
    public NhanVienDAO()
    {
        
    }
//    public ArrayList<NhanVienDTO>list()
//    {
//        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
//        try{
//            String sql = "SELECT * FROM nhan_vien WHERE enable=1";
//            ResultSet rs= mySQL.executeQuery(sql);
//            while(rs.next())
//            {
//                String MaNv=rs.getString("MA_NV");
//                String HoTenNv= rs.getString("HO_TEN");
//                String NgaySinh=rs.getString("NGAY_SINH");
//                String Phai=rs.getString("PHAI");
//                String CMND= rs.getString("CMND");
//                String Diachi=rs.getString("DIACHI");
//                String Dienthoai=rs.getString("DIENTHOAI");
//                String Ngayvaolam=rs.getString("NGAY_VAO_LAM");
//                String MaCV= rs.getString("MA_CV");
//                
//                NhanVienDTO nv= new NhanVienDTO(MaNv,HoTenNv,NgaySinh,Phai,CMND,Diachi,Dienthoai,Ngayvaolam,MaCV);
//                dsnv.add(nv);
//            }
//            rs.close();
//            mySQL.disConnect();
//        }catch(SQLException ex)
//        {
//            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE,null,ex);
//        }
//        return dsnv;
//    }
//    public void set (NhanVienDTO nv)
//    {
//        MySQLConnect mySQL= new MySQLConnect();
//        String sql= "UPDATE nhan_vien SET ";
//        sql += "MA_NV='"+nv.getManv()+"', ";
//        sql += "HO_TEN='"+nv.getHoTen()+"', ";
//        sql += "NGAY_SINH='"+nv.getNgaySinh()+"', ";
//        sql += "PHAI='"+nv.getPhai()+"', ";
//        sql += "CMND='"+nv.getCCCD()+"', ";
//        sql += "DIA_CHI='"+nv.getDiachi()+"', ";
//        sql += "DIENTHOAI='"+nv.getDienThoai()+"', ";
//        sql += "NGAY_VAO_LAM='"+nv.getNgayVaoLam()+"', ";
//        sql += "MA_CV='"+nv.getMaCV()+"', ";
//        System.out.println(sql);
//        
//        mySQL.executeQuery(sql);
//    }
//    public void add(NhanVienDTO nv)
//    {
//        MySQLConnect mySQL= new MySQLConnect();
//        String sql= "INSERT INTO nhan_vien VALUES (";
//                sql += "'"+nv.getManv()+"',";
//                sql += "'"+nv.getHoTen()+"',";
//                sql += "'"+nv.getNgaySinh()+"',";
//                sql += "'"+nv.getPhai()+"',";
//                sql += "'"+nv.getCCCD()+"',";
//                sql += "'"+nv.getDiachi()+"',";
//                sql += "'"+nv.getNgayVaoLam()+"',";
//                sql += "'"+nv.getMaCV()+"',";
//                sql += "'1')";
//         System.out.println(sql);
//         mySQL.executeUpdate(sql);
//    }
//    public void delele(String MaNV)
//    {
//        MySQLConnect MySQL= new MySQLConnect();
//        String sql= "UPDATE nhan_vien set enable=0 WHERE MA_NV='"+MaNV+"'";
//        MySQL.executeUpdate(sql);
//        System.out.println(sql);
//    }
    
}
