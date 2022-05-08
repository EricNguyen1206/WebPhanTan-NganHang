package com.o7planning.SpringBootRoutingDS.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.o7planning.SpringBootRoutingDS.model.KhachHangModel;

import org.springframework.jdbc.core.RowMapper;

public class KhachHangMapper implements RowMapper<KhachHangModel>{
    public static final String QUERY_ALL_KHACHHANG = "SELECT * FROM LINK.NGANHANG.DBO.KHACHHANG";
    public static final String QUERY_KHACHHANG = "SELECT * FROM KHACHHANG";


    @Override
    public KhachHangModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        KhachHangModel khachHang = new KhachHangModel();

        khachHang.setCMND(rs.getString("CMND"));
        khachHang.setHo(rs.getString("HO"));
        khachHang.setTen(rs.getString("TEN"));
        khachHang.setDiaChi(rs.getString("DIACHI"));
        khachHang.setPhai(rs.getString("PHAI"));
        khachHang.setNgayCap(rs.getDate("NGAYCAP"));
        khachHang.setSDT(rs.getString("SODT"));
        khachHang.setMaCN(rs.getString("MACN"));
        
        return khachHang;
    }
}
