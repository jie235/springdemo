package com.jie.springbootlogin.config;

import com.jie.springbootlogin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: jie
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    /**
     * 映射本地静态文件的访问路径和存储路径
     * "/**"表示匹配所有url，如"home/user/config/uid1..."；"/*"不能匹配钱数带有斜杆的url
     * 资源路径的resourceLocations这里，路径目录最后一级必须带上斜杆（也就是最右边）。在这里"classpath:static/imgs/"可以写作"classpath:/static/imgs/"，但是不能写作"classpath:static/imgs"
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/imgs/**").addResourceLocations("classpath:/static/imgs/");
    }

    @Override
    /**
     * 拦截器，对所有的请求地址，除了"/toLogin", "/login", "/ops/**", "/**.html"之外都进行拦截
     */
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin", "/login", "/ops/**", "/**.html", "/imgs/**");
    }

    @Override
    /**
     * 添加无业务逻辑相关的controller
     * 这里是说，添加请求地址为"/toLogin"的controller，该请求返回渲染解析后的view -- "login"
     */
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/toLogin").setViewName("login");
    }
}
