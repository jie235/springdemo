package com.jie.securitydemo.service.imp;

import com.jie.securitydemo.bean.User;
import com.jie.securitydemo.dao.UserMapper;
import com.jie.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jie
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser(){
        return userMapper.getUser();
    }
}
