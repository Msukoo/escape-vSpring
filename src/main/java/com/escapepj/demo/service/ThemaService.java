package com.escapepj.demo.service;

import com.escapepj.demo.mapper.ThemaMapper;
import org.springframework.stereotype.Service;

@Service
public class ThemaService {

    private final ThemaMapper themaMapper;

    public ThemaService(ThemaMapper themaMapper){
        this.themaMapper = themaMapper;
    }
}
