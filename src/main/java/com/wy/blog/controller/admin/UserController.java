package com.wy.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.UserInfo;
import com.wy.blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String goLogin(){
        return "/admin/login";
    }

    @RequestMapping("")
    public String index(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                        Model model) throws Exception {
        //1表示添加用户的界面
        model.addAttribute("statusMsg",1);
        PageInfo<UserInfo> pageInfo = userService.findAllUser(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/blog/user";
    }

    @RequestMapping("/add")
    public String addUser(UserInfo userInfo) throws Exception {
        //设置昵称
        if(userInfo.getNickName().length() <= 0)
            userInfo.setNickName(userInfo.getUserName());
        userInfo.setRegisterTime(new Date());
        userInfo.setStatus(0);
        userService.addUser(userInfo);
        return "redirect:/user";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer userId,
                           @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                           Model model) throws Exception {
        UserInfo userInfo = userService.findUserByUserId(userId);
        model.addAttribute("userInfo",userInfo);
        PageInfo<UserInfo> pageInfo = userService.findAllUser(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        //0表示修改用户信息界面
        model.addAttribute("statusMsg",0);
        return "/admin/blog/user";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer userId) throws Exception {
        userService.deleteUserByUserId(userId);
        return "redirect:/user";
    }

    @RequestMapping("/update")
    public String updateUser(UserInfo userInfo,Model model) throws Exception {
        userService.updateUser(userInfo);
        return "redirect:/user";
    }
}
