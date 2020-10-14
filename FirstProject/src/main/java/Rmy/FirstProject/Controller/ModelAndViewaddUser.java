package Rmy.FirstProject.Controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ModelAndViewaddUser {
    @RequestMapping("/addUser")
    public ModelAndView addUser(User user, HttpServletRequest Request, HttpSession session){
        ModelAndView mav=new ModelAndView();
        mav.addObject("user",user);
        mav.setViewName("redirect:index");
        mav.setViewName("index");
        return mav;
    }
}
