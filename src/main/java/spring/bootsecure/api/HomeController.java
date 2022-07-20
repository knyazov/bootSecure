package spring.bootsecure.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(name = "/")
    private String indexPage(){
        return "index";
    }

    @GetMapping(name = "/login")
    private String loginPage(){
        return "login";
    }

    @GetMapping(name = "/profile")
    private String profilePage(){
        return "profile";
    }
}
