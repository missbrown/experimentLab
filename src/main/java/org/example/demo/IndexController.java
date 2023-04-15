package org.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bosc")
public class IndexController {

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
