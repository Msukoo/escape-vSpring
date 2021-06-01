package com.escapepj.demo.controller;

import com.escapepj.demo.mapper.BookingMapper;
import com.escapepj.demo.vo.BookingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/booking/*")
public class BookingController {

    private final BookingMapper bookingMapper;

    public BookingController(BookingMapper bookingMapper){
        this.bookingMapper = bookingMapper;
    }

    @RequestMapping("/view")
    public String booking(ModelMap model, BookingVo bookingVo, HttpServletRequest request, HttpServletResponse response) {

        return "common/booking";
    }

    @RequestMapping("/booking")
    public String  bookingProcess(ModelMap model, BookingVo bookingVo, HttpServletRequest request, HttpServletResponse response) {
        int result = 0;
        result = bookingMapper.saveReserve(bookingVo);
        if(result == 1) {
            model.addAttribute("result", "Y");
        }else if(result == 0) {
            model.addAttribute("result", "N");
        }
        model.addAttribute("submit", "booking");
        return "common/result";
    }
}
