package Rmy.FirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/freemarker")
public class HelloWorldFreemakerContainer {
    /**
     * @return
     */
    @RequestMapping("/say")
    public ModelAndView say(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","你好");
        mav.setViewName("helloWorld");
        return  mav;
    }
}
