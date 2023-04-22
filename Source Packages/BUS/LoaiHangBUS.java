/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoaiHangDAO;
import DTO.LoaiHangDTO;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LoaiHangBUS {
    private LoaiHangDAO loaihangDAO= new LoaiHangDAO();
    private ArrayList<LoaiHangDTO> listloaihang = null;
    public static LoaiHangBUS getIntance() {
        return new LoaiHangBUS();
	}
    public ArrayList<LoaiHangDTO> getList()
    {
        listloaihang = loaihangDAO.selectAll();
        return listloaihang;
    }
    public ArrayList<String>getListByChungLoai(String maCl){
		return LoaiHangDAO.getIntance().selectByChungLoai(maCl);
	}
    public LoaiHangDTO getLoaiHangByID(LoaiHangDTO lh) {
		return loaihangDAO.getIntance().selectById(lh);
	}
}
