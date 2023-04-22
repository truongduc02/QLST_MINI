/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DonViDAO;
import DTO.DonViDTO;
public class DonViBUS {
    public static DonViBUS getIntance() {
		return new DonViBUS();
	}
	public DonViDTO getDonViByID(DonViDTO dv) {
		return DonViDAO.getIntance().selectById(dv);
	}
}
