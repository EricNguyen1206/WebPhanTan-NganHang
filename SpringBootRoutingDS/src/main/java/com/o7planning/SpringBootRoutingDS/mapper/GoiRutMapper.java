package com.o7planning.SpringBootRoutingDS.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.o7planning.SpringBootRoutingDS.model.GoiRutModel;

import org.springframework.jdbc.core.RowMapper;

public class GoiRutMapper implements RowMapper<GoiRutModel>{

    public static final String QUERY_ALL_GD_GOIRUT = "SELECT * FROM LINK.NGANHANG.DBO.GD_GOIRUT";
    public static final String QUERY_GD_GOIRUT = "SELECT * FROM GD_GOIRUT";


    @Override
    public GoiRutModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        GoiRutModel chuyenTien = new GoiRutModel();

        chuyenTien.setMaGD(rs.getInt("MAGD"));
        chuyenTien.setSoTK(rs.getString("SOTK"));
        chuyenTien.setLoaiGD(rs.getString("LOAIGD"));
        chuyenTien.setNgayGD(rs.getDate("NGAYGD"));
        chuyenTien.setSoTien(rs.getDouble("SOTIEN"));
        chuyenTien.setMaNV(rs.getString("MANV"));

        return chuyenTien;
    }
    
}
