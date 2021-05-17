package com.escapepj.demo.service;

import com.escapepj.demo.mapper.UserMapper;
import com.escapepj.demo.vo.RoleVo;
import com.escapepj.demo.vo.SecurityUser;
import com.escapepj.demo.vo.UserRoleVo;
import com.escapepj.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    private static final String ROLE_PREFIX = "ROLE_";

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = userMapper.readUser(username);
        System.out.println("readuser");
        if(userVo != null) {
            userVo.setAuthorities(makeGrantedAuthority(userMapper.readAuthority(username)));
        }
        return new SecurityUser(userVo);
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
        return list;
    }



}
