package com.o7planning.SpringBootRoutingDS.dao.Form;

import java.util.Optional;

import javax.sql.DataSource;

import com.o7planning.SpringBootRoutingDS.model.Form.FormLogin;
import com.o7planning.SpringBootRoutingDS.mapper.Form.FormLoginMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FormLoginDAO extends JdbcDaoSupport{
    
    @Autowired
    public FormLoginDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public Optional<FormLogin> queryLogin(String username, String password) {   
        String sql = FormLoginMapper.QueryLogin(username, password);
        Object [] params = new Object[]{};
        FormLoginMapper mapper = new FormLoginMapper();
        
        if(this.getJdbcTemplate().query(sql, params, mapper) == null) return null;
        Optional<FormLogin> lg = Optional.of(this.getJdbcTemplate().query(sql, params, mapper).get(0));
        return lg;
    }
}
