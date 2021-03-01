package com.jie.springbootlogin.interceptor;

import com.jie.springbootlogin.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Handler;

/**
 * @author: jie
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    //拦截器处理逻辑：不管是request的方法还是response的方法，都会执行，因为这些语句在return语句之前
    //但是，他们并不是立即执行的，而是在执行return语句之后再执行。
    //如果return返回true，那么按照spring的流程继续执行；如果返回false，那么中断执行的流程
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            //转发和重定向在这里使用的路径是不一样的，
            //转发是直接填写controller的名称，而重定向需要指定相对或绝对路径
            //另外，重定向之后客户端发送的是get请求，一般是重定向到无业务逻辑的controller。如果是到有业务逻辑的controller，需要注意http请求的类型
//            request.getRequestDispatcher("/toLogin").forward(request, response);
//            response.sendRedirect("./index.html");
            return true;
//            //为了不影响后面的调试，先把这里设置为返回true
//            response.sendRedirect("./toLogin");
//            return false;
        }else{
            return true;
        }
    }
}
