package com.wy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("")
    public String test(){
        return "/admin/test";
    }

    @RequestMapping("/data1")
    public String data(String data){
        System.out.println(data);
        return "/admin/test";
    }
    @RequestMapping("/data2")
    public String data1(String data){
        System.out.println("变化后的数据：" + data);
        return "/admin/test";
    }
}
