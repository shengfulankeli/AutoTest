package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


/**
 * @author shengfulankuli
 * @create 2021-12-29 19:55
 */

@Controller
@EnableAutoConfiguration
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello World!";
    }

    public static void main(String[] args){
        SpringApplication.run(SampleController.class,args);
    }
}
