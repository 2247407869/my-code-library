package pers.lls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String getUser() {
        return "hello";
    }
}