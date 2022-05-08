package com.o7planning.SpringBootRoutingDS.model;

import java.sql.Date;

public class ChuyenTienModel {
    
    private int maGD;
    private String soTKChuyen;
    private Date ngayGD;
    private double soTien;
    private String soTKNhan;
    private String maNV;

    public int getMaGD() {
        return this.maGD;
    }

    public void setMaGD(int maGD) {
        this.maGD = maGD;
    }

    public String getSoTKChuyen() {
        return this.soTKChuyen;
    }

    public void setSoTKChuyen(String soTKChuyen) {
        this.soTKChuyen = soTKChuyen;
    }

    public Date getNgayGD() {
        return this.ngayGD;
    }

    public void setNgayGD(Date ngayGD) {
        this.ngayGD = ngayGD;
    }

    public double getSoTien() {
        return this.soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getSoTKNhan() {
        return this.soTKNhan;
    }

    public void setSoTKNhan(String soTKNhan) {
        this.soTKNhan = soTKNhan;
    }

    public String getMaNV() {
        return this.maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    
}
