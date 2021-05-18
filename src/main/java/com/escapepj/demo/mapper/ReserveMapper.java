package com.escapepj.demo.mapper;

import com.escapepj.demo.vo.ReserveVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReserveMapper {
    int saveReserve(ReserveVo reserveVo);
}
