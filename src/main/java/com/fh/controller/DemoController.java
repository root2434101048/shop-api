package com.fh.controller;

import com.fh.model.BuyCar;
import com.fh.service.DemoService;
import com.fh.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("queryList")
    public List<BuyCar> queryList(){
        List<BuyCar> buyCarList = demoService.queryList();
        return buyCarList;
    }




}
