package com.jie.springbootlogin.dao.imp;

import com.jie.springbootlogin.bean.User;
import com.jie.springbootlogin.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author: jie
 */
@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(User user){
        String sql = "insert into user_table(name, passwd) values(?,?)";
        int res = jdbcTemplate.update(sql, user.getName(), user.getPasswd());
        return res;
    }
}
