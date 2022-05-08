package com.o7planning.SpringBootRoutingDS.model;

import java.sql.Date;

public class KhachHangModel {
    
    private String CMND;
    private String ho;
    private String ten;
    private String diaChi;
    private String phai;
    private Date ngayCap;
    private String SDT;
    private String maCN;

    public String getCMND() {
        return this.CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getHo() {
        return this.ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return this.diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhai() {
        return this.phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public Date getNgayCap() {
        return this.ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getSDT() {
        return this.SDT;
    }

    public void setSDT(String soDT) {
        this.SDT = soDT;
    }

    public String getMaCN() {
        return this.maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }
    
}
