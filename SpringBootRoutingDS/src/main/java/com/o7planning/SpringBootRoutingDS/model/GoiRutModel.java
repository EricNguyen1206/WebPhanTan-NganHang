package com.o7planning.SpringBootRoutingDS.model;

import java.sql.Date;

public class GoiRutModel {
    
    private int maGD;
    private String soTK;
    private String loaiGD;
    private Date ngayGD;
    private Double soTien;
    private String maNV;

    public int getMaGD() {
        return this.maGD;
    }

    public void setMaGD(int maGD) {
        this.maGD = maGD;
    }

    public String getSoTK() {
        return this.soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getLoaiGD() {
        return this.loaiGD;
    }

    public void setLoaiGD(String loaiGD) {
        this.loaiGD = loaiGD;
    }

    public Date getNgayGD() {
        return this.ngayGD;
    }

    public void setNgayGD(Date ngayGD) {
        this.ngayGD = ngayGD;
    }

    public Double getSoTien() {
        return this.soTien;
    }

    public void setSoTien(Double soTien) {
        this.soTien = soTien;
    }

    public String getMaNV() {
        return this.maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }


}
