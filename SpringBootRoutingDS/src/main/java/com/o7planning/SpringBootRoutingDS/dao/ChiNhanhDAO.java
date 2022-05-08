package com.o7planning.SpringBootRoutingDS.dao;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.o7planning.SpringBootRoutingDS.model.ChiNhanhModel;
import com.o7planning.SpringBootRoutingDS.mapper.ChiNhanhMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ChiNhanhDAO extends JdbcDaoSupport{
    
    @Autowired
    public ChiNhanhDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<ChiNhanhModel> queryAllChiNhanh() {   
        // String sql = "Select * from LINK0.NGANHANG.DBO.ChiNhanh";
        String sql = ChiNhanhMapper.QUERY_ALL_CHINHANH;
        Object [] params = new Object[]{};
        ChiNhanhMapper mapper = new ChiNhanhMapper();
        List<ChiNhanhModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }


    public Optional<ChiNhanhModel> queryChiNhanh() {   
        String sql = ChiNhanhMapper.QUERY_CHINHANH;
        Object [] params = new Object[]{};
        ChiNhanhMapper mapper = new ChiNhanhMapper();
        Optional<ChiNhanhModel> cn = Optional.of(this.getJdbcTemplate().query(sql, params, mapper).get(0));
        return cn;
    }
    

}
