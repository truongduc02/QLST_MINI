/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DonViDAO;
import DTO.DonViDTO;
import java.util.ArrayList;
public class DonViBUS {
    private DonViDAO donviDAO = new DonViDAO();
    private ArrayList<DonViDTO> listdonvi=null;
    public static DonViBUS getIntance() {
		return new DonViBUS();
	}
        public ArrayList<DonViDTO> getList()
        {
            listdonvi=donviDAO.selectAll();
            return listdonvi;
        }
	public DonViDTO getDonViByID(DonViDTO dv) {
		return DonViDAO.getIntance().selectById(dv);
	}
        public String laymatheotendonvitinh(String tendonvitinh)
        {
            String madv=null;
            for(DonViDTO dv: getList())
            {
                if(dv.getTenDvt().equalsIgnoreCase(tendonvitinh))
                {
                    madv=dv.getMaDvt();
                }
            }
            return madv;
        }
        public String laytentheomadonvitinh(String madonvitinh)
        {
            String tendv=null;
            for(DonViDTO dv: getList())
            {
                if(dv.getMaDvt().equalsIgnoreCase(madonvitinh))
                    tendv=dv.getTenDvt();
            }
            return tendv;
        }
}
