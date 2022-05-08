package com.o7planning.SpringBootRoutingDS.dao;
import java.util.List;

import javax.sql.DataSource;

import com.o7planning.SpringBootRoutingDS.mapper.NhanVienMapper;
import com.o7planning.SpringBootRoutingDS.model.NhanVienModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class NhanVienDAO extends JdbcDaoSupport{
    @Autowired
    public NhanVienDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<NhanVienModel> queryAllNhanVien() {   
        // String sql = "Select * from LINK0.NGANHANG.DBO.ChiNhanh";
        String sql = NhanVienMapper.QUERY_ALL_NHANVIEN;
        Object [] params = new Object[]{};
        NhanVienMapper mapper = new NhanVienMapper();
        List<NhanVienModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

    public List<NhanVienModel> queryNhanVien() {   
        // String sql = "Select * from LINK0.NGANHANG.DBO.ChiNhanh";
        String sql = NhanVienMapper.QUERY_NHANVIEN;
        Object [] params = new Object[]{};
        NhanVienMapper mapper = new NhanVienMapper();
        List<NhanVienModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }
    

}
