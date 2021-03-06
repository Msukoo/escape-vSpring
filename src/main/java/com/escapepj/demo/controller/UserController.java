package com.escapepj.demo.controller;

import com.escapepj.demo.mapper.UserMapper;
import com.escapepj.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/*")
public class UserController {

    private final UserMapper userMapper;

    public UserController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @RequestMapping("/login")
    public String  userLogin() {
        return "user/login";
    }

    @RequestMapping("/join")
    public String  joinUser() {
        return "user/join";
    }

    @ResponseBody
    @RequestMapping("/idCheck")
    public Map<String,String> idCheckAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,String> resultMap = new HashMap<String,String>();
        int check = 0;
        String result = "";

        String username = request.getParameter("username");
        check = userMapper.idCheck(username);
        if(check == 1) {
            result = "N";
        }else if(check == 0) {
            result = "Y";
        }
        resultMap.put("result", result);
        return resultMap;
    }

    @RequestMapping("/join/save")
    public String  saveUser(ModelMap model, UserVo userVo, HttpServletRequest request, HttpServletResponse response) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
        int result = 0;
        result =userMapper.saveUser(userVo);
        if(result == 1) {
            model.addAttribute("result", "Y");
        }else if(result == 0) {
            model.addAttribute("result", "N");
        }
        model.addAttribute("submit", "join");
        return "common/result";
    }

    @RequestMapping("/login/fail")
    public String  loginFailUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("result", "N");
        model.addAttribute("submit", "login");
        return "common/result";
    }

    @RequestMapping("/mypage")
    public String getUser(Model model, HttpServletRequest request, HttpServletResponse response){
        UserVo userVo = new UserVo();

        model.addAttribute("userVo", userVo);
        return "user/mypage";
    }






//    @RequestMapping("/openapi/readAuthority/{username}")
//    public @ResponseBody String  openApiReadAuthority(@PathVariable String username) {
//        List<String> auths = userMapper.readAuthority(username);
//
//        StringBuffer buf = new StringBuffer();
//        for(String auth : auths) {
//            buf.append(auth);
//            buf.append(" ");
//        }
//        return buf.toString();
//    }

}
