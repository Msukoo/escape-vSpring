package com.escapepj.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface TestMapper {

    @Select("SELECT now()")
    public Date now();

    public MyDate now2();
}
