package com.escapepj.demo.vo;

import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
    private static final long serialVersionUID = 1L;

    public SecurityUser(UserVo userVo) {
        super(userVo.getUsername(), userVo.getPassword(), userVo.getAuthorities());
    }

}
