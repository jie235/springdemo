package com.jie.springbootlogin.controller;

import com.jie.springbootlogin.bean.User;
import com.jie.springbootlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jie
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/ops/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> addUser(@RequestBody User user){
        if(user == null)return null;
        Map<String, Integer>map = new HashMap<>();
        if(StringUtils.isEmptyOrWhitespace(user.getName()) || StringUtils.isEmptyOrWhitespace(user.getPasswd())){
            map.put("please fill in all fields", 0);
            return map;
        }
        int res = userService.addUser(user);
        map.put("message", res);
        return map;
    }
}
