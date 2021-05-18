package com.escapepj.demo.controller;

import com.escapepj.demo.mapper.ReserveMapper;
import com.escapepj.demo.vo.ReserveVo;
import com.escapepj.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/reserve/*")
public class ReserveController {

    @Autowired
    ReserveMapper reserveMapper;

    @RequestMapping("/")
    public String  reserve(ModelMap model, ReserveVo reserveVo, HttpServletRequest request, HttpServletResponse response) {

        return "reserve/reserve";
    }

    @RequestMapping("/reserve")
    public String  reserveProcess(ModelMap model, ReserveVo reserveVo, HttpServletRequest request, HttpServletResponse response) {
        int result = 0;
        result =reserveMapper.saveReserve(reserveVo);
        if(result == 1) {
            model.addAttribute("result", "Y");
        }else if(result == 0) {
            model.addAttribute("result", "N");
        }
        model.addAttribute("submit", "reserve");
        return "common/result";
    }
}
