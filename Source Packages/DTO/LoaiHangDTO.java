/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class LoaiHangDTO {
    private String MaLh, TenLh, MaCl;
    public LoaiHangDTO()
    {
        
    }

    public LoaiHangDTO(String MaLh, String TenLh, String MaCl) {
        this.MaLh = MaLh;
        this.TenLh = TenLh;
        this.MaCl = MaCl;
    }
    
    public String getMaLh() {
        return MaLh;
    }

    public void setMaLh(String MaLh) {
        this.MaLh = MaLh;
    }

    public String getTenLh() {
        return TenLh;
    }

    public void setTenLh(String TenLh) {
        this.TenLh = TenLh;
    }

    public String getMaCl() {
        return MaCl;
    }

    public void setMaCl(String MaCl) {
        this.MaCl = MaCl;
    }
    
}
