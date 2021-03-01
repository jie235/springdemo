package com.jie.springbootlogin.service.imp;

import com.jie.springbootlogin.bean.User;
import com.jie.springbootlogin.service.UserService;
import com.jie.springbootlogin.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jie
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user){
        return userDao.add(user);
    }
}
