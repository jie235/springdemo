package com.jie.springbootlogin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jie
 */
@RestController
public class LoginController {

    @Value("${name.fullname}")
    private String name;

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Map<String,String> login(@RequestParam String name, @RequestParam String passwd){
        if(StringUtils.isEmptyOrWhitespace(name) || StringUtils.isEmptyOrWhitespace(passwd)){
            return new HashMap<String, String>(){{this.put("message","incorrect input");}};
        }else{
            return new HashMap<String, String>(){{this.put("message","success");}};
        }
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){
        return this.name;
    }
}
