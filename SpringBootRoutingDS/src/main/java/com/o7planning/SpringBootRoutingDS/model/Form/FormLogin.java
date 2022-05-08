package com.o7planning.SpringBootRoutingDS.model.Form;

public class FormLogin {
    
    private String hoTen;
    private String maNV;
    private String maChiNhanh;
    private String quyen;

    
    public FormLogin() {}

    public FormLogin(String hoTen, String maNV, String maChiNhanh, String quyen) {
        this.hoTen = hoTen;
        this.maNV = maNV;
        this.maChiNhanh = maChiNhanh;
        this.quyen = quyen;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaNV() {
        return maNV;
    }


    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }


    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getQuyen() {
        return quyen;
    }


    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }


}
