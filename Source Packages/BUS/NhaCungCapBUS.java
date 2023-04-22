/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class NhaCungCapBUS {
    private NhaCungCapDAO nhacungcapDAO= new NhaCungCapDAO();
    private ArrayList<NhaCungCapDTO> listNhaCungCap = null;
    public ArrayList<NhaCungCapDTO> getList()
    {
        listNhaCungCap=nhacungcapDAO.selectAll();
        return listNhaCungCap;
    }
    public void add(NhaCungCapDTO ncc)
    {
        nhacungcapDAO.them(ncc);
    }
    public NhaCungCapDTO getById(NhaCungCapDTO ncc)
    {
        return nhacungcapDAO.selectById(ncc);
    }
    public void delete(NhaCungCapDTO ncc)
    {
        nhacungcapDAO.xoa(ncc);
    }
}
