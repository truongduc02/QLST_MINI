/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MatHangDAO;
import DTO.MatHangDTO;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class MatHangBUS {
    private MatHangDAO mathangdao= new MatHangDAO();
    private ArrayList<MatHangDTO> listMatHang= new ArrayList<>();
    public static MatHangBUS getInstance() {
		return new MatHangBUS();
	}
    public ArrayList<MatHangDTO> getList()
    {
        return MatHangDAO.getInstance().selectAll();
    }
    public String getAnh(String ma)
    {
        return mathangdao.getAnh(ma);
    }
    
    public void add(MatHangDTO mh)
    {
        MatHangDAO.getInstance().them(mh);
    }
    public void capnhat(MatHangDTO mh)
    {
        MatHangDAO.getInstance().capNhap(mh);
    }
    public MatHangDTO getById(MatHangDTO mh)
    {
        return mathangdao.selectById(mh);
    }
    public boolean delete(MatHangDTO mh)
    {
        if (mh.getMaMh().trim().equals("")) {
            JOptionPane.showMessageDialog(null,"Chưa chọn mặt hàng để xóa","ERROR_MESSAGE",1);
            return false;
        }
        if (mathangdao.xoa(mh)==1) {
            JOptionPane.showMessageDialog(null,"Xóa thành công","INFORMATION_MESSAGE",2);
            return true;
        }

         JOptionPane.showMessageDialog(null,"Xóa thất bại","ERROR_MESSAGE",1);
        return false;
    }
    public ArrayList<MatHangDTO> searchSP(String masp,String maloai,double max,double min)
    {
        ArrayList<MatHangDTO> search = new ArrayList<>();
        masp = masp.isEmpty()?masp = "": masp;
        maloai = maloai.isEmpty()?maloai = "": maloai;
        for(MatHangDTO sp : mathangdao.selectAll())
        {
            if( sp.getMaMh().contains(masp) && 
                sp.getMaLH().contains(maloai) &&
                sp.getGiaBan()>= min && 
                sp.getGiaBan() <= max)
            {
                search.add(sp);
            }
        }
        return search;
    }
    public void xuatExcel()
    {
        mathangdao.xuatfile();
    }
    public void nhapExcel(File file)
    {
        mathangdao.nhapfile(file);
    }
}
