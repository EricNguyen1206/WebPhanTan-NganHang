package com.o7planning.SpringBootRoutingDS.dao;
import java.util.List;

import javax.sql.DataSource;

import com.o7planning.SpringBootRoutingDS.model.GoiRutModel;
import com.o7planning.SpringBootRoutingDS.mapper.GoiRutMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GoiRutDAO extends JdbcDaoSupport{
    
    @Autowired
    public GoiRutDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<GoiRutModel> queryAllGoiRut() {   
        // String sql = "Select * from LINK0.NGANHANG.DBO.ChiNhanh";
        String sql = GoiRutMapper.QUERY_ALL_GD_GOIRUT;
        Object [] params = new Object[]{};
        GoiRutMapper mapper = new GoiRutMapper();
        List<GoiRutModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }

    public List<GoiRutModel> queryGoiRut() {   
        // String sql = "Select * from LINK0.NGANHANG.DBO.ChiNhanh";
        String sql = GoiRutMapper.QUERY_GD_GOIRUT;
        Object [] params = new Object[]{};
        GoiRutMapper mapper = new GoiRutMapper();
        List<GoiRutModel> list = this.getJdbcTemplate().query(sql, params, mapper);
        return list;
    }
}
