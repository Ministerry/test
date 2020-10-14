package Rmy.FirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ab")
public class testResponseBody {
    @RequestMapping("/testRespenseBody")
    @ResponseBody//输出方法的return到html
    public String testResponseBody(HttpServletRequest request){
        return "<h1 style='color:lightGreen'>Hello Web!</h1>";
    }
}
