package com.py.myweb.controller;


import com.py.myweb.domain.Ajax;
import com.py.myweb.domain.Area;
import com.py.myweb.mapper.AreaMapper;
import com.py.myweb.service.SerchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class AreaController {

    @Autowired
    AreaMapper areaMapper;
    @Autowired
    SerchService serchService;




    @ResponseBody
    //@RequestMapping(value = "/area/{id}",method = RequestMethod.POST)
    //ublic Area login(@PathVariable("id") Integer id,  @RequestBody Ajax body){
    @RequestMapping("/serch1")
    public Area login(@RequestBody Ajax body){
        Area area=serchService.SerchGet(body.getId());
        System.out.println(area);

        System.out.println(body.getId()+"    "+body.getName());
        return area;
    }
    //@ResponseBody
    @RequestMapping("/serch")
    public String serch(Integer id){

        System.out.println("ID   "+id);
        return "index";
    }
}
