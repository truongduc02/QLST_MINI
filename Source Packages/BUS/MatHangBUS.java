/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MatHangDAO;
import DTO.MatHangDTO;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatHangBUS {
    private MatHangDAO mathangdao= new MatHangDAO();
    private ArrayList<MatHangDTO> listMatHang= null;
    public static MatHangBUS getInstance() {
		return new MatHangBUS();
	}
    public ArrayList<MatHangDTO> getList()
    {
        return MatHangDAO.getInstance().selectAll();
    }
    public void add(MatHangDTO mh)
    {
        mathangdao.them(mh);
    }
    public MatHangDTO getById(MatHangDTO mh)
    {
        return mathangdao.selectById(mh);
    }
    public void delete(MatHangDTO mh)
    {
        mathangdao.xoa(mh);
    }
}
