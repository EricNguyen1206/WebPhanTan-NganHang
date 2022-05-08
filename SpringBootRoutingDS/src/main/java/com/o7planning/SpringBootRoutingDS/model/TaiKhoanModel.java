package com.o7planning.SpringBootRoutingDS.model;

import java.sql.Date;

public class TaiKhoanModel {
    
    private String soTK;
    private String CMND;
    private float soDu;
    private String maCN;
    private Date ngayMoTK;

    public String getSoTK() {
        return this.soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getCMND() {
        return this.CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public float getSoDu() {
        return this.soDu;
    }

    public void setSoDu(float soDu) {
        this.soDu = soDu;
    }

    public String getMaCN() {
        return this.maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public Date getNgayMoTK() {
        return this.ngayMoTK;
    }

    public void setNgayMoTK(Date ngayMoTK) {
        this.ngayMoTK = ngayMoTK;
    }



}
