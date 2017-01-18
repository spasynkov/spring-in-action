package com.springinaction.spitter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping({"/", "/homepage"})                // map this controller to /
public class HomeController {

    @RequestMapping(method = GET)   // handle GET request
    public String home() {
        return "home";              // view name is home
    }
}
