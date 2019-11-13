package com.wy.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.blog.dao.UserDao;
import com.wy.blog.domain.UserInfo;
import com.wy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("开始查询用户信息");
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        User user = new User(userInfo.getUserName(),"{noop}" + userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getStatus()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(Integer status){
        List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>();
        if(status == 1){
            authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorityList;
    }


    public UserInfo findUserByUserId(Integer userId) throws Exception {
        return userDao.getUserInfoById(userId);
    }

    public PageInfo<UserInfo> findAllUser(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> userList = userDao.findAllUser();
        return new PageInfo<UserInfo>(userList);
    }


    public void updateUser(UserInfo userInfo) throws Exception {
        userDao.update(userInfo);
    }

    public void deleteUserByUserId(Integer userId) throws Exception {
        userDao.delete(userId);
    }

    public void addUser(UserInfo userInfo) throws Exception {
        userDao.add(userInfo);
    }
}
