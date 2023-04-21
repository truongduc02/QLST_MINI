/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class DonViDTO {
    private String MaDvt,TenDvt;
    public DonViDTO()
    {
        
    }

    public DonViDTO(String MaDvt, String TenDvt) {
        this.MaDvt = MaDvt;
        this.TenDvt = TenDvt;
    }

    public String getMaDvt() {
        return MaDvt;
    }

    public void setMaDvt(String MaDvt) {
        this.MaDvt = MaDvt;
    }

    public String getTenDvt() {
        return TenDvt;
    }

    public void setTenDvt(String TenDvt) {
        this.TenDvt = TenDvt;
    }
    
}
