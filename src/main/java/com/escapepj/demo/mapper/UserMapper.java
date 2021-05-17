package com.escapepj.demo.mapper;

import com.escapepj.demo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
public interface UserMapper {
    public UserVo readUser(String username);

    public List<String> readAuthority(String username);

    public int saveUser(UserVo userVo);

    int idCheck(String userId);
}
