package DTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class NhanVienDTO {
    private String Manv,HoTen,NgaySinh,Phai,CCCD,Diachi,DienThoai,NgayVaoLam,MaCV;
    public NhanVienDTO()
    {
        
    }

    public NhanVienDTO(String Manv, String HoTen, String NgaySinh, String Phai, String CCCD, String Diachi, String DienThoai, String NgayVaoLam, String MaCV) {
        this.Manv = Manv;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.Phai = Phai;
        this.CCCD = CCCD;
        this.Diachi = Diachi;
        this.DienThoai = DienThoai;
        this.NgayVaoLam = NgayVaoLam;
        this.MaCV = MaCV;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String Phai) {
        this.Phai = Phai;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(String NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

}
