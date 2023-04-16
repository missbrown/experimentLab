package com.bosc.assessment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bosc.assessment.dto.TagOpDto;
import com.bosc.assessment.dto.TagOwnerDto;
import com.bosc.assessment.service.TestService;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    TestService testService;
    
    @RequestMapping("/hello")
    public String hello() {
        return "hello there";
    }

    @GetMapping("/tag/op/list")
    public List<TagOpDto> getTagOps() {
        return testService.mockTagOpList();
    }
    
    @GetMapping("/tag/owner/list")
    public Map<String, List<TagOwnerDto>> getOwnerOps() {
        return testService.mockOwnerList();
    }
}
