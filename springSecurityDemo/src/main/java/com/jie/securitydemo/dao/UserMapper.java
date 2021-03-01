package com.jie.securitydemo.dao;

import com.jie.securitydemo.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: jie
 */
@Mapper
public interface UserMapper {
    List<User>getUser();
}
