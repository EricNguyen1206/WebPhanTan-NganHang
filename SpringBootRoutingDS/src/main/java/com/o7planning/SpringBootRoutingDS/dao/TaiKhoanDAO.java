package com.o7planning.SpringBootRoutingDS.dao;
import com.o7planning.SpringBootRoutingDS.model.TaiKhoanModel;
import com.o7planning.SpringBootRoutingDS.mapper.TaiKhoanMapper;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TaiKhoanDAO extends JdbcDaoSupport{
    @Autowired
    public TaiKhoanDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<TaiKhoanModel> queryAllTaiKhoan() {   
        // String sql = "Select * from LINK0.NGANHANG.DBO.ChiNhanh";
        String sql = TaiKhoanMapper.QUERY_ALL_TAIKHOAN;
        Object [] params = new Object[]{};
        TaiKhoanMapper mapper = new TaiKhoanMapper();
        List<TaiKhoanModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

    public List<TaiKhoanModel> queryTaiKhoan() {   
        // String sql = "Select * from LINK0.NGANHANG.DBO.ChiNhanh";
        String sql = TaiKhoanMapper.QUERY_TAIKHOAN;
        Object [] params = new Object[]{};
        TaiKhoanMapper mapper = new TaiKhoanMapper();
        List<TaiKhoanModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

}
