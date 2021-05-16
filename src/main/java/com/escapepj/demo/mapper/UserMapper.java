package com.escapepj.demo.mapper;

import com.escapepj.demo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    UserVo findUserByLoginId(@Param("loginId") String loginId);

    int setUserInfo(@Param("param") UserVo param);
}
