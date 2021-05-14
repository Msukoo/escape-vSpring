package com.escapepj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class StudentController {

    @Autowired
    TestMapper testMapper;

    @RequestMapping("/")
    public String index() {
        Date date = testMapper.now();
        MyDate date2 = testMapper.now2();

        // logic to process input data
        return "index";
    }
}