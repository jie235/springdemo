package com.jie.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;

/**
 * @author: jie
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    //基于内存的用户存储--需要指定加密方式，否则会报错
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().passwordEncoder(new SCryptPasswordEncoder())
//                .withUser("jack").password("jackoff123").authorities("ROLE_USER")
//                .and()
//                .withUser("Tina").password("tinaoff132").authorities("ROLE_USER");
//    }

//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    //基于数据库的加密
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("select name,passwd from user_table where name=?")
//                .authoritiesByUsernameQuery("select name,authority from user_authority where name=?")
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0}")
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("passcode");
    }
}
