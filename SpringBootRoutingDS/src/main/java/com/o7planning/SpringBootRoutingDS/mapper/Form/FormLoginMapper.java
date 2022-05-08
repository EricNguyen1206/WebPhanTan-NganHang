package com.o7planning.SpringBootRoutingDS.mapper.Form;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.o7planning.SpringBootRoutingDS.model.Form.FormLogin;

import org.springframework.jdbc.core.RowMapper;

public class FormLoginMapper implements RowMapper<FormLogin>{

    public static String QueryLogin(String username, String password){
        return "exec SP_DANGNHAP_MANV_ROLE @TENLOGIN = '"+username+"', @MATKHAU = '"+password+"'";
    }

    @Override
    public FormLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        FormLogin formLogin = new FormLogin();

        formLogin.setMaNV(rs.getString("USERNAME"));
        formLogin.setHoTen(rs.getString("HOTEN"));
        formLogin.setQuyen(rs.getString("TENNHOM"));
        formLogin.setMaChiNhanh(rs.getString("MACHINHANH"));

        return formLogin;
    }
}
