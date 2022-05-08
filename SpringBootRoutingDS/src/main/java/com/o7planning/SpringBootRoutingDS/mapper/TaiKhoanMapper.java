package com.o7planning.SpringBootRoutingDS.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.o7planning.SpringBootRoutingDS.model.TaiKhoanModel;

import org.springframework.jdbc.core.RowMapper;

public class TaiKhoanMapper implements RowMapper<TaiKhoanModel>{

    public static final String QUERY_ALL_TAIKHOAN = "SELECT * FROM LINK.NGANHANG.DBO.TAIKHOAN";
    public static final String QUERY_TAIKHOAN = "SELECT * FROM TAIKHOAN";


    @Override
    public TaiKhoanModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        TaiKhoanModel taiKhoan = new TaiKhoanModel();

        taiKhoan.setSoTK(rs.getString("SOTK"));
        taiKhoan.setCMND(rs.getString("CMND"));
        taiKhoan.setSoDu(rs.getFloat("soDU"));
        taiKhoan.setMaCN(rs.getString("MACN"));
        taiKhoan.setNgayMoTK(rs.getDate("NGAYMOTK"));

        return taiKhoan;
    }
    
}
