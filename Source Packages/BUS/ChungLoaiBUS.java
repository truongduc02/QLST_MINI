/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;

import DAO.ChungLoaiDAO;
import DTO.ChungLoaiDTO;
public class ChungLoaiBUS {
    public static ChungLoaiBUS getIntance() {
		return new ChungLoaiBUS();
	}
	public ArrayList<String> getListChungloai(){
		ArrayList<String>listCL=new ArrayList<>();
		for (ChungLoaiDTO cl : ChungLoaiDAO.getIntance().selectAll()) {
			listCL.add(cl.toString());
		}
		return listCL;
	}
}
