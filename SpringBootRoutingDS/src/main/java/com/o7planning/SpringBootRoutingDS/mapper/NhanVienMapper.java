package com.o7planning.SpringBootRoutingDS.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.o7planning.SpringBootRoutingDS.model.NhanVienModel;

import org.springframework.jdbc.core.RowMapper;

public class NhanVienMapper implements RowMapper<NhanVienModel>{
    public static final String QUERY_ALL_NHANVIEN = "SELECT * FROM LINK.NGANHANG.DBO.NHANVIEN";
    public static final String QUERY_NHANVIEN = "SELECT * FROM NHANVIEN";


    @Override
    public NhanVienModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        NhanVienModel khachHang = new NhanVienModel();

        khachHang.setMaNV(rs.getString("MANV"));
        khachHang.setHo(rs.getString("HO"));
        khachHang.setTen(rs.getString("TEN"));
        khachHang.setDiaChi(rs.getString("DIACHI"));
        khachHang.setPhai(rs.getString("PHAI"));
        khachHang.setSDT(rs.getString("SODT"));
        khachHang.setMaCN(rs.getString("MACN"));
        khachHang.setTTXoa(rs.getBoolean("TrangThaiXoa"));
        
        return khachHang;
    }
}
