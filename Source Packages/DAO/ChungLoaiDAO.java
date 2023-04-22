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
import DTO.ChungLoaiDTO;
import DTO.DonViDTO;
import java.sql.Connection;

public class ChungLoaiDAO implements DaoInterface<ChungLoaiDTO> {

    public static ChungLoaiDAO getIntance()
    {
        return new ChungLoaiDAO();
    }   
    @Override
    public int them(ChungLoaiDTO t) {
         int result=0; 
        try{
            Connection con= (Connection) new MySQLConnect().getConnection();
            String sql="INSERT INTO chung_loai VALUES (?,?)";
            PreparedStatement prep= con.prepareStatement(sql);
            prep.setString(1,t.getMaLoai());
            prep.setString(2,t.getTenLoai());
            result=prep.executeUpdate();
            if(result>0)
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
    public int capNhap(ChungLoaiDTO t) {
        int result=0; 
        try{
            Connection con= (Connection) new MySQLConnect().getConnection();
            String sql="UPDATE chung_loai SET TEN=? WHERE MA_CL=?";
            PreparedStatement prep= con.prepareStatement(sql);
            prep.setString(1,t.getMaLoai());
            prep.setString(2,t.getTenLoai());
            result=prep.executeUpdate();
            if(result>0)
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
    public int xoa(ChungLoaiDTO t) {
        int result=0; 
        try{
            Connection con = (Connection) new MySQLConnect().getConnection();
            String sql=" DELETE FROM chung_loai WHERE MA_CL=?";
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setString(1,t.getMaLoai());
            prep.setString(2,t.getTenLoai());
            result = prep.executeUpdate();
             if (result > 0) {
            result = 1;
        } else {
            result = 0;
        }
        }catch(SQLException ex)
        {
            return 0;
        }
        return result;
    }

    @Override
    public ArrayList<ChungLoaiDTO> selectAll() {
        ArrayList<ChungLoaiDTO> listcl = new ArrayList<>();
        try {
        	Connection con=new MySQLConnect().getConnection();
            String sql = "SELECT * FROM chung_loai";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	ChungLoaiDTO cl = new ChungLoaiDTO();
            	cl.setMaLoai(rs.getString(1));
            	cl.setTenLoai(rs.getString(2));
                listcl.add(cl);
            }
        } catch (SQLException ex) {
        	ex.printStackTrace();
            return null;
            
        }
		return listcl;
    }

    @Override
    public ChungLoaiDTO selectById(ChungLoaiDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ChungLoaiDTO> selectBy(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
