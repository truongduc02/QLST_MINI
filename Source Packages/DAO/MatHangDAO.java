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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
           prep.setTimestamp(5, new java.sql.Timestamp(t.getNgaySX().getTime()));
           prep.setTimestamp(6, new java.sql.Timestamp(t.getHsd().getTime()));
           prep.setDouble(7, t.getSlNhap());
           prep.setDouble(8, t.getSlBan());
           prep.setTimestamp(9, new java.sql.Timestamp(t.getNgayNhap().getTime()));
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
            String sql="UPDATE mat_hang SET TEN=?,GIAMUA=?,GIABAN=?,NGAY_SX=?,HAN_SU_DUNG=?,SL_NHAP=?,SL_BAN=?,NGAY_NHAP=?,VAT=?,MA_LH=?,MA_DVT=?,img=? WHERE MA_MH=?";
            PreparedStatement prep =con.prepareStatement(sql);
           
           prep.setString(1,t.getTenMh());
           prep.setDouble(2,t.getGiaMua());
           prep.setDouble(3,t.getGiaBan());
           prep.setTimestamp(4, new java.sql.Timestamp(t.getNgaySX().getTime()));
           prep.setTimestamp(5, new java.sql.Timestamp(t.getHsd().getTime()));
           prep.setDouble(6, t.getSlNhap());
           prep.setDouble(7, t.getSlBan());
           prep.setTimestamp(8, new java.sql.Timestamp(t.getNgayNhap().getTime()));
           prep.setDouble(9, t.getVat());
           prep.setString(10,t.getMaLH());
           prep.setString(11,t.getMaDVT());
           prep.setString(12,t.getImg());
           prep.setString(13, t.getMaMh());
           result= prep.executeUpdate() ;
           if(result >0)
               result=1; 
           else 
               result=0;
           MySQLConnect.closeConnection(con);
        }catch(Exception ex)
        {
            ex.printStackTrace();
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
            	sp.setNgaySX(rs.getDate(5));
            	sp.setHsd(rs.getDate(6));
            	sp.setSlNhap(rs.getInt(7));
            	sp.setSlBan(rs.getInt(8));
            	sp.setNgayNhap(rs.getDate(9));
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
            	mh.setNgaySX(rs.getDate(5));
            	mh.setHsd(rs.getDate(6));
            	mh.setSlNhap(rs.getInt(7));
            	mh.setSlBan(rs.getInt(8));
            	mh.setNgayNhap(rs.getDate(9));
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
    public String getAnh(String ma)
    {
        try{
            String sql="SELECT img FROM mat_hang WHERE MA_MH=? ";
            PreparedStatement pre= MySQLConnect.getConnection().prepareStatement(sql);
            pre.setString(1,ma);
            ResultSet rs= pre.executeQuery();
            if(rs.next()){
                return rs.getString("img");
            }
            
        }catch(Exception e)
        {
            
        }
        return "";
    }
    public void xuatfile()
    {
         try{
             Connection con =(Connection) new MySQLConnect().getConnection();
            String sql = "SELECT * FROM mat_hang";
              Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("mat_hang_db");
            
                    
            XSSFFont font = workbook.createFont();
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
        
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFont(font);
            
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell;
            
            cell = row.createCell(0);
            cell.setCellValue("MA_MH");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("TEN");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("GIAMUA");
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue("GIABAN");
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue("NGAY_SX");
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue("HAN_SU_DUNG");
            cell.setCellStyle(style);
            cell = row.createCell(6);
            cell.setCellValue("SL_NHAP");
            cell.setCellStyle(style);
            cell = row.createCell(7);
            cell.setCellValue("SL_BAN");
            cell.setCellStyle(style);
            cell = row.createCell(8);
            cell.setCellValue("NGAY_NHAP");
            cell.setCellStyle(style);
            cell = row.createCell(9);
            cell.setCellValue("VAT");
            cell.setCellStyle(style);
            cell = row.createCell(10);
            cell.setCellValue("MA_LH");
            cell.setCellStyle(style);
            cell = row.createCell(11);
            cell.setCellValue("MA_DVT");
            cell.setCellStyle(style);
            cell = row.createCell(12);
            cell.setCellValue("img");
            cell.setCellStyle(style);
            int i = 1;
        
        while(rs.next()){
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(rs.getString("MA_MH"));
            cell = row.createCell(1);
            cell.setCellValue(rs.getString("TEN"));
            cell = row.createCell(2);
            cell.setCellValue(rs.getDouble("GIAMUA"));
            cell = row.createCell(3);
            cell.setCellValue(rs.getDouble("GIABAN"));
            cell = row.createCell(4);
            cell.setCellValue(rs.getDate("NGAY_SX").toString());
            cell = row.createCell(5);
            cell.setCellValue(rs.getDate("HAN_SU_DUNG").toString());
            cell = row.createCell(6);
            cell.setCellValue(rs.getDouble("SL_NHAP"));
            cell = row.createCell(7);
            cell.setCellValue(rs.getDouble("SL_BAN"));
            cell = row.createCell(8);
            cell.setCellValue(rs.getDate("NGAY_NHAP").toString());
            cell = row.createCell(9);
            cell.setCellValue(rs.getDouble("VAT"));
            cell = row.createCell(10);
            cell.setCellValue(rs.getString("MA_LH"));
            cell = row.createCell(11);
            cell.setCellValue(rs.getString("MA_DVT"));
            cell = row.createCell(12);
            cell.setCellValue(rs.getString("img"));
            
            i++;
        }
        
        for(int colNum = 0;colNum < row.getLastCellNum();colNum++) {
            sheet.autoSizeColumn((short) (colNum));
        }
        
        FileOutputStream out = new FileOutputStream(new File("./report/mat_hang_db.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Xuat file thanh cong");
        
        MySQLConnect.closeConnection(con);
        
        } catch (SQLException ex) {
            Logger.getLogger(MatHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void nhapfile(File file)
    {
        try{
            Connection con =(Connection) new MySQLConnect().getConnection();
            FileInputStream in = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row;
            for(int i = 1; i <= sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);
                String maSP = row.getCell(0).getStringCellValue();
                String tenSP = row.getCell(1).getStringCellValue();
                double giamua = (double) row.getCell(2).getNumericCellValue();
                double giaban = (double) row.getCell(3).getNumericCellValue();
                //Date ngaysx = row.getCell(4).getDateCellValue();
                Date ngaysx = row.getCell(4).getDateCellValue();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String ngaysxStr = sdf.format(ngaysx);
                Date hansudung = (Date)row.getCell(5).getDateCellValue();
                String hansudungStr=sdf.format(hansudung);
                double slnhap =(double) row.getCell(6).getNumericCellValue();
                double slban =(double) row.getCell(7).getNumericCellValue();
                Date ngaynhap = (Date)row.getCell(8).getDateCellValue();
                String ngaynhapStr= sdf.format(ngaynhap);
                double vat =(double) row.getCell(9).getNumericCellValue();
                String malh = row.getCell(10).getStringCellValue();
                String madvt = row.getCell(11).getStringCellValue();
                String img = row.getCell(12).getStringCellValue();
                
                String sql_check = "SELECT * FROM mat_hang WHERE MA_MH='"+maSP+"'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql_check);
                if(!rs.next()){
                    String sql = "INSERT INTO mat_hang VALUES (";
                    sql += "'"+maSP+"',";
                    sql += "N'"+tenSP+"',";
                    sql += "'"+giamua+"',";
                    sql += "'"+giaban+"',";
                    sql += "'"+ngaysxStr+"',";
                    sql += "'"+hansudungStr+"',";
                    sql += "'"+slnhap+"',";
                    sql += "'"+slban+"',";
                    sql += "'"+ngaynhapStr+"',";
                    sql += "'"+vat+"',";
                    sql += "'"+malh+"',";
                    sql += "'"+madvt+"',";
                    sql += "'"+img+"')";
                    System.out.println(sql);
                    stmt.executeUpdate(sql);
                }
                else{
                    String sql = "UPDATE mat_hang SET ";
                    sql += "TEN='"+tenSP+"', ";
                    sql += "GIAMUA='"+giamua+"', ";
                    sql += "GIABAN='"+giaban+"', ";
                    sql += "NGAY_SX='"+ngaysxStr+"', ";
                    sql += "HAN_SU_DUNG='"+hansudungStr+"', ";
                    sql += "SL_NHAP='"+slnhap+"', ";
                    sql += "SL_BAN='"+slban+"', ";
                    sql += "NGAY_NHAP='"+ngaynhapStr+"', ";
                    sql += "VAT='"+vat+"', ";
                    sql += "MA_LH='"+malh+"' ,";
                    sql += "MA_DVT='"+madvt+"', ";
                    sql += "img='"+img+"' ";
                    sql += "WHERE MA_MH='"+maSP+"'";
                    System.out.println(sql);    
                    stmt.executeUpdate(sql);
                }
            }
            in.close();
            MySQLConnect.closeConnection(con);
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(MatHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
