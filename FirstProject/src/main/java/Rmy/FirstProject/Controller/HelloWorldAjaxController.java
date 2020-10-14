package Rmy.FirstProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax")
public class HelloWorldAjaxController {

    @RequestMapping("/say")
    public String say(){

        return "{'message1':'SpringBoot1','message2','SpringBoot2'}";
    }
}
