package net.jie.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
    @RequestMapping(value = "/", method = RequestMethod.GET)//处理具体的请求路径，此处演示为"/"
    public String prepareView(Model model){
        model.addAttribute("msg", "spring mvc demo test page!");
        return "home";
    }
}
