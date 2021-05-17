package com.escapepj.demo.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class UserVo {

    private String username;
    private String password;
    private String name;
    private String phone;
    private int trophy;
    private Collection<? extends GrantedAuthority> authorities;

}
