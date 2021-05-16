package com.escapepj.demo.controller;

import com.escapepj.demo.mapper.UserMapper;
import com.escapepj.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/user2/login")
    public String  openApiReadUser(String username) {
        UserVo userVo = userMapper.readUser(username);
        return userVo.getName();
    }

    @RequestMapping("/openapi/readAuthority/{username}")
    public @ResponseBody String  openApiReadAuthority(@PathVariable String username) {
        List<String> auths = userMapper.readAuthority(username);

        StringBuffer buf = new StringBuffer();
        for(String auth : auths) {
            buf.append(auth);
            buf.append(" ");
        }
        return buf.toString();
    }

}
