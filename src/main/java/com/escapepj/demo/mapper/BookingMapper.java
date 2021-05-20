package com.escapepj.demo.mapper;

import com.escapepj.demo.vo.BookingVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingMapper {
    int saveReserve(BookingVo bookingVo);
}
