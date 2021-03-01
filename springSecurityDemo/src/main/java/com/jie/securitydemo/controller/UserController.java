package com.jie.securitydemo.controller;

import com.jie.securitydemo.bean.User;
import com.jie.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author: jie
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    @ResponseBody
    public List<User> main(){
        return userService.getUser();
    }
}
