package DTO;

import java.util.Date;

public class MatHangDTO {
	private String maMh;
	private String tenMh;
	private double giaMua;
	private double giaBan;
	private Date ngaySX;
	private Date hsd;
	private double slNhap;
	private double slBan;
	private Date ngayNhap;
	private double vat;
	private String maLH;
	private String maDVT;
        private String img=null;
	public MatHangDTO() {
		
	}

    public MatHangDTO(String maMh, String tenMh, double giaMua, double giaBan, Date ngaySX, Date hsd, double slNhap, double slBan, Date ngayNhap, double vat, String maLH, String maDVT, String img) {
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.ngaySX = ngaySX;
        this.hsd = hsd;
        this.slNhap = slNhap;
        this.slBan = slBan;
        this.ngayNhap = ngayNhap;
        this.vat = vat;
        this.maLH = maLH;
        this.maDVT = maDVT;
        this.img = img;
    }

    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public double getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(double giaMua) {
        this.giaMua = giaMua;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public Date getNgaySX() {
        return ngaySX;
    }

    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }

    public Date getHsd() {
        return hsd;
    }

    public void setHsd(Date hsd) {
        this.hsd = hsd;
    }

    public double getSlNhap() {
        return slNhap;
    }

    public void setSlNhap(double slNhap) {
        this.slNhap = slNhap;
    }

    public double getSlBan() {
        return slBan;
    }

    public void setSlBan(double slBan) {
        this.slBan = slBan;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getMaDVT() {
        return maDVT;
    }

    public void setMaDVT(String maDVT) {
        this.maDVT = maDVT;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   
	
	
}
