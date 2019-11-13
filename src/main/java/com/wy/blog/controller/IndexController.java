package com.wy.blog.controller;

import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.Blog;
import com.wy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class IndexController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/error")
    public String error(){
        return "/admin/error";
    }

    @RequestMapping("/404")
    public String notFound(@RequestParam(required = false)String message, Model model){
        model.addAttribute("errorMsg","数据库中没有该分类的信息，请添加后在查询");
        model.addAttribute("code",0);
        return "/blog/error/404";
    }

    @RequestMapping(value = {"","/blog"})
    public String index(@RequestParam(required = false,defaultValue = "0")Integer pageNum,
                        @RequestParam(required = false,defaultValue = "10")Integer pageSize,Model model) throws Exception{
        //获取所有已经发布的文章
        PageInfo<Blog> pageInfo = blogService.findAll(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "/blog/index";
    }
}
