//package com.escapepj.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.Mapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//// 일반적인 view resolver를 거치지 않고, <자바 객체를> 알아서 보내준다-> 알아서?? -> json으로 기본 세팅되어 있음!
//// ajax 처리를 할 때 얘를 쓴다 <- @RestController 이러저러한 것의 축약!
//public class MyRestController {
//
////    @Autowired
//    private TestMapper testMapper;
//    public MyRestController(TestMapper testMapper) {
//        this.testMapper = testMapper;
//    }
//
//    @RequestMapping("/now2")
//    public MyDate now2() {
//        MyDate myDate =  testMapper.now2();
//        return myDate;
//    }
//}
