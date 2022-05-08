package com.o7planning.SpringBootRoutingDS.dao;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.o7planning.SpringBootRoutingDS.model.KhachHangModel;
import com.o7planning.SpringBootRoutingDS.mapper.KhachHangMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class KhachHangDAO extends JdbcDaoSupport{
    @Autowired
    public KhachHangDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<KhachHangModel> queryAllKhachHang() {   

        String sql = KhachHangMapper.QUERY_ALL_KHACHHANG;
        Object [] params = new Object[]{};
        KhachHangMapper mapper = new KhachHangMapper();
        List<KhachHangModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

    public List<KhachHangModel> queryKhachHang() {   

        String sql = KhachHangMapper.QUERY_KHACHHANG;
        Object [] params = new Object[]{};
        KhachHangMapper mapper = new KhachHangMapper();
        List<KhachHangModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

}
