package com.escapepj.demo.controller;

import com.escapepj.demo.service.ThemaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thema/*")
public class ThemaController {

    private final ThemaService themaService;

    public ThemaController(ThemaService themaService){
        this.themaService = themaService;
    }
}
