package com.wy.blog.service;

import com.github.pagehelper.PageInfo;
import com.wy.blog.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {


    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    UserInfo findUserByUserId(Integer userId) throws Exception;

    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<UserInfo> findAllUser(Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 修改用户的信息
     * @param userInfo
     */
    void updateUser(UserInfo userInfo) throws Exception;

    /**
     * 删除用户
     * @param userId
     */
    void deleteUserByUserId(Integer userId) throws Exception;

    /**
     * 添加用户
     * @param userInfo
     */
    void addUser(UserInfo userInfo) throws Exception;
}
