package org.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bosc")
public class IndexController {

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
