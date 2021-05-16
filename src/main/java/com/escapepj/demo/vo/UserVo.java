package com.escapepj.demo.vo;

import lombok.Data;

@Data
public class UserVo {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private int active;
}
