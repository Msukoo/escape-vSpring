package com.escapepj.demo.service;

import com.escapepj.demo.mapper.UserMapper;
import com.escapepj.demo.vo.RoleVo;
import com.escapepj.demo.vo.UserRoleVo;
import com.escapepj.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserVo findUserByLoginId(String loginId) {
        return userMapper.findUserByLoginId(loginId);
    }

    public void saveUser(UserVo userVo) {
        userVo.setPassword(bCryptPasswordEncoder.encode(userVo.getPassword()));
        userVo.setActive(1);
        userMapper.setUserInfo(userVo);
        RoleVo roleVo = roleMapper.getRoleInfo("ADMIN");
        UserRoleVo userRoleVo = new UserRoleVo();
        userRoleVo.setRoleId(roleVo.getId());
        userRoleVo.setUserId(userVo.getId());
        userRoleMapper.setUserRoleInfo(userRoleVo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = userMapper.findUserByLoginId(username);
        return new UserPrincipal(userVo);
    }


}
