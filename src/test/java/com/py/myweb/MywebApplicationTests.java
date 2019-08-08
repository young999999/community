package com.py.myweb;

import com.py.myweb.controller.AreaController;
import com.py.myweb.domain.Area;
import com.py.myweb.mapper.AreaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MywebApplicationTests {


    @Autowired
    AreaMapper areaMapper;
    @Test
    public void contextLoads() {
        Area area=areaMapper.getDeptById(1);
        System.out.println(area);
    }

}
