package com.o7planning.SpringBootRoutingDS.dao;
import java.util.List;

import javax.sql.DataSource;

import com.o7planning.SpringBootRoutingDS.model.ChuyenTienModel;
import com.o7planning.SpringBootRoutingDS.mapper.ChuyenTienMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ChuyenTienDAO extends JdbcDaoSupport{
    
    @Autowired
    public ChuyenTienDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<ChuyenTienModel> queryAllGDChuyenTien() {   
        String sql = ChuyenTienMapper.QUERY_ALL_GD_CHUYENTIEN;
        Object [] params = new Object[]{};
        ChuyenTienMapper mapper = new ChuyenTienMapper();
        List<ChuyenTienModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

    public List<ChuyenTienModel> queryGDChuyenTien() {   
        String sql = ChuyenTienMapper.QUERY_GD_CHUYENTIEN;
        Object [] params = new Object[]{};
        ChuyenTienMapper mapper = new ChuyenTienMapper();
        List<ChuyenTienModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }
}
