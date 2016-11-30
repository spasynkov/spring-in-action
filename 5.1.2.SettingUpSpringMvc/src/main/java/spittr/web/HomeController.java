package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping({"/", "/homepage"})                // map this controller to /
public class HomeController {

    @RequestMapping(method = GET)   // handle GET request
    public String home() {
        return "home";              // view name is home
    }
}
