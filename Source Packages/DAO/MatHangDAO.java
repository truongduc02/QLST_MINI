/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
  
    @Override
    public int them(MatHangDTO t) {
        int result =0;
        try {
            Connection con =(Connection) new MySQLConnect().getConnection();
            
        }catch(Exception ex)
        {
            return 0;
        }
        return result;
    }

    @Override
    public int capNhap(MatHangDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int xoa(MatHangDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MatHangDTO> selectAll() {
        ArrayList<MatHangDTO> listsp = new ArrayList<>();
        try {
        	Connection con=new MySQLConnect().getConnection();
            String sql = "SELECT * FROM mat_hang";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	MatHangDTO sp = new MatHangDTO();
            	sp.setMaMh(rs.getString(1));
            	sp.setTenMh(rs.getString(2));
            	sp.setGiaMua(rs.getDouble(3));
            	sp.setGiaBan(rs.getDouble(4));
            	sp.setDatengsx(rs.getDate(5));
            	sp.setDatehsd(rs.getDate(6));
            	sp.setSlNhap(rs.getInt(7));
            	sp.setSlBan(rs.getInt(8));
            	sp.setDatengaynhap(rs.getDate(9));
            	sp.setVat(rs.getInt(10));
            	sp.setMaLH(rs.getString(11));
            	sp.setMaDVT(rs.getString(12));
                listsp.add(sp);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
        	System.out.println("thất bại");
            return null;
            
        }
		return listsp;
    }

    @Override
    public MatHangDTO selectById() {
        MatHangDTO mh= null;
        try {
            Connection con =(Connection) new MySQLConnect().getConnection();
            String sql = "SELECT * FROM mat_hang WHERE Ma_MH='"+mh.getMaMh()+"'" ;
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
