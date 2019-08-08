package com.py.myweb.service;

import com.py.myweb.domain.Area;
import com.py.myweb.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerchService {
    @Autowired
    AreaMapper areaMapper;
    public Area SerchGet(Integer id){
        Area area=areaMapper.getDeptById(id);
        return  area;
    }
}
