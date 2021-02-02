package net.jie.springmvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import sun.plugin.com.Dispatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext){
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MyConfig.class);
        ctx.setServletContext(servletContext);
//        ctx.scan("net.jie.springmvc");//如果Config里面没有使用@Bean注入Controller实体，那么这里需要这么操作
        ServletRegistration.Dynamic servlet = servletContext.addServlet("springmvc demo", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");//设置接收的请求根路径，对应于url中的https://....com/projectname/，表明在该url之下的请求都会被该dispatcher处理
    }

}
