package com.o7planning.SpringBootRoutingDS.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.o7planning.SpringBootRoutingDS.model.ChuyenTienModel;

import org.springframework.jdbc.core.RowMapper;

public class ChuyenTienMapper implements RowMapper<ChuyenTienModel>{
    public static final String QUERY_ALL_GD_CHUYENTIEN = "SELECT * FROM LINK.NGANHANG.DBO.GD_CHUYENTIEN";
    public static final String QUERY_GD_CHUYENTIEN = "SELECT * FROM GD_CHUYENTIEN";


    @Override
    public ChuyenTienModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        ChuyenTienModel chuyenTien = new ChuyenTienModel();

        chuyenTien.setMaGD(rs.getInt("MAGD"));
        chuyenTien.setSoTKChuyen(rs.getString("SOTK_CHUYEN"));
        chuyenTien.setSoTKNhan(rs.getString("SOTK_NHAN"));
        chuyenTien.setNgayGD(rs.getDate("NGAYGD"));
        chuyenTien.setSoTien(rs.getDouble("SOTIEN"));
        chuyenTien.setMaNV(rs.getString("MANV"));

        return chuyenTien;
    }
}
