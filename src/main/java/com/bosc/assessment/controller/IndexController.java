package com.bosc.assessment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @RequestMapping("bosc")
@Controller
public class IndexController {

    @RequestMapping("/dash")
    public ModelAndView dashboard() {
        ModelAndView mav = new ModelAndView("tagDashboard");
        return mav;
    }
}
