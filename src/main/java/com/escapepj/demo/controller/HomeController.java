package com.escapepj.demo.controller;

import com.escapepj.demo.MyDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        // logic to process input data
        return "index";
    }
}
