/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import DTO.MatHangDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatHangDAO implements DaoInterface<MatHangDTO>{
    
    public static MatHangDAO getInstance() {
		return new MatHangDAO();
	}
    @Override
    public int them(MatHangDTO t) {
        int result =0;
        try {
            Connection con =(Connection) new MySQLConnect().getConnection();
            String sql="INSERT INTO mat_hang VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep =con.prepareStatement(sql);
           prep.setString(1, t.getMaMh());
           prep.setString(2,t.getTenMh());
           prep.setDouble(3,t.getGiaMua());
           prep.setDouble(4,t.getGiaBan());
           prep.setDate(5,t.getDatengsx());
           prep.setDate(6,t.getDatehsd());
           prep.setDouble(7, t.getSlNhap());
           prep.setDouble(8, t.getSlBan());
           prep.setDate(9,t.getDatengaynhap());
           prep.setDouble(10, t.getVat());
           prep.setString(11,t.getMaLH());
           prep.setString(12,t.getMaDVT());
           prep.setString(13,t.getImg());
           result= prep.executeUpdate() ;
           if(result >0)
               result=1; 
           else 
               result=0;
           MySQLConnect.closeConnection(con);
        }catch(Exception ex)
        {
            return 0;
        }
        return result;
    }

    @Override
    public int capNhap(MatHangDTO t) {
        int result =0;
        try {
            Connection con =(Connection) new MySQLConnect().getConnection();
            String sql="UPDATE mat_hang SET TEN=?,GIAMUA=?,GIABAN=?,NGAYSX=?,HAN_SU_DUNG=?,SL_NHAP=?,SL_BAN=?,NGAY_NHAP=?,VAT=?,MA_LH=?,MA_DVT=?,img=? WHERE MA_MH=?";
            PreparedStatement prep =con.prepareStatement(sql);
           prep.setString(1, t.getMaMh());
           prep.setString(2,t.getTenMh());
           prep.setDouble(3,t.getGiaMua());
           prep.setDouble(4,t.getGiaBan());
           prep.setDate(5,t.getDatengsx());
           prep.setDate(6,t.getDatehsd());
           prep.setDouble(7, t.getSlNhap());
           prep.setDouble(8, t.getSlBan());
           prep.setDate(9,t.getDatengaynhap());
           prep.setDouble(10, t.getVat());
           prep.setString(11,t.getMaLH());
           prep.setString(12,t.getMaDVT());
           prep.setString(13,t.getImg());
           result= prep.executeUpdate() ;
           if(result >0)
               result=1; 
           else 
               result=0;
        }catch(Exception ex)
        {
            return 0;
        }
        return result;
    }

    @Override
    public int xoa(MatHangDTO t) {
         int result= 0;
        try {
            Connection con=(Connection) new MySQLConnect().getConnection();
            String sql="DELETE FROM mat_hang WHERE MA_MH=?";
             PreparedStatement prep = con.prepareStatement(sql);
        prep.setString(1, t.getMaMh());
        result = prep.executeUpdate();
        if (result > 0) {
            result = 1;
        } else {
            result = 0;
        }
        MySQLConnect.closeConnection(con);
    } catch (SQLException ex) {
        return 0;
    }
        return result;
    }

    @Override
    public ArrayList<MatHangDTO> selectAll() {
        
        try {
        	Connection con=new MySQLConnect().getConnection();
                ArrayList<MatHangDTO> listsp = new ArrayList<>();
            String sql = "SELECT * FROM mat_hang";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	MatHangDTO sp = new MatHangDTO();
            	sp.setMaMh(rs.getString(1));
            	sp.setTenMh(rs.getString(2));
            	sp.setGiaMua(rs.getDouble(3));
            	sp.setGiaBan(rs.getDouble(4));
            	java.sql.Date ngaysx=rs.getDate(5);
            	sp.setDatehsd(rs.getDate(6));
            	sp.setSlNhap(rs.getInt(7));
            	sp.setSlBan(rs.getInt(8));
            	sp.setDatengaynhap(rs.getDate(9));
            	sp.setVat(rs.getInt(10));
            	sp.setMaLH(rs.getString(11));
            	sp.setMaDVT(rs.getString(12));
                sp.setImg(rs.getString(13));
                listsp.add(sp);
            }
            MySQLConnect.closeConnection(con);
               return listsp;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	System.out.println("thất bại");
            return null;        
        }
        
    }

    @Override
    public MatHangDTO selectById(MatHangDTO v) {
        MatHangDTO mh= null;
        try {
            Connection con =(Connection) new MySQLConnect().getConnection();
            String sql = "SELECT * FROM mat_hang WHERE Ma_MH='"+v.getMaMh()+"'" ;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                mh = new MatHangDTO();
                mh.setMaMh(rs.getString(1));
            	mh.setTenMh(rs.getString(2));
            	mh.setGiaMua(rs.getDouble(3));
            	mh.setGiaBan(rs.getDouble(4));
            	mh.setDatengsx(rs.getDate(5));
            	mh.setDatehsd(rs.getDate(6));
            	mh.setSlNhap(rs.getInt(7));
            	mh.setSlBan(rs.getInt(8));
            	mh.setDatengaynhap(rs.getDate(9));
            	mh.setVat(rs.getInt(10));
            	mh.setMaLH(rs.getString(11));
            	mh.setMaDVT(rs.getString(12));
                mh.setImg(rs.getString(13));
            }
        MySQLConnect.closeConnection(con);
        }catch(Exception ex)
        {
            return null;
        }
        return mh;
    }

    @Override
    public ArrayList<MatHangDTO> selectBy(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

   

    

}
