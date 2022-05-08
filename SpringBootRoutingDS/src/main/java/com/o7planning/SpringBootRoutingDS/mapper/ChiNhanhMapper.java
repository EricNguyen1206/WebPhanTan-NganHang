package com.o7planning.SpringBootRoutingDS.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.o7planning.SpringBootRoutingDS.model.ChiNhanhModel;

import org.springframework.jdbc.core.RowMapper;

public class ChiNhanhMapper implements RowMapper<ChiNhanhModel>{

    public static final String QUERY_ALL_CHINHANH = "SELECT * FROM LINK.NGANHANG.DBO.CHINHANH";
    public static final String QUERY_CHINHANH = "SELECT * FROM CHINHANH";

    @Override
    public ChiNhanhModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        ChiNhanhModel chiNhanh = new ChiNhanhModel();

        chiNhanh.setMaCN(rs.getString("MACN"));
        chiNhanh.setTenCN(rs.getString("TENCN"));
        chiNhanh.setDiaChi(rs.getString("DIACHI"));
        chiNhanh.setSDT(rs.getString("SODT"));
        
        return chiNhanh;
    }
 
    
}
